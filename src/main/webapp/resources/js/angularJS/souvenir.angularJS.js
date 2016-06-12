/**
 *
 */

/* app */
var souvenirApp = angular.module('souvenirApp', ['ngRoute', 'ngAnimate']);

/* constants */
souvenirApp.constant("hostConst", "/souvenirs");
souvenirApp.constant("OK_CODE", "100");//OK_CODE, ERROR_CODE, INSERT_OK_CODE, INSERT_ERROR_CODE, UPDATE_OK_CODE, UPDATE_ERROR_CODE, DELETE_OK_CODE, DELETE_ERROR_CODE, GET_OK_CODE, GET_ERROR_CODE
souvenirApp.constant("ERROR_CODE", "101");
souvenirApp.constant("INSERT_OK_CODE", "102");
souvenirApp.constant("INSERT_ERROR_CODE", "103");
souvenirApp.constant("UPDATE_OK_CODE", "104");
souvenirApp.constant("UPDATE_ERROR_CODE", "105");
souvenirApp.constant("DELETE_OK_CODE", "106");
souvenirApp.constant("DELETE_ERROR_CODE", "107");
souvenirApp.constant("GET_OK_CODE", "108");
souvenirApp.constant("GET_ERROR_CODE", "109");

/* http://souvenir-mtsmda999.rhcloud.com */

/* Ctrl */

/* fixed piece */
souvenirApp.controller('fixedPieceCtrl', function ($scope, $http) {
    $scope.skypeLinkClass = "skypeClose";
    $scope.phoneLinkClass = "phoneClose";
    $scope.emailLinkClass = "emailClose";

    $scope.openInfoBtn = "infoClose";

    $scope.infoBtnToggle = false;

    $scope.infoBtnClick = function () {
        $scope.infoBtnToggle = !$scope.infoBtnToggle;
        if ($scope.infoBtnToggle == true) {
            $scope.openInfoBtn = "infoOpen";
        } else {
            $scope.openInfoBtn = "infoClose";
            $scope.skypeLinkClass = "skypeClose";
            $scope.phoneLinkClass = "phoneClose";
            $scope.emailLinkClass = "emailClose";
        }
    };

    $scope.otherBtnClick = function (param) {
        if (param == 0) {
            if ($scope.skypeLinkClass == "skypeClose") {
                $scope.skypeLinkClass = "skypeOpen";
            } else {
                $scope.skypeLinkClass = "skypeClose";
            }
        } else if (param == 1) {
            if ($scope.phoneLinkClass == "phoneClose") {
                $scope.phoneLinkClass = "phoneOpen";
            } else {
                $scope.phoneLinkClass = "phoneClose";
            }
        } else if (param == 2) {
            if ($scope.emailLinkClass == "emailClose") {
                $scope.emailLinkClass = "emailOpen";
            } else {
                $scope.emailLinkClass = "emailClose";
            }
        }
    }

});

/* index page */
souvenirApp.controller('indexCtrl',
    function ($scope, $http, $timeout, hostConst) {

    });

