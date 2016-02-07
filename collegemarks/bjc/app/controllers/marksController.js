(function() {
    
    var MarksController = function ($scope, $log,$window, marksFactory, appSettings) {

        $scope.sortBy = 'name';
        $scope.reverse = false;
        $scope.marks = [];
        $scope.appSettings = appSettings;

        
        function init() {
            marksFactory.getAllMarks()
                .success(function(allmarks) {
                $scope.list = allmarks;
                $scope.currentPage = 1; //current page
                $scope.entryLimit = 20; //max no of items to display in a page
                $scope.filteredItems = $scope.list.length; //Initially for no filter  
                $scope.totalItems = $scope.list.length;
                })
                .error(function(data, status, headers, config) {
                    $log.log(data.error + ' ' + status);
                });
        }
        
        init();
        
    $scope.setPage = function(pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.sort_by = function(predicate) {
        $scope.predicate = predicate;
        $scope.reverse = !$scope.reverse;
    };


        $scope.doSort = function(propName) {
           $scope.sortBy = propName;
           $scope.reverse = !$scope.reverse;
        };

    };


    MarksController.$inject = ['$scope', '$log', '$window', 'marksFactory', 
                                   'appSettings'];

    angular.module('marksApp')
      .controller('MarksController', MarksController);
    
}());