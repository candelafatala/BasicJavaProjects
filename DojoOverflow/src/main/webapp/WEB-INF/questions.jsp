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
<title>Dojo Overflow</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container m-2">
<h1>Questions Dashboard</h1>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${questions}" var="q">
		<tr>
			<td><a href="/questions/${q.id}">${q.question} </a></td>
			<td> 
				<c:forEach items="${q.tags}" var="tag">
				${tag.subject} 
				</c:forEach>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a class="text-end" href="/questions/new">New Question</a>
</div>
</body>
</html>