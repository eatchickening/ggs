(function () {
    'use strict';

    angular.module('chicken.pages.ratingBureau').factory('AwardBureauService', ['$http', '$q', function ($http, $q) {
        return {
            listActivities: function(activityName, pageNum, pageSize){
                var deferred = $q.defer();
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/ggs/activity/list',
                    data: {
                        activityName: activityName,
                        pageNum: pageNum,
                        pageSize: pageSize
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