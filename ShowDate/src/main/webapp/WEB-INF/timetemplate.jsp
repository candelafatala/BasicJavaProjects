<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     
	pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html> 
<head> 
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./CSS/timeStyle.css">
	<title>Time</title> 
</head> 
<body>
	<main>
		<h1> 
			<c:out value="${hora}"/>:<c:out value="${minuto}"/> <c:out value="${tiempo}"/>
		</h1>
	</main>
	<script type="text/javascript" src="./JS/timeApp.js"></script>
</body> 
</html>