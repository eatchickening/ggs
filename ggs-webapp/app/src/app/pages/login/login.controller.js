(function () {
    'use strict';

    angular.module('chicken.pages.login')
        .controller('LoginCtrl', function ($rootScope, $scope, $state, toastr, LoginService) {
            console.log("test");
            $scope.login = function () {
                LoginService.login($scope.user.username, $scope.user.password).then(function(data){
                    if (data && data.status === 200) {
                        $rootScope.user = {
                            username: $scope.user.username,
                            password: $scope.user.password
                        };
                        $state.go('root.home');
                    }
                }).catch(function(err) {
                    toastr.error(err);
                });
            };
        });
})();