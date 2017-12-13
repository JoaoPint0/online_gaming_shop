<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Indie Discovery - ${title} </title>

<script type="text/javascript">
	window.menu = "${title}"
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/flatty_theme.css"  rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/landingpage.css"   rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared_layouts/navbar.jsp"%>

		<!-- Page Content - Home -->
		<div class="content">
			<c:if test="${userClickHome == true or userClickAllProducts == true 
			or userClickCategoryProducts == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Page Content - About -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Page Content - Product Details -->
			<c:if test="${userClickSingleProduct == true}">
				<%@include file="productsDetails.jsp"%>
			</c:if>

			<!-- Page Content - ContactUs -->
			<c:if test="${userClickContacts == true}">
				<%@include file="contact.jsp"%>
			</c:if>
		</div>
		
		<!-- Footer -->
		<%@include file="./shared_layouts/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery-3.2.1.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- JavaScript Pages-->
		<script src="${js}/navbarController.js"></script>
	</div>
</body>

</html>