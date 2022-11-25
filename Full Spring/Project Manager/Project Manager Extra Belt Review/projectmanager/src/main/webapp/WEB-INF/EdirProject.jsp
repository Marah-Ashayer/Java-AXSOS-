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
<title>Edit Page</title>
</head>
<body>
<div style="display:flex;margin-left : 15%;margin-bottom:50px;margin-top : 30px">
	<h2> Edit Project</h2>
	<a style="margin-left : 17%;font-size:15px" href="/projects">Cancel</a>
</div>


	<form:form action="/projects/edit/${project.id}" method="post" modelAttribute="project"  style="width : 400px;margin-left : 15%;">
	      
	      <form:hidden path="lead" value="${user_id}"/>
	  <div class="form-group">
	    <form:label path="title" for="exampleInputEmail1">Project Title : </form:label>
	    <form:errors path="title"/>
	    <form:input path="title" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Title"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="description" for="exampleInputPassword1">Project Description : </form:label>
	    <form:errors path="description"/>
	    <form:input path= "description" type="text" class="form-control" id="exampleInputPassword1"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="dueDate" for="exampleInputPassword1">Date :</form:label>
	    <form:errors path="dueDate"/>
	    <form:input path="dueDate" type="date" class="form-control" id="exampleInputPassword1" placeholder="Thoughts"></form:input>
	  </div>
	  	  <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Save">
	</form:form>
</body>
</html>