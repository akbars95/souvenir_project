<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="authorizationForm">
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

<%--<jsp:include page="./includes/footer.jsp"/>--%>