(function () {
    'use strict';

    angular.module('chicken.pages.basic')
        .controller('DepartEditCtrl', function ($scope, $state) {
            var data = $state.params;
            function transform(data) {
                var result = [];
                data.forEach(function(area) {
                    result.push({
                        id: area.areacode,
                        parent: '#',
                        type: 'folder',
                        text: area.areaName,
                        areacode: area.areacode,
                        state: {
                            opened: true
                        }
                    });
                    area.organVoList.forEach(function(organ) {
                        result.push({
                            id: organ.organcode,
                            parent: area.areacode,
                            type: 'folder',
                            text: organ.organName,
                            organcode: organ.organcode,
                            state: {
                                opened: true
                            }
                        });
                        organ.departVoList.forEach(function(depart) {
                            result.push({
                                id: depart.departcode,
                                parent: organ.organcode,
                                type: 'folder',
                                text: depart.departName,
                                departcode: depart.departcode,
                                state: {
                                    opened: true
                                }
                            });
                            depart.post.forEach(function(p) {
                                result.push({
                                    id: p.postcode,
                                    parent: depart.departcode,
                                    type: 'folder',
                                    text: p.postName,
                                    postcode: p.postcode,
                                    state: {
                                        opened: true
                                    }
                                });
                            });
                        });
                    });
                });
                return result;
            }
            $scope.treeData = transform(data.organs);
        });
})();