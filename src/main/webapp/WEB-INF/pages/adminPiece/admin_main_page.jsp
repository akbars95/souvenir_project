<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 03.02.2016
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="defaultAdminAngularJSRoutingTemplate">
    <tiles:putAttribute name="title">
        <spring:message code="page.admin.souvenir.title"/>
    </tiles:putAttribute>
    <tiles:putAttribute name="content">
        <div class="">

            <div class="adminMenu">
                <ul>
                    <li><a href="#/"><spring:message code="page.admin_piece.index.menu.title" /></a></li>
                    <li><a href="#/souvenirs"><spring:message code="page.admin_piece.souvenirs.menu.title" /></a></li>
                    <li><a href="#/souvenir_categories"><spring:message code="page.admin_piece.souvenir_categories.menu.title" /></a></li>
                    <li><a href="#/messages"><spring:message code="page.admin_piece.messages.menu.title" /></a></li>
                </ul>
            </div>

            <div ng-view></div>

        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>