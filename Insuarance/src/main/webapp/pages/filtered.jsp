<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Filtered derivative</title>
</head>
<body>
	<c:forEach items="${filter}" var="responsibility">
		<div class="field">
			<label>Title: </label>
			<c:out value="${responsibility.title}" />
		</div>
		<div class="field">
			<label>Price: </label>
			<c:out value="${responsibility.price}" />
			(UAH)
		</div>
		<div class="field">
			<label>Risk rate: </label>
			<c:out value="${responsibility.riskRate}" />%
		</div>
		<hr>
	</c:forEach>
	<a href="controller?command=back">Back to main page</a>
</body>
</html>