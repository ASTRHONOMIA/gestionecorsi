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
<% if(request.getParameter("error")!=null && !request.getParameter("error").equals("")){%>
<script>
	$(document).ready(function(){
		$("#errorModal").modal('show');
	});
</script>
<% } %>
<jsp:include page="nav.jsp"/>
<div class="container">
	<jsp:include  page ="creaCorsistaModal.jsp"/>
	<jsp:include  page="creacorsomodal.jsp"/>
	<jsp:include  page="datierratiModal.jsp"/>
	<header>
		<h3>Corsisti attualmente iscritti: </h3>
	</header>
	
	<div  class="listaCorsistiBtn"  style="margin-bottom:30px;">
	
		<a class="btn btn-info col-md-3 col-sm-6 col-xs-12" style="background-color:LightSkyBlue;color:#344055;border-radius: 0px" data-toggle="modal" data-target="#editModal" href="#">
		<label>Inserisci nuovo corsista &nbsp;<span class="glyphicon glyphicon-plus"></span></label>
		</a>
		
		<a  class="btn btn-info col-md-3 col-sm-6 col-xs-12" data-toggle="modal" data-target="#ModalCorso" style="background-color:LightSkyBlue;color:#344055;border-radius: 0px" href="#" >
		<label>Inserisci corso &nbsp;<span class="glyphicon glyphicon-plus"></span></label>
		</a>
		
		<a  class="btn btn-info col-md-3 col-sm-6 col-xs-12" href="statistiche.jsp" style="background-color:LightSkyBlue;color:#344055;border-radius: 0px" >
		<label>Visualizza statistiche &nbsp;<span class="glyphicon glyphicon-list-alt"></span></label>
		</a>
		
		<a class="btn btn-info col-md-3 col-sm-6 col-xs-12" href="corsidisp.jsp" style="background-color:LightSkyBlue;color:#344055;border-radius: 0px">
		<label>Rimuovi corso&nbsp;<span class="glyphicon glyphicon-trash"></span></label>
		</a>
	</div>
	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Precedenti Formativi</th>
				</tr>
				</thead>
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
					<%
						if(c[i].isPrecedentiFormativi()==(true)){
					%>
					<td>Si</td>
					<%
						} else{
					%>
					<td>No</td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>
<footer>
	<%@include file="footer.html" %>
</footer>
</body>

</html>
<%
	} else {
		response.sendRedirect("index.jsp");
	}
%>