/*apps*/
var adminSouvenirAngularJSRoutingApp = angular.module('adminSouvenirAngularJSRoutingApp', ['ngRoute']);

/* constants */
adminSouvenirAngularJSRoutingApp.constant("hostConst", "/souvenirs");

/*configs*/
adminSouvenirAngularJSRoutingApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {template: 'This is the default Route'})
        .when('/computers', {template: 'This is the <h1>computers</h1> Route'})
        .when('/printers', {template: 'This is the printers Route'})
        .when('/messages', {templateUrl: '/souvenirs/adminPiece/message'})
        .otherwise({redirectTo: '/'});
}]);