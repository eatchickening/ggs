(function () {
    'use strict';

    angular.module('chicken.pages.basic')
        .controller('UserCtrl', function ($scope, $uibModal, BasicService, toastr) {

            function init () {
                $scope.userList = [];
                $scope.displayed = [];
                $scope.pageSizes = [10, 15, 20, 25];
                $scope.pageSize = 10;
                BasicService.listuser(1, 10).then(function (data) {
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        $scope.userList = data.data;
                        $scope.totalItems = data.data.length;
                    }
                }).catch(function (err) {
                    toastr.error(err);
                });
            }

            init();
                       
            $scope.pageChange = function (p) {
                
            };

            $scope.addUser = function () {
                var model = $uibModal.open({
                    animation: true,
                    templateUrl: 'app/pages/basic/user/adduser.html',
                    size: 'lg',
                    scope: $scope,
                    resolve: {
                        items: function () {
                            return $scope.items;
                        }
                    }
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

            $scope.insertUser = function() {
                BasicService.adduser().then(function (data) {
                    console.log(data);
                }).catch(function (err) {
                    toastr.error(err);
                });
            };

        });
})();