<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1 style= "margin-left : 15%; margin-top : 1%"><c:out value="${dojo.name}"></c:out></h1>
 <table class="table table-striped" style="width : 700px;margin-left : 15%;">
    <thead class="thead-dark">
        <tr>
            <th scope="col" >First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="n" items="${dojo.ninjas}">
    		<tr>
    			<td><c:out value="${n.firstName}"></c:out></td>
			    <td><c:out value="${n.lastName}"></c:out></td>
			    <td><c:out value="${n.age}"></c:out></td>
			</tr>
		</c:forEach>
    </tbody>
</table>
</body>
</html>