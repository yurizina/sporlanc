<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Class</title>
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
			<h2>Class details</h2>
			<p>Period: ${classe.period2}</p>
			<p>Days: ${classe.days}</p>
			<p>Capacity: ${classe.capactity}</p>
			<p>Price(per day): ${classe.price}</p>
			<p>Type: ${classe.type2}</p>
			<p>Sport: ${classe.sport}</p>
			<p>Emp ID: ${classe.emp_id}</p>
			<p>Category: ${classe.ages_id}</p>
			<p>Language: ${classe.language2}</p>

			<h1>New/Edit Class</h1>
			<form:form action="saveClass" method="post" modelAttribute="classe">
				<form:hidden path="class_ID" />
				<form:hidden path="emp_id" />

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

				<label for="m">Monday</label>
				<input type="checkbox" id="m" name="days" value="M" required>

				<label for="t">Tuesday </label>
				<input type="checkbox" id="t" name="days" value="T" required>

				<label for="w">Wednesday </label>
				<input type="checkbox" id="w" name="days" value="W" required>

				<label for="th">Thursday </label>
				<input type="checkbox" id="th" name="days" value="TH" required>

				<label for="f">Friday </label>
				<input type="checkbox" id="f" name="days" value="F" required>

				<label for="s">Saturday </label>
				<input type="checkbox" id="s" name="days" value="S" required>

				<br>
			
				<label> Type: </label>

				<input type="radio" id="t1" name="type" value="P" required>
				<label for="t1" style="width: 100px;">Private</label>

				<input type="radio" id="t2" name="type" value="G" required>
				<label for="t2" style="width: 100px;">Group </label>

				<br>

				<label> Sport: </label>
				<input type="radio" id="football" name="sport_id" value="1" required>
				<label for="football">Football</label>

				<input type="radio" id="volley" name="sport_id" value="2" required>
				<label for="volley">Volleyball </label>

				<input type="radio" id="handball" name="sport_id" value="3" required>
				<label for="handball">Handball </label>

				<input type="radio" id="basketball" name="sport_id" value="4" required>
				<label for="Basketball">Basketball </label>

				<input type="radio" id="hr" name="sport_id" value="5" required>
				<label for="hr">Horse Riding </label>

				<input type="radio" id="fencing" name="sport_id" value="6" required>
				<label for="fencing">Fencing </label>

				<input type="radio" id="golf" name="sport_id" value="7" required>
				<label for="golf">Golf </label>

				<br>
				<br>

				<label> Category: </label>

				<input type="radio" id="c" name="ages_id" value="10" required>
				<label for="c" style="width: 100px;">10</label>

				<input type="radio" id="c2" name="ages_id" value="14" required>
				<label for="c2" style="width: 100px;">14 </label>

				<input type="radio" id="c3" name="ages_id" value="17" required>
				<label for="c3" style="width: 100px;">17 </label>

				<br>
				<br>

				<label> Language </label>

				<input type="radio" id="e" name="language" value="E" required>
				<label for="e" style="width: 50px;">English </label>

				<input type="radio" id="s" name="language" value="S" required>
				<label for="s" style="width: 50px;">Spanish </label>

				<br>
				<br>

				<br>

				<label for="cap"> Capacity: </label>
				<input type="number" id="cap" name="capactity"
					value=${classe.capactity} required>
				<br>

				<label for="price"> Price: </label>
				<input type="number" id="price" name="price" value=${classe.price} required>
				<br>
				<input type="submit" value="Save">

			</form:form>
		</div>
	</div>
</body>
</html>