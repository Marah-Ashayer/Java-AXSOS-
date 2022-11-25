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
<title>Login Page</title>


			<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>


<body style="font-family:cursive">

<h1 style="color:LightCoral;margin-left : 17% ">Book Club</h1>
<h6 style="margin-left : 17%;">A Place For friend To Share Thoughts On Books</h6>

<div style="display:flex;padding:3%">

<div class="form1" style="margin-left:11%">
	<h3 style="margin-left : 15%;font-weight:bold">Register</h3>
	<form:form action="/register" method="post" modelAttribute="newUser"  style="width : 400px;margin-left : 15%;">
	  <div class="form-group">
	    <form:label path="userName" for="exampleInputEmail1">User Name : </form:label>
	    <form:errors path="userName"/>
	    <form:input path="userName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="UserName"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="email" for="exampleInputPassword1">Email : </form:label>
	    <form:errors path="email"/>
	    <form:input path= "email" type="email" class="form-control" id="exampleInputPassword1" placeholder="Email"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="password" for="exampleInputPassword1">Password:</form:label>
	    <form:errors path="password"/>
	    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"></form:input>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="confirm" for="exampleInputPassword1">Confirm PW :</form:label>
	    <form:errors path="confirm"/>
	    <form:input path="confirm" type="password" class="form-control" id="exampleInputPassword1" placeholder="Confirm Password"></form:input>
	  </div>
	  <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Register">
	</form:form>
</div>



<div class="form2" style="margin-left:40px">
		<h3 style="margin-left : 15%;font-weight:bold">Log In</h3>
		<form:form action="/login" method="post" modelAttribute="newLogin"  style="width : 400px;margin-left : 15%;">
		  <div class="form-group">
		    <form:label path="email" for="exampleInputEmail1">Email </form:label>
		    <form:errors path="email"/>
		    <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"></form:input>
		  </div>
		  <div class="form-group">
		    <form:label path="password" for="exampleInputPassword1">Password</form:label>
		    <form:errors path="password"/>
		    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"></form:input>
		  </div>
		  <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Log In">
		</form:form>
</div>

</div>





</body>
</html>