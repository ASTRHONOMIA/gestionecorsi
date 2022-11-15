<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" 
      data-toggle="collapse" data-target="#menuApp">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="menuApp">
    <%
    	String codAdmin = (String) session.getAttribute("codAdmin");
    	if(codAdmin == null){
    %>
      <ul class="nav navbar-nav navbar-right">
        <li>
        	<a href="index.jsp">
        	<span class="glyphicon glyphicon-log-in"></span> Login</a>.
        </li>
      </ul>
    <%
    	}else{
    %>	  
      <ul class="nav navbar-nav navbar-right">
        <li>
    		<a href="#">
        	<span class="glyphicon glyphicon-user"></span>
        	<%=codAdmin%>
        	</a>
        </li>
        <li>
    		<a href="#">
        	<span class="glyphicon glyphicon-off"></span>Logout
        	</a>
        </li>
      </ul>
    <%
    	}
    %>
    </div>
  </div>
</nav>