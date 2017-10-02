<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:bundle basename="pagecontent" />
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>

</head>
<body>
	<form method="post" action="controller" name="registrationForm" >
		<input type="hidden" name="command" value="registration" />
		<fmt:message key="login.email"/><br> 
		<input type="email" name="email" value="" required="required" placeholder="xxxx@xxxx.xx"/> 
		
		<br><fmt:message key="login.password"/><br>
		<input type="password" name="password" value="" required="required"/>
		
		<br><fmt:message key="register.firstname"/><br>
		<input type="text" name="firstName" value="" required="required" 
		pattern="[A-ZА-Я][a-zа-я]*" title="<fmt:message key="register.wrong.name"/>"/>
		
		<br><fmt:message key="register.middlename"/><br>
		<input type="text" name="middleName" value="" required="required" 
		pattern="[A-ZА-Я][a-zа-я]*" title="<fmt:message key="register.wrong.name"/>"/>
		
		<br><fmt:message key="register.lastname" /><br>
		<input type="text" name="lastName" value="" required="required" 
		pattern="[A-ZА-Я][a-zа-я]*" title="<fmt:message key="register.wrong.name"/>"/>
		
		<br><fmt:message key="register.passportid"/><br>
		<input type="text" name="passportId" value="" required="required" 
		placeholder="MU234281" pattern="[A-Z]{2}[0-9]{6}" title="<fmt:message key="register.wrong.passportid"/>"/>
		
		<br><br><c:out value="${wrongRegistration}"/><br>
		<input type="submit" value="<fmt:message key="register.signup"/>" />
	</form>
	<a href="${pageContext.request.contextPath}/login"><fmt:message key="login.signin"/></a>
</body>
</html>