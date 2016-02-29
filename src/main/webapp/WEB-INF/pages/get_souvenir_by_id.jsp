<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 02.02.2016
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.catalog.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="" ng-controller="souvenirByIdCtrl">

			<div class="row">
				<div class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-10 col-xs-offset-2 col-xs-10 text-center">
					<h1>${currentSouvenir.souvenirName}</h1>
					<p>${currentSouvenir.souvenirDescription}<br>
					Price = ${currentSouvenir.souvenirPrice }</p>
				</div>
			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>