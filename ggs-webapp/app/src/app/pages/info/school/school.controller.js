(function () {
  'use strict';

  angular.module('chicken.pages.info')
    .controller('SchoolCtrl', function ($scope, $uibModal, toastr, SchoolService) {

      $scope.regions = [
        { name: '全部', value: '0' },
        { name: '地区1', value: '1' },
        { name: '地区2', value: '2' },
        { name: '地区3', value: '3' },
        { name: '地区4', value: '4' },
        { name: '地区5', value: '5' },
      ];

      $scope.schoolTypes = [
        { name: '全部', value: '1' },
        { name: '高职', value: '2' },
        { name: '高中', value: '3' },
        { name: '初中', value: '4' },
        { name: '小学', value: '5' },
      ];

      $scope.smartTableData = [
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

      //当前选择的区域
      $scope.curRegion = 0;

      //当前选中的学校类型
      $scope.curSchoolType = 1;


      //查询条件---地区变化
      $scope.onRegionChanged = function (value) {
        $scope.curRegion = value;
      };

      $scope.onSchoolTypeChanged = function (value) {
        $scope.curSchoolType = value;
      };

      //根据查询条件加载教师数据
      $scope.querySchoolInfo = function (schoolName) {

        if (!schoolName) {
          toastr.error('请输入学校名称!', '精确查询', {});
          return;
        }
        getSchoolList(1, $scope.tempPageSize, $scope.curRegion, $scope.curSchoolType, $scope.schoolName);
      };

      function getSchoolList(pageNum, pageSize, region, schoolType, schoolName) {
        $scope.totalItems = 10;

        $scope.schoolList = $scope.smartTableData;
      }

      var currentScope = 1;
      $scope.tempPageSize = 5;
      $scope.pageSize = 5;

      function init() {
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