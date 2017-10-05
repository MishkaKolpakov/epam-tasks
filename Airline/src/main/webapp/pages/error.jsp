<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />
<html>
<head>
<title>Error</title>
</head>
<body>
	<c:out value="${contact}" />
	<a href="${pageContext.request.contextPath}/rest/book"><fmt:message key="ticket.back"/></a>
</body>
</html>