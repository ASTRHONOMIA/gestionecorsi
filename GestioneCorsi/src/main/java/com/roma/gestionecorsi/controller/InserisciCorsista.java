package com.roma.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.businesscomponent.facade.Facade;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;



@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet {
	private static final long serialVersionUID = -7602021962686667714L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			try {
				Corsista corsista=new Corsista();
				String nome= (String) request.getParameter("nome");
				String cognome= (String) request.getParameter("cognome");
				corsista.setNomeCorsista(nome);
				corsista.setCognomeCorsista(cognome);
				if(Integer.valueOf(request.getParameter("precedenti"))==1)
					corsista.setPrecedentiFormativi(true);
				else
					corsista.setPrecedentiFormativi(false);
				Facade.getIstance().createOrUpdate(corsista);
				response.sendRedirect("listacorsisti.jsp");
			} catch (ClassNotFoundException | DAOException | IOException e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
	}

}
