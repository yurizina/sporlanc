<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Form - Part 1</title>

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
   
        <h2>Enter your Eircode!</h2>
        <form:form action="saveregistereir" method="post" modelAttribute="eircode">
        <form:hidden path="eircode_ID"/>
        <label for="eircode"> Eircode: </label> 
        <input type="text" id="eircode" name="eircode" placeholder="D00 XX00" required><br> 
            
     	<input type="submit" value="Submit">    
        </form:form>
    </div>
 </div> 
</body>
</html>