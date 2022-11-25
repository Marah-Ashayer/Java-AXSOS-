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
<title>Book Page</title>
			<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<p><a href="/books">Go Back To The Shelves</a></p>
<c:out value="${book.title}"></c:out>
<p style="color: purple"><c:out value="${book.user.userName}"></c:out>  read <c:out value="${book.title}"></c:out>By <c:out value="${book.author}"></c:out></p>
<h5 style="color:red">Here are  <c:out value="${book.user.userName}"></c:out>'s thoughts : </h5>
<p>  <c:out value="${book.thoughts}"></c:out></p>
<c:choose>
    <c:when test="${user_id == book.user.id}">
        <p><a href="/books/edit/${book.id}">Edit</a></p>
		<p><form action="/books/delete/${book.id}" method="post">
    		    <input type="hidden" name="_method" value="delete">
    		    <input type="submit" value="Delete">
			</form>
		</p>
    </c:when> 
    <c:otherwise>
		<p></p>
		<p></p>
	</c:otherwise>   
</c:choose>

			    

</body>
</html>