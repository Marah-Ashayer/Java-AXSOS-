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
<div style="display:flex;margin-left: 20%;margin-bottom:40px" >
	<div>
		<h1 style="color:LightCoral;">Welcome , <c:out value="${thisUser.userName}">!</c:out> </h1>
		<h6 >Books From Everyone's Shelves </h6>
	</div>

	<div style="margin-left:25%">
		<p><a  href="/logout">Log Out</a></p>
		<p><a  href="/books/new">+Add a Book </a></p>
	</div>
</div>

<table class="table table-striped" style="width : 700px;margin-left : 20%;">
    <thead>
        <tr>
            <th class="table-danger">ID</th>
            <th class="table-danger" >Title</th>
            <th class="table-danger">Author Name</th>
            <th class="table-danger">Posted By</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="b" items="${books}">
    		<tr>
    			<td><c:out value="${b.id}"></c:out></td>
			    <td><a href="/books/${b.id}"><c:out value="${b.title}"></c:out></a></td>
			    <td><c:out value="${b.author}"></c:out></td>
			    <td><c:out value="${b.user.userName}"></c:out></td>
			</tr>
		</c:forEach>
    </tbody>
</table>




</body>

</html>