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
                        <input type="text" class="form-control" ng-model="firstname" required ng-minlength="3" ng-maxlength="50"
                         placeholder="<spring:message code="page.registration.firstname.title"/>"
                         name="firstnameP" id="firstnameP">
                        <span ng-show="registrationForm.firstnameP.$valid"><spring:message code="form.common.count.input.letters" /> {{50 -  firstname.length}}</span>
                        <span class="error" ng-show="registrationForm.firstnameP.$error.required"> <spring:message code="form.common.error.required" /></span>
                        <span class="error" ng-show="registrationForm.firstnameP.$error.minlength"> <spring:message code="form.common.error.minlength" htmlEscape="false" argumentSeparator=";" arguments="3" /></span>
                        <span class="error" ng-show="registrationForm.firstnameP.$error.maxlength"> <spring:message code="form.common.error.maxlength" htmlEscape="false" argumentSeparator=";" arguments="50" /></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="lastnameP" class="control-label"><spring:message code="page.registration.lastname.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="text" class="form-control" ng-model="lastname" required ng-minlength="3" ng-maxlength="50"
                         placeholder="<spring:message code="page.registration.lastname.title"/>" name="lastnameP" id="lastnameP">
                         <span ng-show="registrationForm.lastnameP.$valid"><spring:message code="form.common.count.input.letters" /> {{50 -  lastname.length}}</span>
                         <span class="error" ng-show="registrationForm.lastnameP.$error.required"> <spring:message code="form.common.error.required" /></span>
                         <span class="error" ng-show="registrationForm.lastnameP.$error.minlength"> <spring:message code="form.common.error.minlength" htmlEscape="false" argumentSeparator=";" arguments="3" /></span>
                         <span class="error" ng-show="registrationForm.lastnameP.$error.maxlength"> <spring:message code="form.common.error.maxlength" htmlEscape="false" argumentSeparator=";" arguments="50" /></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="patronymicP" class="control-label"><spring:message code="page.registration.patronymic.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="text" class="form-control" ng-model="patronymic" ng-minlength="3" ng-maxlength="75"
                         placeholder="<spring:message code="page.registration.patronymic.title"/>" name="patronymicP" id="patronymicP">
                        <span ng-show="registrationForm.patronymicP.$valid"><spring:message code="form.common.count.input.letters" /> {{75 -  patronymic.length}}</span>
                        <span class="error" ng-show="registrationForm.patronymicP.$error.minlength"> <spring:message code="form.common.error.minlength" htmlEscape="false" argumentSeparator=";" arguments="3" /></span>
                        <span class="error" ng-show="registrationForm.patronymicP.$error.maxlength"> <spring:message code="form.common.error.maxlength" htmlEscape="false" argumentSeparator=";" arguments="75" /></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="usernameP" class="control-label"><spring:message code="page.registration.username.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="text" class="form-control" ng-model="username" required ng-minlength="7" ng-maxlength="50" ng-pattern="/^([\w\.]){7,50}$/"
                        placeholder="<spring:message code="page.registration.username.title"/>" name="usernameP" id="usernameP">
                         <span ng-show="registrationForm.usernameP.$valid"><spring:message code="form.common.count.input.letters" /> {{50 -  username.length}}</span>
                         <span class="error" ng-show="registrationForm.usernameP.$error.required"> <spring:message code="form.common.error.required" /></span>
                         <span class="error" ng-show="registrationForm.usernameP.$error.pattern"> <spring:message code="form.common.error.pattern" /></span>
                         <span class="error" ng-show="registrationForm.usernameP.$error.minlength"> <spring:message code="form.common.error.minlength" htmlEscape="false" argumentSeparator=";" arguments="7" /></span>
                         <span class="error" ng-show="registrationForm.usernameP.$error.maxlength"> <spring:message code="form.common.error.maxlength" htmlEscape="false" argumentSeparator=";" arguments="50" /></span>
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
                        <input type="text" class="form-control" ng-model="email" name="emailP" id="emailP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="phoneNumberP" class="control-label"><spring:message code="page.registration.phoneNumber.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="text" class="form-control" ng-model="phoneNumber" name="phoneNumberP" id="phoneNumberP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <input type="reset" class="btn btn-danger" value='<spring:message code="page.registration.btn.reset.title" />'>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="button" class="btn btn-success" ng-click="registration()"
                         ng-disabled="registrationForm.$invalid" value='<spring:message code="page.registration.btn.registration.title" />'>
                    </div>
                </div>
            </form>
            <input type="hidden"
                   name="csrf_token_value"
                   ng-init="set('${_csrf.token}')" ng-model="csrf_token_value"/>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>