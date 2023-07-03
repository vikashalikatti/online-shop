<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Signup</title>
</head>
<body>
	<h1 id="successMessage">${fail}</h1>
	<h1 id="failMessage">${pass}</h1>
	<div class="header"></div>

	<div class="container">
		<form action="/customer/signup" method="post">
			Name: <input type="text" name="name"><br> Email: <input
				type="text" name="email"><br> Mobile: <input type="tel"
				name="mobile" pattern="{0-9}[10]"><br> Create Password:
			<input type="password" name="password"><br> Date of
			Birth: <input type="date" name="date"><br> Gender: <input
				type="radio" name="gender" value="male">Male <input
				type="radio" name="gender" value="female">Female<br>
			Address:
			<textarea rows="5" cols="30"></textarea>
			<br>
			<button>Signup</button>
			<button type="reset">Cancel</button>
		</form>
		<br> <br> <a href="/customer/login"><button>Back</button></a>
	</div>

	<div class="footer"></div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script>
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