(function () {
  'use strict';

  angular.module('chicken.pages.info')
    .controller('StudentCtrl', function ($scope, $uibModal, toastr, StudentService, InfoService) {

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
        getStudentList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      $scope.onSchoolTypeChanged = function (value) {
        if (value == $scope.curSchoolType) {
          return;
        }

        $scope.curSchoolType = value;
        //学校类型变化后重新查询对应的学校
        initSchools();
        getStudentList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      $scope.onSchoolChanged = function (value) {
        if (value == $scope.curSchool) {
          return;
        }
        $scope.curSchool = value;
        getStudentList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      //根据查询条件加载学生数据
      $scope.queryStudentInfo = function (studentNum) {

        if (!studentNum) {
          studentNum = '';
        }
        getStudentList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, studentNum);
      };

      var currentScope = 1;
      $scope.tempPageSize = 5;
      $scope.pageSize = 5;

      function getStudentList(pageNum, pageSize, region, schoolType, schoolCode, studentNum) {
        StudentService.query(pageNum, pageSize, studentNum, schoolCode, region, schoolType).then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.studentList = data.data;
            $scope.totalItems = data.total;
          } else {
            toastr.error(data.data.message);
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
        getStudentList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      }

      init();

      $scope.pageChange = function (p) {
        if (Math.ceil(p / 10) !== currentScope) {
          $scope.studentList = [];
          var pageNum = Math.floor(p / 10) * 10 + 1;
          if (p % 10 === 0) {
            pageNum = (Math.floor(p / 10) - 1) * 10 + 1;
          }
          var pageSize = $scope.tempPageSize;
          getStudentList(pageNum, pageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
          currentScope = Math.ceil(p / 10);
        }
      };

      $scope.changePageSize = function (pageSize) {
        $scope.studentList = [];
        $scope.tempPageSize = pageSize;
        getStudentList(1, pageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, '');
      };

      $scope.openDetail = function (student) {
        
        $scope.curStudentItem = student;
                var model = $uibModal.open({
                  animation: true,
                  templateUrl: 'app/pages/info/student/studentDetailInfo.html',
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