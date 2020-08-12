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
</head>

<style type="text/css">
<%@include file="/resources/style.css" %>
</style>
<body>

<div class=bg-img>
		<img src="resources/sporlanc_logo.png">

		<div class=block-center align="center">
        <form:form action="checkClass" method="post" modelAttribute="checkType">
        <form:hidden path="student_id"/>
        <form:hidden path="age"/>
        
        		<label id="pcfl"> Type: </label>
				<input type="radio" id="private" name="type" value="P" required>
				<label id="pcfl" for="private">Private</label>
				<input type="radio" id="group" name="type" value="G" required>
				<label id="pcfl" for="group">Group</label>
				<br>
				<input type="submit" value="Submit">
        </form:form>
    </div> 
  </div>
</body>
</html>