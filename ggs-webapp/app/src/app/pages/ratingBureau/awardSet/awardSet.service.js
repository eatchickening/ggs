(function () {
    'use strict';

    angular.module('chicken.pages.info').factory('BureauAwardSetService', ['$http', '$q' ,function ($http, $q) {
        return {
            query: function (pageNum, pageSize, awardName) {
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/appr/list',
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                    transformRequest: function(obj) {
                        var str = [];
                        for (var p in obj)
                            str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                        return str.join("&");
                    },
                    data: {
                        pageNum: pageNum,
                        pageSize: pageSize,
                        name:awardName
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