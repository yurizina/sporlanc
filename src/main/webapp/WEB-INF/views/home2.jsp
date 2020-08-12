<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Admin</title>

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
	<div align="center">
		<img id="imgHome" src="resources/sporlanc_logo.png">	
			<button id=hPb>
				<a href="/sporlanc/homeAdmin?id=${id}"> Return</a>
			</button>
			
			<h1>Item Session</h1>
			
			<table border="1">
				<tr>
				
				</tr>
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Price</th>
					<th>Availability</th>
					<th>Type</th>
					<th><a href="/sporlanc/newItem">New Item</a></th>
				</tr>

				<c:forEach var="item" items="${listItem}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.availability}</td>
						<td>${item.type}</td>
						<td><a href="/sporlanc/editItem?id=${item.item_id}&empId=${id}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteItem?id=${item.item_id}">Delete</a></td>

					</tr>
				</c:forEach>
			</table>

			<!-----------   List AddItems ----------->
			<hr>
			<h1>Basket Session</h1>

			<table border="1">
				<tr>
					<th>No</th>
					<th>No AddItem</th>
					<th>Quantity</th>
					<th>No Booking</th>
					<th>No Item</th>
					<!-- 
					<th><a href="/sporlanc/newAddItem">New Basket Item</a></th>
					 -->
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

			<!-- -----------------------BOOKING ------------------------- -->
			<hr>

			<h1>Booking Session</h1>
			<table border="1">
				<tr>
					<th>No</th>
					<th>Booking ID</th>
					<th>Student ID</th>
					<th>Class ID</th>
					<th>Subscription</th>
					<th>Starting Date</th>
					<th><a href="/sporlanc/newBookingAdmin">New Booking</a></th>
				</tr>

				<c:forEach var="booking" items="${listBooking}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${booking.booking_ID}</td>
						<td>${booking.studentID}</td>
						<td>${booking.class_ID}</td>
						<td>${booking.subscription}</td>
						<td>${booking.from_date}</td>

						<td><a href="/sporlanc/editBooking?id=${booking.booking_ID}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteBookingAdmin?id=${booking.booking_ID}">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</table>

			<!-- ------------------------ Class Session ------------------------- -->
			<hr>

			<h1>Class Session</h1>
			<table border="1">
				<tr>
					<th>No</th>
					<th>Period</th>
					<th>Days</th>
					<th>Capacity</th>
					<th>Price</th>
					<th>Type</th>
					<th>Sport ID</th>
					<th>Employee ID</th>
					<th>Under (years)</th>
					<th>Language</th>
					<th><a href="/sporlanc/newClassforEmp?id=${id}">New Class</a></th>

				</tr>

				<c:forEach var="classe" items="${listClasse}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>

						<td>${classe.period}</td>
						<td>${classe.days}</td>
						<td>${classe.capactity}</td>
						<td>${classe.price}</td>
						<td>${classe.type}</td>
						<td>${classe.sport_id}</td>
						<td>${classe.emp_id}</td>
						<td>${classe.ages_id}</td>
						<td>${classe.language}</td>

						<td><a href="/sporlanc/editClass?id=${classe.class_ID}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteClass?id=${classe.class_ID}&empId=${id}">Delete</a></td>

					</tr>
				</c:forEach>
			</table>

			<!-- --------------------Eircode------------------- -->
			<hr>

			<h1>Eircode Session</h1>
			<table border="1">
				<tr>
					<th>No</th>
					<th>Eircode ID</th>
					<th>Eircode</th>
					<th><a href="/sporlanc/newEir">New Eircode</a></th>
				</tr>

				<c:forEach var="eircode" items="${listEircode}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${eircode.eircode_ID}</td>
						<td>${eircode.eircode}</td>
						<td><a href="/sporlanc/editEir?id=${eircode.eircode_ID}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteEir?id=${eircode.eircode_ID}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>


			<!-- --------------------Employee------------------- -->
			<hr>

			<h1>Employee Session</h1>
			<table border="1">
				<tr>
					<th>No</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Surname</th>
					<th>Gender</th>
					<th>Birth Date</th>
					<th>Staff role</th>
					<th>Phone</th>
					<th>Hire Date</th>
					<th>Address</th>
					<th>Email</th>
					<th>Passwoord</th>
					<th>Eircode ID</th>
					<th><a href="/sporlanc/newEmpAdmin">New Employee</a></th>
				</tr>

				<c:forEach var="employee" items="${listEmp}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${employee.username}</td>
						<td>${employee.first_name}</td>
						<td>${employee.surname}</td>
						<td>${employee.gender}</td>
						<td>${employee.birth_date}</td>
						<td>${employee.staff_role}</td>
						<td>${employee.phone}</td>
						<td>${employee.hire_date}</td>
						<td>${employee.address}</td>
						<td>${employee.email}</td>
						<td>${employee.password}</td>
						<td>${employee.eircodeID}</td>
						<td><a href="/sporlanc/editEmpAdmin?id=${employee.emp_id}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteEmp?id=${employee.emp_id}">Delete</a></td>

					</tr>
				</c:forEach>
			</table>

			<!-- --------------------Parent------------------- -->
			<hr>

			<h1>Parent Session</h1>
			<table border="1">
				<tr>
					<th>No</th>

					<th>First Name</th>
					<th>Surname</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Eircode ID</th>
					<th>Username</th>
					<th>Email</th>
					<th>Password</th>
					<th><a href="/sporlanc/newParentAdmin">New Parent</a></th>
				</tr>

				<c:forEach var="parent" items="${listParent}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${parent.first_name}</td>
						<td>${parent.surname}</td>
						<td>${parent.phone}</td>
						<td>${parent.address}</td>
						<td>${parent.eircodeID}</td>
						<td>${parent.username}</td>
						<td>${parent.email}</td>
						<td>${parent.password}</td>
						<td><a href="/sporlanc/editParentAdmin?id=${parent.user_ID}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteParent?id=${parent.user_ID}">Delete</a></td>

					</tr>
				</c:forEach>
			</table>
			
			<!-- --------------------Student------------------- -->
			<hr>
			<h1>Student Session</h1>
			<table border="1">
				<tr>
					<th>No</th>
					<td>Student ID</td>

					<th>First Name</th>
					<th>Surname</th>
					<th>Gender</th>
					<th>Birth Date</th>
					<th>Parent ID</th>
					<th><a href="/sporlanc/newStudentAdmin">New Student</a></th>
				</tr>

				<c:forEach var="student" items="${listStudent}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${student.studentID}</td>
						<td>${student.first_name}</td>
						<td>${student.surname}</td>
						<td>${student.gender}</td>
						<td>${student.birth_date}</td>
						<td>${student.userID}</td>

						<td><a
							href="/sporlanc/editStudentAdmin?id=${student.studentID}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/sporlanc/deleteStudentAdmin?id=${student.studentID}">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	
</body>
</html>