package com.roma.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import com.roma.gestionecorsi.architecture.dao.CorsoDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Corso;

public class CorsoBC {
	private Connection conn;
	
	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void createCorso(Corso corso) throws DAOException {
		CorsoDAO.getFactory().create(conn, corso);
	}
	
	public String getNomeCorsoFrequentato() {
		String nome = null;
		
		//TODO
		
		return nome;
	}
	
	public Date getInizioUltimoCorso() throws DAOException {
		Corso[] corsi = getCorsi();
		
		long num = corsi.length;
		
		Corso corso = getById(num);
		
		return CorsoDAO.getFactory().getInizioCorso(conn, corso.getCodCorso());
	}
	
	public int getDurataMedia(Corso corso) throws DAOException {
		return CorsoDAO.getFactory().getDurataCorso(conn, corso);
	}
	
	public int getNumeroCommenti() throws DAOException {
		return CorsoDAO.getFactory().getNumeroCommenti(conn);
	}
	
	public Corso getById(long id) throws DAOException {
		return CorsoDAO.getFactory().getById(conn, id);
	}
	
	public Corso[] getCorsi() throws DAOException {
		return CorsoDAO.getFactory().getAll(conn);
	}
	
	public void deleteCorso(Corso corso) throws DAOException {
		CorsoDAO.getFactory().delete(conn, corso);
	}
	
	public Corso[] getCorsiFromDate() throws DAOException {
		return CorsoDAO.getFactory().getCorsoFromDate(conn);
	}
	
	public void updateCorso(Corso corso) throws DAOException {
		CorsoDAO.getFactory().update(conn, corso);
	}
}
