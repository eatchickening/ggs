/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('chicken.pages', [
      'ui.router',
      'ngFileUpload',
      'chicken.pages.login',
      'chicken.pages.home',
      'chicken.pages.basic',
      'chicken.pages.info',
      'chicken.pages.system',
      'chicken.pages.awardApply',
      'chicken.pages.ratingBureau',
      'chicken.pages.ratingSchool'
    ])
    .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider,$urlRouterProvider) {
    $stateProvider
      .state('root', {
        url: '',
        abstract: true,
        views: {
          'whole@': {
            templateUrl: 'app/main.html'
          }
        },
        resolve: {
          userObj: function($rootScope, $state) {
            if ($rootScope.user) {
              return;
            }
            if (!$rootScope.user) {
              $state.go('login');
              return;
            }
          }
        }
      });
    $urlRouterProvider.otherwise('/login');

  }

  // angular.module('chicken.pages')
  //   .constant('_', window._);

})();