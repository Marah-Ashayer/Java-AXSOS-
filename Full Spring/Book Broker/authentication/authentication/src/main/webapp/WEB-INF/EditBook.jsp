<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
			<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div style="display:flex;margin-left : 15%;margin-bottom:50px;margin-top : 30px">
	<h2> Edit Your Entry</h2>
	<a style="margin-left : 17%;font-size:15px" href="/books">Back To The Shelves!</a>
</div>


	<form:form action="/books/edit/${book.id}" method="post" modelAttribute="book"  style="width : 400px;margin-left : 15%;">
	      <input type="hidden" name="_method" value="put">
	      <form:hidden path="user" value="${user_id}"/>
	  <div class="form-group">
	    <form:label path="title" for="exampleInputEmail1">Title : </form:label>
	    <form:errors path="title"/>
	    <form:input path="title" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Title"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="author" for="exampleInputPassword1">Author : </form:label>
	    <form:errors path="author"/>
	    <form:input path= "author" type="text" class="form-control" id="exampleInputPassword1" placeholder="Author Name"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="thoughts" for="exampleInputPassword1">My Thoughts:</form:label>
	    <form:errors path="thoughts"/>
	    <form:input path="thoughts" type="text" class="form-control" id="exampleInputPassword1" placeholder="Thoughts"></form:input>
	  </div>
	  	  <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Submit">
	</form:form>
	
	<a href="/books/delete/${ b.id }">delete</a>
</body>
</html>