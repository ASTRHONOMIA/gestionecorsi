<%
	if(session.getAttribute("nomeAdmin") != null) {
		session.invalidate();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Logout</h3>
	</header>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Hai effettuato il logout</h3>
		</div>
		<div class="panel-body">
			<p>Per procedere fare il login</p>
			<p><a href="index.jsp">Login</a></p>
		</div>
	</div>
</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("index.jsp");
	}
%>