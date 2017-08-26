(function () {
  'use strict';

  var chicken = angular.module('chicken.pages.info')
    .controller('StudentCtrl', function ($scope) {

      $scope.smartTablePageSize = 10;

      $scope.rowNums = [5, 10, 15, 20, 25];

      $scope.pageChange = function (p) {
        console.log(p);
      };

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
        }
      ];

       //数据记录的总条数
       $scope.totalItems = $scope.smartTableData.length;

    });


})();