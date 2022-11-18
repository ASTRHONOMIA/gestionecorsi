<%@page import="com.roma.gestionecorsi.businesscomponent.model.Docente"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%

%>
<div class="modal fade" id="ModalCorso" role="dialog">
	<div class="modal-dialog modal-md">
		<form
			action="/<%=application.getServletContextName()%>/inserisciCorso"
			method="post" class="form-horizontal" id="adminForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Crea corso</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="col-md-3 control-label">Nome Corso</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-book"></i>
								</span> <input type="text" name="nomeCorso" id="nomeCorso"
									placeholder="Nome corso..." class="form-control">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label">Data Inizio</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group date" id="di">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-calendar"></i>
								</span> <input type="text" name="dataInizio" id="dataInizio"
									placeholder="DD/MM/YYYY" class="form-control">
							</div>
						</div>
					</div>
					<script>
						$(function() {
							$('#di').datepicker({
								format : 'dd/mm/yyyy',
								autoclose : true,
								startDate : '01/01/1900',
								endDate : new Date()
							}).on(
									'changeDate',
									function(e) {
										$('#adminForm')
												.bootstrapValidator(
														'revalidateField',
														'dataInizio');
									});
						});
					</script>

					<div class="form-group">
						<label class="col-md-3 control-label">Data Fine</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group date" id="df">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-calendar"></i>
								</span> <input type="text" name="dataFine" id="dataFine"
									placeholder="DD/MM/YYYY" class="form-control">
							</div>
						</div>
					</div>
					<script>
						$(function() {
							$('#df').datepicker({
								format : 'dd/mm/yyyy',
								autoclose : true,
								startDate : '03/01/1900',
								endDate : new Date()
							}).on(
									'changeDate',
									function(e) {
										$('#adminForm').bootstrapValidator(
												'revalidateField', 'dataFine');
									});
						});
					</script>

					<div class="form-group">
						<label class="col-md-3 control-label">Commento</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-pencil"></i>
								</span>
								<textarea rows="3" cols="40" name="commento"
									placeholder="Commento..." class="form-control"
									style="resize: none;" id="Commento"></textarea>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label">Costo Corso</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-book"></i>
								</span> <input type="number" name="costoCorso" id="costoCorso"
									placeholder="costo corso..." class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Aula Corso</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-home"></i>
								</span> <input type="text" name="aulaCorso" id="aulaCorso"
									placeholder="Aula	 corso..." class="form-control">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label">Nome Docente</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
							<span class="input-group-addon"> <i
									class="glyphicon glyphicon-user"></i>
								</span>
							<select class="form-control" name="CodDocente" id="CodDocente" >
							<%
								Docente[] docenti=Facade.getIstance().getDocenti();
								for(Docente docente:docenti ){
							%>
							<option value="<%= docente.getCodDocente()%>"><%= docente.getNomeDocente()%></option>
							<% } %>
							</select>
								<!--  <span class="input-group-addon"> <i
									class="glyphicon glyphicon-user"></i>
								</span> <input type="text" name="nomeDocente" id="nomeDocente"
									placeholder="Nome docente..." class="form-control">
									-->
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-lg">Salva
						modifiche</button>
					<button type="button" class="btn btn-success btn-lg"
						data-dismiss="modal">Anulla</button>
				</div>
			</div>
		</form>
	</div>
</div>