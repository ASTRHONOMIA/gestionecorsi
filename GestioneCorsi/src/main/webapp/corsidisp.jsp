<%@page import="java.sql.Date"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Corsi disponibili</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Corsi disponibili: </h3>
	</header>
	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Codice</th>
					<th>Nome</th>
					<th>Inizio</th>
					<th>Fine</th>
					<th>Costo</th>
					<th>Commento</th>
					<th>Aula</th>
					<th>Docente</th>
					<th>Posti Occupati</th>
				</tr>
			</thead>
			<tbody>
				<% 
					Corso[] cor = Facade.getIstance().getCorsi();
					long ms = System.currentTimeMillis();
					for(int i=0; i<cor.length ; i++){
						if(cor[i].getDataInizio().compareTo(new Date(ms))>0){
				%>
				<tr>
					<td><%=cor[i].getCodCorso()%></td>
					<td><%=cor[i].getNomeCorso()%></td>
					<td><%=cor[i].getDataInizio()%></td>
					<td><%=cor[i].getDataFine()%></td>
					<td><%=cor[i].getCosto()%></td>
					<td><%=cor[i].getCommento()%></td>
					<td><%=cor[i].getAulaCorso()%></td>
					<td><%=cor[i].getCodDocente()%></td>
					<td><%=cor[i].getPostiOccupati()%></td>
				</tr>
				<% 
						}
					}
				%>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>