<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<body>
	<center>
		<div class=container>
			<h1 style="color: red">${fail}</h1>
			<h1 style="color: red">${pass}</h1>
			<h1>Login page</h1>
			<form action="/admin/login" method="post">
				<label for="name">Username:</label> <input type="text" id="name"
					placeholder="Enter your mail id" name="email" type="text"><br>
				<br> <label for="password">Password:</label> <input id="name"
					placeholder="Enter your password" name="password" type="password"><br>
				<br>
				<button type="submit">Login</button>
				<button type="reset">Cancel</button>
				<a href="/jsp/Home.jsp">
					<button type="button">Home</button>
				</a>
			</form>
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>