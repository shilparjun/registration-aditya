(function() {
    var marksFactory = function($http) {
    
 
        var factory = {};
        
        factory.getAllMarks = function() {
            return $http.get('/allMarks');        
        };
 

        return factory;
    };
    
    marksFactory.$inject = ['$http'];
        
    angular.module('marksApp').factory('marksFactory', 
                                           marksFactory);
                                           
}());