<%
Cookie my_cookie = null;
Cookie[] my_cookies = null;
// Get an array of Cookies associated with the this domain
my_cookies = request.getCookies();
if( my_cookies != null ) {
   for (int i = 0; i < my_cookies.length; i++) {
      my_cookie = my_cookies[i];
      	my_cookie.setMaxAge(0);
      	response.addCookie(my_cookie);
      	}
   }
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