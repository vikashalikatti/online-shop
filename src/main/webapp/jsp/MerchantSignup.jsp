<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant Signup</title>
</head>
<body>
	<h1 id="successMessage">${fail}</h1>
	<h1 id="failMessage">${pass}</h1>

	<div class="container">
		<div class="form">
			<form action="/merchant/signup" method="post"
				enctype="multipart/form-data">
				<h2>Merchant Signup</h2>
				<label for="name">Name:</label> <input type="text" name="name"
					id="name" required><br> <label for="email">Email:</label>
				<input type="text" name="email" id="email" required><br>
				<label for="mobile">Mobile:</label> <input type="tel" name="mobile"
					id="mobile" pattern="[0-9]{10}" required><br> <label
					for="password">Create Password:</label> <input type="password"
					name="password" id="password" required><br> <label
					for="date">Date of Birth:</label> <input type="date" name="date"
					id="date" required><br> <label for="gender">Gender:</label>
				<input type="radio" name="gender" id="male" value="male" required>
				<label for="male">Male</label> <input type="radio" name="gender"
					id="female" value="female" required> <label for="female">Female</label><br>
				<label for="pic">Picture:</label> <input type="file" name="pic"
					id="photo" accept="image/*" required><br> <label
					for="address">Address:</label>
				<textarea rows="5" cols="30" name="address" id="address" required></textarea>
				<br>
				<button type="submit">Signup</button>
				<button type="reset">Cancel</button>
			</form>
		</div>
		<br> <br> <a href="/merchant/login"><button>Back</button></a>
	</div>

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
	<script>
		function checkFileSize(input) {
			if (input.files[0].size > 200000) {
				alert("The file must be less than 200KB.");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
