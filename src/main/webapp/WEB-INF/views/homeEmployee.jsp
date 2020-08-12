<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello ${emp.first_name} ${emp.surname}</title>
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
			<!-- --------------------Students------------------- -->
			<h1> Hello ${emp.first_name} ${emp.surname} </h1>
			<table border="1">
				<tr>
					<th>First Name</th>
					<th>Surname</th>
					<th>Position</th>
					<th>Employee since:</th>
					<th>Birth Date</th>
				</tr>
				<tr>
					<td>${emp.first_name}</td>
					<td>${emp.surname}</td>
					<td>${emp.staff_role}</td>
					<td>${emp.hire_date}</td>
					<td>${emp.birth_date}</td>
				</tr>

			</table>
			<hr>
			<!-- Create a bottom for the user to get out from here!  -->
				<button id=hPb>
					<a style="color: black;" href="/sporlanc">Log-Out</a>
				</button>
				<!--  Improve this link to update details and add new kids! -->
				<button id=hPb>
					<a style="color: black;" href="/sporlanc/editEmp?id=${emp.emp_id}"> Update
						Personal Details</a>
				</button>
				<hr>
				<button id=hPb>
					<a style="color: black;" href="/sporlanc/listclassperstaff?id=${emp.emp_id}"> 
						Check Timetable</a>
				</button>
				<!--   This code is to protect personal data! It uses POST methods! 
				<button id=hPb>
					<form:form action="listclassperstaff?id=${emp.emp_id}" method="post" >
						<input type="submit" value="Check Timetable by Post">
					</form:form>
				</button>
				-->
				<button id=hPb>
					<a style="color: black;" href="/sporlanc/newClassforEmp?id=${emp.emp_id}"> Add Class</a>
				</button>
			
		</div>
	</div>
</body>
</html>