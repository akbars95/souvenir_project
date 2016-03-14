<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" /></title>

<!-- stylesheets -->
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- end stylesheets -->

<!-- scripts -->
<c:forEach var="script" items="${javascripts}">
	<script src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- end scripts -->

</head>
<body style="display: inherit !important;" ng-app="souvenirApp">

	<div ng-controller="fixedPieceCtrl">
		<div class="fixedPieceInfoButton"  ng-cloak>
			<div class="infoBtn" ng-click="infoBtnClick()">
				<spring:message code="fixed.piece.info.btn_title" />
			</div>
		</div>
		<div class="fixedPieceOtherButtons"  ng-cloak>
			<div ng-class="openInfoBtn">
				<div class="otherBtnWrapperDiv">
					<button class="btn btn-default" ng-click="otherBtnClick('0')">
						<spring:message code="fixed.piece.skype.btn_title" />
					</button>
					<span class="infoView" ng-class="skypeLinkClass">mySkype</span>
				</div>
				<div class="otherBtnWrapperDiv">
					<button class="btn btn-default" ng-click="otherBtnClick('1')">
						<spring:message code="fixed.piece.phone.btn_title" />
					</button>
					<span class="infoView" ng-class="phoneLinkClass">068 - 258- 963</span>
				</div>
				<div class="otherBtnWrapperDiv">
					<button class="btn btn-default" ng-click="otherBtnClick('2')">
						<spring:message code="fixed.piece.email.btn_title" />
					</button>
					<span class="infoView" ng-class="emailLinkClass">ivan.ivanov@mail.md</span>
				</div>
			</div>
		</div>
	</div>

	<div class="container"  ng-cloak>
		<!-- header -->
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<!-- end header  -->

		<!-- menu -->
		<div id="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<!-- end menu  -->

		<!-- content -->
		<div id="content">
			<div class="content">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
		<!-- end content -->

		<!-- footer -->
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		<!-- end footer -->

	</div>

</body>
</html>