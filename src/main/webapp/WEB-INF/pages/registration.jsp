<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.registration.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="containerRegistration" ng-controller="registrationCtrl">
            <form novalidate="novalidate" name="registrationForm">
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="firstnameP" class="control-label"><spring:message code="page.registration.firstname.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" ng-model="firstname" required ng-minlength="3" ng-maxlength="50"
                         placeholder="<spring:message code="page.registration.firstname.title"/>"
                         name="firstnameP" id="firstnameP">
                        <span ng-show="registrationForm.firstnameP.$valid"><spring:message code="page.contactus.form.count.input.letters" /> {{50 -  firstname.length}}</span>
                        <span class="error" ng-show="registrationForm.firstnameP.$error.required"> <spring:message code="page.registration.form.firstname.error.required" /></span>
                        <span class="error" ng-show="registrationForm.firstnameP.$error.minlength"> <spring:message code="page.registration.form.firstname.error.minlength" /></span>
                        <span class="error" ng-show="registrationForm.firstnameP.$error.maxlength"> <spring:message code="page.registration.form.firstname.error.maxlength" /></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="lastnameP" class="control-label"><spring:message code="page.registration.lastname.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" ng-model="lastname" name="lastnameP" id="lastnameP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="patronymicP" class="control-label"><spring:message code="page.registration.patronymic.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" ng-model="patronymic" name="patronymicP" id="patronymicP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="usernameP" class="control-label"><spring:message code="page.registration.username.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" ng-model="username" name="usernameP" id="usernameP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="passwordP" class="control-label"><spring:message code="page.registration.password.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="password" class="form-control" ng-model="password" name="passwordP" id="passwordP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="passwordRepeatP" class="control-label"><spring:message code="page.registration.password_repeat.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="password" class="form-control" ng-model="passwordRepeat" name="passwordRepeatP" id="passwordRepeatP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="genderP" class="control-label"><spring:message code="page.registration.gender.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <select name="genderP" id="genderP" ng-model="gender">

                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="dateOfBirthP" class="control-label"><spring:message code="page.registration.dateOfBirth.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="date" ng-model="dateOfBirth" name="dateOfBirthP" id="dateOfBirthP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="emailP" class="control-label"><spring:message code="page.registration.email.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" ng-model="email" name="emailP" id="emailP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="phoneNumberP" class="control-label"><spring:message code="page.registration.phoneNumber.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" ng-model="phoneNumber" name="phoneNumberP" id="phoneNumberP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <input type="reset" class="btn btn-danger" value='<spring:message code="page.registration.btn.reset.title" />'>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="button" class="btn btn-success" ng-click="registration()" value='<spring:message code="page.registration.btn.registration.title" />'>
                    </div>
                </div>
            </form>
            <input type="hidden"
                   name="csrf_token_value"
                   ng-init="set('${_csrf.token}')" ng-model="csrf_token_value"/>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>