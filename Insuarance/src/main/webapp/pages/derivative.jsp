<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Derivative</title>
</head>
<body>
<h3 align="center">Derivative</h3>
	<c:forEach items="${individual}" var="responsibility">
		<div class="field">
			<label>Title: </label>
			<c:out value="${responsibility.title}" />
		</div>
		<div class="field">
			<label>Price: </label>
			<c:out value="${responsibility.price}" /> (UAH)
		</div>
		<div class="field">
			<label>Risk rate: </label>
			<c:out value="${responsibility.riskRate}" />%
		</div>
		<div class="field">
			<label>Health state: </label>
			<c:out value="${responsibility.healthState}" />
		</div>
		<div class="field">
			<label>Personal code: </label>
			<c:out value="${responsibility.personalCode}" />
		</div>
		<hr>
	</c:forEach>
	<c:forEach items="${property}" var="responsibility">
		<div class="field">
			<label>Title: </label>
			<c:out value="${responsibility.title}" />
		</div>
		<div class="field">
			<label>Price: </label>
			<c:out value="${responsibility.price}" /> (UAH)
		</div>
		<div class="field">
			<label>Risk rate: </label>
			<c:out value="${responsibility.riskRate}" />%
		</div>
		<div class="field">
			<label>Property state: </label>
			<c:out value="${responsibility.propertyState}" />
		</div>
		<div class="field">
			<label>Compulsory: </label>
			<c:out value="${responsibility.compulsory}" />
		</div>
		<hr>
	</c:forEach>
	<div class="field">
		Summary price: ${summary} (UAH)
	</div>
	<a href="controller?command=back">Back to main page</a>
</body>
</html>