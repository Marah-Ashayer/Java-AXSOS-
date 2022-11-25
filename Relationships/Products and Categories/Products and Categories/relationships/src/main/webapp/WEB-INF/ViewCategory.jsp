<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
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
<h1><c:out value="${category.name}"/></h1>

<h2>Products :</h2>
		<c:forEach items="${category.products}" var="product">
			<h4><c:out value="${product.name}"/></h4>
		</c:forEach>

<label for="products">Add Category :</label>
<form:form action="/categories/add" method="post" style= "margin-left : 10%;"  class="form-group">
  	<input type="hidden" name="category" value="${category.id}">
  	<p>
  	<select name="product">
		<c:forEach var="product" items="${outp}">
		     <option value="${product.id}">
		         <c:out value="${product.name}"/>
		     </option>
		</c:forEach>
	 </select>
	</p>
	<input class="btn btn-primary" type="submit" value="Add"/>
</form:form>
</body>
</html>