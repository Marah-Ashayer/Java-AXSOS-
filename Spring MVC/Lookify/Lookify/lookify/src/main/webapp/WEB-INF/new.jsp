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
<form:form action="/songs/new" method="post" modelAttribute="song" style= "margin-left : 10%;"  class="form-group">
  <h2>Add Song : </h2>
    <p>
        <form:label path="title">Title:</form:label>
        <form:errors path="title"/>
        <form:input class="form-control" id="formGroupExampleInput" path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist :</form:label>
        <form:errors path="artist"/>
        <form:input class="form-control" id="formGroupExampleInput" path="artist"/>
    </p>
    <p>
        <form:label path="rating">Rating :</form:label>
        <form:errors path="rating"/>
        <form:input type="number" class="form-control" id="formGroupExampleInput"  path="rating"/>
    </p>
   
    <input class="btn btn-primary" type="submit" value="Add Song"/>
</form:form>
<a href="/dashboard">DashBoard</a>
</body>
</html>