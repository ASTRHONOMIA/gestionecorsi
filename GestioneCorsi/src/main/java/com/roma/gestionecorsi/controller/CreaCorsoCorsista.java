package com.roma.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roma.gestionecorsi.businesscomponent.facade.Facade;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista;

@WebServlet("/creaCorsoCorsista")
public class CreaCorsoCorsista extends HttpServlet {
	private static final long serialVersionUID = 5891782773898129937L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			if(request.getParameter("CodCorso") == null || request.getParameter("CodCorsista") == null) {
				response.sendRedirect("infocorsista.jsp");
			}else {
				
			
			CorsoCorsista corsocorsista = new CorsoCorsista();
			
			long CodCorso = Long.valueOf(request.getParameter("CodCorso"));
			long CodCorsista = Long.valueOf(request.getParameter("CodCorsista"));
			CorsoCorsista[] ccL = Facade.getIstance().getAllCorsoCorsista();
			for(CorsoCorsista cc : ccL) 
				if(cc.getCodCorsista()== CodCorsista && cc.getCodCorso()== CodCorso) 
					response.sendRedirect("infocorsista.jsp"); 
			corsocorsista.setCodCorso(CodCorso);
			corsocorsista.setCodCorsista(CodCorsista);
			Facade.getIstance().createCorsoCorstita(corsocorsista);
			response.sendRedirect("infocorsista.jsp");
			Corso corso= Facade.getIstance().findByCod(CodCorso);
			corso.setPostiOccupati(corso.getPostiOccupati()+1);
			Facade.getIstance().updateCorso(corso);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}
}