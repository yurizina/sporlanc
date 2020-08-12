<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Form - Part 2</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
<%@include file="/resources/style.css" %>
</style>
<body>
	<div class=bg-img>
		<img src="resources/sporlanc_logo.png">

		<div class=block-center align="center">
			<h1>New Parent</h1>
			<form:form action="saveParent" method="post" modelAttribute="parent">
				<form:hidden path="user_ID" />
				<form:hidden path="eircodeID" />

				<label for="first_name" path="first_name"> First Name: </label>
				<input type="text" id="first_name" name="first_name" required>
				
				<br>

				<label for="surname"> Surname: </label>
				<input type="text" id="surname" name="surname" required>
				<br>

				<label for="phone"> Phone: </label>
				<input type="number" id="phone" name="phone"
					placeholder="0834567890" required>
				<br>

				<label for="address"> Address: </label>
				<input type="text" id="address" name="address" required>
				<br>

				<label for="username"> Username: </label>
				<input type="text" id="username" name="username" required>
				<br>

				<label for="email"> Email: </label>
				<input type="email" id="email" name="email" required>
				<br>

				<label for="password"> Password: </label>
				<input type="password" id="password" name="password" required>
				<br>
				<br>

				<input type="submit" value="SIGN UP">

			</form:form>
		</div>
	</div>
</body>
</html>