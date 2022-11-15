package com.roma.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO extends GenericDAOAdapter<CorsoCorsista> implements DAOCostants {

	
	public static CorsoCorsistaDAO getFactory() throws com.roma.gestionecorsi.architecture.dao.DAOException {
		return new CorsoCorsistaDAO();
	}

	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, CorsoCorsista entity)
			throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateLong(2, entity.getCodCorsista());
			
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}
	
	
	
	
	
}
