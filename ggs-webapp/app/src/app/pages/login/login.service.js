(function () {
    'use strict';

    angular.module('chicken.pages.login').factory('LoginService', ['$http', '$q', function($http, $q){
        return {
            login: function (username, password) {
                var deferred = $q.defer();
                $http.post('http://localhost:8080/sys/login', {
                    username: username,
                    password: password
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