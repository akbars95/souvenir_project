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
            </form>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>