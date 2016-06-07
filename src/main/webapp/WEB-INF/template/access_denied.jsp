<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="contactUsTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.contact_us.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
        <div>
            <c:url value="/logout" var="logoutUrl" />
            <!-- csrt support -->
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2>
                    Dear : ${pageContext.request.userPrincipal.name}, You are not authorized to access this page | <a
                        href="javascript:formSubmit()"> Logout</a>
                </h2>
            </c:if>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>