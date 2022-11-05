<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Page</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>

    
    
    <form action="/login" method="post">
    	<h2>Send an Omikuji !</h2>
    	<table>
	    	<tr>
	     	<td><label> Pick Any Number from 5 to 25</label></td>
	     	<td><input type="number" name="num"></td>
	     	</tr>
	     	
	        <tr>
	        <td><label>Enter The Name of Any City :</label></td>
	        <td><input type="text" name="city"></td>
	        </tr>
	        
	        <tr>
	        <td><label>Enter The Name of Any Real Person :</label></td>
	        <td><input type="text" name="person"></td>
	        </tr>
	        
	        <tr>
	        <td><label>Enter Professional Endeavor Or Hoppy :</label></td>
	        <td><input type="text" name="hoppy"></td>
	        </tr>
	        
	        <tr>
	        <td><label>Enter Any Type of Living Thing :</label></td>
	        <td><input type="text" name="living"></td>
	        </tr>
	        
	        <tr>
	        <td><label>Say Something Nice To Someone:</label></td>
	        <td><input type="text" name="say"></td>
	        </tr>
        
        </table>
        <label>Send and Show a Friend</label>
        <input type="submit">
    </form>
    



</body>
</html>