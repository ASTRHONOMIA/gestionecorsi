<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corsista"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corso"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>

<div class="modal fade" id="addCorsoModal_0" tabindex="-1" role="dialog" aria-labelledby="modalLabelSmall" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
		<form action="/<%=application.getServletContextName()%>/creaCorsoCorsista" method="post">
			<div class="modal-header" style="background:#87cefa;color:black;">
				<button type="button" class="btn btn-danger" style="position:absolute;right:12px;top:12px;" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="modalLabelSmall">Iscrivi a nuovo corso</h4>
			</div>
									
			<div class="modal-body">
				
				<div class="form-group">
				<div class="inputGroupContainer">
				
				<% 
							Corso[] corsi=Facade.getIstance().getCorsiPrenotabili(Long.valueOf(request.getParameter("idCorsista")));
									if(corsi.length ==0){%>
									
									
									<h3>Non ci sono corsi disponibili!</h3>
									
									<%}else{ %>
				
					<label for="CodCorso">Seleziona uno dei corsi disponibili</label>
					<select  class="form-control" name="CodCorso" id="CodCorso" >
	        		
						<%for(Corso c : corsi){ %>
							
							<option value="<%= c.getCodCorso()%>"><%= c.getNomeCorso()%></option>
						<% 
							
							}
									}
								
						
						%>
							
					</select>
				</div>
			</div>
			</div>
			<div class="modal-footer" style="text-align:center;">
					<input type="hidden" name="CodCorsista" value="<%=request.getParameter("idCorsista") %>">
					
						<button type="submit" class="btn btn-primary btn-md"> Iscrivi </button>
						<button type="button" class="btn btn-danger btn-md " data-dismiss="modal" aria-label="Close"> Annulla </button>
					
			</div>
		</form>
		</div>
	</div>
</div>