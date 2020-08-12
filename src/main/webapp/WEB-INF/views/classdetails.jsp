<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class Details</title>
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

			<!-- ------------------------ Class Session ------------------------- -->

			<h2>Class Details</h2>

			<table border="1">

				<tr>
					<th>Period</th>
					<th>Days</th>
					<th>Price (per day)</th>
					<th>Type</th>
					<th>Sport:</th>
					<th>Language</th>

				</tr>

				<tr>

					<td>${classe.period2}</td>
					<td>${classe.days}</td>
					<td>${classe.price}</td>
					<td>${classe.type2}</td>
					<td>${classe.sport}</td>
					<td>${classe.language2}</td>
				</tr>	
			</table>
			
			<hr>
			<button id="hPb">
				<a href="/sporlanc/bookingsStudent?id=${classe.student_id}">Return</a>
			</button>
				
		</div>
	</div>
</body>
</html>