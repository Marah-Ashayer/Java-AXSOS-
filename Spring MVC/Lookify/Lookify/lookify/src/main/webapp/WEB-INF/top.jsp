<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Top Ten Songs : </h1>
<c:forEach var="s" items="${topSongs}">
    <p><c:out value="${s.rating}"></c:out>
    <a href="/songs/${s.id}"><c:out value="${s.title}"></c:out></a>
    <c:out value="${s.artist}"></c:out>
    </p>
			    
</c:forEach>

<a class="btn btn-primary" href="/dashboard">DashBoard</a>
</body>
</html>