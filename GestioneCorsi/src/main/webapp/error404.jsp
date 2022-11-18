<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
<title>Error 404</title></head>
<link rel="stylesheet" href="css/style.css">
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Pagina non trovata</h3>	
	</div>
	<div class="panel panel-danger">
		<header class="panel-heading">
			<h4>Impossibile caricare la risorsa richiesta</h4>
		</header>
	 	<div class="panel-body">
	 		<input type="button" class="btn btn-default" 
	 		value="Indietro" onclick="window.history.back()" /> 
	 		<p>
	 	</div>
	</div>
</div>
<footer>
	<%@include file="footer.html" %>
</footer>
</body>
</html>