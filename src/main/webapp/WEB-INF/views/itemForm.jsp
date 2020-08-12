<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Item</title>
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
		<img id="hPimg"src="resources/sporlanc_logo.png">

		<div class=block-center align="center">
        <h1>New/Edit Item</h1>
        <form:form action="saveItem" method="post" modelAttribute="item">
        <table>
        <form:hidden path="item_id"/>
        <tr> 
        	<td>Name:</td>
        	<td><form:input path="name" required="required"/>
        </tr>
        
         <tr> 
        	<td>Price:</td>
        	<td><form:input path="price" required="required"/>
        </tr>
        <tr> 
        	<td>Availability:</td>
        	<td><form:input path="availability" required="required"/>
        </tr>
        <tr> 
        	<td>Type:</td>
        	<td><form:input path="type" required="required"/>
        </tr>
        <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
        </table>
        </form:form>
        </hr>
        <button id="hPb">
					<a href="/sporlanc/homeAdmin?id=${id}"> Return</a>
		</button>
    </div> 
   </div>
</body>
</html>