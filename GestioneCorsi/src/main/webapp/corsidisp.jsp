<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
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
	<header>
		<h3>Corsi disponibili: </h3>
	</header>
	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
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
					DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
					Corso[] cor = Facade.getIstance().getCorsi();
					long ms = System.currentTimeMillis();
					for(int i=0; i<cor.length ; i++){
						if(cor[i].getDataInizio().compareTo(new Date(ms))>0){
				%>
				<tr>
					<td><%=cor[i].getNomeCorso()%></td>
					<td><%=format.format(cor[i].getDataInizio())%></td>
					<td><%=format.format(cor[i].getDataFine())%></td>
					<td><%=String.format("%.2f",cor[i].getCosto())%>&euro;</td>
					<td><%=cor[i].getCommento()%></td>
					<td><%=cor[i].getAulaCorso()%></td>
					<td><%=cor[i].getCodDocente()%></td>
					<td><%=cor[i].getPostiOccupati()%></td>
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
</div>
</body>
</html>