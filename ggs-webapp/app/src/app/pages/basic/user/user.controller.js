(function () {
    'use strict';

    angular.module('chicken.pages.basic')
        .controller('UserCtrl', function ($scope, $uibModal, BasicService, toastr) {

            var currentScope = 1;
            var tempPageSize = 10;

            function getUserList (pageNum, pageSize) {
                BasicService.listuser(pageNum, pageSize).then(function(data) {
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        $scope.userList = data.data;
                        $scope.totalItems = data.total;
                    }
                }).catch(function(err) {
                    toastr.error(err);
                });
            }

            function init () {
                $scope.displayed = [];
                $scope.pageSizes = [10, 15, 20, 25];
                getUserList(1, 10);
            }

            init();
            
            $scope.pageChange = function (p) {
                if (Math.ceil(p/10)!==currentScope) {
                    $scope.userList = [];
                    var pageNum = Math.floor(p/10) * 10 + 1;
                    if (p % 10 === 0) {
                        pageNum = (Math.floor(p/10) - 1) * 10 + 1;
                    }
                    var pageSize = tempPageSize;
                    getUserList(pageNum, pageSize);
                    currentScope = Math.ceil(p/10);
                }
            };

            $scope.changePageSize = function(pageSize){
                $scope.userList = [];
                tempPageSize = pageSize;
                getUserList(1, pageSize);
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