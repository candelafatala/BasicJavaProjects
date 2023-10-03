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
<title>Languages</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<h1 class="py-2">Programming Languages Database</h1>
		<h3 class="py-2">View all languages</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${langs}" var="lang">
					<tr>
						<td><a href="/languages/${lang.id}">${lang.name}</a></td>
						<td><c:out value="${lang.creator}" /></td>
						<td><c:out value="${lang.currentVersion}" /></td>
						<td class="d-flex justify-content-start">
							<a class="mt-2" href="/languages/${lang.id}/edit">Edit</a>
							<form class="mx-4" action="/languages/${lang.id}"
								method="post">
								<input type="hidden" name="_method" value="delete"> <input
									class="form-control-plaintext text-danger" type="submit"
									value="Delete">
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3 class="py-2">Add a new language</h3>
		<form:form class="form col-6" action="/languages" method="post"
			modelAttribute="lang">
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
			<input class="btn btn-primary my-2" type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>