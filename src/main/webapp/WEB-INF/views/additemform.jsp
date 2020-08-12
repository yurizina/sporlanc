<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
<%@include file="/resources/style.css" %>
</style>

</head>
<body>
	<div class=bg-img>
		<img src="resources/sporlanc_logo.png">
		<div class=block-center align="center">
			<h1>Shop Our Products</h1>

			<table border="1">
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Price</th>
					<th>Type</th>
				</tr>

				<c:forEach var="item" items="${listItem}" varStatus="status">
					<tr>
						<td>${item.item_id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.type}</td>
						
					</tr>
				</c:forEach>
			</table>
			<hr>
			<form:form action="saveAddItem" method="post" modelAttribute="additem">
					<form:hidden path="addItem_ID" />
					<form:hidden path="bookingID" />
					<form:hidden path="student_id" />
					
					<label for="quantity">Quantity:</label>
					<input type="number" id="quantity" name="quantity" min="1">
					
					<label for="item">Item ID:</label>
					<input type="number" id="item" name="item_id" min="1" value="${additem.item_id}">
				
					<input type="submit" value="Add to Basket">
					
			</form:form>
			
			<hr>
			<button id="hPb">
				<a href="/sporlanc/bookingsStudent?id=${id}">Return</a>
			</button>
			
		</div>
	</div>
</body>
</html>