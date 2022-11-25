<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<a href="/">Home</a>


<form:form action="/categories/new" method="post" modelAttribute="category" style= "margin-left : 10%;"  class="form-group">
  <h2>New Category : </h2>
    <p>
        <form:label path="name">Name :</form:label>
        <form:errors path="name"/>
        <form:input class="form-control" id="formGroupExampleInput" path="name"/>
    </p>
    <input class="btn btn-primary" type="submit" value="Creat"/>
</form:form>
</body>
</html>