<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Ordered derivative</title>
</head>
<body>
	<h3 align="center">Derivative</h3>
	<c:forEach items="${ordered}" var="responsibility">
		<div class="field">
			<label>Title: </label>
			<c:out value="${responsibility.title}" />
		</div>
		<div class="field">
			<label>Price: </label>
			<c:out value="${responsibility.price}" />
			<label>(UAH)</label>
		</div>
		<div class="field">
			<label>Risk rate: </label>
			<c:out value="${responsibility.riskRate}" />%
		</div>
		<hr>
	</c:forEach>
	<div class="field">
		Summary price: ${summary} <label>(UAH)</label>
	</div>
	<a href="controller?command=back">Back to main page</a>
</body>
</html>