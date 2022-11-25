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
<title>DashBoard</title>
			<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="font-family:cursive;margin-left:10%">


<h1 style="margin-left:18%">Project Manager Dashboard</h1>
<h3 style="margin-left:30%;color:red">Welcome, ${user.firstName}</h3>
<p><a href="/logout" style="margin-left:70%">Log Out</a></p>
<p><a href="/projects/new" style="margin-left:70%">Add Project</a></p>

<h4 style="margin-left:15%">All Projects</h4>

<table class="table table-striped" style="width : 700px;margin-left : 15%;">
    <thead>
        <tr>
            <th class="table-danger" >Project</th>
            <th class="table-danger">Team Lead</th>
            <th class="table-danger">Due Date</th>
            <th class="table-danger">Actions</th>
        </tr>
    </thead>
    <tbody>
<c:forEach var="project" items="${unassignedProjects}">        
		<tr>
			<c:if test = "${project.lead.id!=user.id}">
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td><c:out value="${project.lead.firstName}"></c:out></td>
			<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
		    <td><a href="/dashboard/join/${project.id}">Join Team</a></td>
		    </c:if>
		</tr>	
</c:forEach>  
    </tbody>
</table>



<br>
<br>

<h4 style="margin-left:15%">Your Projects</h4>
<table class="table table-striped" style="width : 700px;margin-left : 15%;">
    <thead> 
    	<tr>
    		<th class="table-danger">Project</th>
    		<th class="table-danger">Team Lead</th>
    		<th class="table-danger">Due Date</th>
    		<th class="table-danger">Actions</th>
    	</tr>
    </thead>
    <tbody>
    	<c:forEach var="project" items="${assignedProjects}">
		<tr>
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td><c:out value="${project.lead.firstName}"></c:out></td>
			<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
			<c:if test = "${project.lead.id==user.id}">
		       <td><a href="/projects/edit/${project.id}">Edit Project</a></td>
		    </c:if>
		    <c:if test = "${project.lead.id!=user.id}">
		       <td><a href="/dashboard/leave/${project.id}">Leave Team</a></td>
		    </c:if>
		</tr>	
	</c:forEach>
    </tbody>
</table>

</body>
</html>