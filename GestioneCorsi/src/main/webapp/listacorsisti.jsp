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
	<jsp:include  page ="creaCorsistaModal.jsp"/>
	<header>
		<h3>Corsisti attualmente iscritti: </h3>
	</header>
	<div  class="btn-group btn-group-justified " role="group" style="margin-bottom:30px;" >
		<a class="btn btn-info btn-xs" data-toggle="modal" data-target="#editModal" href="#">
		Inserisci nuovo corsista &nbsp;<span class="glyphicon glyphicon-plus"></span>
		</a>
		
		<a  class="btn btn-info " href="statistiche.jsp">
		Visualizza statistiche &nbsp;<span class="glyphicon glyphicon-list-alt">
		</a>
		
		<a class="btn btn-info " href="corsidisp.jsp">
		Rimuovi corso &nbsp;<span class="glyphicon glyphicon-trash">
		</a>
	</div>
	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
			</thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Precedenti Formativi</th>
				</tr>
			<tbody>
				<% 
					Corsista[] c = Facade.getIstance().getCorsisti();
					for(int i=0; i<c.length ; i++){
				%>
				<tr>
					<td>
						<form action="infocorsista.jsp" method="post">
							<input type="hidden" name="idCorsista" value="<%= c[i].getCodiceCorsista()%>">
							<button type="submit" class="btn btn-link"> <%= c[i].getNomeCorsista()%> </button>
						</form>
					</td>
					<td><%= c[i].getCognomeCorsista()%></td>
					<td><%= c[i].isPrecedentiFormativi()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
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