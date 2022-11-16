package com.roma.gestionecorsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roma.gestionecorsi.businesscomponent.facade.Facade;
import com.roma.gestionecorsi.businesscomponent.model.Amministratore;

@WebServlet("/controlloAccesso")
public class ControlloAccesso extends HttpServlet {
	private static final long serialVersionUID = -4946103221700578770L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nomeAdmin = request.getParameter("nomeAdmin");

		long codAdmin = Long.valueOf((String)request.getParameter("codAdmin"));

		HttpSession session = request.getSession();

		int loginAttempt;

		if (session.getAttribute("loginCount") == null) {
			loginAttempt = 0;
		} else {
			loginAttempt = (int) session.getAttribute("loginCount");
		}
			
		String loginAdmin = null;

		if (nomeAdmin != null && codAdmin != 0) {
			try {
				Amministratore admin=Facade.getIstance().findAmministratoreByid(codAdmin);
				if(admin!=null)
					loginAdmin =admin.getNomeAdmin();
				if (loginAdmin != null) {
					if (loginAdmin.equals(nomeAdmin)) {
						session.setAttribute("nomeAdmin", nomeAdmin);
						Cookie adminCookie = new Cookie("Admin", (String) request.getParameter("nomeAdmin"));
						adminCookie.setMaxAge(60*60*24); 
						response.addCookie(adminCookie);
						response.sendRedirect("listacorsisti.jsp");
					} else {
						if (loginAttempt > 3){
							session.setAttribute("loginCount", 0);
							response.sendRedirect("tentativiesauriti.jsp");
						}else{
							session.setAttribute("loginCount",++loginAttempt);
							response.sendRedirect("index.jsp");
						}
					}
				} else {
					if (loginAttempt > 3){
						session.setAttribute("loginCount", 0);
						response.sendRedirect("tentativiesauriti.jsp");
					}else{
						session.setAttribute("loginCount",++loginAttempt);
						response.sendRedirect("index.jsp");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
		}
		
		//contollare se nomeAdmin e codAdmin sono corretti
		
		//se lo sono mandare alla pagina listacorsisti.jsp e salvare i dati della sessione dell'admin
		
		//se sono SCORRETTI per 5 volte mandare alla pagina tentativiesauriti.jsp
		
	}

}
