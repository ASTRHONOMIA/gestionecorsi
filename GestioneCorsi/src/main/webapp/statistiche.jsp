<%
	if(session.getAttribute("codAdmin") != null){
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
	<header class="page-header">
		<h3>Statistiche:</h3>
	</header>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Corsisti totali</th>
					<th>Corso più frequentato</th>
					<th>Data inizio ultimo corso</th>
					<th>Durata media dei corsi</th>
					<th>N°commenti presenti</th>
					<th>Elenco corsisti</th>
					<th>Docente migliore</th>
					<th>Corsi con posti disponibili</th>
				</tr>
			</thead>
			<tbody>
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