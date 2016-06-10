<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.registration.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="containerRegistration">
            <form>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="firstnameP" class="control-label"><spring:message code="page.registration.firstname.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" name="firstnam1eP" id="firstnameP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="lastnameP" class="control-label"><spring:message code="page.registration.lastname.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" name="lastnameP" id="lastnameP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="patronymicP" class="control-label"><spring:message code="page.registration.patronymic.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" name="patronymicP" id="patronymicP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="usernameP" class="control-label"><spring:message code="page.registration.username.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" name="usernameP" id="usernameP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="passwordP" class="control-label"><spring:message code="page.registration.password.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="password" class="form-control" name="passwordP" id="passwordP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="password2P" class="control-label"><spring:message code="page.registration.password2.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="password" class="form-control" name="password2P" id="password2P">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="genderP" class="control-label"><spring:message code="page.registration.gender.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        gender
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="dateOfBirthP" class="control-label"><spring:message code="page.registration.dateOfBirth.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        dateOfBirth
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="emailP" class="control-label"><spring:message code="page.registration.email.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" name="emailP" id="emailP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <label for="phoneNumberP" class="control-label"><spring:message code="page.registration.phoneNumber.title" /></label>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="test" class="form-control" name="phoneNumberP" id="phoneNumberP">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-offset-3 col-lg-3 col-md-offset-3 col-md-3 col-sm-offset-2 col-sm-4 col-xs-offset-1 col-xs-5">
                        <input type="reset" value='<spring:message code="page.registration.btn.reset.title" />'>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-5">
                        <input type="button" value='<spring:message code="page.registration.btn.registration.title" />'>
                    </div>
                </div>
            </form>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>