<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />

<html>
<head>
<title>Administrator</title>
</head>
<body>
	<form action="controller" method="post">
	<input type="hidden" name="command" value="ADD">
		
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
		<br><br>
		<fmt:message key="order.date"/>
		<input type="datetime-local" name="date" pattern="([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])T([01]\d|2[1-4]):([0-5]\d))" title="yyyy-mm-dd'T'hh:mm" required="required" /> 
		<br><br>
		<fmt:message key="ticket.price"/>
		<input type="number" name="ticketPrice" required="required" /><br><br>
		
		<fmt:message key="ticket.baggage.price"/>
		<input type="number" name="baggagePrice" required="required" /><br><br>
		
		<fmt:message key="ticket.queue.price"/>
		<input type="number" name="queuePrice" required="required" /><br><br>
		
		<fmt:message key="order.amount"/>
		<input type="number" name="amount" required="required" /><br><br>
				
		<input type="submit" value="<fmt:message key="ticket.add"/>" />
	</form>
	<br>
	<c:out value="${addSuccess}"/>
	
	<c:out value="${addWrong}"/>
	<br>
	<a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="main.logout"/></a>
</body>
</html>