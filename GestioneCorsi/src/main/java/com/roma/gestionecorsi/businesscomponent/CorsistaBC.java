package com.roma.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.roma.gestionecorsi.architecture.dao.CorsistiDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.codgenerator.CorsistaCodGenerator;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn=DBAccess.getConnection();
	}
	
	public void createOrUpdate(Corsista corsista) throws DAOException, ClassNotFoundException, IOException
	{
		if (corsista.getCodiceCorsista() > 0) 
			CorsistiDAO.getFactory().update(conn, corsista);
		else {
			corsista.setCodiceCorsista(CorsistaCodGenerator.getInstance().getNextCod());
			CorsistiDAO.getFactory().create(conn, corsista);
		}
	}
	
	public Corsista findByCod(long cod) throws DAOException
	{
		return CorsistiDAO.getFactory().getById(conn, cod);
	}
	
	public Corsista[] getCorsisti() throws DAOException
	{
		return CorsistiDAO.getFactory().getAll(conn);
	}
	
	public void delete(Corsista corsista) throws DAOException {
		CorsistiDAO.getFactory().delete(conn, corsista);
	}
	
	
	
}
