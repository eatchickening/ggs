(function () {
    'use strict';

    angular.module('chicken.pages.info')
        .controller('StudentCtrl', function ($scope) {

            //数据记录的总条数
            $scope.total = 22222;

            //每页的记录条数
            $scope.pageSize = 5;

            //每页数量变化
            $scope.pageSizeChanged = function(){
              console.log("pageSize:"+$scope.pageSize);
              //根据当前页和每页个数查询数据
            }

            //页码数变化
            $scope.pageChanged = function(){
              console.log("currentPage:"+$scope.currentPage);
              //根据当前页和每页个数查询数据
            }
            
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
                    id: 6,
                    firstName: 'Ann',
                    lastName: 'Smith',
                    username: '@ann',
                    email: 'ann@gmail.com',
                    age: '21'
                  },
                  {
                    id: 7,
                    firstName: 'Barbara',
                    lastName: 'Black',
                    username: '@barbara',
                    email: 'barbara@yandex.ru',
                    age: '43'
                  },
                  {
                    "id": 60,
                    "firstName": "Lou",
                    "lastName": "Conner",
                    "username": "@Sanchez",
                    "email": "lousanchez@comtours.com",
                    "age": 16
                  }
                ];
        });
})();