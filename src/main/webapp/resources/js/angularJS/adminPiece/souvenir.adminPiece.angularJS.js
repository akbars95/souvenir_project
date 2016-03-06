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
        $scope.getAllSouvenirs = function () {
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

        $scope.saveSouvenir = function(){
        	var fd = new FormData();
        	if($scope.souvenirFiles && $scope.souvenirFiles.length > 0){
        		for(i = 0; i < $scope.souvenirFiles.length; i++){
        			fd.append("souvenirFiles", $scope.souvenirFiles[i]);
        		}
        	}

        	fd.append("souvenirName", $scope.souvenirName);
        	fd.append("souvenirDescription", $scope.souvenirDescription);
        	fd.append("souvenirShow", $scope.souvenirShow);
        	fd.append("souvenirPrice", $scope.souvenirPrice);
        	fd.append("souvenirCountOfDaysForOrder", $scope.souvenirCountOfDaysForOrder);
        	fd.append("souvenirCategoryId", $scope.currentSouvenirCategoryId);
        	var c = angular.isNumber($scope.currentSouvenirCategoryId);
        	var g = angular.isNumber($scope.souvenirPrice);
            $http.post(hostConst + "/insert_souvenir", fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function(data, status, headers, config){
            	console.log(data);
            })
            .error(function(data, status, headers, config){
            	console.log(data);
            });
        };
        
        $scope.resetForm = function(){
        	$scope.souvenirName = "";
        	$scope.souvenirDescription = "";
        	$scope.souvenirShow = false;
        	$scope.souvenirPrice = 0.0;
        	$scope.souvenirCountOfDaysForOrder = 0;
        	$scope.currentSouvenirCategoryId = "";
        	$scope.souvenirFiles = null;
        	angular.element("input[type='file']").val(null);
        };
        
        $scope.getAllSouvenirs();
        $scope.getAllSouvenirCategories();
        $scope.resetForm();

    });

/* directives */
souvenirAdminPieceApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files);
                });
            });
        }
    };
}]);