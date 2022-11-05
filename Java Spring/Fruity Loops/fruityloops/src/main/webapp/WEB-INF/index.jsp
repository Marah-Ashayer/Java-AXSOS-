<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
</head>
<body>
    <h1 style= "margin-left : 20%; margin-top : 10%">Fruit Store</h1>
    <table class="table table-striped" id="table">
    	<thead>
    		<tr>
    			<th class="table-danger">Name</th>
    			<th class="table-danger">Price</th>
    		</tr>
    	</thead>
    	<c:forEach var="f" items="${fruitsfromController}">
    		<tr>
			        <td><c:out value="${f.name}"></c:out></td>
			        <td><c:out value="${f.price}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>