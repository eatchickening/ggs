(function () {
    'use strict';

    angular.module('chicken.pages.info').factory('TeacherService', ['$http', '$q' ,function ($http, $q) {
        return {
            query: function (pageNum, pageSize, teacherName, schoolName,areaName,schoolType ) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/teacher/list',
                    data: {
                        pageNum: pageNum,
                        pageSize: pageSize,
                        name:teacherName,
                        schoolname:schoolName,
                        areaname:areaName,
                        schooltype:schoolType
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