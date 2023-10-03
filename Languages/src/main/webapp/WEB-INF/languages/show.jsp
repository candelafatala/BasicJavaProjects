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
<title>Language Details</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container col-6">
		<a href="/languages" class="row p-2 m-2">Dashboard</a>
		<ul class="list-group m-2">
			<li class="list-group-item"><c:out value="${lang.name}"></c:out></li>
			<li class="list-group-item"><c:out value="${lang.creator}"></c:out></li>
			<li class="list-group-item"><c:out
					value="${lang.currentVersion}"></c:out></li>
		</ul>
		<div class="p-2 m-2 d-flex justify-content-between">
			<a href="/languages/${lang.id}/edit" class="mt-1">Edit</a>
			<form class="mx-4" action="/languages/${lang.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					class="form-control-plaintext text-danger" type="submit"
					value="Delete">
			</form>
		</div>
	</div>
</body>

</html>