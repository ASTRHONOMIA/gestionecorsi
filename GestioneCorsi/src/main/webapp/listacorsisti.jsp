<%
	if(session.getAttribute("nomeAdmin") != null) {
%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corsista"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Lista Corsisti</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Corsisti attualmente iscritti:</h3>
	</header>
	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
			</thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Codice</th>
					<th>Precedenti Formativi</th>
				</tr>
			<tbody>
				<% 
					Corsista[] c = Facade.getIstance().getCorsisti();
					for(int i=0; i<c.length ; i++){
				%>
				<tr>
					<td><%= c[i].getNomeCorsista()%></td>
					<td><%= c[i].getCognomeCorsista()%></td>
					<td><%= c[i].getCodiceCorsista()%></td>
					<td></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	
	<div class="well well">
		<a class="btn btn-info btn-lg" href="/<%=application.getServletContextName()%>/inserisciCorsista">
		Inserisci nuovo corsista &raquo;
		</a>
		<br><br>
		<a class="btn btn-info btn-lg" href="statistiche.jsp">
		Visualizza statistiche &raquo;
		</a>
		<br><br>
		<a class="btn btn-info btn-lg" href="corsidisp.jsp">
		Rimuovi corso &raquo;
		</a>
	</div>
	
</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("index.jsp");
	}
%>