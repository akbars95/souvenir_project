/**
 *
 */

/* apps */
var souvenirAdminPieceApp = angular.module('souvenirAdminPieceApp', []);

/* constants */
souvenirAdminPieceApp.constant("hostConst", "/souvenirs");

/* controllers */
souvenirAdminPieceApp.controller('insertSouvenirCtrl', function ($scope, $http,
                                                                 hostConst) {
    /* objects */

    /* paths */

    /* variables */

    /* functions */
    $scope.save = function () {
        var fd = new FormData();
        angular.forEach($scope.files, function (file) {
            fd.append('souvenirPath', file);
        });
        fd.append('souvenirName', $scope.souvenirName);
        fd.append('souvenirDescription', $scope.souvenirDescription);
        fd.append('souvenirShow', $scope.souvenirShow);
        fd.append('souvenirCategoryId', $scope.souvenirCategoryId);
        fd.append('souvenirPrice', $scope.souvenirPrice);
        $http.post(hostConst + "/souvenirInsert", fd, {
            transformRequest: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        }).success(function (data) {
            console.log(data)
        });
    };

});

souvenirAdminPieceApp
    .controller(
    'adminSouvenirCtrl',
    function ($scope, $http, hostConst) {
        $scope.getAllSOuvenirs = function () {
            $scope.souvenirs = [];
            $scope.souvenirCategories = [];

            $http
                .get(hostConst + "/get_all_souvenirs")
                .success(
                function (data, status, headers, config) {
                    $scope.souvenirs = data;
                    $scope.addNewSouvenirBootstrapClass = ($scope.souvenirs.length % 2 == 0) ? "col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-5 col-lg-5"
                        : "col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1";
                })
                .error(function (data, status, headers, config) {
                    // log error
                });

            $scope.styleClassesForInsertNewSouvenir = "glyphicon-plus";

            $scope.eventMouseEnterNew = function () {
                $scope.styleClassesForInsertNewSouvenir = "glyphicon-plus-sign";
            };

            $scope.eventMouseLeaveNew = function () {
                $scope.styleClassesForInsertNewSouvenir = "glyphicon-plus";
            };

        };

        $scope.getAllSouvenirCategories = function(){
            $http
                .get(hostConst + "/getAllSouvenirCategories")
                .success(
                function (data, status, headers, config) {
                    $scope.souvenirCategories = data;
                })
                .error(function (data, status, headers, config) {
                    // log error
                });
        };

        $scope.getAllSOuvenirs();
        $scope.getAllSouvenirCategories();

    });

/* directives */
souvenirAdminPieceApp.directive('fileInput', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, elm, attrs) {
            elm.bind('change', function () {
                $parse(attrs.fileInput).assign(scope, elm[0].files);
                scope.$apply();
            })
        }
    };
}]);