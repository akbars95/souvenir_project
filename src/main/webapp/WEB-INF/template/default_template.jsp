<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title"/></title>

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

<div class="fixedPiece" ng-controller="fixedPieceCtrl">
    <div class=""><%--infoBtn rotateInfoBtn--%>
        <p ng-click="infoBtnClick()"><spring:message code="fixed.piece.info.btn_title"/></p>
    </div>
    <div>
        <div ng-class="skypeLinkClass">
            <button class="btn btn-default">
                <spring:message code="fixed.piece.skype.btn_title"/>
            </button>
            <span>mySkype</span>
        </div>
        <div ng-class="phoneLinkClass">
            <button class="btn btn-default">
                <spring:message code="fixed.piece.phone.btn_title"/>
            </button>
            <span>068 - 258- 963</span>
        </div>
        <div ng-class="emailLinkClass">
            <button class="btn btn-default">
                <spring:message code="fixed.piece.email.btn_title"/>
            </button>
            <span>ivan.ivanov@mail.md</span>
        </div>
    </div>
</div>

<div class="container">
    <!-- header -->
    <div id="header">
        <tiles:insertAttribute name="header"/>
    </div>
    <!-- end header  -->

    <!-- menu -->
    <div id="menu">
        <tiles:insertAttribute name="menu"/>
    </div>
    <!-- end menu  -->

    <!-- content -->
    <div id="content">
        <div class="content">
            <tiles:insertAttribute name="content"/>
        </div>
    </div>
    <!-- end content -->

    <!-- footer -->
    <div id="footer">
        <tiles:insertAttribute name="footer"/>
    </div>
    <!-- end footer -->

</div>

</body>
</html>