(function () {
    'use strict';

    angular.module('chicken.pages.ratingBureau')
        .controller('RatingBureauAwardManagerCtrl', function ($scope, $state, AwardBureauService, $uibModal, toastr) {
            // list activities by page
            var currentScope = 1;
            var tempPageSize = 10;
            var activityName = '';
            function getActivityList (activityName, pageNum, pageSize) {
                AwardBureauService.listActivities(activityName, pageNum, pageSize).then(function(data) {
                    if (data.code === 0 && data.data && data.data instanceof Array) {
                        $scope.activities = data.data;
                        $scope.totalItems = data.total;
                    }
                }).catch(function(err) {
                    toastr.error(err);
                });
            }

            function init () {
                $scope.displayed = [];
                $scope.pageSizes = [10, 15, 20, 25];
                getActivityList(activityName, 1, 10);
            }

            init();
            
            $scope.pageChange = function (p) {
                if (Math.ceil(p/10)!==currentScope) {
                    $scope.activities = [];
                    var pageNum = Math.floor(p/10) * 10 + 1;
                    if (p % 10 === 0) {
                        pageNum = (Math.floor(p/10) - 1) * 10 + 1;
                    }
                    var pageSize = tempPageSize;
                    getActivityList(activityName, pageNum, pageSize);
                    currentScope = Math.ceil(p/10);
                }
            };

            $scope.changePageSize = function(pageSize){
                $scope.activities = [];
                tempPageSize = pageSize;
                getActivityList(activityName, 1, pageSize);
            };

            // search activity by activity name
            $scope.searchActivity = function(activityName) {
                getActivityList(activityName, 1, 10);
            };

            // delete activity
            $scope.deleteActivity = function(activity) {
                $scope.delActivityName = activity.activityName;
                var delActivityModal = $uibModal.open({
                    animation: true,
                    templateUrl: 'app/pages/ratingBureau/awardManager/delActivity.html',
                    size: 'sm',
                    scope: $scope
                });
                delActivityModal.result.then(function(result){
                    if (result && result === 'OK') {
                        return AwardBureauService.deleteActivity(activity.id).then(function(response) {
                            if (response.data && response.data.code === 0) {
                                getActivityList('', 1, tempPageSize);
                                toastr.success('删除评优活动'+activity.activityName+'成功！', '成功');
                            }
                        });
                    }
                }); 
            };

            // add new activity
            $scope.addActivity = function() {
                $state.go('root.ratingBureau.new');
            };
        });
})();