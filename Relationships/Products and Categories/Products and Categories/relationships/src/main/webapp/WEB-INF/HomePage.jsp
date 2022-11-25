<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Home Page</h1>
<a href="/products">New Product</a>
<a href="/categories">New Category</a>


 <table class="table table-striped" style="width : 400px;margin-left : 10%;">
    <thead class="thead-dark">
        <tr>
            <th scope="col" >Products</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="p" items="${products}">
    		<tr>
			    <td><a href="/products/${p.id}"><c:out value="${p.name}"></c:out></a></td>
			</tr>
		</c:forEach>
    </tbody>
</table>




 <table class="table table-striped" style="width : 400px;margin-left : 50%;">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Categories</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="c" items="${categories}">
    		<tr>
			    <td><a href="/categories/${c.id}"><c:out value="${c.name}"></c:out></a></td>
			</tr>
		</c:forEach>
    </tbody>
</table>
</body>
</html>