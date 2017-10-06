<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<c:set var="language" value="${locale}" scope="page" />
<fmt:setLocale value="en_US" />
<c:if test="${not empty language}">
<fmt:setLocale value="${locale}" />
</c:if>
<fmt:setBundle basename="pagecontent" />

<html>
<head>
<title>Login</title>
</head>
<body>

	<form method="post" action="${pageContext.request.contextPath}/rest/language" style="margin: 0; padding: 0; display: inline;">
		<input type="hidden" name="language" value="en_US" />
		<input type="submit" value="English" />
	</form>
	
	<form method="post" action="${pageContext.request.contextPath}/rest/language" style="margin: 0; padding: 0; display: inline;" >
		<input type="hidden" name="language" value="ru_RU" />
		<input style="display: inline;" type="submit" value="Русский" />
	</form>
	
	<form method="post" action="${pageContext.request.contextPath}/rest/login" name="loginForm">
		<br>
		<fmt:message key="login.email"/><br> 
		<input type="email" name="email" value="" /> 
		<br><fmt:message key="login.password"/><br>
		<input type="password" name="password" value="" />
		<br>
		<span style="color:red"><c:out value="${wrongLoginPass}" /></span>
		<br>
		<input type="submit" value="<fmt:message key="login.signin"/>" />
	</form>
		
	<a href="${pageContext.request.contextPath}/rest/registration"><fmt:message key="login.signup"/></a><br>
	<c:out value="${successRegistration}"/><br>
	<c:out value="${guestPage}" />
</body>
</html>