/** 
* @version 2.1.8
* @license MIT
*/
(function (ng, undefined){
    'use strict';

ng.module('yw-table', []).run(['$templateCache', function ($templateCache) {
    $templateCache.put('template/yw-table/pagination.html',
        '<nav ng-if="numPages && pages.length >= 2"><ul class="pagination">' +
        '<li ng-repeat="page in pages" ng-class="{active: page==currentPage}"><a href="javascript: void(0);" ng-click="selectPage(page)">{{page}}</a></li>' +
        '</ul></nav>');
}]);


ng.module('yw-table')
  .constant('ywConfig', {
    pagination: {
      template: 'template/yw-table/pagination.html',
      itemsByPage: 10,
      displayedPages: 5
    },
    search: {
      delay: 400, // ms
      inputEvent: 'input'
    },
    select: {
      mode: 'single',
      selectedClass: 'yw-selected'
    },
    sort: {
      ascentClass: 'yw-sort-ascent',
      descentClass: 'yw-sort-descent',
      descendingFirst: false,
      skipNatural: false,
      delay:300
    },
    pipe: {
      delay: 100 //ms
    }
  });
ng.module('yw-table')
  .controller('ywTableController', ['$scope', '$parse', '$filter', '$attrs', function YwTableController ($scope, $parse, $filter, $attrs) {
    var propertyName = $attrs.ywTable;
    var displayGetter = $parse(propertyName);
    var displaySetter = displayGetter.assign;
    var safeGetter;
    var orderBy = $filter('orderBy');
    var filter = $filter('filter');
    var safeCopy = copyRefs(displayGetter($scope));
    var tableState = {
      sort: {},
      search: {},
      pagination: {
        start: 0,
        totalItemCount: 0
      }
    };
    var filtered;
    var pipeAfterSafeCopy = true;
    var ctrl = this;
    var lastSelected;

    function copyRefs (src) {
      return src ? [].concat(src) : [];
    }

    function updateSafeCopy () {
      safeCopy = copyRefs(safeGetter($scope));
      if (pipeAfterSafeCopy === true) {
        ctrl.pipe();
      }
    }

    function deepDelete (object, path) {
      if (path.indexOf('.') != -1) {
        var partials = path.split('.');
        var key = partials.pop();
        var parentPath = partials.join('.');
        var parentObject = $parse(parentPath)(object)
        delete parentObject[key];
        if (Object.keys(parentObject).length == 0) {
          deepDelete(object, parentPath);
        }
      } else {
        delete object[path];
      }
    }

    if ($attrs.ywSafeSrc) {
      safeGetter = $parse($attrs.ywSafeSrc);
      $scope.$watch(function () {
        var safeSrc = safeGetter($scope);
        return safeSrc && safeSrc.length ? safeSrc[0] : undefined;
      }, function (newValue, oldValue) {
        if (newValue !== oldValue) {
          updateSafeCopy();
        }
      });
      $scope.$watch(function () {
        var safeSrc = safeGetter($scope);
        return safeSrc ? safeSrc.length : 0;
      }, function (newValue, oldValue) {
        if (newValue !== safeCopy.length) {
          updateSafeCopy();
        }
      });
      $scope.$watch(function () {
        return safeGetter($scope);
      }, function (newValue, oldValue) {
        if (newValue !== oldValue) {
          tableState.pagination.start = 0;
          updateSafeCopy();
        }
      });
    }

    /**
     * sort the rows
     * @param {Function | String} predicate - function or string which will be used as predicate for the sorting
     * @param [reverse] - if you want to reverse the order
     */
    this.sortBy = function sortBy (predicate, reverse) {
      tableState.sort.predicate = predicate;
      tableState.sort.reverse = reverse === true;

      if (ng.isFunction(predicate)) {
        tableState.sort.functionName = predicate.name;
      } else {
        delete tableState.sort.functionName;
      }

      tableState.pagination.start = 0;
      return this.pipe();
    };

    /**
     * search matching rows
     * @param {String} input - the input string
     * @param {String} [predicate] - the property name against you want to check the match, otherwise it will search on all properties
     */
    this.search = function search (input, predicate) {
      var predicateObject = tableState.search.predicateObject || {};
      var prop = predicate ? predicate : '$';

      input = ng.isString(input) ? input.trim() : input;
      $parse(prop).assign(predicateObject, input);
      // to avoid to filter out null value
      if (!input) {
        deepDelete(predicateObject, prop);
      }
      tableState.search.predicateObject = predicateObject;
      tableState.pagination.start = 0;
      return this.pipe();
    };

    /**
     * this will chain the operations of sorting and filtering based on the current table state (sort options, filtering, ect)
     */
    this.pipe = function pipe () {
      var pagination = tableState.pagination;
      var output;
      filtered = tableState.search.predicateObject ? filter(safeCopy, tableState.search.predicateObject) : safeCopy;
      if (tableState.sort.predicate) {
        filtered = orderBy(filtered, tableState.sort.predicate, tableState.sort.reverse);
      }
      pagination.totalItemCount = filtered.length;
      if (pagination.number !== undefined) {
        pagination.numberOfPages = filtered.length > 0 ? Math.ceil(filtered.length / pagination.number) : 1;
        pagination.start = pagination.start >= filtered.length ? (pagination.numberOfPages % pagination.number - 1) * pagination.number : pagination.start;
        output = filtered.slice(pagination.start, pagination.start + parseInt(pagination.number));
      }
      displaySetter($scope, output || filtered);
    };

    /**
     * select a dataRow (it will add the attribute isSelected to the row object)
     * @param {Object} row - the row to select
     * @param {String} [mode] - "single" or "multiple" (multiple by default)
     */
    this.select = function select (row, mode) {
      var rows = copyRefs(displayGetter($scope));
      var index = rows.indexOf(row);
      if (index !== -1) {
        if (mode === 'single') {
          row.isSelected = row.isSelected !== true;
          if (lastSelected) {
            lastSelected.isSelected = false;
          }
          lastSelected = row.isSelected === true ? row : undefined;
        } else {
          rows[index].isSelected = !rows[index].isSelected;
        }
      }
    };

    /**
     * take a slice of the current sorted/filtered collection (pagination)
     *
     * @param {Number} start - start index of the slice
     * @param {Number} number - the number of item in the slice
     */
    this.slice = function splice (start, number) {
      tableState.pagination.start = start;
      tableState.pagination.number = number;
      return this.pipe();
    };

    /**
     * return the current state of the table
     * @returns {{sort: {}, search: {}, pagination: {start: number}}}
     */
    this.tableState = function getTableState () {
      return tableState;
    };

    this.getFilteredCollection = function getFilteredCollection () {
      return filtered || safeCopy;
    };

    /**
     * Use a different filter function than the angular FilterFilter
     * @param filterName the name under which the custom filter is registered
     */
    this.setFilterFunction = function setFilterFunction (filterName) {
      filter = $filter(filterName);
    };

    /**
     * Use a different function than the angular orderBy
     * @param sortFunctionName the name under which the custom order function is registered
     */
    this.setSortFunction = function setSortFunction (sortFunctionName) {
      orderBy = $filter(sortFunctionName);
    };

    /**
     * Usually when the safe copy is updated the pipe function is called.
     * Calling this method will prevent it, which is something required when using a custom pipe function
     */
    this.preventPipeOnWatch = function preventPipe () {
      pipeAfterSafeCopy = false;
    };
  }])
  .directive('ywTable', function () {
    return {
      restrict: 'A',
      controller: 'ywTableController',
      link: function (scope, element, attr, ctrl) {

        if (attr.ywSetFilter) {
          ctrl.setFilterFunction(attr.ywSetFilter);
        }

        if (attr.ywSetSort) {
          ctrl.setSortFunction(attr.ywSetSort);
        }
      }
    };
  });

ng.module('yw-table')
  .directive('ywSearch', ['ywConfig', '$timeout','$parse', function (ywConfig, $timeout, $parse) {
    return {
      require: '^ywTable',
      link: function (scope, element, attr, ctrl) {
        var tableCtrl = ctrl;
        var promise = null;
        var throttle = attr.ywDelay || ywConfig.search.delay;
        var event = attr.ywInputEvent || ywConfig.search.inputEvent;

        attr.$observe('ywSearch', function (newValue, oldValue) {
          var input = element[0].value;
          if (newValue !== oldValue && input) {
            ctrl.tableState().search = {};
            tableCtrl.search(input, newValue);
          }
        });

        //table state -> view
        scope.$watch(function () {
          return ctrl.tableState().search;
        }, function (newValue, oldValue) {
          var predicateExpression = attr.ywSearch || '$';
          if (newValue.predicateObject && $parse(predicateExpression)(newValue.predicateObject) !== element[0].value) {
            element[0].value = $parse(predicateExpression)(newValue.predicateObject) || '';
          }
        }, true);

        // view -> table state
        element.bind(event, function (evt) {
          evt = evt.originalEvent || evt;
          if (promise !== null) {
            $timeout.cancel(promise);
          }

          promise = $timeout(function () {
            tableCtrl.search(evt.target.value, attr.ywSearch || '');
            promise = null;
          }, throttle);
        });
      }
    };
  }]);

ng.module('yw-table')
  .directive('ywSelectRow', ['ywConfig', function (ywConfig) {
    return {
      restrict: 'A',
      require: '^ywTable',
      scope: {
        row: '=ywSelectRow'
      },
      link: function (scope, element, attr, ctrl) {
        var mode = attr.ywSelectMode || ywConfig.select.mode;
        element.bind('click', function () {
          scope.$apply(function () {
            ctrl.select(scope.row, mode);
          });
        });

        scope.$watch('row.isSelected', function (newValue) {
          if (newValue === true) {
            element.addClass(ywConfig.select.selectedClass);
          } else {
            element.removeClass(ywConfig.select.selectedClass);
          }
        });
      }
    };
  }]);

ng.module('yw-table')
  .directive('ywSort', ['ywConfig', '$parse', '$timeout', function (ywConfig, $parse, $timeout) {
    return {
      restrict: 'A',
      require: '^ywTable',
      link: function (scope, element, attr, ctrl) {

        var predicate = attr.ywSort;
        var getter = $parse(predicate);
        var index = 0;
        var classAscent = attr.ywClassAscent || ywConfig.sort.ascentClass;
        var classDescent = attr.ywClassDescent || ywConfig.sort.descentClass;
        var stateClasses = [classAscent, classDescent];
        var sortDefault;
        var skipNatural = attr.ywSkipNatural !== undefined ? attr.ywSkipNatural : ywConfig.sort.skipNatural;
        var descendingFirst = attr.ywDescendingFirst !== undefined ? attr.ywDescendingFirst : ywConfig.sort.descendingFirst;
        var promise = null;
        var throttle = attr.ywDelay || ywConfig.sort.delay;

        if (attr.ywSortDefault) {
          sortDefault = scope.$eval(attr.ywSortDefault) !== undefined ? scope.$eval(attr.ywSortDefault) : attr.ywSortDefault;
        }

        //view --> table state
        function sort () {
          if (descendingFirst) {
            index = index === 0 ? 2 : index - 1;
          } else {
            index++;
          }

          var func;
          predicate = ng.isFunction(getter(scope)) || ng.isArray(getter(scope)) ? getter(scope) : attr.ywSort;
          if (index % 3 === 0 && !!skipNatural !== true) {
            //manual reset
            index = 0;
            ctrl.tableState().sort = {};
            ctrl.tableState().pagination.start = 0;
            func = ctrl.pipe.bind(ctrl);
          } else {
            func = ctrl.sortBy.bind(ctrl, predicate, index % 2 === 0);
          }
          if (promise !== null) {
            $timeout.cancel(promise);
          }
          if (throttle < 0) {
            func();
          } else {
            promise = $timeout(func, throttle);
          }
        }

        element.bind('click', function sortClick () {
          if (predicate) {
            scope.$apply(sort);
          }
        });

        if (sortDefault) {
          index = sortDefault === 'reverse' ? 1 : 0;
          sort();
        }

        //table state --> view
        scope.$watch(function () {
          return ctrl.tableState().sort;
        }, function (newValue) {
          if (newValue.predicate !== predicate) {
            index = 0;
            element
              .removeClass(classAscent)
              .removeClass(classDescent);
          } else {
            index = newValue.reverse === true ? 2 : 1;
            element
              .removeClass(stateClasses[index % 2])
              .addClass(stateClasses[index - 1]);
          }
        }, true);
      }
    };
  }]);

ng.module('yw-table')
  .directive('ywPagination', ['ywConfig', function (ywConfig) {
    return {
      restrict: 'EA',
      require: '^ywTable',
      scope: {
        ywItemsByPage: '=?',
        ywDisplayedPages: '=?',
        ywTotalItems: '=?',
        ywPageChange: '&'
      },
      templateUrl: function (element, attrs) {
        if (attrs.ywTemplate) {
          return attrs.ywTemplate;
        }
        return ywConfig.pagination.template;
      },
      link: function (scope, element, attrs, ctrl) {

        scope.ywItemsByPage = scope.ywItemsByPage ? +(scope.ywItemsByPage) : ywConfig.pagination.itemsByPage;
        scope.ywDisplayedPages = scope.ywDisplayedPages ? +(scope.ywDisplayedPages) : ywConfig.pagination.displayedPages;

        scope.currentPage = 1;
        scope.pages = [];
        scope.tempCurrentPage = 1;
        function redraw () {
          var paginationState = ctrl.tableState().pagination;
          if (scope.ywTotalItems) {
            paginationState.numberOfPages = Math.ceil(scope.ywTotalItems/scope.ywItemsByPage);
          }
          var start = 1;
          var end;
          var i;
          var prevPage = scope.currentPage;
          scope.totalItemCount = paginationState.totalItemCount;
          // scope.currentPage = Math.floor(paginationState.start / paginationState.number) + 1;
          scope.currentPage = scope.tempCurrentPage;
          start = Math.max(start, scope.currentPage - Math.abs(Math.floor(scope.ywDisplayedPages / 2)));
          end = start + scope.ywDisplayedPages;

          if (end > paginationState.numberOfPages) {
            end = paginationState.numberOfPages + 1;
            start = Math.max(1, end - scope.ywDisplayedPages);
          }

          scope.pages = [];
          scope.numPages = paginationState.numberOfPages;

          for (i = start; i < end; i++) {
            scope.pages.push(i);
          }

          if (prevPage !== scope.currentPage) {
            scope.ywPageChange({newPage: scope.currentPage});
          }
        }

        //table state --> view
        scope.$watch(function () {
          return ctrl.tableState().pagination;
        }, redraw, true);

        //scope --> table state  (--> view)
        scope.$watch('ywItemsByPage', function (newValue, oldValue) {
          if (newValue !== oldValue) {
            scope.selectPage(1);
          }
        });

        scope.$watch('ywDisplayedPages', redraw);

        //view -> table state
        scope.selectPage = function (page) {
          if (page > 0 && page <= scope.numPages) {
            scope.tempCurrentPage = page;
            ctrl.slice(((page - 1) % 10) * scope.ywItemsByPage, scope.ywItemsByPage);
          }
        };

        if (!ctrl.tableState().pagination.number) {
          ctrl.slice(0, scope.ywItemsByPage);
        }
      }
    };
  }]);

ng.module('yw-table')
  .directive('ywPipe', ['ywConfig', '$timeout', function (config, $timeout) {
    return {
      require: 'ywTable',
      scope: {
        ywPipe: '='
      },
      link: {

        pre: function (scope, element, attrs, ctrl) {

          var pipePromise = null;

          if (ng.isFunction(scope.ywPipe)) {
            ctrl.preventPipeOnWatch();
            ctrl.pipe = function () {

              if (pipePromise !== null) {
                $timeout.cancel(pipePromise);
              }

              pipePromise = $timeout(function () {
                scope.ywPipe(ctrl.tableState(), ctrl);
              }, config.pipe.delay);

              return pipePromise;
            };
          }
        },

        post: function (scope, element, attrs, ctrl) {
          ctrl.pipe();
        }
      }
    };
  }]);

})(angular);