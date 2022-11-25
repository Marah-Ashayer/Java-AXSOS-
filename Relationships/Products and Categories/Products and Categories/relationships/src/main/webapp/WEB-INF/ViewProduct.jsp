<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
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
<h1><c:out value="${product.name}"/></h1>

<h2>Categories :</h2>
		<c:forEach items="${product.categories}" var="category">
			<h4><c:out value="${category.name}"/></h4>
		</c:forEach>

<label for="categories">Add Category :</label>
<form action="/products/add" method="post" style= "margin-left : 10%;"  class="form-group">
  	<input type="hidden" name="product" value="${product.id}">
  	<p>
  	<select name="category">
		<c:forEach var="category" items="${outc}">
		     <option value="${category.id}">
		         <c:out value="${category.name}"/>
		     </option>
		</c:forEach>
	 </select>
	</p>
	<input class="btn btn-primary" type="submit" value="Add"/>
</form>
</body>
</html>