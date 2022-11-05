<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Page</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
</head>
<body>

<div style="width: 25rem; margin-left : 20px ; margin-top : 20px ; padding : 10px" class="card text-white bg-info mb-3">
<h1 class="card-title">Here's Your Okmuji !</h1>
<p class="card-text">
  In<c:out value="${num}"></c:out> years,
  You will live in <c:out value="${city}"></c:out>
  with <c:out value="${person}"></c:out> as your roommate,
  <c:out value="${hoppy}"></c:out>for a living.
  The next time you see a <c:out value="${living}"></c:out>
  you will have a good luck.
  Also ,<c:out value="${say}"></c:out>.
  </p>
<a href="/" class="btn btn-primary">Go Back </a>
</div>
</body>
</html>