<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
<h1 style= "margin-left : 15%; margin-top : 1%">Save Travels</h1>
 <table class="table table-striped" style="width : 500px;margin-left : 15%;">
    <thead class="thead-dark">
        <tr>
            <th scope="col" >Expense</th>
            <th scope="col">Vendor</th>
            <th scope="col"># Amount</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="e" items="${expenses}">
    		<tr>
    			<td><c:out value="${e.name}"></c:out></td>
			    <td><c:out value="${e.vendor}"></c:out></td>
			    <td><c:out value="${e.ammount}"></c:out></td>
			</tr>
		</c:forEach>
    </tbody>
</table>



   

<form:form action="/expenses/new" method="post" modelAttribute="expense" style= "margin-left : 10%;"  class="form-group">
  <h2>Add an Expense : </h2>
    <p>
        <form:label path="name">Expense Name :</form:label>
        <form:errors path="name"/>
        <form:input class="form-control" id="formGroupExampleInput" path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor : </form:label>
        <form:errors path="vendor"/>
        <form:input class="form-control" id="formGroupExampleInput" path="vendor"/>
    </p>
    <p>
        <form:label path="ammount">Amount : </form:label>
        <form:errors path="ammount"/>
        <form:input class="form-control" id="formGroupExampleInput"  path="ammount"/>
    </p>
    <p>
        <form:label path="description">Description : </form:label>
        <form:errors path="description"/>     
        <form:input class="form-control" id="formGroupExampleInput" path="description"/>
    </p>    
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>    


</body>
</html>