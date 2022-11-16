<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	
%>
<div class="modal fade"  id="editModal" role="dialog">
	<div class="modal-dialog modal-md">
	<form action="/<%= application.getServletContextName()%>/inserisciCorsista" method="post">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Crea corsista</h4>
			</div>
			<div class="modal-body" >
				<div class="form-group">
					<label for="nome">Nome</label>
					<input type="text" class="form-control" name="nome" required>
				</div>	
					<div class="form-group">
						<label for="cognome">Corsista</label>
						<input type="text" class="form-control" name="cognome" required>
					</div>
					<div class="form-group">
						
							<label for="precedenti">Precedenti formativi</label>
						<div class="btn-group">
							<label>
							<input type="radio"  name="precedenti" value="1" checked>Si</label>
							<label>
							<input type="radio"  name="precedenti" value="0">No</label>
						</div>
					</div>
			</div>
			<div class="modal-footer">
			<button type="submit" class="btn btn-success btn-lg">Salva modifiche</button>
			<button type="button" class="btn btn-success btn-lg" data-dismiss="modal">Anulla</button>
			</div>
		</div>
	</form>
	</div>
</div>