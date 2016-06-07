<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header ">
	<div class="row languageBar">
		<div class="col-md-offset-6 col-md-6 text-right">
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
	</div>

	<div class="row">
        <div class="col-md-offset-6 col-md-6 text-right">
            <a href="">Registration</a>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a href="" data-toggle="modal" data-target="#loginModal">Log In</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <span>Hello, ${pageContext.request.userPrincipal.name}</span>
                <a href="javascript:formSubmit()">Log Out</a>
            </c:if>
        </div>
	</div>

    <!-- Modal -->
    <div class="modal fade" id="loginModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3 class="text-center">Login</h3>
                </div>
                <div class="modal-body">
                    <div class="">
                        <c:url value="/login_process" var="loginUrl"/>
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <c:if test="${param.error != null}">
                                <div class="alert alert-error">
                                    Failed to login.
                                    <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                                        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}"/>
                                    </c:if>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    You have been logged out.
                                </div>
                            </c:if>
                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                    <label class="control-label" for="souvenir_username_9">Username</label>
                                </div>
                                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                    <input type="text" class="form-control" id="souvenir_username_9" name="souvenir_username_9"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                    <label class="control-label" for="souvenir_password_9">Password</label>
                                </div>
                                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                    <input type="password" class="form-control" id="souvenir_password_9" name="souvenir_password_9"/>
                                    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                    <label class="control-label" for="souvenir-remember-me">Remember me</label>
                                </div>
                                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                    <input type="checkbox" id="souvenir-remember-me" class="checkbox" name="souvenir-remember-me" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <input id="submit" class="btn btn-success" name="submit" type="submit"
                                       value="Login"/>
                                   <input id="submit" class="btn btn-danger" name="submit" type="reset"
                                                                      value="Reset"/>
                               </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

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

</div>