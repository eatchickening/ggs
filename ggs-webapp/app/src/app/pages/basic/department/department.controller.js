(function () {
    'use strict';

    angular.module('chicken.pages.basic')
        .controller('DepartmentCtrl', function ($scope, $uibModal, BasicService, toastr) {

            // list organ by page
            var currentScope = 1;
            var tempPageSize = 10;

            function getOrganList () {
                BasicService.listAreaDetail('').then(function(data) {
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        $scope.organList = data.data;
                        $scope.totalItems = data.total;
                    }
                }).catch(function(err) {
                    toastr.error(err);
                });
            }

            function init () {
                $scope.displayed = [];
                $scope.pageSizes = [10, 15, 20, 25];
                getOrganList(1, 10);
            }

            init();
            
            $scope.pageChange = function (p) {
                if (Math.ceil(p/10)!==currentScope) {
                    $scope.organList = [];
                    var pageNum = Math.floor(p/10) * 10 + 1;
                    if (p % 10 === 0) {
                        pageNum = (Math.floor(p/10) - 1) * 10 + 1;
                    }
                    var pageSize = tempPageSize;
                    getOrganList(pageNum, pageSize);
                    currentScope = Math.ceil(p/10);
                }
            };

            $scope.changePageSize = function(pageSize){
                $scope.organList = [];
                tempPageSize = pageSize;
                getOrganList(1, pageSize);
            };

            $scope.edit = function () {

            };

        });
})();