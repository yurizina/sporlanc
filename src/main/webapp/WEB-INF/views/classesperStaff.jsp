<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookings Session</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	
<script type="text/javascript">
	$("#btnPrint2").live("click", function() {
		var divContents = $("#divContainer").html();
		var printWindow = window.open('', '', 'height=400,width=800');
		printWindow.document.write('<html><head><title>DIV Contents</title>');
		printWindow.document.write('</head><body >');
		printWindow.document.write(divContents);
		printWindow.document.write('</body></html>');
		printWindow.document.close();
		printWindow.print();
	});
</script>

<style type="text/css">
<%@include file="/resources/style.css" %>
</style>
</head>

<body>
	<div class=bg-img>
		<img src="resources/sporlanc_logo.png">
		<div class=block-center align="center">
			<div id="divContainer" align="center">
				<h1>Class Session</h1>
				<table border="1">
					<tr>
						<th>No</th>
						<th>&nbsp;&nbsp;Period&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Days&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Capacity&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Spots&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Price&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Type&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;&nbsp;&nbsp;Sport&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Employee ID&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Under (years)&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Language&nbsp;&nbsp;</th>
						<th>&nbsp;&nbsp;Management&nbsp;&nbsp;</th>
					</tr>

					<c:forEach var="classe" items="${listClasse}" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>

							<td>${classe.period2}</td>
							<td>${classe.days}</td>
							<td>${classe.capactity}</td>
							<td>${classe.availability}</td>
							<td>${classe.price}</td>
							<td>${classe.type2}</td>
							<td>${classe.sport}</td>
							<td>${classe.emp_id}</td>
							<td>${classe.ages_id}</td>
							<td>${classe.language2}</td>

							<td><a href="/sporlanc/editClass?id=${classe.class_ID}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="/sporlanc/deleteClass?id=${classe.class_ID}&empID=${emp_id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				</div>
				<hr>
			<!--  Print Function -->
			<form id="form1">
				<input type="button" value="Print" id="btnPrint2" />
			</form>
			
			<hr>
			<button id="hPb">
				<a href="/sporlanc/homeEmp?id=${emp_id}">Return</a>
			</button>

		</div>
	</div>
</body>
</html>