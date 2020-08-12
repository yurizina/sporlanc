<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Basket</title>
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

			<h1>List Items</h1>
			<table border="1">
				<tr>
					<th>No Item</th>
					<th>Name</th>
					<th>Price</th>
					<th>Availability</th>
					<th>Type</th>
				</tr>

				<c:forEach var="item" items="${listItem}" varStatus="status">
					<tr>
						<td>${item.item_id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.availability}</td>
						<td>${item.type}</td>
					</tr>
				</c:forEach>
			</table>


			<!-----------   List AddItems ----------->
			<hr>

			<h1>Basket</h1>

			<table border="1">
				<tr>
					<th>No</th>
					<th>No AddItem</th>
					<th>Quantity</th>
					<th>No Booking</th>
					<th>No Item</th>
				</tr>

				<c:forEach var="additem" items="${listAddItem}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${additem.addItem_ID}</td>
						<td>${additem.quantity}</td>
						<td>${additem.bookingID}</td>
						<td>${additem.item_id}</td>
						<td><a href="/sporlanc/editAddItem?id=${additem.addItem_ID}&stuID=${student_id}&itemID=${additem.item_id}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteAddItem?id=${additem.addItem_ID}&bookingId=${additem.bookingID}&stuID=${student_id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr>
			<button id="hPb">
				<a href="/sporlanc/bookingsStudent?id=${student_id}">Return</a>
			</button>
			
		</div>
	</div>
</body>
</html>