<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />
<html>
<head>
<title>Profile</title>
</head>
<body>
	<c:import url="/pages/static/header.jsp" />
	<div class="profile">
	<fmt:message key="login.email"/><br>
	<c:out value="${email}" /><br>
	<hr>
	<fmt:message key="register.firstname"/><br>
	<c:out value="${client.firstName}"/><br>
	<hr>
	<fmt:message key="register.middlename"/><br>
	<c:out value="${client.middleName}"/><br>
	<hr>
	<fmt:message key="register.lastname"/><br>
	<c:out value="${client.lastName}"/><br>
	<hr>
	<fmt:message key="register.passportid"/><br>
	<c:out value="${client.passportId}"/><br>
	<hr>
	</div>
	<c:import url="/pages/static/footer.jsp" />
</body>
</html>