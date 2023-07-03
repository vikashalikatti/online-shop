<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
</head>
<body>
	<h1 id="successMessage">${fail}</h1>
	<h1 id="failMessage">${pass}</h1>
	<div class="header"></div>


	<div class="container">
		
		<form action="/customer/login" method="post">
			Email: <input type="text" name="email"><br> Password: <input
				type="password" name="password"><br>
			<button>Login</button>
			<button type="reset">Cancel</button>
		</form>
		<br> <a href="/customer/forgotpassword">Forgot Password?</a> <br>
		<br> <a href="/customer/signup">New?Click here to Signup</a> <br>
		<br> <a href="/"><button>Back</button></a>
	</div>

	<div class="footer"></div>

	<script type="text/javascript"
		src="/webjars/bootstrap/5.3.0/js/bootstrap.min.js">
		// Get the success and fail message elements
		var successMessage = document.getElementById("successMessage");
		var failMessage = document.getElementById("failMessage");

		// Check if the success message exists and display it as a pop-up alert
		if (successMessage.innerText !== "") {
			window.alert(successMessage.innerText);
			successMessage.style.display = "none"; // Hide the success message element
		}

		// Check if the fail message exists and display it as a pop-up alert
		if (failMessage.innerText !== "") {
			window.alert(failMessage.innerText);
			failMessage.style.display = "none"; // Hide the fail message element
		}
	</script>


</body>
</html>