<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class Request Form</title>
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
			<h1>New Class</h1>
			<form:form action="confirmClass" method="post"
				modelAttribute="classe">

				<form:hidden path="class_ID" />
				<form:hidden path="capactity" />
				<form:hidden path="price" />
				<form:hidden path="type" />
				<form:hidden path="emp_id" />
				<form:hidden path="student_id" />
				<form:hidden path="age" />
				<form:hidden path="ages_id" />

				<label> Period: </label>

				<input type="radio" id="m1" name="period" value="M1" required>
				<label for="m1" style="width: 100px;">9h00 - 10h30 </label>

				<input type="radio" id="m2" name="period" value="M2" required>
				<label for="m2" style="width: 100px;">10h30 - 11h00 </label>

				<input type="radio" id="a1" name="period" value="A1" required>
				<label for="a1" style="width: 100px;">13h00 - 14h30 </label>

				<input type="radio" id="a2" name="period" value="A2" required>
				<label for="a2" style="width: 100px;">14h30 - 16h00 </label>

				<br>
				<br>

				<label> Days: </label>
				
				<label for="m" >Monday</label>
				<input type="checkbox" id="m" name="days" value="M" required>

				<label for="t" >Tuesday </label>
				<input type="checkbox" id="t" name="days" value="T" required >
				
				<label for="w" >Wednesday </label>
				<input type="checkbox" id="w" name="days" value="W" required>

				<label for="th" >Thursday </label>
				<input type="checkbox" id="th" name="days" value="TH" required >
						
				<label for="f" >Friday </label>
				<input type="checkbox" id="f" name="days" value="F" required >
				
				<label for="s" >Saturday </label>
				<input type="checkbox" id="s" name="days" value="S" required >
				
				<br>
				<br>

				<label> Sport: </label>
				<input type="radio" id="football" name="sport_id" value="1" required>
				<label for="football" >Football</label>

				<input type="radio" id="volley" name="sport_id" value="2" required>
				<label for="volley" >Volleyball </label>

				<input type="radio" id="handball" name="sport_id" value="3" required>
				<label for="handball" >Handball </label>

				<input type="radio" id="basketball" name="sport_id" value="4" required>
				<label for="Basketball" >Basketball </label>

				<input type="radio" id="hr" name="sport_id" value="5" required>
				<label for="hr" >Horse Riding </label>

				<input type="radio" id="fencing" name="sport_id" value="6" required>
				<label for="fencing" >Fencing </label>

				<input type="radio" id="golf" name="sport_id" value="7" required>
				<label for="golf" >Golf </label>

				<br>
				<br>

				<label> Language </label>

				<input type="radio" id="e" name="language" value="E" required>
				<label for="e" style="width: 50px;">English </label>

				<input type="radio" id="s" name="language" value="S" required>
				<label for="s" style="width: 50px;">Spanish </label>

				<br>
				<br>

				<input type="submit" value="Submit">
			</form:form>
		</div>
	</div>
</body>
</html>