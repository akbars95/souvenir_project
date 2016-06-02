<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<c:if test="${param.logout != null}">
    <div class="alert alert-success">
        You have been logged out.
    </div>
</c:if>

<!--<sec:authorize access="isAuthenticated()">
   		<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>
</sec:authorize>
-->
<c:url value="/logout" var="logoutUrl" />

		<!-- csrt support -->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden"
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

{{message}}