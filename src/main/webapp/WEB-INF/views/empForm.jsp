<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Employee</title>
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

			<h1>New/Edit Employee</h1>
			<form:form action="saveEmp" method="post" modelAttribute="employee">
				<form:hidden path="emp_id" />
				<form:hidden path="eircodeID" />
				<form:hidden path="hire_date" />
				
				<p>Hire Date (year-month-day): ${employee.hire_date}</p>
				
				<label for="staff_role"> Post: </label>
				<input type="text" id="staff_role" name="staff_role" value=${employee.staff_role} required>
				<br>

				<label for="first_name"> Current name:  </label>
				<input type="text" id="first_name" name="first_name" value=${employee.first_name} required>
				<br>
				
				<label for="surname"> Surname: </label>
				<input type="text" id="surname" name="surname" value=${employee.surname} required>
				<br>

				<label for="birth_date"> Birth date: </label>
				<input type="date" id="birth_date" name="birth_date"
					max="2002-01-01" value= ${employee.birth_date} required>
				<br>

				<label for="phone"> Phone: </label>
				<input type="number" id="phone" name="phone"
					placeholder="0834567890" value=${employee.phone} required>
				<br>

				<label for="address"> Address: </label>
				<input type="text" id="address" name="address" value=${employee.address} required>
				<br>
				
				<label for="email"> Email: </label>
				<input type="email" id="email" name="email" value=${employee.email} required>
				<br>
				
				<label> Gender: </label>

				<input type="radio" id="male" name="gender" value="M" required>
				<label for="male" style="width: 50px;">Male</label>


				<input type="radio" id="female" name="gender" value="F" required>
				<label for="female" style="width: 50px;">Female</label>

				<p>Gender registered: ${employee.gender}</p>
				
				<hr>
				
				<label for="username"> Username: </label>
				<input type="text" id="username" name="username" value=${employee.username} required>
				<br>
				
				<label for="password"> Password: </label>
				<input type="password" id="password" name="password" value=${employee.password} required>
				<p>Old Password: ${employee.password}</p>
				
				
				

				<input type="submit" value="Save">
			</form:form>
		</div>
	</div>
</body>
</html>