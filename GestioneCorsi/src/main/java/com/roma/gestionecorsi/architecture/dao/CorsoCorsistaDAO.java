package com.roma.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.roma.gestionecorsi.businesscomponent.model.Corsista;
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
	
	public String[] CorsoPiuFrequentato(Connection conn) throws DAOException
	{
		String [] nomi = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSO_PIU_FREQUENTE);
			rs.last();
			nomi = new String[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0;rs.next(); i++) {
				String n = new String();
				n=rs.getString(2);
				nomi[i] = n;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return nomi;
	}
	
	
	
	
}
