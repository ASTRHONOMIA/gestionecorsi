package com.roma.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/controlloAccesso")
public class ControlloAccesso extends HttpServlet {
	private static final long serialVersionUID = -4946103221700578770L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		
		//contollare se nomeAdmin e codAdmin sono corretti
		
		//se lo sono mandare alla pagina listacorsisti.jsp e salvare i dati della sessione dell'admin
		
		//se sono SCORRETTI per 5 volte mandare alla pagina tentativiesauriti.jsp
		
	}

}