/* catalog page */
souvenirApp
    .controller(
    'catalogCtrl',
    function ($scope, $http, $timeout, hostConst, $location, OK_CODE, ERROR_CODE, INSERT_OK_CODE, INSERT_ERROR_CODE, UPDATE_OK_CODE, UPDATE_ERROR_CODE, DELETE_OK_CODE, DELETE_ERROR_CODE, GET_OK_CODE, GET_ERROR_CODE) {
        var get_all_souvenirsURL = "/get_all_souvenirs";

        $scope.souvenirs = [];
        $http.get(hostConst + get_all_souvenirsURL).success(
            function (data, status, headers, config) {
                if (status == 200 && data.responseCode.code == GET_OK_CODE) {
                    $scope.souvenirs = data.object;

                    for(i = 0; i < $scope.souvenirs.length; i++){
                        console.log($scope.souvenirs[i].souvenirName + " - - - - - " + $scope.souvenirs[i].souvenirMainPhotoId.souvenirPhotoPath);
                    }

                    $scope.changeCountPerPage();
                }
            }).error(function (data, status, headers, config) {
                console.log(data);
                // log error
            });

        $scope.currentSortType = false;
        $scope.currentFieldName = "";

        $scope.changeSortType = function (fieldName) {
            $scope.currentSortType = !$scope.currentSortType;
            $scope.currentFieldName = fieldName;
            $scope.checkSortType();
        }

        $scope.checkSortType = function () {
            if ($scope.currentFieldName == "souvenirName"
                && $scope.currentSortType == true) {
                return "glyphicon glyphicon-sort-by-alphabet-alt";
            } else if ($scope.currentFieldName == "souvenirName"
                && $scope.currentSortType == false) {
                return "glyphicon glyphicon-sort-by-alphabet";
            }

            if ($scope.currentFieldName == "souvenirPrice"
                && $scope.currentSortType == true) {
                return "glyphicon glyphicon-sort-by-order-alt";
            } else if ($scope.currentFieldName == "souvenirPrice"
                && $scope.currentSortType == false) {
                return "glyphicon glyphicon-sort-by-order";
            }

            if (($scope.currentFieldName == "souvenirCountOfDaysForOrder"
                || $scope.currentFieldName == "souvenirAudit.createdDatetime" || $scope.currentFieldName == "souvenirAudit.lastUpdateDatetime")
                && $scope.currentSortType == true) {
                return "glyphicon glyphicon-sort-by-attributes-alt";
            } else if (($scope.currentFieldName == "souvenirCountOfDaysForOrder"
                || $scope.currentFieldName == "souvenirAudit.createdDatetime" || $scope.currentFieldName == "souvenirAudit.lastUpdateDatetime")
                && $scope.currentSortType == false) {
                return "glyphicon glyphicon-sort-by-attributes";
            }
        }

        $scope.countPerPage = [{
            name: 10,
            value: 10
        }, {
            name: 25,
            value: 25
        }, {
            name: 50,
            value: 50
        }, {
            name: 100,
            value: 100
        }, {
            name: 'all',
            value: 10000
        }];

        $scope.currentCountValue = $scope.countPerPage[0];
        $scope.countOfPage = [];

        $scope.showPagination = function () {
            if ($scope.souvenirs.length > $scope.currentCountValue.name) {
                /*
                 * var tempCountPages = $scope.souvenirs.length /
                 * $scope.currentCountValue.value; for (i = 0; i <
                 * Math.round(tempCountPages); i++) {
                 * $scope.countOfPage.push(i); }
                 */
                return true;
            }
            return false;
        };

        $scope.changeCountPerPage = function () {
            $scope.showPagination();
        };

        $scope.countInRowSouvenirs = [{
            count : 12,
            label : "1"
        },{
            count : 6,
            label : "2"
        },{
            count : 4,
            label : "3"
        },{
            count : 3,
            label : "4"
        }];

        $scope.currentCountInRowSouvenir = $scope.countInRowSouvenirs[2];

        $scope.allCurrencies = [{
            name: "$",
            value: "USD"
        }, {
            name: "€",
            value: "EUR"
        }, {
            name: "mdl",
            value: "mold_lei"
        }, {
             name: "₽",
             value: "RUB"
         }];

        $scope.getBNMExchange = function(){
            $http({
                method  : "GET", //'JSONP',
                url     : "http://bnm.md/ro/official_exchange_rates?get_xml=1&date=10.05.2016",
                /*timeout : 500,*/
                /*headers : {
                    "Access-Control-Allow-Origin" : "http://localhost:8989"*//*,
                    "Access-Control-Allow-Methods" : "GET,POST,PUT,DELETE,OPTIONS",
                    "Access-Control-Allow-Headers" : "*"*//**//*,
                    "content-type" : "application/json; charset=utf-8"*//*
                },*/
    //            params  : {}//,  // Query Parameters (GET)
                transformResponse : function(data, headersGetter, status) {
                    // string -> XML document object
                    console.log(data);
                    return $.parseXML(data);
                }
            }).success(
                function (data, status, headers, config) {
                    $scope.bnm = data.documentElement.innerHTML;
                    $scope.bnm = data;
                    console.log($scope.bnm.length);
                }).error(function (data, status, headers, config) {
                    // log error
                });
        }

});

