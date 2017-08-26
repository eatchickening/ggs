(function () {
    'use strict';

    angular.module('chicken.pages.basic').factory('BasicService', ['$http', '$q', function ($http, $q) {
        return {
            listuser: function () {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/userInfo/list',
                    data: {
                        pageNum: 1,
                        pageSize: 10
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