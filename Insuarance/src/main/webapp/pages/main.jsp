<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label>Get all available responsibilities: </label>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="show_derivative"> 
		<input type="submit" value="Show derivative" />
	</form>
	<hr>
	<label>Sort responsibilities by risk rate (descending): </label>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="show_ordered"> 
		<input type="submit" value="Show ordered" />
	</form>
<hr>
	<label>Search responsibilities in derivative by risk rate(%) and price(UAH) </label>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="filter_derivative">
		
		<label>From risk rate:</label> 
		<input type="number" name="riskLowerBound" />

		
		<label>To risk rate:</label>
		<input type="number" name="riskUpperBound" /> 

		
		<label>From price:</label>
		<input type="number" name="priceLowerBound" />
		
		<label>To price:</label> 
		<input type="number" name="priceUpperBound" />
		<div>${illegalInput}</div>
		<div>${emptyInput}</div>
		<input type="submit" value="Find" />
	</form>
</body>
</html>