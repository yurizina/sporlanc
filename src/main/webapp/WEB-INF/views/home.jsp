<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
  <%@include file="/resources/style.css" %>
  <!-- 
  Solution: 
  https://stackoverflow.com/questions/8395941/in-eclipse-dynamic-web-project-how-to-link-css-to-jsp-file-in-webcontent-folder 
  -->
</style>

</head>

<body style="height: 1500px">
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a id="nav" class="navbar-brand" href="#">Sporlanc</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul  class="nav navbar-nav">
				<li class="active"><a href="/sporlanc/">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#location">Location</a></li>
				<li><a href="#pricing">Pricing</a></li>
				<li><a href="#classes">Classes</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/sporlanc/registerParent"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>


				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Login <span
						class="glyphicon glyphicon-log-in"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/sporlanc/loginParent">Parent</a></li>
						<li><a href="/sporlanc/loginStaff">Staff</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class=container id="about">


		<h1 align=center>About</h1>
		<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Integer molestie ullamcorper iaculis. Integer eu laoreet sem. In hac
			habitasse platea dictumst. Vestibulum sagittis euismod leo, quis
			placerat nulla rhoncus quis. Vivamus ultricies imperdiet est, in
			congue ipsum cursus porta. Maecenas dignissim odio ut mi varius
			dictum. Nunc vel urna sem. Phasellus non nisl malesuada, placerat
			quam vitae, consectetur magna. Etiam nec quam dapibus, luctus sem eu,
			congue purus. Vivamus quis nunc nibh. Morbi ullamcorper leo eu lacus
			venenatis, quis condimentum metus tincidunt. Aliquam tincidunt libero
			leo, vitae suscipit elit gravida vitae. Sed eleifend et tortor eu
			bibendum. Donec bibendum ante et venenatis molestie. Nunc lobortis
			nisi vel commodo congue.</h2>
			
		<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Integer molestie ullamcorper iaculis. Integer eu laoreet sem. In hac
			habitasse platea dictumst. Vestibulum sagittis euismod leo, quis
			placerat nulla rhoncus quis. Vivamus ultricies imperdiet est, in
			congue ipsum cursus porta. Maecenas dignissim odio ut mi varius
			dictum. Nunc vel urna sem. Phasellus non nisl malesuada, placerat
			quam vitae, consectetur magna. Etiam nec quam dapibus, luctus sem eu,
			congue purus. Vivamus quis nunc nibh. Morbi ullamcorper leo eu lacus
			venenatis, quis condimentum metus tincidunt. Aliquam tincidunt libero
			leo, vitae suscipit elit gravida vitae. Sed eleifend et tortor eu
			bibendum. Donec bibendum ante et venenatis molestie. Nunc lobortis
			nisi vel commodo congue.</h2>
	</div>

	<div class=container id="location">

		<h1 align=center>MAP</h1>
		<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Integer molestie ullamcorper iaculis. Integer eu laoreet sem. In hac
			habitasse platea dictumst. Vestibulum sagittis euismod leo, quis
			placerat nulla rhoncus quis. Vivamus ultricies imperdiet est, in
			congue ipsum cursus porta. Maecenas dignissim odio ut mi varius
			dictum. Nunc vel urna sem. Phasellus non nisl malesuada, placerat
			quam vitae, consectetur magna. Etiam nec quam dapibus, luctus sem eu,
			congue purus. Vivamus quis nunc nibh. Morbi ullamcorper leo eu lacus
			venenatis, quis condimentum metus tincidunt. Aliquam tincidunt libero
			leo, vitae suscipit elit gravida vitae. Sed eleifend et tortor eu
			bibendum. Donec bibendum ante et venenatis molestie. Nunc lobortis
			nisi vel commodo congue.</h2>
	</div>
	<iframe
		src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d152515.2533336981!2d-6.385787755917003!3d53.324443138592216!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x48670e80ea27ac2f%3A0xa00c7a9973171a0!2sDublin!5e0!3m2!1sen!2sie!4v1595443068437!5m2!1sen!2sie"
		width="100%" height="450" frameborder="0" style="border: 0px;"></iframe>




	<div class=container id="pricing">

		<h1 align=center>Pricing</h1>
		<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Integer molestie ullamcorper iaculis. Integer eu laoreet sem. In hac
			habitasse platea dictumst. Vestibulum sagittis euismod leo, quis
			placerat nulla rhoncus quis. Vivamus ultricies imperdiet est, in
			congue ipsum cursus porta. Maecenas dignissim odio ut mi varius
			dictum. Nunc vel urna sem. Phasellus non nisl malesuada, placerat
			quam vitae, consectetur magna. Etiam nec quam dapibus, luctus sem eu,
			congue purus. Vivamus quis nunc nibh. Morbi ullamcorper leo eu lacus
			venenatis, quis condimentum metus tincidunt. Aliquam tincidunt libero
			leo, vitae suscipit elit gravida vitae. Sed eleifend et tortor eu
			bibendum. Donec bibendum ante et venenatis molestie. Nunc lobortis
			nisi vel commodo congue.</h2>
	</div>

	<div class=container id="classes">

		<h1 align=center>Classes</h1>
		<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Integer molestie ullamcorper iaculis. Integer eu laoreet sem. In hac
			habitasse platea dictumst. Vestibulum sagittis euismod leo, quis
			placerat nulla rhoncus quis. Vivamus ultricies imperdiet est, in
			congue ipsum cursus porta. Maecenas dignissim odio ut mi varius
			dictum. Nunc vel urna sem. Phasellus non nisl malesuada, placerat
			quam vitae, consectetur magna. Etiam nec quam dapibus, luctus sem eu,
			congue purus. Vivamus quis nunc nibh. Morbi ullamcorper leo eu lacus
			venenatis, quis condimentum metus tincidunt. Aliquam tincidunt libero
			leo, vitae suscipit elit gravida vitae. Sed eleifend et tortor eu
			bibendum. Donec bibendum ante et venenatis molestie. Nunc lobortis
			nisi vel commodo congue.</h2>


	</div>

	<footer>

	<h2>Contact</h2>
	<p>Author: Yuri Andrade</p>
	<p>
		<span class="glyphicon glyphicon-road"></span> Dublin, Ireland
	</p>
	<p>
		<span class="glyphicon glyphicon-earphone"></span> +353 830373047
	</p>
	<p>
		<span class="glyphicon glyphicon-envelope"></span> <a id="nav"
			href="mailto:yurisfa@gmail.com">Email</a>
	</p>
	<!--  Icons retrieved from: https://getbootstrap.com/docs/3.3/components/ -->
	</footer>
</body>

</html>