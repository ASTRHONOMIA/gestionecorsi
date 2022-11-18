<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Tentativi Esauriti</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Tentativi d'accesso esauriti</h3>
	</header>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Non hai più tentativi a disposizione</h3>
		</div>
		<div class="panel-body">
			<p>Torna alla pagina iniziale</p>
			<p><a href="index.jsp">Login</a>.</p>
		</div>
	</div>
</div>
<footer>
	<%@include file="footer.html" %>
</footer>
</body>
</html>