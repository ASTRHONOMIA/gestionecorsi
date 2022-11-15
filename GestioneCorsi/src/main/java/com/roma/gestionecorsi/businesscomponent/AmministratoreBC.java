package com.roma.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.roma.gestionecorsi.architecture.dao.AmministratoreDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Amministratore;

public class AmministratoreBC {
	private Connection conn;
	
	public AmministratoreBC() 
			throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Amministratore findByID(long id) throws DAOException {
		return AmministratoreDAO.getFactory().getById(conn, id);
	}
	
	public Amministratore[] getAdmin() throws DAOException {
		return AmministratoreDAO.getFactory().getAll(conn);
	}
}