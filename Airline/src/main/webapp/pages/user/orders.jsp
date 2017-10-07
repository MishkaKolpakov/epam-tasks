<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />
<html>
<head>
<title>Orders</title>
</head>
<body>
	<c:import url="/pages/static/header.jsp" />
	
	<c:forEach items="${orders}" var="order">
		<fmt:message key="service.date" />
		<c:out value="${order.ticket.departureDateTime}" /><br>
		
		<fmt:message key="service.direction" />
		<c:out value="${order.ticket.flightInstance.from}" />
		<c:out value=" - " />
		<c:out value="${order.ticket.flightInstance.to}" /><br>
		
		<fmt:message key="service.duration" />
		<c:out value="${order.ticket.flightInstance.duration}" /><br>
		
		<fmt:message key="order.final.price"/>
		<ctg:money amountInCents="${order.orderPrice}" /><br>
		<form action="${pageContext.request.contextPath}/rest/buy" method="post">
			<input type="hidden" name="ticketId" value="${order.ticket.id}">
			<input type="submit" value="<fmt:message key="orders.buy"/>"/>
		</form>
	</c:forEach>
	<c:out value="${bought}" />
	<c:out value="${emptyOrders}" />
	<c:import url="/pages/static/footer.jsp" />
</body>
</html>