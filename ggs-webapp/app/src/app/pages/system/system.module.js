(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('root.system', {
                url: '/system',
                abstract: true,
                template: '<ui-view></ui-view>',
                title: '系统管理',
                sidebarMeta: {
                    icon: 'ion-gear-a',
                    order: 4,
                }
            }).state('root.system.log', {
                url: '/log',
                templateUrl: 'app/pages/system/log/log.html',
                title: '日志管理',
                controller: 'LogCtrl',
                sidebarMeta: {
                    order: 1
                }
            }).state('root.system.notification', {
                url: '/notification',
                templateUrl: 'app/pages/system/notification/notification.html',
                title: '通知信息',
                controller: 'NotificationCtrl',
                sidebarMeta: {
                    order: 2
                }
            });
    }

    angular.module('chicken.pages.system', [])
        .config(routeConfig);
})();