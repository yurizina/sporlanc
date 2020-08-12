<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit AddItem</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
 <%@include file="/resources/style.css" %>
</style>
</head>
<body>
	<div class=bg-img>
		<img src="resources/sporlanc_logo.png">

		<div class=block-center align="center">
			<h1>New/Edit Eircode</h1>
			<form:form action="saveEir" method="post" modelAttribute="eircode">
				<table>
					<form:hidden path="eircode_ID" />
					<tr>
						<td>EIRCODE:</td>
						<td><form:input path="eircode" required="required"/>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>