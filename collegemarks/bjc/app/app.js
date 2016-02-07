(function() {
    
    var app = angular.module('marksApp', ['ui.bootstrap','ngRoute', 'ngAnimate']);

    app.filter('startFrom', function() {
    return function(input, start) {
        if(input) {
            start = +start; //parse to int
            return input.slice(start);
        }
        return [];
    }
});
    
    app.config(function($routeProvider) {
        $routeProvider

             .when('/getAllMarks', {
                controller: 'MarksController',
                templateUrl: 'app/views/Marks.html'
            })    

    });
    
}());