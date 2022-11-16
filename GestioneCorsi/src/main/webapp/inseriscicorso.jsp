<%
	if(session.getAttribute("nomeAdmin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<script type='text/javascript'>
        function addFields(){
            // Generate a dynamic number of inputs
            var number = document.getElementById("corsisti").value;
            if(number > 12)
            	number = 12;
            // Get the element where the inputs will be added to
            var container = document.getElementById("container");
            // Remove every children it had before
            while (container.hasChildNodes()) {
                container.removeChild(container.lastChild);
            }
            for (i=0;i<number;i++){
                // Append a node with a label
                var label = document.createElement("label");
                label.classList.add("col-md-2");
                label.classList.add("control-label");
                label.appendChild(document.createTextNode("Corsista " + (i+1)));
                container.appendChild(label);
                //-----------------------
                var im = document.createElement("i");
                im.classList.add("glyphicon");
                im.classList.add("glyphicon-user");
                //Create an <span> element
                var span = document.createElement("span");
                span.classList.add("input-group-addon");
                span.appendChild(im);
                // Create an <input> element, set its type and name attributes
                var inputnome = document.createElement("input");
                inputnome.type = "text";
                inputnome.name = "nomecorsista" + i;
                inputnome.id = "nomecorsista" + i;
                inputnome.placeholder = "Nome corsista...";
                inputnome.classList.add("form-control");
                
                var inputcognome = document.createElement("input");
                inputcognome.type = "text";
                inputcognome.name = "cognomecorsista" + i;
                inputcognome.id = "cognomecorsista" + i;
                inputcognome.placeholder = "Cognome corsista...";
                inputcognome.classList.add("form-control");
                
                var div1 = document.createElement("div");
                div1.classList.add("input-group");
                div1.appendChild(span);
                div1.appendChild(inputnome);
                div1.appendChild(document.createElement("hr"));
                div1.appendChild(inputcognome);
                
                var div2 = document.createElement("div");
                div2.classList.add("col-md-4");
                div2.classList.add("inputGroupContainer");
                div2.appendChild(div1);
                
                var div3 = document.createElement("div");
                div3.classList.add("form-group");
                div3.appendChild(div2);
                
                container.appendChild(div3);

            }
        }
</script>
<meta charset="ISO-8859-1">
<title>Lista Corsisti</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3>Inserire i dati del nuovo corso</h3>
	</header>
	
	<form action="/<%=application.getServletContextName()%>/inserisciCorsista" method="post"
	class="form-horizontal" id="adminForm">
	
	<div class="form-group">
		<label class="col-md-2 control-label">Nome Corso</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-book"></i>
				</span>
				<input type="text" name="nomeCorso" id="nomeCorso"
				placeholder="Nome corso..." class="form-control">
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">Data Inizio</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group date" id="di">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-calendar"></i>
				</span>
				<input type="text" name="dataInizio" id="dataInizio"
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
			}).on('changeDate', function(e) {
				$('#adminForm').bootstrapValidator('revalidateField', 'dataInizio');
			});
		});
	</script>
	
	<div class="form-group">
		<label class="col-md-2 control-label">Data Fine</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group date" id="df">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-calendar"></i>
				</span>
				<input type="text" name="dataFine" id="dataFine"
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
			}).on('changeDate', function(e) {
				$('#adminForm').bootstrapValidator('revalidateField', 'dataFine');
			});
		});
	</script>
	
	<div class="form-group">
		<label class="col-md-2 control-label">Commento</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-pencil"></i>
				</span>
				<textarea rows="3" cols="40" name="commento" placeholder="Commento..."
					class="form-control" style="resize: none;"  id="Commento"></textarea>
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">Precedenti Formativi</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-book"></i>
				</span>
				<fieldset>&nbsp;
					<input type="radio" id="si" name="precedenteFormativo" value="SI">
					<label for="si">Si</label>&nbsp;
					<input type="radio" id="no" name="precedenteFormativo" value="NO">
					<label for="no">No</label>
				</fieldset>
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">Aula Corso</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-home"></i>
				</span>
				<input type="text" name="aulaCorso" id="aulaCorso"
				placeholder="Aula	 corso..." class="form-control">
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">Nome Docente</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
				</span>
				<input type="text" name="nomeDocente" id="nomeDocente"
				placeholder="Nome docente..." class="form-control">
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-2 control-label">Numero Corsisti</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
				</span>
				<input type="text" id="corsisti" placeholder = "Numero corsisti..."; name="corsisti" id="corsisti" value=""><br />
    			<a href="#" id="filldetails" onclick="addFields()">Aggiungi Corsisti</a>
			</div>
		</div>
	</div>
	<div id="container" class="row"></div>
	
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<button type="submit" class="btn btn-success">
			Invia&nbsp;&nbsp;<span class="glyphicon glyphicon-send"></span>
			</button>
		</div>
	</div>
	</form>
	
</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("index.jsp");
	}
%>