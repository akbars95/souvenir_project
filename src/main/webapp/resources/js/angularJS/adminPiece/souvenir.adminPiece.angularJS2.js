/*apps*/
var adminSouvenirAngularJSRoutingApp = angular.module('adminSouvenirAngularJSRoutingApp', ['ngRoute']);

/* constants */
adminSouvenirAngularJSRoutingApp.constant("hostConst", "/souvenirs");

/*ctrls*/
adminSouvenirAngularJSRoutingApp.controller('indexCtrl', function ($scope) {
    $scope.message = "Index";
});

adminSouvenirAngularJSRoutingApp.controller('souvenirCtrl', function ($scope, $http, hostConst) {

    $scope.classForSouvenirOdd = "col-xs-12 col-sm-12 col-md-6 col-lg-6";
    $scope.classForSouvenirEven = "col-md-6 col-lg-6";
    $scope.getAllSouvenirs = function () {
        $scope.souvenirs = [];

        $http.get(hostConst + "/get_all_souvenirs")
            .success(
                function (data, status, headers, config) {
                    $scope.souvenirs = data;
                    $scope.addNewSouvenirBootstrapClass = ($scope.souvenirs.length % 2 == 0) ? $scope.classForSouvenirOdd
                        : $scope.classForSouvenirEven;
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


        $scope.souvenirCategories = [];
    $scope.getAllSouvenirCategories = function () {
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

    $scope.saveSouvenir = function () {
        var fd = new FormData();
        if ($scope.souvenirFiles && $scope.souvenirFiles.length > 0) {
            for (i = 0; i < $scope.souvenirFiles.length; i++) {
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
            .success(function (data, status, headers, config) {
                if (data && data == true && status == 200) {
                    $scope.getAllSouvenirs();
                    $scope.resetForm();
                }
            })
            .error(function (data, status, headers, config) {
                console.log(data);
            });
    };

    $scope.resetForm = function () {
        var temp = $scope.souvenirCategories;
        $scope.souvenirName = "";
        $scope.souvenirDescription = "";
        $scope.souvenirShow = false;
        $scope.souvenirPrice = 0.0;
        $scope.souvenirCountOfDaysForOrder = 0;
        $scope.currentSouvenirCategoryId = "-";
        $scope.souvenirFiles = null;
        $scope.souvenirCategories = temp;
        angular.element("input[type='file']").val(null);
    };

    $scope.addNewCategory = false;

    $scope.showOrHideAddNewSouvenirCategory = function () {
        $scope.addNewCategory = !$scope.addNewCategory;
    };

    $scope.addNewSouvenirCategory = function () {
        var dataObj = {
            souvenirCategory: $scope.souvenirCategory
        };
        $http.post(hostConst + "/insertSouvenirCategories", dataObj)
            .success(function (data, status, headers, config) {
                if (data && data == true && status == 200) {
                    $scope.getAllSouvenirCategories();
                    $scope.addNewCategory = false;
                }
            })
            .error(function (data, status, headers, config) {
                console.log(data);
            });
    };

    $scope.currentHoverIndex = -1;

    $scope.showOrHideButtons = function (index) {
        $scope.currentHoverIndex = index;
    };

    $scope.currentSouvenirForEdit = -1;

    $scope.editSouvenir = function (index) {
        $scope.currentSouvenirForEdit = index;
    };

    $scope.currentSouvenirForRemove = -1;

    $scope.prepareForRemoveSouvenir = function (index, currentSouvenirName) {
        $scope.currentSouvenirForRemove = index;
        $scope.currentSouvenirName = currentSouvenirName;
    };

    $scope.removeSouvenir = function () {
        if ($scope.currentSouvenirForRemove > -1 && $scope.currentSouvenirForRemove < $scope.souvenirs.length) {
            var temp = $scope.souvenirs[$scope.currentSouvenirForRemove];
            $scope.souvenirs.splice($scope.currentSouvenirForRemove, 1);
            $http.delete(hostConst + "/delete_souvenir/" + temp.souvenirId)
                .success(function (data, status, headers) {
                    console.log(data + " - " + status);
                })
                .error(function (data, status, header, config) {
                    console.log(data + " - " + status);
                });
        } else {
            console.log("error index - " + $scope.currentSouvenirForRemove);
        }
    };

    $scope.showSouvenir = function(index){
        var temp = $scope.souvenirs[index];
        if($scope.souvenirs[index].souvenirShow){
            $scope.souvenirs[index].souvenirShow = false;
        }else {
            $scope.souvenirs[index].souvenirShow = true;
        }

        $http.put(hostConst + "/show_hide_souvenir/" + temp.souvenirId)
                .success(function (data, status, headers) {
                    console.log(data + " - " + status);
                })
                .error(function (data, status, header, config) {
                    console.log(data + " - " + status);
                });

    };

    $scope.hideSouvenir = function(index){
        $scope.showSouvenir(index);
    };

    $scope.getAllSouvenirs();
    $scope.getAllSouvenirCategories();
    $scope.resetForm();

});

adminSouvenirAngularJSRoutingApp.controller('souvenirCategoryCtrl', function ($scope) {
    $scope.message = "Souvenir Category";
});

adminSouvenirAngularJSRoutingApp.controller('messageCtrl', function ($scope) {
    $scope.message = "Message";
});

/*configs*/
adminSouvenirAngularJSRoutingApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/souvenirs/adminPiece/index',
            controller: 'indexCtrl'
        })
        .when('/souvenirs', {
            templateUrl: '/souvenirs/adminPiece/souvenir',
            controller: 'souvenirCtrl'
        })
        .when('/souvenir_categories', {
            templateUrl: '/souvenirs/adminPiece/souvenirCategory',
            controller: 'souvenirCategoryCtrl'
        })
        .when('/messages', {
            templateUrl: '/souvenirs/adminPiece/message',
            controller: 'messageCtrl'
        })
        .otherwise({redirectTo: '/'});
}]);


/* directives */
adminSouvenirAngularJSRoutingApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files);
                });
            });
        }
    };
}]);
