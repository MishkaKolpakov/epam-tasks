<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />
<html>
<head>
<title>Main</title>
</head>
<body>
	<c:import url="/pages/static/header.jsp" />
	<form action="controller" method="post">
	<input type="hidden" name="command" value="FIND">
		<fmt:message key="order.from"/>
		<select name="from">
			<option value="Kiev" selected="selected">Kiev</option>
			<option value="Lviv">Lviv</option>
			<option value="Warszawa">Warszawa</option>
		</select> 
		<fmt:message key="order.to"/> 
		<select name="to">
			<option value="Kiev">Kiev</option>
			<option value="Lviv" selected="selected">Lviv</option>
			<option value="Warszawa">Warszawa</option>
		</select>
		<fmt:message key="order.date"/>
		<input type="date" name="date" pattern="([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])" title="YYYY-MM-DD"/> 
		<br><br>
		<input type="submit" value="<fmt:message key="order.find"/>" />
	</form>
	
	<c:forEach items="${flights}" var="flight">
		<fmt:message key="service.date"/> 
		<c:out value="${flight.departureDateTime}" /><br>
		<fmt:message key="service.direction"/>
		<c:out value="${flight.flightInstance.from}" />
		<c:out value=" - "/> 
		<c:out value="${flight.flightInstance.to}" /><br>
		<fmt:message key="service.duration"/>
		<c:out value="${flight.flightInstance.duration}" /><br>
		<fmt:message key="service.amount"/>
		<c:out value="${flight.placesAmount}" /><br>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="TICKET">
			<input type="hidden" name="flightId" value="${flight.id}">
			<input type="submit" value="<fmt:message key="order.order"/>"/>
		</form>
		<br>
	</c:forEach>
	<c:out value="${successOrder}"/><br>
	<c:out value="${alreadyOrdered}"/><br>
	<br>
	<c:import url="/pages/static/footer.jsp" />
</body>
</html>