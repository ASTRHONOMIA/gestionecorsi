<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.roma.gestionecorsi.architecture.dao.CorsoDAO"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corso"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>
<%
Cookie my_cookie = null;
Cookie[] my_cookies = null;
// Get an array of Cookies associated with the this domain
my_cookies = request.getCookies();
if (my_cookies != null) {
	for (int i = 0; i < my_cookies.length; i++) {
		my_cookie = my_cookies[i];
		if (my_cookie.getName().equals("Admin")) //se trova il coockie che mi interessa esce dal ciclo
	break;
	}
}
if (my_cookie != null && my_cookie.getName().equals("Admin")) {
	session.setAttribute("nomeAdmin", my_cookie.getValue());
}
if (session.getAttribute("nomeAdmin") != null) {
%>

<%
int sommaDurata = 0;
Corso[] corsi = Facade.getIstance().getCorsi();
if (corsi.length != 0) {
	for (Corso cor : corsi)
		sommaDurata += Facade.getIstance().getDurataCorso(cor);
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Statistiche</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<header>
			<h3>Statistiche generali:</h3>
		</header>

		<div class="table-responsive">
			<table class="table table-hover">
				<tbody>
					<tr onclick="window.location.href='listacorsisti.jsp'"
						style="cursor: pointer;">
						<th style="width: 25%">Corsisti totali</th>
						<td><%=Facade.getIstance().getNumberCorsisti()%></td>
					</tr>
					<%
					if (corsi.length != 0) {
						double durataMedia = sommaDurata / corsi.length;
					%>
					<tr>
						<th style="width: 25%">Corso pi&ugrave; frequentato</th>
						<td>
							<%
							String[] nomi = Facade.getIstance().corsoPiuFrequentato();
							if (nomi.length != 0) {
								for (String nome : nomi) {
							%> <%=nome%> <br> <%
 }
 } else {
 %> Nessun corso viene frequentato <%
 }
 %>
						</td>
					</tr>
					<tr>
						<th style="width: 25%">Data Inizio ultimo corso</th>
						<td>
							<%
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							%>
							<%=formatter.format(Facade.getIstance().getInizioUltimoCorso())%>
						</td>
					</tr>
					<tr>
						<th style="width: 25%">Durata Media Corsi</th>
						<td><%=String.format("%.0f giorni", durataMedia)%></td>
					</tr>
					<tr>
						<th style="width: 25%">Numero Totali commenti corsi</th>
						<td><%=Facade.getIstance().numeroCommenti()%></td>
					</tr>
					<%
					} else {
					%>
					<tr>
						<th style="width: 25%">Nessun Corso Presente</th>
						<td></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<div>
			<a type="button" class="btn btn-default" href="listacorsisti.jsp">HomePage
				<span class="glyphicon glyphicon-home"></span>
			</a>
		</div>
	</div>
	<footer>
		<%@include file="footer.html"%>
	</footer>
</body>
</html>
<%
} else {
response.sendRedirect("index.jsp");
}
%>