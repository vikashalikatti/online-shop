<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
	<nav class="container">
		<a href="/logout"><button class="btn btn-success">logout</button></a>
	</nav>
	<center>
		<div class="container">
			<h1 style="color: green">${pass}</h1>
		</div>
		<div class="container">
			<h1>Admin Home</h1>
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>