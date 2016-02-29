<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.404.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="">
			<h1 class="text-center">
				<spring:message code="page.404.title" />
			</h1>
			<h2 class="text-center">
				<spring:message code="page.404.description" />
				<spring:url value="/home" var="homeUrl" htmlEscape="true" />
				<a href="${homeUrl}"><spring:message code="menu.home.title" /></a>
			</h2>

		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>