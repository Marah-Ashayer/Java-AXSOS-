<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
 <table class="table table-striped" style="width : 700px;margin-left : 15%;">
    <thead class="thead-dark">
        <tr>
            <th scope="col" >Name</th>
            <th scope="col">Rating</th>
            <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="s" items="${songs}">
    		<tr>
    			<td><a href="/songs/${s.id}"><c:out value="${s.title}"></c:out></a></td>
			    <td><c:out value="${s.rating}"></c:out></td>
			     <td>
			         <form action="/songs/delete/${s.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input type="submit" value="Delete">
				     </form>
			     </td>
			</tr>
		</c:forEach>
    </tbody>
</table>
<a href="/songs/top">Top Ten</a>


<form action="/search" method="post" modelAttribute="artist" >

        <label>Search Artists:</label>
        <input name="artist" id="artist"/>
        <input class="btn btn-primary" type="submit" value="search"/>
</form>

<a href="/songs">Add Song</a>
</body>
</html>