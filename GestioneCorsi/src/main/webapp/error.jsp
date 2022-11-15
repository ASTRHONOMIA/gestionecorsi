<%@page import="com.roma.gestionecorsi.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Error Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Pagina di errore</h3>
	</header>
<%
	if(exception instanceof ClassNotFoundException) {
%>

<div class="panel panel-danger">
	<div class="panel-heading">
		<h5>Driver non trovato/supportato</h5>
	</div>
	<div class="panel-body">
     	<h5><%= exception.getClass().getName() %></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<button onclick="window.history.back()" class="btn btn-default">Indietro</button>
	</div>
</div>

<%
	} else if(exception instanceof DAOException) {
%>
<div class="panel panel-danger">
	<div class="panel-heading">
		<H5>Eccezione SQL</H5>
	</div>
	<div class="panel-body">
    <h5><%= exception.getClass().getName() %></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<button onclick="window.history.back()" class="btn btn-default">Indietro</button>
	</div>
</div>
<%
	} else {
%>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h5>Eccezione non prevista</h5>
	</div>
	<div class="panel-body">
    <h5><%= exception.getClass().getName() %></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<p>StackTrace:&nbsp;<% exception.printStackTrace(new PrintWriter(out)); %></p>
	<button onclick="window.history.back()" class="btn btn-default">Indietro</button>
	</div>
</div>
<%
	}
%>
</div>

</body>
</html>