<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>    
     

<form:form action="/languages/edit/${language.id}" method="post" modelAttribute="language" class="form-group" style="width : 800px;margin-left : 50px">
    <input type="hidden" name="_method" value="put">
    <h1>Edit Language</h1>
    <p>
        <form:label class="col-sm-2 col-form-label" path="name">Language Name : </form:label>
        <form:errors path="name"/>
        <form:input class="form-control" path="name"/>
    </p>
    <p>
        <form:label class="col-sm-1 col-form-label" path="creator">Language Creator :</form:label>
        <form:errors path="creator"/>
        <form:input class="form-control" path="creator"/>
    </p>
    <p>
        <form:label class="col-sm-2 col-form-label" path="version">Language Version : </form:label>
        <form:errors path="version"/>
        <form:input class="form-control" path="version"/>
    </p>
    
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>

<form action="/languages/delete/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input style ="margin-top:10px;margin-left:50px" class="btn btn-primary" type="submit" value="Delete">
</form>
 <a href="/languages" class="btn btn-danger" style="margin-top : 20px;margin-left : 50px">DashBoard</a>
</body>
</html>