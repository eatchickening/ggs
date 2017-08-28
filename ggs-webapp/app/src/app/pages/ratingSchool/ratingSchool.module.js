(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('root.ratingSchool', {
                url: '/ratingSchool',
                abstract: true,
                template: '<ui-view></ui-view>',
                title: '学校评优活动',
                sidebarMeta: {
                    icon: 'ion-bookmark',
                    order: 5,
                }
            }).state('root.ratingSchool.awardSet', {
                url: '/ratingSchoolAwardSet',
                templateUrl: 'app/pages/ratingSchool/awardSet/awardSet.html',
                title: '评优奖项设置',
                controller: 'RatingSchoolAwardSetCtrl',
                sidebarMeta: {
                    order: 1
                }
            }).state('root.ratingSchool.awardManager', {
                url: '/ratingSchoolAwardManager',
                templateUrl: 'app/pages/ratingSchool/awardManager/awardManager.html',
                title: '评优活动管理',
                controller: 'RatingSchoolAwardManagerCtrl',
                sidebarMeta: {
                    order: 2
                }
            }).state('root.ratingSchool.awardAssess', {
                url: '/ratingSchoolAwardAssess',
                templateUrl: 'app/pages/ratingSchool/awardAssess/awardAssess.html',
                title: '评优活动评定列表',
                controller: 'RatingSchoolAwardAssessCtrl',
                sidebarMeta: {
                    order: 3
                }
            });
    }

    angular.module('chicken.pages.ratingSchool', [])
        .config(routeConfig);
})();