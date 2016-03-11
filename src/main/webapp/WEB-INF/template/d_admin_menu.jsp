<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="menu">
    <ul>
        <li><a href="<spring:url value="/adminPiece/souvenir" htmlEscape="true"/>">Souvenir</a></li>
        <li><a href="<spring:url value="/adminPiece/souvenirCategory" htmlEscape="true"/>">Souvenir categorii</a></li>
        <li><a href="<spring:url value="/adminPiece/message" htmlEscape="true"/>">Messages</a></li>
<%--

        <hr>
        <li><a href="#/admin/souvenir_piece">Souvenir</a></li>
        &lt;%&ndash;<li><a href="#/admin/souvenir_piece">Souvenir categorii</a></li>&ndash;%&gt;
        <li><a href="#/admin/message_piece">Messages</a></li>

        <div ng-view></div>--%>
    </ul>
</div>