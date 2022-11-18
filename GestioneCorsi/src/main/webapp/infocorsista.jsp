<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%

	if(session.getAttribute("nomeAdmin")==null || request.getParameter("idCorsista")==null)
		response.sendRedirect("index.jsp");
	else{
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
<div class="container" style="justify-content:space-between;">
	<header class="page-header">
		<h3><%=corsista.getNomeCorsista()%> <%=corsista.getCognomeCorsista()%></h3>
	</header>
	
	<div class="row"  style="justify-content:flex-start;margin-left:3px" >
		
		<form action="addCorsoModal.jsp" method="post" >
				<input type="hidden" name="CodCorsista" value="<%= corsista.getCodiceCorsista()%>">
				<button type="button" class="btn btn-primary" data-toggle="modal" 
				data-target="#addCorsoModal_0">
				Iscrivi a nuovo corso&nbsp;<span class="glyphicon glyphicon-pencil"></span></button>
				<a type="button" class="btn btn-default" href="listacorsisti.jsp">HomePage&nbsp;<span class="glyphicon glyphicon-home"></span></a>
		</form>		
			
	
	</div>
	
	<div class="row" style="justify-content:space-between; margin-top:50px;">
	
	<% 
			DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
			for(int i=0; i<idCorso.length ; i++){
				long id = idCorso[i];
				Corso corso = Facade.getIstance().findByCod(id);
	%>
	
		<div class=" col-md-3 col-sm-5 col-xs-12" style="display:inline-block;">
	
			<div class="panel panel-info" >
				<div class="panel-heading">
					<h3><%=corso.getNomeCorso()%></h3>
				</div>
			<div class="panel-body">
		
			<h4></h4>
			<p>Inizio: <%=format.format(corso.getDataInizio())%></p>
			<p>Fine: <%=format.format(corso.getDataFine())%></p>
			<p>Costo: <%=String.format("%.2f",corso.getCosto())%>&euro;</p>
			<p>Commento: <%=corso.getCommento() %></p>
			<p>Aula: <%=corso.getAulaCorso()%></p>
			<p>Posti occupati: <%=corso.getPostiOccupati()%></p>
			<hr>
		
			</div>
			</div>
			
		</div>
	<% 
		}
	%>
	</div>
</div>
<footer>
	<%@include file="footer.html" %>
</footer>
</body>
</html>
<jsp:include page="addCorsoModal.jsp">
	<jsp:param value="0" name="addCorso"/>
</jsp:include>
<%
	}
%>