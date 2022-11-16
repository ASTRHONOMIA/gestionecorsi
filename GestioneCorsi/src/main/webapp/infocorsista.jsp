<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%
	long idCorsista = Long.valueOf(request.getParameter("idCorsista"));
	Corsista corsista = Facade.getIstance().findCorsistaByCod(idCorsista);
	long idCorso[] = Facade.getIstance().corsiDelCorsista(idCorsista);
%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corsista"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Informazioni Corsista</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3><%=corsista.getNomeCorsista()%> <%=corsista.getCognomeCorsista()%></h3>
	</header>
	<div class="panel panel-info" style="margin-top:50px;">
		<div class="panel-heading">
			<h3>Corsi frequentati: </h3>
		</div>
		<div class="panel-body">
		<% 
			DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
			for(int i=0; i<idCorso.length ; i++){
				long id = idCorso[i];
				Corso corso = Facade.getIstance().findByCod(id);
		%>
			<h4><%=corso.getNomeCorso()%></h4>
			<p>Inizio: <%=format.format(corso.getDataInizio())%></p>
			<p>Fine: <%=format.format(corso.getDataFine())%></p>
			<p>Costo: <%=String.format("%.2f",corso.getCosto())%>&euro;</p>
			<p>Commento: <%=corso.getCommento() %></p>
			<p>Aula: <%=corso.getAulaCorso()%></p>
			<p>Posti occupati: <%=corso.getPostiOccupati()%></p>
			<hr>
		<% 
			}
		%>
		</div>
	</div>
	<hr>
	<a href="listacorsisti.jsp">Torna alla lista dei corsisti</a>
</div>
</body>
</html>