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
<title>Edit Language</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container col-6">
		<div class="p-2 d-flex justify-content-between">
			<a class="mt-2" href="/languages">Dashboard</a>
			<form action="/languages/${lang.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					class="form-control-plaintext text-danger" type="submit"
					value="Delete">
			</form>
		</div>
		<form:form class="form p-2" action="/languages/${lang.id}"
			method="post" modelAttribute="lang">
			<input type="hidden" name="_method" value="put">
			<div class="my-2">
				<form:label class="form-label" path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input class="form-control" path="name" />
			</div>
			<div class="my-2">
				<form:label class="form-label" path="creator">Creator</form:label>
				<form:errors class="text-danger" path="creator" />
				<form:input class="form-control" path="creator" />
			</div>
			<div class="my-2">
				<form:label class="form-label" path="currentVersion">Version</form:label>
				<form:errors class="text-danger" path="currentVersion" />
				<form:input class="form-control" path="currentVersion" />
			</div>
			<input class="btn btn-primary" type="submit" value="Save Edits" />
		</form:form>
	</div>
</body>
</html>