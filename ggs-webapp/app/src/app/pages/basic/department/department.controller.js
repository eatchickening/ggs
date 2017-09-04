(function () {
    'use strict';

    angular.module('chicken.pages.basic')
        .controller('DepartmentCtrl', function ($scope, $state, $uibModal, BasicService, toastr) {

            // list organ by page
            function transformData(data) {
                var organs = [];
                data.forEach(function(area) {
                    if (area.organVoList && area.organVoList.length > 0) {
                        area.organVoList.forEach(function(organ) {
                            if (organ.departVoList && organ.departVoList.length > 0){
                                organ.departVoList.forEach(function(depart){
                                    if (depart.post && depart.post.length > 0) {
                                        depart.post.forEach(function(p){
                                            organs.push({
                                                areacode: area.areacode,
                                                areaName: area.areaName,
                                                organcode: organ.organcode,
                                                organName: organ.organName,
                                                departcode: depart.departcode,
                                                departName: depart.departName,
                                                postcode: p.postcode,
                                                postName: p.postName
                                            });
                                        });
                                    } else {
                                        organs.push({
                                            areacode: area.areacode,
                                            areaName: area.areaName,
                                            organcode: organ.organcode,
                                            organName: organ.organName,
                                            departcode: depart.departcode,
                                            departName: depart.departName,
                                        });
                                    }
                                });
                            } else {
                                organs.push({
                                    areacode: area.areacode,
                                    areaName: area.areaName,
                                    organcode: organ.organcode,
                                    organName: organ.organName
                                });
                            }
                        });
                    } else {
                        organs.push({
                            areacode: area.areacode,
                            areaName: area.areaName
                        });
                    }
                    
                });
                return organs;
            }

            var organs = '';
            function getOrganList () {
                BasicService.listAreaDetail('').then(function(data) {
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        organs = data.data;
                        $scope.organList = transformData(data.data);
                        $scope.totalItems = $scope.organList.length;
                    }
                }).catch(function(err) {
                    toastr.error(err);
                });
            }

            function init () {
                $scope.displayed = [];
                $scope.pageSizes = [10, 15, 20, 25];
                getOrganList(1, 10);
            }

            init();

            $scope.edit = function () {
                $state.go('root.basic.edit', {organs: organs});
            };

        });
})();