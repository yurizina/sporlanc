<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
<%@ include file="/resources/style.css" %>
</style>
</head>
<body>
	<div class=block-center align="center">
		<div class="header">
			<img id=wholeIMG src="resources/sporlanc_logo.png">
		</div>

		<div class="row square">

			<h2>
				<a id="hloggedP" href="/sporlanc/studentForm?id=${parent.user_ID}">New Student</a>
			</h2>
		
			<h2>
				<a id="hloggedP" href="/sporlanc/liststudentperparent?id=${parent.user_ID}">
					Students Registered</a>
			</h2>
		
			<h2>
				<a id="hloggedP" href="/sporlanc/editParent?id=${parent.user_ID}">
					Update Personal Details</a>
			</h2>
		</div>
	</div>

</body>
</html>