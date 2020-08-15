<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Parent</title>
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
		<img id="hPimg" src="resources/sporlanc_logo.png">

		<div class=block-center align="center">
			<!-- --------------------Students------------------- -->

			<table border="1">
				<tr>
					<th>No</th>
					<th>First Name</th>
					<th>Surname</th>
					<th>Age (years)</th>
					<th>Manage Bookings</th>
					<th>Student Management</th>
				</tr>

				<c:forEach var="student" items="${listStudent}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${student.first_name}</td>
						<td>${student.surname}</td>
						<td>${student.currentAge}</td>

						<td>&nbsp; <a
							href="/sporlanc/newBooking2?id=${student.studentID}&age=${student.currentAge}">New
								Booking</a> &nbsp;&nbsp; &nbsp;&nbsp; <a
							href="/sporlanc/bookingsStudent?id=${student.studentID}">Bookings</a>
							&nbsp;&nbsp;
						</td>

						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/editStudent?id=${student.studentID}">Edit</a>
							&nbsp;&nbsp;&nbsp;<a 
							href="/sporlanc/deleteStudent?id=${student.studentID}&parentid=${student.userID}" title="Only when all bookings are paid!" >Delete 
							</a>
							 &nbsp;&nbsp;
						</td>

					</tr>
				</c:forEach>
			</table>
			<hr>

			<!-- Create a bottom for the user to get out from here!  -->
			<h3>
				<button id="hPb">
					<a href="/sporlanc">Log-Out</a>
				</button>
				<!--  Improve this link to update details and add new kids! -->
				<button id="hPb">
					<a href="/sporlanc/loggedParent?id=${userID}"> Return</a>
				</button>
			</h3>
		</div>
	</div>
</body>
</html>