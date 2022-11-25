<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<!-- 
=========================================================================
<form:form action="/ninjas/new" method="post" modelAttribute="ninja" style= "margin-left : 10%;"  class="form-group">
  <h2>New Ninja : </h2>
  	<p>
  	<form:label path="dojo">Select Dojo :</form:label>
  	<form:select path="dojo">
		<c:forEach var="dojo" items="${dojos}">
		     <form:option value="${dojo}">
		         <c:out value="${dojo.name}"/>
		     </form:option>
		</c:forEach>
	 </form:select>
	</p>
    <p>
        <form:label path="firstName">First Name :</form:label>
        <form:errors path="firstName"/>
        <form:input class="form-control" id="formGroupExampleInput" path="firstName"/>
    </p>
    
    <p>
        <form:label path="lastName">Last Name :</form:label>
        <form:errors path="lastName"/>
        <form:input class="form-control" id="formGroupExampleInput" path="lastName"/>
    </p>
    
        <p>
        <form:label path="age">Age :</form:label>
        <form:errors path="age"/>
        <form:input class="form-control" id="formGroupExampleInput" path="age"/>
    </p>
        <input class="btn btn-primary" type="submit" value="Creat"/>
</form:form>
===================================================================================
  -->
</body>
</html>