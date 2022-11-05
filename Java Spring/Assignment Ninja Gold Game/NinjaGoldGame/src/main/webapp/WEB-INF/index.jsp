<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
    <div class="game">
        <div class="your_gold">
            <h1>Your Gold: <c:out value="${total_gold}"></c:out></h1> 
     	</div>
     	<div class="container">
                <form action="/money" method="post">
                    <div id="s1">
                        <h3>Farm</h3>
                        <h4>earns 10-20 gold</h4>
                        <input type="hidden" value="farm" name="test">
                        <button type="submit" >Find Gold!</button>
                    </div>
                </form>

                <form action="/money" method="post">
                    <div id="s2">
                        <h3>Cave</h3>
                        <h4>earns 5-10 gold</h4>
                        <input type="hidden" value="cave" name="test">
                        <button type="submit" >Find Gold!</button>
                    </div>
                </form>

                <form action="/money" method="post">
                    <div id="s3">
                        <h3>House</h3>
                        <h4>earns 2-5 gold</h4>
                        <input type="hidden" value="house" name="test">
                        <button type="submit">Find Gold!</button>
                    </div>
                </form>

                <form action="/money" method="post">
                    <div id="s4">
                        <h3>Quest</h3>
                        <h4>earns/takes 0-50 gold</h4>
                        <input type="hidden" value="quest" name="test">
                        <button type="submit">Find Gold!</button>
                    </div>
                </form>
            </div>
            
           
            
             <form action="/money" method="post">
                <div class="activities" style=" height:200px;  overflow: scroll;">
                    <h2>Activities :</h2>
					<c:forEach var="message" items="${activities}">
					      <div style="color : red">
					      	<c:if test = "${fn:contains(message, 'lost')}"><c:out value="${message}"/><br /></c:if>
					      </div>

					       <div style="color : green">
					       		<c:if test = "${fn:contains(message, 'earn')}"><c:out value="${message}"/><br /></c:if>
					       </div>
					     
					</c:forEach>
                </div>
            </form>
     </div>

</body>
</html>