(function () {
    'use strict';

    angular.module('chicken.pages.basic').factory('BasicService', ['$http', '$q', function ($http, $q) {
        return {
            listuser: function (pageNum, pageSize) {
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
            adduser: function() {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/userInfo/save',
                    data: {
                        account: 'testyw',
                        username: '张三',
                        password: '123456',
                        departname: '信息学院',
                        postname: '教授',
                        organname: '山农大',
                        menuId: '1,2'
                    }
                }).then(function (response) {
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
                    method: 'GET',
                    url: 'http://localhost:8080/ggs/dictionary/areaDetail',
                    params: {
                        bizcode: bizcode
                    }
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