/* souvenirById page */
souvenirApp.controller('souvenirByIdCtrl', function ($scope, $http, $timeout,
                                                     hostConst) {
    var get_all_souvenirsURL = "/get_all_souvenirs";
    $http.get(hostConst + get_all_souvenirsURL).success(
        function (data, status, headers, config) {
            $scope.souvenirs = data;
        }).error(function (data, status, headers, config) {
            // log error
        });
});

/* advanced_search page */
souvenirApp.controller('advancedSearchCtrl', function ($scope, $http, $timeout,
                                                       hostConst) {

});

/* about_us page */
souvenirApp.controller('aboutUsCtrl', function ($scope, $http, $timeout,
                                                hostConst) {

});

/*registration*/
souvenirApp
    .controller(
    'contactUsCtrl',
    function ($scope, $http, $timeout, hostConst) {
        /* objects */
        $scope.currentCaptcha = "";
        $scope.formDataSendEmail = {
            messageId: 0,
            messageName: "",
            messageEmail: "",
            messageText: "",
            messageCaptcha: ""
        };

        /* paths */
        $scope.updateCaptchaURL = hostConst + "/update_captcha";
        $scope.sendEmailURLURL = hostConst + "/sendemail";
        $scope.sendemailWithFileURL = hostConst
            + "/sendemailWithFile";
        $scope.check_captchaURL = hostConst + "/check_captcha";

        /* variables */
        $scope.responseFormSuccess = false;
        $scope.responseFormError = false;
        $scope.showFileUpload = false;
        $scope.checkCaptchaResult = true;

        /* functions */
        $scope.refreshCaptcha = function () {
            var dataObj = {
                captchaId: $scope.currentCaptcha.captchaId,
                captchaValue: "",
                captchaUrlFile: ""
            };
            $scope.showEC = "refreshCaptcha";
            $http
                .post($scope.updateCaptchaURL, dataObj)
                .success(
                function (response) {
                    $scope.currentCaptcha = response;
                    $scope.currentCaptcha.captchaUrlFile = hostConst
                        + $scope.currentCaptcha.captchaUrlFile;
                    $scope.showEC = "";
                }).error(function (response) {
                    $scope.currentCaptcha.error = response;
                    $scope.showEC = "";
                });
            ;
        };
        $scope.refreshCaptcha();

        $scope.sendFormToServer = function () {
            if ($scope.showFileUpload) {
                var data = 'messageName='
                    + $scope.formDataSendEmail.messageName
                    + '&messageEmail='
                    + $scope.formDataSendEmail.messageEmail
                    + '&messageText='
                    + $scope.formDataSendEmail.messageText
                    + '&messageCaptcha='
                    + $scope.formDataSendEmail.messageCaptcha;

                /*
                 * var data = $.param({ messageName:
                 * $scope.formDataSendEmail.messageName,
                 * messageEmail:
                 * $scope.formDataSendEmail.messageEmail,
                 * messageText:
                 * $scope.formDataSendEmail.messageText,
                 * messageCaptcha:
                 * $scope.formDataSendEmail.messageCaptcha });
                 */
                var config = {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                    }
                };

                $http.post($scope.sendemailWithFileURL, data,
                    config).success(function (response) {
                        console.log(response);
                        $scope.responseFormSuccess = true;
                        $scope.responseFormError = false;
                    }).error(function (response) {
                        $scope.responseFormSuccess = false;
                        $scope.responseFormError = true;
                    });
            } else {

                var dataToServer = {
                    "message": {
                        "messageId": "",
                        "messageName": $scope.formDataSendEmail.messageName,
                        "messageEmail": $scope.formDataSendEmail.messageEmail,
                        "messageText": $scope.formDataSendEmail.messageText,
                        "messageCaptchaId": $scope.currentCaptcha.captchaId
                    },
                    "captcha": {
                        "captchaId": $scope.currentCaptcha.captchaId,
                        "captchaValue": $scope.formDataSendEmail.messageCaptcha,
                        "captchaUrlFile": ""
                    }
                };

                /*
                 * var data = 'messageName=' +
                 * $scope.formDataSendEmail.messageName
                 */

                $http.post($scope.sendEmailURLURL, dataToServer)
                    .success(function (response) {
                        console.log(response);
                        $scope.responseFormSuccess = true;
                        $scope.responseFormError = false;
                        $timeout(callAtTimeout, 3000);
                        $scope.resetForm();
                    }).error(function (response) {
                        $scope.responseFormSuccess = false;
                        $scope.responseFormError = true;
                        $timeout(callAtTimeout, 3000);
                    });
            }
        }

        $scope.resetForm = function () {
            $scope.formDataSendEmail.messageName = "";
            $scope.formDataSendEmail.messageEmail = "";
            $scope.formDataSendEmail.messageText = "";
            $scope.formDataSendEmail.messageCaptcha = "";
        };

        $scope.checkCaptcha = function () {
            if ($scope.formDataSendEmail.messageCaptcha) {
                var dataObj = {
                    captchaId: $scope.currentCaptcha.captchaId,
                    captchaValue: $scope.formDataSendEmail.messageCaptcha,
                    captchaUrlFile: ""
                };
                $http.post($scope.check_captchaURL, dataObj)
                    .success(function (response) {
                        $scope.checkCaptchaResult = response;
                    });
            }
        }

        function callAtTimeout() {
            $scope.responseFormSuccess = false;
            $scope.responseFormError = false;
        }

        $scope.fileUpload = function () {
            $scope.showFileUpload = !$scope.showFileUpload;
        };

    });

