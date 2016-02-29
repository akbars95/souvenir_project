/**
 * 
 */

/* app */
var souvenirApp = angular.module('souvenirApp', [ 'ngRoute' ]);

/* constants */
souvenirApp.constant("hostConst", "/souvenir");

/* Ctrl */
/* index page */
souvenirApp.controller('indexCtrl',
		function($scope, $http, $timeout, hostConst) {

		});

/* catalog page */
souvenirApp
		.controller(
				'catalogCtrl',
				function($scope, $http, $timeout, hostConst) {
					var get_all_souvenirsURL = "/get_all_souvenirs";

					$scope.souvenirs = [];

					$http.get(hostConst + get_all_souvenirsURL).success(
							function(data, status, headers, config) {
								$scope.souvenirs = data;
								$scope.changeCountPerPage();
							}).error(function(data, status, headers, config) {
						// log error
					});

					$scope.currentSortType = false;
					$scope.currentFieldName = "";

					$scope.changeSortType = function(fieldName) {
						$scope.currentSortType = !$scope.currentSortType;
						$scope.currentFieldName = fieldName;
						$scope.checkSortType();
					}

					$scope.checkSortType = function() {
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

					$scope.countPerPage = [ {
						name : 10,
						value : 10
					}, {
						name : 25,
						value : 25
					}, {
						name : 50,
						value : 50
					}, {
						name : 100,
						value : 100
					}, {
						name : 'all',
						value : 10000
					} ];

					$scope.currentCountValue = $scope.countPerPage[0];
					$scope.countOfPage = [];

					$scope.showPagination = function() {
						if ($scope.souvenirs.length > $scope.currentCountValue.name) {
							/*var tempCountPages = $scope.souvenirs.length
									/ $scope.currentCountValue.value;
							for (i = 0; i < Math.round(tempCountPages); i++) {
								$scope.countOfPage.push(i);
							}*/
							return true;
						}
						return false;
					};

					$scope.changeCountPerPage = function() {
						$scope.showPagination();
					};

				});

/* souvenirById page */
souvenirApp.controller('souvenirByIdCtrl', function($scope, $http, $timeout,
		hostConst) {
	var get_all_souvenirsURL = "/get_all_souvenirs";
	$http.get(hostConst + get_all_souvenirsURL).success(
			function(data, status, headers, config) {
				$scope.souvenirs = data;
			}).error(function(data, status, headers, config) {
		// log error
	});
});

/* advanced_search page */
souvenirApp.controller('advancedSearchCtrl', function($scope, $http, $timeout,
		hostConst) {

});

/* about_us page */
souvenirApp.controller('aboutUsCtrl', function($scope, $http, $timeout,
		hostConst) {

});

souvenirApp
		.controller(
				'contactUsCtrl',
				function($scope, $http, $timeout, hostConst) {
					/* objects */
					$scope.currentCaptcha = "";
					$scope.formDataSendEmail = {
						messageId : 0,
						messageName : "",
						messageEmail : "",
						messageText : "",
						messageCaptcha : ""
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
					$scope.refreshCaptcha = function() {
						var dataObj = {
							captchaId : $scope.currentCaptcha.captchaId,
							captchaValue : "",
							captchaUrlFile : ""
						};
						$scope.showEC = "refreshCaptcha";
						$http
								.post($scope.updateCaptchaURL, dataObj)
								.success(
										function(response) {
											$scope.currentCaptcha = response;
											$scope.currentCaptcha.captchaUrlFile = hostConst
													+ $scope.currentCaptcha.captchaUrlFile;
											$scope.showEC = "";
										}).error(function(response) {
									$scope.currentCaptcha.error = response;
									$scope.showEC = "";
								});
						;
					};
					$scope.refreshCaptcha();

					$scope.sendFormToServer = function() {
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
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
								}
							};

							$http.post($scope.sendemailWithFileURL, data,
									config).success(function(response) {
								console.log(response);
								$scope.responseFormSuccess = true;
								$scope.responseFormError = false;
							}).error(function(response) {
								$scope.responseFormSuccess = false;
								$scope.responseFormError = true;
							});
						} else {

							var dataToServer = {
								"message" : {
									"messageId" : "",
									"messageName" : $scope.formDataSendEmail.messageName,
									"messageEmail" : $scope.formDataSendEmail.messageEmail,
									"messageText" : $scope.formDataSendEmail.messageText,
									"messageCaptchaId" : $scope.currentCaptcha.captchaId
								},
								"captcha" : {
									"captchaId" : $scope.currentCaptcha.captchaId,
									"captchaValue" : $scope.formDataSendEmail.messageCaptcha,
									"captchaUrlFile" : ""
								}
							};

							/*
							 * var data = 'messageName=' +
							 * $scope.formDataSendEmail.messageName
							 */

							$http.post($scope.sendEmailURLURL, dataToServer)
									.success(function(response) {
										console.log(response);
										$scope.responseFormSuccess = true;
										$scope.responseFormError = false;
										$timeout(callAtTimeout, 3000);
										$scope.resetForm();
									}).error(function(response) {
										$scope.responseFormSuccess = false;
										$scope.responseFormError = true;
										$timeout(callAtTimeout, 3000);
									});
						}
					}

					$scope.resetForm = function() {
						$scope.formDataSendEmail.messageName = "";
						$scope.formDataSendEmail.messageEmail = "";
						$scope.formDataSendEmail.messageText = "";
						$scope.formDataSendEmail.messageCaptcha = "";
					};

					$scope.checkCaptcha = function() {
						if ($scope.formDataSendEmail.messageCaptcha) {
							var dataObj = {
								captchaId : $scope.currentCaptcha.captchaId,
								captchaValue : $scope.formDataSendEmail.messageCaptcha,
								captchaUrlFile : ""
							};
							$http.post($scope.check_captchaURL, dataObj)
									.success(function(response) {
										$scope.checkCaptchaResult = response;
									});
						}
					}

					function callAtTimeout() {
						$scope.responseFormSuccess = false;
						$scope.responseFormError = false;
					}

					$scope.fileUpload = function() {
						$scope.showFileUpload = !$scope.showFileUpload;
					};

				});

/* custom validators */
souvenirApp.directive("captcha", function() {
	// requires an isloated model
	return {
		// restrict to an attribute type.
		restrict : 'A',
		// element must have ng-model attribute.
		require : 'ngModel',
		link : function(scope, ele, attrs, ctrl) {

			// add a parser that will process each time the value is
			// parsed into the model when the user updates it.
			ctrl.$parsers.unshift(function(value) {
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