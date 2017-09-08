(function () {
    'use strict';

    angular.module('chicken.pages.ratingBureau')
        .controller('CreateActivityCtrl', function ($scope, $state, AwardBureauService, toastr, Upload, $timeout) {

            $scope.awardDisable = false;

            $scope.uploadFiles = function (files) {
                $scope.progress = 0;
                $scope.files = files;
                if (files && files.length) {
                    Upload.upload({
                        url: 'http://localhost:8080/ggs/activity/upload',
                        params: {
                            id: 1,
                            files: files
                        }
                    }).then(function (response) {
                        $timeout(function () {
                            $scope.result = response.data;
                        });
                    }, function (response) {
                        if (response.status > 0) {
                            $scope.errorMsg = response.status + ': ' + response.data;
                        }
                    }, function (evt) {
                        $scope.progress = 
                            Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
                    });
                }
            };
        });
})();