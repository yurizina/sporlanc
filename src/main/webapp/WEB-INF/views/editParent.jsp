<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Parent</title>
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
		<div class="block-center" align="center">
			<h1>Update Personal Details</h1>
			<form:form action="saveParent2" method="post" modelAttribute="parent">
				<table>
					<form:hidden path="user_ID" />
					<form:hidden path="eircodeID" />
					<tr>
						<td>First Name:</td>
						<td><form:input path="first_name" required="required" />
					</tr>

					<tr>
						<td>Surname:</td>
						<td><form:input path="surname" required="required"/>
					</tr>
					<tr>
						<td>Phone:</td>
						<td><form:input path="phone" required="required"/>
					</tr>
					<tr>
						<td>Address:</td>
						<td><form:input path="address" required="required"/>
					</tr>
					<tr>
						<td>Username:</td>
						<td><form:input path="username" required="required"/>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path="email" required="required"/>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input path="password" required="required" />
					</tr>
					<tr>
						<td colspan="2" align="center"><br>
						<input type="submit"
							value="Save"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>