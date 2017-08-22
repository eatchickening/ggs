(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('root.basic', {
                url: '/basic',
                abstract: true,
                template: '<ui-view></ui-view>',
                title: '基础设置',
                sidebarMeta: {
                    icon: 'ion-settings',
                    order: 2,
                }
            }).state('root.basic.department', {
                url: '/department',
                templateUrl: 'app/pages/basic/department/department.html',
                title: '部门与岗位设置',
                controller: 'DepartmentCtrl',
                sidebarMeta: {
                    order: 1
                }
            }).state('root.basic.user', {
                url: '/user',
                templateUrl: 'app/pages/basic/user/user.html',
                title: '用户管理',
                controller: 'UserCtrl',
                sidebarMeta: {
                    order: 2
                }
            });
    }

    angular.module('chicken.pages.basic', [])
        .config(routeConfig);
})();