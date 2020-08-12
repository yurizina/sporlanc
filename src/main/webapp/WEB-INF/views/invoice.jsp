<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INVOICE</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	
<script type="text/javascript">
	$("#btnPrint").live("click", function() {
		var divContents = $("#dvContainer").html();
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
			<div  class=block-center align="center">
			<div id="dvContainer" align="center">
				<!-- -----------------------BOOKING ------------------------- -->
				<h1>INVOICE</h1>

				<h3>Booking</h3>
				<table border="1">
					<tr>
						<th>Class ID</th>
						<th>Period</th>
						<th>Days</th>
						<th>Price (per day)</th>
					</tr>

					<tr>
						<td>${listClasse.class_ID}</td>
						<td>${listClasse.period2}</td>
						<td>${listClasse.days}</td>
						<td>${listClasse.price}</td>
					</tr>
				</table>
				<p>Total ${valueClass} &#8364; for this class.</p>
				<table border="1">
					<tr>
						<th>Student ID</th>
						<th>Subscription</th>
						<th>Starting Date</th>
					</tr>

					<tr>
						<td>${listBooking.studentID}</td>
						<td>${listBooking.subscription}</td>
						<td>${listBooking.from_date}</td>

					</tr>

				</table>
				<p>
					Weeks subscribed: <b>${valueSubscription}</b>
				</p>

				<h3>Basket</h3>

				<table border="1">
					<tr>
						<th>No</th>
						<th>No AddItem</th>
						<th>Quantity</th>
						<th>No Booking</th>
						<th>No Item</th>
					</tr>

					<c:forEach var="additem" items="${listAddItem}" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${additem.addItem_ID}</td>
							<td>${additem.quantity}</td>
							<td>${additem.bookingID}</td>
							<td>${additem.item_id}</td>

						</tr>
					</c:forEach>
				</table>
				<p>
					Total items: <b>${finalPrice}</b> &#8364;
				</p>

				<h3>Total (Basket + Booking)</h3>
				<p>
					Invoice Total: <strong>${total}</strong> &#8364;
				</p>
				<hr>
			</div>

			<!-- Print function: -->
			<!-- https://stackoverflow.com/a/33890644 -->
			
			<form id="form1">
				<input type="button" value="Print" id="btnPrint" />
			</form>
			
			<hr>
			<button id="hPb">
				<a href="/sporlanc/bookingsStudent?id=${listBooking.studentID}">Return</a>
			</button>
			</div>	
		</div>
	
</body>
</html>