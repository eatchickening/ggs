(function () {
    'use strict';

    angular.module('chicken.pages.basic')
        .controller('UserCtrl', function ($scope, $uibModal, BasicService, toastr) {

            // list user by page
            var currentScope = 1;
            var tempPageSize = 10;

            function getUserList (pageNum, pageSize) {
                BasicService.listUser(pageNum, pageSize).then(function(data) {
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

            // add new user
            function listAreaDetail(bizcode) {
                BasicService.listAreaDetail(bizcode).then(function(data) {
                    if (data.code === 0 && data.data && data.data instanceof Array && data.data.length > 0) {
                        $scope.organs = data.data[0].organVoList;
                    }
                }).catch(function(err){
                    console.log(err);
                });
            }

            function transformMenus(data) {
                var menus = [];
                data.forEach(function(item) {
                    if (item.parentId === 0) {
                        menus.push({
                            id: item.id,
                            name: item.name,
                            state: item.angularState,
                            submenus: []
                        });
                    }
                });
                data.forEach(function(item) {
                    menus.forEach(function(menu) {
                        if (item.parentId !== 0 && item.parentId === menu.id) {
                            menu.submenus.push({
                                id: item.id,
                                name: item.name,
                                state: item.angularState
                            });
                        }
                    });
                });
                return menus;
            }

            $scope.changeArea = function () {
                listAreaDetail($scope.user.area.bizcode);
            };
            var selectedMenus = [];
            $scope.selectMenu = function (select, id) {
                if (select === true) {
                    var exit = false;
                    selectedMenus.forEach(function(item) {
                        if (item === id) {
                            exit = true;
                        }
                    });
                    if (exit === false) {
                        selectedMenus.push(id);
                    }
                }
                if (select === false) {
                    for (var i=0;i<selectedMenus.length;i++) {
                        if (selectedMenus[i] === id) {
                            selectedMenus.splice(i, 1);
                        }
                    }
                }
                console.log(selectedMenus);
            };

            $scope.addUser = function () {
                $scope.user = {
                    account: '',
                    password: '',
                    defaultPassword: false,
                    username: '',
                    areas: '',
                    organs: '',
                    departs: '',
                    posts: ''
                };
                BasicService.listMenus().then(function(data){
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        $scope.menus = transformMenus(data.data);
                    }
                }).catch(function(err){
                    console.log(err);
                });

                BasicService.listArea().then(function(data){
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        $scope.areas = data.data;
                    }
                }).catch(function(err){
                    console.log(err);
                });
                
                var addUserModal = $uibModal.open({
                    animation: true,
                    templateUrl: 'app/pages/basic/user/adduser.html',
                    size: 'lg',
                    scope: $scope
                });
                addUserModal.result.then(function(result){
                    if (result && result === 'OK') {
                        console.log($scope.user);
                        return BasicService.addUser($scope.user, selectedMenus.join(',')).then(function(response){
                            if (response.code === 0) {
                                toastr.success('添加用户：'+$scope.user.username+'成功！', '成功');
                            }
                        });
                    }
                }).catch(function(err){
                    if (err) {
                        console.log(err);
                    }
                });
            };

            //delete user
            $scope.deleteUser = function(user){
                $scope.delusername = user.username;
                var delUserModal = $uibModal.open({
                    animation: true,
                    templateUrl: 'app/pages/basic/user/deluser.html',
                    size: 'sm',
                    scope: $scope
                });
                delUserModal.result.then(function(result){
                    if (result && result === 'OK') {
                        return BasicService.deleteUser(user.id).then(function(response) {
                            if (response.data && response.data.code === 0) {
                                getUserList(1, tempPageSize);
                                toastr.success('删除用户'+user.username+'成功！', '成功');
                            }
                        });
                    }
                }); 
            };

        });
})();