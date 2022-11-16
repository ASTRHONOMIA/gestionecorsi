<!-- Funzionamento cookie --> 
<%
Cookie my_cookie = null;
Cookie[] my_cookies = null;
// Get an array of Cookies associated with the this domain
my_cookies = request.getCookies();
if( my_cookies != null ) {
   for (int i = 0; i < my_cookies.length; i++) {
      my_cookie = my_cookies[i];
      	if(my_cookie.getName().equals("Admin")) //se trova il coockie che mi interessa esce dal ciclo
      		break;
      	}
   }
		String admins=(String)request.getParameter("nomeAdmin");
		String cancella=(String)request.getParameter("cancella");
		if(my_cookie == null || !my_cookie.getName().equals("Admin") && cancella!=null && !cancella.equals("si") ) //se inserisco si cancella sempre il coockie
		{
			out.println(request.getParameter("nomeAdmin"));
			if(admins!=null && !admins.equals(""))
			{
				Cookie admin = new Cookie("Admin", (String) request.getParameter("nomeAdmin"));
				admin.setMaxAge(60*60*24); 
				response.addCookie(admin);
				out.println("coockie creato");
				response.sendRedirect("#");
			}
		}
		
		if(my_cookie.getName().equals("Admin") && cancella!=null && cancella.equals("si"))
		{
			out.print("cookie cancellato");
			my_cookie.setMaxAge(0);
			response.addCookie(my_cookie);
			response.sendRedirect("#");
		}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%if(my_cookie.getName().equals("Admin")){%>
		<h1><%= my_cookie.getValue() %></h1>
		<% } %>
	<form action = "#" method = "get">
       User Name: <br/><input type = "text" name = "nomeAdmin"><br/>
       Cancella coockie:<br/><input type = "text" name = "cancella">
                <input type = "submit" value = "Go" />
    </form>
    
</body>
</html>