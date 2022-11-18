<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	
%>
<div class="modal fade"  id="errorModal" role="dialog">
	<div class="modal-dialog modal-md">
	<form action="/<%= application.getServletContextName()%>/inserisciCorsista" method="post">
		<div class="modal-content">
			<div class="modal-header" style="background:#87cefa;color:black;">
				<button type="button" class="btn btn-danger" style="position:absolute;right:12px;top:12px;" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Dati errati</h4>
			</div>
			<div class="modal-body" >
						<h1 style="text-align:center;">DATI INSERITI ERRATI</h1>
			</div>
		</div>
	</form>
	</div>
</div>