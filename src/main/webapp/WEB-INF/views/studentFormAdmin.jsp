<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Student - Admin session</title>
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

			<h1>New/Edit Student</h1>
			<form:form action="saveStudentAdmin" method="post" modelAttribute="student">
				
				<form:hidden path="studentID" />
				
				<label for="userID"> User ID: </label>
				<input type="number" id="userID" name="userID"
					 value="${student.userID}" required>
				<br>
				
				<label for="first_name"> First Name: </label>
				<input type="text" id="first_name" name="first_name" value="${student.first_name}" required>
				<br>

				<label for="surname"> Surname: </label>
				<input type="text" id="surname" name="surname" value="${student.surname}" required>
				<br>

				<label for="birth_date"> Birth Date: </label>
				<input type="date" id="birth_date" name="birth_date"
					min="2003-01-01" max="2013-12-31" value="${student.birth_date}" required>
				<br>

				<label> Gender: </label>

				<input type="radio" id="male" name="gender" value="M" required>
				<label for="male" style="width: 50px;">Male</label>


				<input type="radio" id="female" name="gender" value="F" required>
				<label for="female" style="width: 50px;">Female</label>
				<p>Gender registered: ${student.gender}</p>
				<br>

				<input type="submit" value="Save">

			</form:form>
		</div>
	</div>
</body>
