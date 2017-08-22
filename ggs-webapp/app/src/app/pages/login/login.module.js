(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('login', {
                url: '/login',
                views: {
                    'whole@': {
                        templateUrl: 'app/pages/login/login.html'
                    }
                },
                title: 'Login'
            });
    }

    angular.module('chicken.pages.login', [])
        .config(routeConfig);
})();