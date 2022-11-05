<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1 style= "margin-left : 20%; margin-top : 10%">All Books</h1>
<table class="table table-striped" style="width : 500px;margin-left : 20%;">
    <thead>
        <tr>
            <th class="table-danger">ID</th>
            <th class="table-danger" >Title</th>
            <th class="table-danger">Language</th>
            <th class="table-danger"># Pages</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="b" items="${books}">
    		<tr>
    			<td><c:out value="${b.id}"></c:out></td>
			    <td><a href="/books/${b.id}"><c:out value="${b.title}"></c:out></a></td>
			    <td><c:out value="${b.language}"></c:out></td>
			    <td><c:out value="${b.numberOfPages}"></c:out></td>
			</tr>
		</c:forEach>
    </tbody>
</table>
</body>
</html>