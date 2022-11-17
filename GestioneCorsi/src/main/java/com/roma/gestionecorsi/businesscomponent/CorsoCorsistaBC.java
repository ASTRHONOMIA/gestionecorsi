package com.roma.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.roma.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private  Connection conn;
	
	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(CorsoCorsista cc) throws DAOException{
		CorsoCorsistaDAO.getFactory().create(conn, cc);
	}
	
	public String[] corsoPiuFrequentato() throws DAOException
	{
		return CorsoCorsistaDAO.getFactory().CorsoPiuFrequentato(conn);
	}
	
	public long[] corsiDelCorsista(long cod) throws DAOException
	{
		return CorsoCorsistaDAO.getFactory().corsiDelCorsista(conn, cod);
	}
	
	public CorsoCorsista[] getAll() throws DAOException
	{
		return CorsoCorsistaDAO.getFactory().getAll(conn);
	}
	//Corsi disponibili per il corsista
	
	public Corso[] getCorsiPrenotabili(long cod) throws DAOException
	{
		return CorsoCorsistaDAO.getFactory().getCorsiPrenotabili(conn, cod);
	}
	
	
}
