package com.roma.gestionecorsi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roma.gestionecorsi.businesscomponent.facade.Facade;
//import com.roma.gestionecorsi.businesscomponent.model.Corsista;
import com.roma.gestionecorsi.businesscomponent.model.Corso;


@WebServlet("/inserisciCorso")
public class inserisciCorso extends HttpServlet {

	private static final long serialVersionUID = 4125200630276643713L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Corso corso = new Corso();
		
		//int num = Integer.valueOf(request.getParameter("corsisti"));
		
		try {
			/*Docente[] docenti = Facade.getIstance().getDocenti();
				String nomeDoc = request.getParameter("nomeDocente");
				long idDoc = 0;
			
				for (Docente docente : docenti) {
				if(docente.getNomeDocente().equals(nomeDoc))
					idDoc = docente.getCodDocente();
				}
			*/
			
			long codDocente= Long.valueOf(request.getParameter("CodDocente"));
			String nomeCorso=request.getParameter("nomeCorso");
			double costo=0.0;
			String commento=request.getParameter("commento");
			if(!request.getParameter("costoCorso").equals(""))
				costo=Double.valueOf(request.getParameter("costoCorso"));
			String aulaCorso=request.getParameter("aulaCorso");
			Facade f = Facade.getIstance();
			
			if(		f.convalidaAula(aulaCorso) &&
					f.convalidaCommento(commento) &&
					f.convalidaCOsto(costo) &&
					f.convalidaStringa(nomeCorso) &&
					f.convalidaFormatoDate(request.getParameter("dataInizio")) &&
					f.convalidaFormatoDate(request.getParameter("dataFine")) &&
					f.convalidaDate(request.getParameter("dataInizio"), request.getParameter("dataFine")))
			{
			Date dataInizio=formato.parse(request.getParameter("dataInizio"));
			Date dataFine=formato.parse(request.getParameter("dataFine"));
			corso.setNomeCorso(nomeCorso);
			corso.setDataInizio(dataInizio);
			corso.setDataFine(dataFine);
			corso.setCommento(commento);
			corso.setCosto(costo);
			corso.setAulaCorso(aulaCorso);
			corso.setPostiOccupati(0);
			corso.setCodDocente(codDocente);
			
			
			f.createCorso(corso);
			
			/*for (int i = 0; i < num; i++) {
				Corsista corsista = new Corsista();
				
				corsista.setNomeCorsista(request.getParameter("nomecorsista"+i));
				corsista.setCognomeCorsista(request.getParameter("cognomecorsista"+i));
				corsista.setPrecedentiFormativi(Boolean.valueOf(request.getParameter("precedenteFormativo")));
				
				f.createOrUpdate(corsista);
				
				CorsoCorsista corsoCorsista = new CorsoCorsista();
				
				corsoCorsista.setCodCorsista(corsista.getCodiceCorsista());
				corsoCorsista.setCodCorso(corso.getCodCorso());
				
				f.createCorsoCorstita(corsoCorsista);
			}*/
			
			response.sendRedirect("listacorsisti.jsp");
			}
			else {
				response.sendRedirect("listacorsisti.jsp?error=si");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
