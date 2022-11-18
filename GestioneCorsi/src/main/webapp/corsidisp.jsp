<%@page import="com.roma.gestionecorsi.businesscomponent.model.Docente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
Cookie my_cookie = null;
Cookie[] my_cookies = null;
// Get an array of Cookies associated with the this domain
my_cookies = request.getCookies();
if( my_cookies != null ) {
   for (int i = 0; i < my_cookies.length; i++) {
      my_cookie = my_cookies[i];
      	if(my_cookie.getName().equals("Admin")) //se trova il coockie che mi interessa esce dal ciclo
      		break;
      	}
   }
		if(my_cookie!=null && my_cookie.getName().equals("Admin"))
				{
					session.setAttribute("nomeAdmin", my_cookie.getValue());
				}
		if(session.getAttribute("nomeAdmin") == null)
			response.sendRedirect("index.jsp");
		else{
%>
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
	<header>
		<h3>Corsi disponibili: </h3>
	</header>
	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead style="background-color:LightSkyBlue;color:#344055;text-align: center;">
				<tr>
					<th>Nome</th>
					<th>Inizio</th>
					<th>Fine</th>
					<th>Costo</th>
					<th>Commento</th>
					<th>Aula</th>
					<th>Docente</th>
					<th>Posti Occupati</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<% 
					Date data = new Date();
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Corso[] cor = Facade.getIstance().getCorsi();
					for(int i=0; i<cor.length ; i++){
						if(cor[i].getDataInizio().compareTo(data)>0){
							Docente d = Facade.getIstance().findDocenteById(cor[i].getCodDocente());
				%>
				<tr>
					<td><p><%=cor[i].getNomeCorso()%></p></td>
					<td><p><%=df.format(cor[i].getDataInizio())%></p></td>
					<td><p><%=df.format(cor[i].getDataFine())%></p></td>
					<td><p><%=String.format("%.2f",cor[i].getCosto())%>&euro;</p></td>
					<td><p><%=cor[i].getCommento()%></p></td>
					<td><p><%=cor[i].getAulaCorso()%></p></td>
					<td><p><%=d.getCognomeDocente()%></p></td>
					<td><p><%=cor[i].getPostiOccupati()%></p></td>
					<td>
						
						<button type="submit" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalCorso_<%=cor[i].getCodCorso()%>"> <span class="glyphicon glyphicon-trash"></span> </button>
						
						<!-- The modal -->
						<div class="modal fade" id="modalCorso_<%=cor[i].getCodCorso()%>" tabindex="-1" role="dialog" aria-labelledby="modalLabelSmall" aria-hidden="true">
							<div class="modal-dialog modal-md">
								<div class="modal-content">
								
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="modalLabelSmall" style="text-align:center;">Elimina Corso</h4>
									</div>
									
									<div class="modal-body" style="text-align:center">
									<div>
									<p>Sei sicuro di voler eliminare il corso?</p>
									</div>
									
									<form action="/<%=application.getServletContextName()%>/rimuoviCorso?id=<%=cor[i].getCodCorso()%>" method="post">
										<button type="submit" class="btn btn-danger btn-lg "> Si </button>
										<button type="button" class="btn btn-primary btn-lg " data-dismiss="modal" aria-label="Close">No</button>
									</form> 
									</div>
								</div>
							</div>
						</div>
						
					</td>
				</tr>
				<% 
						}
					}
				%>
			</tbody>
		</table>
	</div>
	<div  class="btn-group btn-group-justified " role="group" style="margin-bottom:30px;" >
	<a  class="btn btn-default" href="listacorsisti.jsp">
		HomePage &nbsp;<span class="glyphicon glyphicon-home"></span>
		</a>
	</div>
</div>
<footer>
	<%@include file="footer.html" %>
</footer>
</body>
</html>
<% } %>