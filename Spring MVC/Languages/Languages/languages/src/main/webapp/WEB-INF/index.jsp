<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
<h1 style= "margin-left : 15%; margin-top : 1%">Languages</h1>
 <table class="table table-striped" style="width : 700px;margin-left : 15%;">
    <thead class="thead-dark">
        <tr>
            <th scope="col" >Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="l" items="${languages}">
    		<tr>
    			<td><a href="/languages/${l.id}"><c:out value="${l.name}"></c:out></a></td>
			    <td><c:out value="${l.creator}"></c:out></td>
			    <td><c:out value="${l.version}"></c:out></td>
			    <td><a href="/languages/edit/${l.id}">Edit</a></td>
			     <td>
			         <form action="/languages/delete/${l.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input type="submit" value="Delete">
				     </form>
			     </td>
			</tr>
		</c:forEach>
    </tbody>
</table>



   

<form:form action="/languages/new" method="post" modelAttribute="language" style= "margin-left : 10%;"  class="form-group">
  <h2>Add a Language : </h2>
    <p>
        <form:label path="name">Name :</form:label>
        <form:errors path="name"/>
        <form:input class="form-control" id="formGroupExampleInput" path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator :</form:label>
        <form:errors path="creator"/>
        <form:input class="form-control" id="formGroupExampleInput" path="creator"/>
    </p>
    <p>
        <form:label path="version">Version :</form:label>
        <form:errors path="version"/>
        <form:input class="form-control" id="formGroupExampleInput"  path="version"/>
    </p>
   
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>    


</body>
</html>