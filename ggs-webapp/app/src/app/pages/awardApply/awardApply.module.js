(function () {
    'use strict';

    function routeConfig($stateProvider) {
        $stateProvider
            .state('root.awardApply', {
                url: '/awardApply',
                abstract: true,
                template: '<ui-view></ui-view>',
                title: '奖项申报',
                sidebarMeta: {
                    icon: 'ion-clipboard',
                    order: 6,
                }
            }).state('root.awardApply.apply', {
                url: '/apply',
                templateUrl: 'app/pages/awardApply/apply/apply.html',
                title: '奖项申报',
                controller: 'AwardApplyCtrl',
                sidebarMeta: {
                    order: 1
                }
            });
    }

    angular.module('chicken.pages.awardApply', [])
        .config(routeConfig);
})();