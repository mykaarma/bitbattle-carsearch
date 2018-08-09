var app = angular.module('bitBattleApp', []);

app.controller('bitBattleCtrl', function($scope, $http) {
    
  $scope.findResults = function() {
    
    
    $scope.searchResults = [];
    $scope.lblStatusMsg='loader';
    $http({
        method : "GET",
        url : "/dealer/getDealerListByMake/"+$scope.make
    }).then(function mySuccess(response) {
        
        $scope.searchResults = response.data;
        $scope.lblStatusMsg='';
    }, function myError(response) {
        $scope.searchResults = response.statusText;
    });
  }
});