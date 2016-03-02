<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header ">
	<div class="languageBar text-right">
		<%-- <span><spring:message code="language.label" />:</span> --%>
		<ul>
			<%
				String language = response.getLocale().getLanguage();
				String cssClassForCurrentLanguage = "activeLanguage";
				String empty = "";
				String languageEn = "en";
				String languageMd = "md";
				String languageRu = "ru";
			%>
			<li><a href="?lang=<%=languageEn%>"
				class="<%if (language.equals(languageEn)) {
				out.print(cssClassForCurrentLanguage);
			} else {
				out.print(empty);
			}%>"><spring:message
						code="language.english" /></a></li>
			<li><a href="?lang=<%=languageMd%>"
				class="<%if (language.equals(languageMd)) {
				out.print(cssClassForCurrentLanguage);
			} else {
				out.print(empty);
			}%>"><spring:message
						code="language.moldavian" /></a></li>
			<li><a href="?lang=<%=languageRu%>"
				class="<%if (language.equals(languageRu)) {
				out.print(cssClassForCurrentLanguage);
			} else {
				out.print(empty);
			}%>"><spring:message
						code="language.russian" /></a></li>
			<%-- <li><a href="?lang=en"
				class="<c:if test="${pageContext.response.locale == 'en'}"><c:out value="${currentLanguageClass}" /></c:if>"><spring:message
						code="language.english" /></a></li>
			<li><a href="?lang=md"
				class="<c:if test="${pageContext.response.locale == 'md'}"><c:out value="${currentLanguageClass}" /></c:if>"><spring:message
						code="language.moldavian" /></a></li>
			<li><a href="?lang=ru"
				class="<c:if test="${pageContext.response.locale == 'ru'}"><c:out value="${currentLanguageClass}" /></c:if>"><spring:message
						code="language.russian" /></a></li> --%>
		</ul>
	</div>

	<!-- <div class="row">
		<div class="col-lg-6 col-md-6"></div>
		<div class="col-lg-6 col-md-6"></div>
	</div> -->

</div>