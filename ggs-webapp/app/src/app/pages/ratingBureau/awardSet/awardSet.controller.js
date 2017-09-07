(function () {
  'use strict';

  angular.module('chicken.pages.ratingBureau')
    .controller('RatingBureauAwardSetCtrl', function ($scope, $uibModal, toastr, BureauAwardSetService) {
      var currentScope = 1;
      $scope.tempPageSize = 10;
      $scope.pageSize = 10;


      function getAwardList(pageNum, pageSize, awardName) {
        BureauAwardSetService.query(pageNum, pageSize, awardName).then(function (data) {
          if (data.code === 0 && data.data && data.data instanceof Array) {
            $scope.awardList = data.data;
            $scope.totalItems = data.total;
          } else {
            toastr.error(data.message);
          }
        }).catch(function (err) {
          toastr.error(err);
        });
      }

      $scope.queryAwardInfo = function (awardName) {
        if (!awardName) {
          awardName = '';
        }
        getAwardList(1, $scope.tempPageSize, awardName);
      };

      function init() {
        $scope.displayed = [];
        $scope.pageSizes = [5, 10, 15, 20, 25];
        getAwardList(1, $scope.tempPageSize, '');
      }

      init();

      $scope.pageChange = function (p) {
        if (Math.ceil(p / 10) !== currentScope) {
          $scope.schoolList = [];
          var pageNum = Math.floor(p / 10) * 10 + 1;
          if (p % 10 === 0) {
            pageNum = (Math.floor(p / 10) - 1) * 10 + 1;
          }
          var pageSize = $scope.tempPageSize;
          getAwardList(pageNum, pageSize, '');
          currentScope = Math.ceil(p / 10);
        }
      };

      $scope.changePageSize = function (pageSize) {
        $scope.schoolList = [];
        $scope.tempPageSize = pageSize;
        getAwardList(1, pageSize, '');
      };

      //编辑
      $scope.editeAward = function (award) {
      };

      //删除
      $scope.deleteAward = function (award) {
      };

      $scope.addAward = function () {

        var vm = this;

        var model = $uibModal.open({
          animation: true,
          templateUrl: 'app/pages/ratingBureau/awardSet/awardAdd.html',
          size: 'lg',
          scope: $scope
        });
        model.result.then(
          //close
          function (result) {
            var a = result;
          },
          //dismiss
          function (result) {
            var a = result;
          });
      };
    });
})();