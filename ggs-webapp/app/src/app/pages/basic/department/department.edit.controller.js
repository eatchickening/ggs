(function () {
    'use strict';

    angular.module('chicken.pages.basic')
        .controller('DepartEditCtrl', function ($scope, $state) {
            var organs = $state.params;
            $scope.treeData = organs;
        });
})();