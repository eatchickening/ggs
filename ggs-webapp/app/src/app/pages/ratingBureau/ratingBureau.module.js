(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('root.ratingBureau', {
                url: '/ratingBureau',
                abstract: true,
                template: '<ui-view></ui-view>',
                title: '教育局评优活动',
                sidebarMeta: {
                    icon: 'ion-bookmark',
                    order: 4,
                }
            }).state('root.ratingBureau.awardSet', {
                url: '/ratingBureauAwardSet',
                templateUrl: 'app/pages/ratingBureau/awardSet/awardSet.html',
                title: '评优奖项设置',
                controller: 'RatingBureauAwardSetCtrl',
                sidebarMeta: {
                    order: 1
                }
            }).state('root.ratingBureau.awardManager', {
                url: '/ratingBureauAwardManager',
                templateUrl: 'app/pages/ratingBureau/awardManager/awardManager.html',
                title: '评优活动管理',
                controller: 'RatingBureauAwardManagerCtrl',
                sidebarMeta: {
                    order: 2
                }
            }).state('root.ratingBureau.awardAssess', {
                url: '/ratingBureauAwardAssess',
                templateUrl: 'app/pages/ratingBureau/awardAssess/awardAssess.html',
                title: '评优活动评定列表',
                controller: 'RatingBureauAwardAssessCtrl',
                sidebarMeta: {
                    order: 3
                }
            }).state('root.ratingBureau.new', {
                url: '/new',
                templateUrl: 'app/pages/ratingBureau/awardManager/createActivity.html',
                title: '添加评优活动',
                controller: 'CreateActivityCtrl'
            });
    }

    angular.module('chicken.pages.ratingBureau', [])
        .config(routeConfig);
})();