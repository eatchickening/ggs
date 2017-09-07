(function () {
    'use strict';

    angular.module('chicken.pages.info').factory('SchoolService', ['$http', '$q' ,function ($http, $q) {
        return {
            query: function (pageNum, pageSize, region, schoolType, schoolName) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/school/list',
                    data: {
                        pageNum: pageNum,
                        pageSize: pageSize,
                        areacode:region,
                        schooltype:schoolType,
                        schoolname:schoolName
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