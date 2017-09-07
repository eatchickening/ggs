(function () {
  'use strict';

  angular.module('chicken.pages.info')
    .controller('SchoolCtrl', function ($scope, $uibModal, toastr, SchoolService, InfoService) {


      //控制查询条件的'更多'按钮
      $scope.isShowMoreRegion = true;
      $scope.showMoreRegion = function (value) {
        $scope.isShowMoreRegion = value;
      };

      $scope.isShowMoreSchoolType = true;
      $scope.showMoreSchoolType = function (value) {
        $scope.isShowMoreSchoolType = value;
      };

      //当前选择的区域
      $scope.curRegion = '';

      //当前选中的学校类型
      $scope.curSchoolType = '';


      //查询条件---地区变化
      $scope.onRegionChanged = function (value) {
        if (value == $scope.curRegion) {
          return;
        }

        $scope.curRegion = value;
        //地区变化后重新查询对应的学校
        getSchoolList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, '');
      };

      $scope.onSchoolTypeChanged = function (value) {
        if (value == $scope.curSchoolType) {
          return;
        }

        $scope.curSchoolType = value;
        //学校类型变化后重新查询对应的学校
        getSchoolList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, '');
      };

      //根据查询条件加载学校数据
      $scope.querySchoolInfo = function (schoolName) {
        if (!schoolName) {
          schoolName = '';
        }

        // if (!schoolName) {
        //   toastr.error('请输入学校名称!', '精确查询', {});
        //   return;
        // }
        getSchoolList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, schoolName);
      };

      function getSchoolList(pageNum, pageSize, region, schoolType, schoolName) {
        SchoolService.query(pageNum, pageSize, region, schoolType, schoolName).then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.schoolList = data.data;
            $scope.totalItems = data.total;
          } else {
            toastr.error(data.message);
          }
        }).catch(function (err) {
          toastr.error(err);
        });
      }

      var currentScope = 1;
      $scope.tempPageSize = 5;
      $scope.pageSize = 5;

      function initArea() {
        //初始化区域和学校类型等查询条件
        InfoService.queryAreas().then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.regions = data.data;
            $scope.regions.unshift({ 'bizcode': '', 'datavalue': '全部' });
          } else {
            toastr.error(data.message);
          }
        }).catch(function (err) {
          toastr.error(err);
        });
      }

      function initSchoolTypes() {
        InfoService.querySchoolTypes().then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.schoolTypes = data.data;
            $scope.schoolTypes.unshift({ 'bizcode': '', 'datavalue': '全部' });
          } else {
            toastr.error(data.message);
          }
        }).catch(function (err) {
          toastr.error(err);
        });
      }

      function init() {

        initArea();
        initSchoolTypes();

        $scope.displayed = [];
        $scope.pageSizes = [5, 10, 15, 20, 25];
        // getUserList(1, 10);
        getSchoolList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, '');
      }

      init();

      $scope.pageChange = function (p) {
        if (Math.ceil(p / 10) !== currentScope) {
          $scope.schoolList = [];
          var pageNum = Math.floor(p / 10) * 10 + 1;
          if (p % 10 === 0) {
            pageNum = (Math.floor(p / 10) - 1) * 10 + 1;
          }
          var pageSize = $scope.tempPageSize;
          getSchoolList(pageNum, pageSize, $scope.curRegion, $scope.curSchoolType, '');
          currentScope = Math.ceil(p / 10);
        }
      };

      $scope.changePageSize = function (pageSize) {
        $scope.schoolList = [];
        $scope.tempPageSize = pageSize;
        getSchoolList(1, pageSize, $scope.curRegion, $scope.curSchoolType, '');
      };

      $scope.openDetail = function (school) {
        $scope.curSchoolItem = school;
        var model = $uibModal.open({
          animation: true,
          templateUrl: 'app/pages/info/school/schoolDetailInfo.html',
          size: 'lg',
          scope: $scope
        });
        model.result.then(
          //close
          function (result) {
            var a = result;
          },
          //dismiss
          function (result) {
            var a = result;
          });
      };
    });
})();