<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />
<html>
<head>

<title></title>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
	
	<div class="menu">
		<ul>
			<li><a href="${pageContext.request.contextPath}/rest/profile"><fmt:message key="main.profile"/></a></li>
			<li><a href="${pageContext.request.contextPath}/rest/book"><fmt:message key="main.book"/></a></li>
			<li><a href="${pageContext.request.contextPath}/rest/orders"><fmt:message key="main.orders"/></a></li>
			<li><a href="${pageContext.request.contextPath}/rest/about"><fmt:message key="main.about"/></a></li>
			<li><a href="${pageContext.request.contextPath}/rest/logout"><fmt:message key="main.logout"/></a></li>
		</ul>
		<br>
	</div>
</body>
</html>