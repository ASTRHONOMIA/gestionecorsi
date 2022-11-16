<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Inserire i dati per effettuare l'accesso</h3>
	</header>
	
	<form action="/<%=application.getServletContextName()%>/controlloAccesso" method="post"
	class="form-horizontal">
	
	<div class="form-group">
		<label class="col-md-1 control-label">Nome</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
				</span>
				<input type="text" name="nomeAdmin" id="nomeAdmin"
				placeholder="Nome admin..." class="form-control">
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-1 control-label">Codice</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-lock"></i>
				</span>
				<input type="password" name="codAdmin" id="codAdmin"
				placeholder="Codice admin..." class="form-control">
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<button type="submit" class="btn btn-success">
			Login&nbsp;&nbsp;<span class="glyphicon glyphicon-send"></span>
			</button>
			
			<button type="reset" class="btn btn-danger">
			Annulla&nbsp;&nbsp;<span class="glyphicon glyphicon-remove"></span>
			</button>
		</div>
	</div>
	</form>
</div>
</body>
</html>