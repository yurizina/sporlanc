<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Booking</title>
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
		<h1>New Booking</h1>
		
		<form:form action="saveBooking" method="post" modelAttribute="booking">
	
				<form:hidden path="booking_ID" />
				<form:hidden path="studentID" />
				<form:hidden path="class_ID" />
				
				<label> Subscription </label>

				<input type="radio" id="week" name="subscription" value="Week" required>
				<label for="week" style="width: 50px;">Week </label>

				<input type="radio" id="month" name="subscription" value="Month" required>
				<label for="month" style="width: 50px;">Month </label>
				
				<input type="radio" id="semester" name="subscription" value="Semester" required>
				<label for="semester" style="width: 50px;">Semester </label>
				<br>
				
				<label for="from_date"> Starting date: </label>
				<input type="date" id="from_date" name="from_date"
					min="2020-08-01" required>
				<br>
				<input type="submit" value="Save">

		</form:form>
	</div>
	</div>
</body>
</html>