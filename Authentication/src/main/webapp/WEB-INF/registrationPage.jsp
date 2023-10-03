<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Registration and Login</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container p-1">
<div class="row">
	<div class="col offset-1"> 
		<h1>Register!</h1>
	    
	    <div><form:errors class="text-danger m-2" path="user.*"/></div>
	    
	    <form:form  class="d-flex flex-column justify-content-between" method="POST" action="/registration" modelAttribute="user">
	        <div class="d-flex justify-content-between my-2">
	            <form:label path="email">Email:</form:label>
	            <form:input type="email" path="email"/>
	        </div>
	        <div class="d-flex justify-content-between my-2">
	            <form:label path="password">Password:</form:label>
	            <form:password path="password"/>
	        </div>
	        <div class="d-flex justify-content-between my-2">
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation"/>
	        </div>
	        <input class="btn btn-info my-2" type="submit" value="Register!"/>
	    </form:form>
	    
	    <p>${register}</p>
	</div>
	
	<div class="col offset-1">
		<h1>Log In!</h1>
	    
	    <div><form:errors class="text-danger m-2" path="login.*"/></div>
	    
	    <form:form class="d-flex flex-column justify-content-between" method="POST" action="/login" modelAttribute="login">
	        <div class="d-flex justify-content-between my-2">
	            <form:label class="" path="email">Email:</form:label>
	            <form:input type="email" path="email"/>
	        </div>
	        <div class="d-flex justify-content-between my-2">
	            <form:label path="password">Password:</form:label>
	            <form:password path="password"/>
	        </div>
	        <input class="btn btn-info my-2" type="submit" value="Log In!"/>
	    </form:form>
	</div>
</div>
</div>
</body>
</html>