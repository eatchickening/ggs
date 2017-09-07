(function () {
  'use strict';

  angular.module('chicken.pages.info')
    .controller('TeacherCtrl', function ($scope, $uibModal, toastr, TeacherService, InfoService) {


      //控制查询条件的'更多'按钮
      $scope.isShowMoreRegion = true;
      $scope.showMoreRegion = function (value) {
        $scope.isShowMoreRegion = value;
      };

      $scope.isShowMoreSchoolType = true;
      $scope.showMoreSchoolType = function (value) {
        $scope.isShowMoreSchoolType = value;
      };

      $scope.isShowMoreSchool = true;
      $scope.showMoreSchool = function (value) {
        $scope.isShowMoreSchool = value;
      };


      //当前选择的区域
      $scope.curRegion = '';

      //当前选中的学校类型
      $scope.curSchoolType = '';

      //当前选择的学校
      $scope.curSchool = '';

      //查询条件---地区变化
      $scope.onRegionChanged = function (value) {

        if (value == $scope.curRegion) {
          return;
        }

        $scope.curRegion = value;
        //地区变化后重新查询对应的学校
        initSchools();
        getTeacherList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      $scope.onSchoolTypeChanged = function (value) {

        if (value == $scope.curSchoolType) {
          return;
        }

        $scope.curSchoolType = value;
        //学校类型变化后重新查询对应的学校
        initSchools();
        getTeacherList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      $scope.onSchoolChanged = function (value) {
        if (value == $scope.curSchool) {
          return;
        }
        $scope.curSchool = value;
        getTeacherList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      //根据查询条件加载教师数据
      $scope.queryTeacherInfo = function (teacherName) {

        if (!teacherName) {
          teacherName = '';
        }

        getTeacherList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, teacherName);
      };

      var currentScope = 1;
      $scope.tempPageSize = 5;
      $scope.pageSize = 5;

      function getTeacherList(pageNum, pageSize, region, schoolType, schoolCode, teacherName) {
        TeacherService.query(pageNum, pageSize, teacherName, schoolCode, region, schoolType).then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.teacherList = data.data;
            $scope.totalItems = data.total;
          } else {
            toastr.error(data.message);
          }
        }).catch(function (err) {
          toastr.error(err);
        });
      }

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

      function initSchools(){
        $scope.curSchool = '';
        InfoService.querySchools($scope.curRegion, $scope.curSchoolType).then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.schools = data.data;
            $scope.schools.unshift({ 'schoolcode': '', 'name': '全部' });
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
        initSchools();

        $scope.displayed = [];
        $scope.pageSizes = [5, 10, 15, 20, 25];
        
        getTeacherList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
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
          getTeacherList(pageNum, pageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
          currentScope = Math.ceil(p / 10);
        }
      };

      $scope.changePageSize = function (pageSize) {
        $scope.schoolList = [];
        $scope.tempPageSize = pageSize;
        getTeacherList(1, pageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      $scope.openDetail = function (teacher) {

        $scope.curTeacherItem = teacher;

        var model = $uibModal.open({
          animation: true,
          templateUrl: 'app/pages/info/teacher/teacherDetailInfo.html',
          size: 'lg',
          scope: $scope,
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