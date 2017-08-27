(function () {
    'use strict';

    angular.module('chicken.pages.info').factory('TeacherService', ['$http', '$q' ,function ($http, $q) {
        return {
            query: function (username, password) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/student/list',
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function(obj) {
                        var str = [];
                        for (var p in obj)
                            str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                        return str.join("&");
                    },
                    data: {
                        account: username,
                        password: password
                    }
                }).then(function (response) {
                    deferred.resolve(response);
                }).catch(function (response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            }
        };
    }]);
})();