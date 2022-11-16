<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.roma.gestionecorsi.architecture.dao.CorsoDAO"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corso"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>
<%
	if(session.getAttribute("nomeAdmin") != null){
%>
	
	
<%
	int sommaDurata= 0;
	Corso [] corsi = Facade.getIstance().getCorsi();
	if(corsi.length !=0){
		for(Corso cor: corsi)
			sommaDurata += Facade.getIstance().getDurataCorso(cor);
	}
	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Statistiche</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header >
		<h3 style="text-align:center;">Statistiche generali</h3>
	</header>
	
	
	<div class="table-responsive col-md-6">
		<table class="table table-hover">
		<!-- <thead>
			<tr>
				<th style="column-span:2; text-align:center;">Statistiche</th>
			</tr>
		</thead> -->
		<tbody>
				<tr>
					<th style="width:40%;">Corsisti totali</th>
					<td style="width:60%;"><%= Facade.getIstance().getNumberCorsisti()%></td>
				</tr>
				<%if (corsi.length != 0){
					double durataMedia = sommaDurata / corsi.length;
					%>
				<tr>
					<th >Corso pi&ugrave; frequentato</th>
					<td >
						<% String [] nomi = Facade.getIstance().corsoPiuFrequentato();
						if(nomi.length !=0){
							for(String nome : nomi){
						%>
						<%= nome %> <br>
					<%}
						}else{
					%>
					Nessun corso viene frequentato
					
					<%} %>
					
					
					</td>
				</tr>
				<tr>
					<th >Data Inizio ultimo corso</th>
					<td >
						<%SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); %>
					 	<%= formatter.format(Facade.getIstance().getInizioUltimoCorso()) %> 
					 </td>
				</tr>
				<tr>
					<th >Durata Media Corsi</th>
					<td >
					 	<%= durataMedia  %> 
					 </td>
				</tr>
				<tr>
					<th >Numero Totali commenti corsi</th>
					<td >
					 	<%= Facade.getIstance().numeroCommenti() %>
					 </td>
				</tr>
				<%}else{%>
				<tr>
					<th>Nessun Corso Presente </th>
					<td></td>
				</tr>
				<%} %>
		</tbody>
				
			
				<!-- <tr>
					<th>Corso pi&ugrave; frequentato</th>
				</tr>
				<tr>
					<th>Corso pi&ugrave; frequentato</th>
				</tr>
				<tr>
					<th>Corso pi&ugrave; frequentato</th>
				</tr>
				<tr>
					<th>Corso pi&ugrave; frequentato</th>
				</tr>
			
			 -->
		</table>
	</div>
	
	
</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("index.jsp");
	}
%>