(function () {
    'use strict';

    angular.module('chicken.pages.info').factory('StudentService', ['$http', '$q', function ($http, $q) {
        return {
            query: function (pageNum, pageSize, studentId, schoolCode, areaCode, schoolType) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/student/list',
                    data: {
                        pageNum: pageNum,
                        pageSize: pageSize,
                        areacode: areaCode,
                        schooltype: schoolType,
                        schoolcode: schoolCode,
                        studentid: studentId
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