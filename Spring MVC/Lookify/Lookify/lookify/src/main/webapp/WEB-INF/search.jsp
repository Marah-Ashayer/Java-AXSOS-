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

<a href="/dashboard">DashBoard</a>
</body>
</html>