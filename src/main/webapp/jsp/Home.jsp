<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="/css/font-awesome.css">

<link rel="stylesheet" href="/css/templatemo-hexashop.css">

<link rel="stylesheet" href="/css/owl-carousel.css">

<link rel="stylesheet" href="/css/lightbox.css">
</head>
<body>
	<%@include file="../jspf/Header.jspf"%>
	<div class="container">
		<div class="centered-div">
			<h1>Home page</h1>
		</div>
	</div>

	<%@include file="../jspf/Footer.jspf"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/js/owl-carousel.js"></script>
	<script src="/js/accordions.js"></script>
	<script src="/js/datepicker.js"></script>
	<script src="/js/scrollreveal.min.js"></script>
	<script src="/js/waypoints.min.js"></script>
	<script src="/js/jquery.counterup.min.js"></script>
	<script src="/js/imgfix.min.js"></script>
	<script src="/js/slick.js"></script>
	<script src="/js/lightbox.js"></script>
	<script src="/js/isotope.js"></script>
	<script src="https://kit.fontawesome.com/49b30a67fc.js" crossorigin="anonymous"></script>

	<!-- Global Init -->
	<script src="/js/custom.js"></script>

	<script>
		$(function() {
			var selectedClass = "";
			$("p").click(function() {
				selectedClass = $(this).attr("data-rel");
				$("#portfolio").fadeTo(50, 0.1);
				$("#portfolio div").not("." + selectedClass).fadeOut();
				setTimeout(function() {
					$("." + selectedClass).fadeIn();
					$("#portfolio").fadeTo(50, 1);
				}, 500);

			});
		});
	</script>
</body>
</html>
