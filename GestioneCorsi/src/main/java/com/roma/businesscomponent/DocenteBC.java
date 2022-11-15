package com.roma.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dao.DocenteDAO;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Docente;

public class DocenteBC {
	Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn=DBAccess.getConnection();
	}
	
	//Get docente by Cod
	public Docente findByCod(long cod) throws DAOException{
		return DocenteDAO.getFactory().getById(conn, cod);
	}
	
	//Get all
	public Docente[] getDocenti() throws DAOException{
		return DocenteDAO.getFactory().getAll(conn);
	}
	
	

}
