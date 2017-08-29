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

            // add new user

            $scope.menus = [{
                id: 1,
                name: '基础设置',
                submenus: [{
                    id: 1,
                    name: '部门与岗位设置'
                },{
                    id: 2,
                    name: '用户管理'
                }]
            },{
                id: 2,
                name: '信息查询',
                submenus: [{
                    id: 3,
                    name: '学生信息查询'
                },
                {
                    id: 4,
                    name: '教师信息查询'
                },{
                    id: 5,
                    name: '学校信息查询'
                }]
            },{
                id: 3,
                name: '教育局评优活动',
                submenus: [{
                    id: 6,
                    name: '评优奖项设置'
                },{
                    id: 7,
                    name: '评选活动管理'
                },{
                    id: 8,
                    name: '优评评定活动列表'
                }]
            },{
                id: 4,
                name: '学校评优活动',
                submenus: [{
                    id: 9,
                    name: '评优奖项设置'
                },{
                    id: 10,
                    name: '评选活动管理'
                },{
                    id: 11,
                    name: '优评评定活动列表'
                }]
            },{
                id: 5,
                name: '系统管理',
                submenus: [{
                    id: 12,
                    name: '日志管理'
                },{
                    id: 13,
                    name: '通知信息管理'
                },{
                    id: 14,
                    name: '通知信息'
                }]
            }];

            $scope.selectMenu = function () {
                
            };

            function listAreaDetail(bizcode) {
                BasicService.listAreaDetail(bizcode).then(function(data) {
                    if (data.code === 0 && data.data && data.data instanceof Array && data.data.length > 0) {
                        $scope.organs = data.data[0].organVoList;
                    }
                }).catch(function(err){
                    console.log(err);
                });
            }

            $scope.changeArea = function () {
                listAreaDetail($scope.user.area.bizcode);
            };

            $scope.addUser = function () {
                $scope.user = {
                    account: '',
                    password: '',
                    username: '',
                    areas: '',
                    organs: '',
                    departs: '',
                    posts: '',
                    selectedMenus: ''
                };

                BasicService.listArea().then(function(data){
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        $scope.areas = data.data;
                    }
                }).catch(function(err){
                    console.log(err);
                });
                
                var addUserModel = $uibModal.open({
                    animation: true,
                    templateUrl: 'app/pages/basic/user/adduser.html',
                    size: 'lg',
                    scope: $scope
                });
                addUserModel.result.then(function(result){
                    if (result && result === 'OK') {
                        console.log($scope.user);
                        return BasicService.adduser($scope.user).then(function(response){
                            if (response) {

                            }
                        });
                    }
                }).catch(function(err){
                    if (err) {
                        console.log(err);
                    }
                });
            };

        });
})();