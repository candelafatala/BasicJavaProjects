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
<title>New Question</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<h1>What is your Question?</h1>
<form:form action="/questions/new" method="POST" modelAttribute="newQuestion">
	<div class="form-group">
		<form:label class="form-label" path="question">Question: </form:label>
		<form:errors class="text-danger" path="question"/>
		<form:textarea class="form-control" path="question"/>
	</div>
<!-- 	no se usa el form: porque estamos usando el requestParam -->
	<div class="form-group">
		<label class="form-label"> Tags:</label>
        <p class="text-danger">  ${error} </p>
        <input type="text" class="form-control" name="tagsParam" />
	</div>
	<button class="btn btn-info text-light my-3">Submit</button>
</form:form>
</div>
</body>
</html>