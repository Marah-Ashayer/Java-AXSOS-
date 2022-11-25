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
<div class="card text-center" style="font-family : cursive;width: 24rem;margin-left : 35%;margin-top: 10%;background-color : Bisque" >
<div class="card-body" >
<h1 class="card-title" style="color : blue">Song Details</h1>
<p class="card-text">Title : <c:out value="${song.title}"/></p>
<p class="card-text">Artist : <c:out value="${song.artist}"/></p>
<p class="card-text">Version : <c:out value="${song.rating}"/></p>

<form action="/songs/delete/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input style ="margin-top:10px" class="btn btn-primary" type="submit" value="Delete">
</form>

</div>
</div>
<a href="/dashboard" class="btn btn-primary" style="margin-left:45%;margin-top:10px" >DashBoard</a>
</body>
</html>