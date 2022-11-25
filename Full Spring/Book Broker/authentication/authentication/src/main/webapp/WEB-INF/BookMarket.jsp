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
		<h6 style="color:LightCoral;">Hello, <c:out value="${user.userName}">.</c:out> Welcome To .. </h6>
		<h1 >The Book Broker ! </h1>
	</div>

	<div style="margin-left:25%">
		<p><a  href="/books">Back To The Shelves</a></p>
	</div>
</div>
<h6 style="margin-left: 20%">Available Books To Borrow </h6>
<table class="table table-striped" style="width : 700px;margin-left : 20%;">
    <thead>
        <tr>
            <th class="table-danger">ID</th>
            <th class="table-danger" >Title</th>
            <th class="table-danger">Author Name</th>
            <th class="table-danger">Owner</th>
            <th class="table-danger">Actions</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="b" items="${allbooks}">
         <c:if test="${ b.borrower == null }">
    		<tr>
    			<td><c:out value="${b.id}"></c:out></td>
			    <td><a href="/books/${b.id}"><c:out value="${b.title}"></c:out></a></td>
			    <td><c:out value="${b.author}"></c:out></td>
			    <td><c:out value="${b.user.userName}"></c:out></td>
			    <td><c:choose>
					<c:when test="${ b.user.id == user_id }">
					<td><a href="/books/edit/${ b.id }">edit</a> || <a href="/books/delete/${ b.id }">delete</a></td>
					</c:when>
					<c:otherwise>
					<td><a href="/bookmarket/borrow/${ b.id }">Borrow</a></td>
					</c:otherwise>
					</c:choose></td>
		    </tr>
	   </c:if>
	   </c:forEach>
    </tbody>
</table>


<h6 style="margin-left: 20%">Books I'm Borrowing .. </h6>

<table class="table table-striped" style="width : 700px;margin-left : 20%;">
    <thead>
        <tr>
            <th class="table-danger">ID</th>
            <th class="table-danger" >Title</th>
            <th class="table-danger">Author Name</th>
            <th class="table-danger">Owner</th>
            <th class="table-danger">Actions</th>
        </tr>
    </thead>
    <tbody>
			<c:forEach var="b" items="${ allbooks }">
				<c:if test="${ b.borrower.id== user_id }">         
    		<tr>
    			<td><c:out value="${b.id}"></c:out></td>
			    <td><a href="/books/${b.id}"><c:out value="${b.title}"></c:out></a></td>
			    <td><c:out value="${b.author}"></c:out></td>
			    <td><c:out value="${b.user.userName}"></c:out></td>
				<td><a href="/bookmarket/return/${ b.id }">Return</a></td>
			</tr>
			</c:if>
		</c:forEach>
    </tbody>
</table>



</body>

</html>