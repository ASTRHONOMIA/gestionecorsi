<%
	
%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corsista"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.model.Corso"%>
<%@page import="com.roma.gestionecorsi.businesscomponent.facade.Facade"%>
<div class="modal fade" id="addCorsoModal_0" tabindex="-1" role="dialog" aria-labelledby="modalLabelSmall" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
		<form action="/<%=application.getServletContextName()%>/creaCorsoCorsista?idCorsista=<%=request.getParameter("idCorsista")%>" method="post">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="modalLabelSmall">Iscrivi a nuovo corso</h4>
			</div>
									
			<div class="modal-body">
				<p>Seleziona il corso</p>
				<div class="btn-group">
        		
					<% 
						Corso[] corsi = Facade.getIstance().getCorsi();
						for(Corso c : corsi){
					%>
						
						<p><button name="CodCorso" type="submit" class="btn btn-link" 
						value="<%= c.getCodCorso()%>"> <%= c.getNomeCorso()%> </button></p>
					<% 
						}
					%>
				</div>
			</div>
			<div class="modal-footer">
					<input type="hidden" name="CodCorsista" value="idCorsista">
					<button type="submit" class="btn btn-success btn-sm "> Iscrivi </button>
					<button type="button" class="btn btn-danger btn-sm " data-dismiss="modal" aria-label="Close"> Annulla </button>
			</div>
		</form>
		</div>
	</div>
</div>