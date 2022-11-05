<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<h3>You Have Visited <a href="/your_server">http:// your_server  </a><c:out value="${count}"></c:out></h3>
	<a href= "/your_server" >Test Another Visit ? </a>
	<a href="/your_server/reset">RESET</a>
</body>
</html>