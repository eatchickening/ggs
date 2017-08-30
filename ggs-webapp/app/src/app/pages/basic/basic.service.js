(function () {
    'use strict';

    angular.module('chicken.pages.basic').factory('BasicService', ['$http', '$q', function ($http, $q) {
        return {
            listUser: function (pageNum, pageSize) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/userInfo/list',
                    data: {
                        pageNum: pageNum,
                        pageSize: pageSize
                    }
                }).then(function (response) {
                    deferred.resolve(response.data);
                }).catch(function (response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            },
            addUser: function(user, menus) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/userInfo/save',
                    data: {
                        account: user.account,
                        username: user.username,
                        password: user.defaultPassword?user.password:'',
                        organName: user.organ?user.organ.organName:'',
                        departName: user.depart?user.depart.departName:'',
                        postName: user.post?user.post.postName:'',
                        menuId: menus
                    }
                }).then(function (response) {
                    deferred.resolve(response.data);
                }).catch(function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            },
            deleteUser: function(id) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/userInfo/delete',
                    params: {
                        id: id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                }).catch(function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            },
            listArea: function () {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/dictionary/get',
                    data: {
                        biztype: 'areacode'
                    }
                }).then(function(response) {
                    deferred.resolve(response.data);
                }).catch(function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            },
            listAreaDetail: function(bizcode) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/dictionary/areaDetail',
                    data: {
                        bizcode: bizcode
                    }
                }).then(function(response) {
                    deferred.resolve(response.data);
                }).catch(function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            },
            listMenus: function() {
                var deferred = $q.defer();
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/ggs/sysMenu/list',

                }).then(function(response) {
                    deferred.resolve(response.data);
                }).catch(function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            }
        };
    }]);
})();