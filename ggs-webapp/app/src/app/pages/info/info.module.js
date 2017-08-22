(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('root.info', {
                url: '/info',
                abstract: true,
                template: '<ui-view></ui-view>',
                title: '信息查询',
                sidebarMeta: {
                    icon: 'ion-search',
                    order: 3,
                }
            }).state('root.info.school', {
                url: '/school',
                templateUrl: 'app/pages/info/school/school.html',
                title: '学校信息查询',
                controller: 'SchoolCtrl',
                sidebarMeta: {
                    order: 1
                }
            }).state('root.info.teacher', {
                url: '/teacher',
                templateUrl: 'app/pages/info/teacher/teacher.html',
                title: '教师信息查询',
                controller: 'TeacherCtrl',
                sidebarMeta: {
                    order: 2
                }
            }).state('root.info.student', {
                url: '/student',
                templateUrl: 'app/pages/info/student/student.html',
                title: '学生信息查询',
                controller: 'StudentCtrl',
                sidebarMeta: {
                    order: 3
                }
            });
    }

    angular.module('chicken.pages.info', [])
        .config(routeConfig);
})();