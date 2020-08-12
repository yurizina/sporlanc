<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Group Classes</title>
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

			<h1>Class Session</h1>

			<table id="bookingPriTable01" border="1">
				<tr>
					<th> &nbsp;No &nbsp;</th>
					<th>&nbsp; Period &nbsp;</th>
					<th> &nbsp;Days &nbsp; </th>
					<th> &nbsp;Price (per class) &nbsp;</th>
					<th> &nbsp;Spots &nbsp;</th>
					<th> &nbsp;Under (years) &nbsp;</th>
					<th> &nbsp;Language &nbsp;</th>
					<th> &nbsp;Book &nbsp;</th>

				</tr>

				<c:forEach var="classe" items="${listClasses}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${classe.period2}</td>
						<td>${classe.days}</td>
						
						<td>${classe.price}</td>
						<td>${classe.availability}</td>
						<td>${classe.sport}</td>
						
						<td>${classe.ages_id}</td>
						<td>${classe.language2}</td>

						<td>&nbsp;&nbsp;&nbsp;&nbsp;<a 
							href="/sporlanc/bookClass?id=${classe.class_ID}&student_id=${classe.student_id}">Book</a>
							&nbsp;&nbsp;&nbsp;&nbsp;</td>

					</tr>
				</c:forEach>
			</table>
		</div>
		</div>
</body>
</html>