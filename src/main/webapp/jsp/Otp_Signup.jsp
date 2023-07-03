<%@page import="com.vikas.shopping.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Verification</title>
</head>
<body>
	<h1 id="successMessage">${fail}</h1>
	<h1 id="failMessage">${pass}</h1>
	<%
	String email = (String) request.getAttribute("merchant");
	%>
	<h2>
		OTP Validation for
		<%=email%></h2>
	<form action="/merchant/verify" method="post">
		<label for="email">Email:</label><br> <input type="hidden"
			id="email" name="email" value="<%=email%>" readonly><br>
		<input type="number" name="otp" placeholder="Enter OTP">
		<button type="submit">Verify</button>
		<button type="reset">Cancel</button>
		<a href="#"><button type="button">Resend</button></a>
	</form>
	<script>
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