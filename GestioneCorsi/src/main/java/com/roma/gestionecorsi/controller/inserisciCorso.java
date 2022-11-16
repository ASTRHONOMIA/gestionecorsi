package com.roma.gestionecorsi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roma.gestionecorsi.businesscomponent.facade.Facade;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.Docente;


@WebServlet("/inserisciCorso")
public class inserisciCorso extends HttpServlet {

	private static final long serialVersionUID = 4125200630276643713L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Corso corso = new Corso();
		
		try {
			Docente[] docenti = Facade.getIstance().getDocenti();
			String nomeDoc = request.getParameter("nomeDocente");
			long idDoc = 0;
			
			for (Docente docente : docenti) {
				if(docente.getNomeDocente().equals(nomeDoc))
					idDoc = docente.getCodDocente();
			}
			
			corso.setNomeCorso(request.getParameter("nomeCorso"));
			corso.setDataInizio(formato.parse(request.getParameter("dataInizio")));
			corso.setDataFine(formato.parse(request.getParameter("dataFine")));
			corso.setCommento(request.getParameter("commento"));
			corso.setCosto(Double.valueOf(request.getParameter("costoCorso")));
			corso.setAulaCorso(request.getParameter("aulaCorso"));
			corso.setPostiOccupati(0);
			corso.setCodDocente(idDoc);
			
			Facade f = Facade.getIstance();
			f.createCorso(corso);
			
			response.sendRedirect("listacorsisti.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}