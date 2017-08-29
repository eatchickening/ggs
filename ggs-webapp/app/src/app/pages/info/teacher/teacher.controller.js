(function () {
  'use strict';

  angular.module('chicken.pages.info')
    .controller('TeacherCtrl', function ($scope, $uibModal, toastr, TeacherService) {

      $scope.regions = [{
          name: '全部',
          value: ''
        },
        {
          name: '地区1',
          value: '1'
        },
        {
          name: '地区2',
          value: '2'
        },
        {
          name: '地区3',
          value: '3'
        },
        {
          name: '地区4',
          value: '4'
        },
        {
          name: '地区5',
          value: '5'
        },
      ];

      $scope.schoolTypes = [{
          name: '全部',
          value: ''
        },
        {
          name: '高职',
          value: '2'
        },
        {
          name: '高中',
          value: '3'
        },
        {
          name: '初中',
          value: '4'
        },
        {
          name: '小学',
          value: '5'
        },
      ];

      $scope.schools = [{
          name: '全部',
          value: ''
        },
        {
          name: '学校1',
          value: '2'
        },
        {
          name: '学校2',
          value: '3'
        },
        {
          name: '学校3',
          value: '4'
        },
        {
          name: '学校4',
          value: '5'
        },
        {
          name: '学校5',
          value: '6'
        },
        {
          name: '学校6',
          value: '7'
        },
        {
          name: '学校7',
          value: '8'
        },
        {
          name: '学校8',
          value: '9'
        },
        {
          name: '学校9',
          value: '10'
        },
        {
          name: '学校10',
          value: '11'
        },
        {
          name: '学校11',
          value: '12'
        },
        {
          name: '学校12',
          value: '13'
        },
        {
          name: '学校13',
          value: '14'
        },
        {
          name: '学校14',
          value: '15'
        },
        {
          name: '学校15',
          value: '16'
        },
        {
          name: '学校16',
          value: '17'
        },
      ];

      $scope.smartTableData = [{
          id: 1,
          firstName: 'Mark',
          lastName: 'Otto',
          username: '@mdo',
          email: 'mdo@gmail.com',
          age: '28'
        },
        {
          id: 2,
          firstName: 'Jacob',
          lastName: 'Thornton',
          username: '@fat',
          email: 'fat@yandex.ru',
          age: '45'
        },
        {
          id: 3,
          firstName: 'Larry',
          lastName: 'Bird',
          username: '@twitter',
          email: 'twitter@outlook.com',
          age: '18'
        },
        {
          id: 4,
          firstName: 'John',
          lastName: 'Snow',
          username: '@snow',
          email: 'snow@gmail.com',
          age: '20'
        },
        {
          id: 5,
          firstName: 'Jack',
          lastName: 'Sparrow',
          username: '@jack',
          email: 'jack@yandex.ru',
          age: '30'
        },
        {
          id: 1,
          firstName: 'Mark',
          lastName: 'Otto',
          username: '@mdo',
          email: 'mdo@gmail.com',
          age: '28'
        },
        {
          id: 2,
          firstName: 'Jacob',
          lastName: 'Thornton',
          username: '@fat',
          email: 'fat@yandex.ru',
          age: '45'
        },
        {
          id: 3,
          firstName: 'Larry',
          lastName: 'Bird',
          username: '@twitter',
          email: 'twitter@outlook.com',
          age: '18'
        },
        {
          id: 4,
          firstName: 'John',
          lastName: 'Snow',
          username: '@snow',
          email: 'snow@gmail.com',
          age: '20'
        },
        {
          id: 5,
          firstName: 'Jack',
          lastName: 'Sparrow',
          username: '@jack',
          email: 'jack@yandex.ru',
          age: '30'
        }
      ];

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
      $scope.curRegion = "";

      //当前选中的学校类型
      $scope.curSchoolType = "";

      //当前选择的学校
      $scope.curSchool = "";

      //查询条件---地区变化
      $scope.onRegionChanged = function (value) {
        $scope.curRegion = value;
      };

      $scope.onSchoolTypeChanged = function (value) {
        $scope.curSchoolType = value;
      };

      $scope.onSchoolChanged = function (value) {
        $scope.curSchool = value;
      };

      //根据查询条件加载教师数据
      $scope.queryTeacherInfo = function (teacherName) {

        //  if(!teacherName){
        //    toastr.error('请输入教师姓名!', '精确查询', {});
        //    return;
        //  }
        if (!teacherName) {
          teacherName = "";
        }
        getTeacherList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.curSchool, teacherName);
      };

      var currentScope = 1;
      $scope.tempPageSize = 5;
      $scope.pageSize = 5;

      function getTeacherList(pageNum, pageSize, region, schoolType, schoolName, teacherName) {
        TeacherService.query(pageNum, pageSize, teacherName, schoolName, region, schoolType).then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.teacherList = data.data;
            $scope.totalItems = data.total;
          }else{
            toastr.error(data.message);
          }
        }).catch(function (err) {
          toastr.error(err);
        });
      }

      function init() {
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