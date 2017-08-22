(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('root.home', {
                url: '/home',
                templateUrl: 'app/pages/home/home.html',
                controller: 'HomeCtrl',
                title: '主页',
                sidebarMeta: {
                    icon: 'ion-android-home',
                    order: 1,
                },
            });
    }

    angular.module('chicken.pages.home', [])
        .config(routeConfig);
})();