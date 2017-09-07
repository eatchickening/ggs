(function () {
    'use strict';

    angular.module('chicken.pages.info').factory('InfoService', ['$http', '$q', function ($http, $q) {
        return {
            queryAreas: function () {
                //查询区域列表
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/dictionary/list',
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function(obj) {
                        var str = [];
                        for (var p in obj)
                            str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                        return str.join("&");
                    },
                    data: {
                        biztype: 'areacode'
                    }
                }).then(function (response) {
                    deferred.resolve(response.data);
                }).catch(function (response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            },
            querySchoolTypes: function () {
                //查询学校类型
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/dictionary/list',
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function(obj) {
                        var str = [];
                        for (var p in obj)
                            str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                        return str.join("&");
                    },
                    data: {
                        biztype: 'schootype'
                    }
                }).then(function (response) {
                    deferred.resolve(response.data);
                }).catch(function (response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            },
            querySchools: function (areaCode, schoolType) {
                //查询学校
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/school/listbyCondition',
                    // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    // transformRequest: function(obj) {
                    //     var str = [];
                    //     for (var p in obj)
                    //         str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    //     return str.join("&");
                    // },
                    data: {
                        areacode: areaCode,
                        schooltype: schoolType
                    }
                }).then(function (response) {
                    deferred.resolve(response.data);
                }).catch(function (response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            }
        };
    }]);
})();