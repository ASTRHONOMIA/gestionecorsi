package com.roma.gestionecorsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roma.gestionecorsi.businesscomponent.facade.Facade;
import com.roma.gestionecorsi.businesscomponent.model.Corso;



@WebServlet("/rimuoviCorso")
public class RimuoviCorso extends HttpServlet {
	private static final long serialVersionUID = 2993779361738230098L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id= request.getParameter("id");
			if(id!= null) {
				Corso c = new Corso();
				c.setCodCorso(Long.valueOf(id));
				Facade.getIstance().deleteCorsi(c);
			}
			response.sendRedirect("corsidisp.jsp");
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
		
	}

}