souvenirApp.controller('registrationCtrl', function ($scope, $http, $timeout, hostConst) {
    $scope.registration = function(){
        var registrationRO = {
            firstname: $scope.firstname,
            lastname: $scope.lastname,
            patronymic: $scope.patronymic,
            username: $scope.username,
            password: $scope.password,
            passwordRepeat: $scope.passwordRepeat,
            gender: $scope.gender,
            dateOfBirth: $scope.dateOfBirth,
            email: $scope.email,
            phoneNumber: $scope.phoneNumber
        };
        $http.post(hostConst + "/registration", registrationRO)
        .success(function (response) {
            $scope.checkCaptchaResult = response;
        });
    }
});

/* custom validators */
souvenirApp.directive("captcha", function () {
    // requires an isloated model
    return {
        // restrict to an attribute type.
        restrict: 'A',
        // element must have ng-model attribute.
        require: 'ngModel',
        link: function (scope, ele, attrs, ctrl) {

            // add a parser that will process each time the value is
            // parsed into the model when the user updates it.
            ctrl.$parsers.unshift(function (value) {
                if (value) {
                    var sc = scope;
                    var g = ele;
                    var g2 = attrs;
                    var ct = ctrl;
                    // test and set the validity after update.
                    ctrl.$setValidity('captcha', attrs.captcha);
                }

                // if it's valid, return the value to the model,
                // otherwise return undefined.
                return attrs.captcha ? attrs.captcha : undefined;
            });

        }
    }
    /*
     * return { restrict: 'A', require: '?ngModel', link: function(scope, elm,
     * attr, ctrl) { if (!ctrl) return;
     *
     * var captcha = ""; attr.$observe('captcha', function(value) { var captcha =
     * value; ctrl.$validate(); }); ctrl.$validators.captcha =
     * function(modelValue, viewValue) { return captcha; }; } };
     */
});