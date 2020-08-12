<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookings Session</title>
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
			<!-- -----------------------BOOKING ------------------------- -->
			<br> <br> <br>
			<h2>Bookings of ${student.first_name} ${student.surname}</h2>
			<table border="1">
				<tr>
					<th>No</th>
					<th>Class ID</th>
					<th>Subscription</th>
					<th>Starting Date</th>
					<th>Management Session</th>
				</tr>

				<c:forEach var="booking" items="${listBooking}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${booking.class_ID}</td>
						<td>${booking.subscription}</td>
						<td>${booking.from_date}</td>

						<td>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteBooking?id=${booking.booking_ID}&userid=${student.userID}&idStu=${booking.studentID}" 
							onMouseOver="alert('To delete a booking, all itens in the basket must be empty!');return true;">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="/sporlanc/classdetails?id=${booking.class_ID}&idStu=${booking.studentID}">Class
								Details</a> &nbsp;&nbsp;&nbsp;&nbsp;<a
							href="/sporlanc/newAddItem2?id=${booking.booking_ID}&idStu=${booking.studentID}">Buy
								Items</a> &nbsp;&nbsp;&nbsp;&nbsp;<a
							href="/sporlanc/basket?id=${booking.booking_ID}&idStu=${booking.studentID}">Basket</a>
							&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="/sporlanc/invoice?id=${booking.booking_ID}&classID=${booking.class_ID}">Print
								Invoice</a> &nbsp;&nbsp;&nbsp;&nbsp;
						</td>

					</tr>
				</c:forEach>
			</table>
			<hr>

			<h1>Class Details</h1>
			<table id="bookingPriTable01" border="1">

				<tr>
					<th>Class ID</th>
					<th>Period</th>
					<th>Days</th>
					<th>Price (per day)</th>
					<th>Type</th>
					<th>Sport:</th>
					<th>Language</th>

				</tr>
				<c:forEach var="listClasse" items="${listClasse}" varStatus="status">
					<tr>
						<td>${listClasse.class_ID}</td>
						<td>${listClasse.period2}</td>
						<td>${listClasse.days}</td>
						<td>${listClasse.price}</td>
						<td>${listClasse.type2}</td>
						<td>${listClasse.sport}</td>
						<td>${listClasse.language2}</td>
					</tr>


				</c:forEach>
			</table>
			<hr>
			<button id="hPb">
				<a href="/sporlanc/liststudentperparent?id=${student.userID}">
					Return</a>
			</button>
		</div>
	</div>
</body>
</html>