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
<title>Question Details</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<h1>${question.question} </h1>
<div class="d-flex">
	<h2 class="col">Tags:</h2>
	<c:forEach items="${question.tags}" var="tag">
		<p class="col border border-dark m-3 text-center"> ${tag.subject} </p>
	</c:forEach>
</div>
<div class="row">
	<div class="col">
		<table class="table">
			<thead>
				<tr>
					<th>Answers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${question.answers}" var="answer">
				<tr>
					<td>${answer.answer}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col">
		<h3>Add your Answer:</h3>
		<form:form action="/questions/${question.id}" method="POST" modelAttribute="userAnswer">
			<form:input type="hidden" path="question" value="${question.id}"/>
			<div class="form-group">
				<form:label path="answer">Answer: </form:label>
				<form:errors class="text-danger" path="answer"/>
				<form:textarea path="answer"/>
			</div>
			<form:button type="submit" class="btn btn-info text-light my-3">Answer it!</form:button>
		</form:form>
	</div>
</div>
</div>
</body>
</html>