package com.roma.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.roma.gestionecorsi.businesscomponent.model.Amministratore;

public class AmministratoreDAO extends GenericDAOAdapter<Amministratore> implements DAOCostants {
	
	private AmministratoreDAO() throws DAOException{
	}
	
	public static AmministratoreDAO getFactory() throws DAOException {
		return new AmministratoreDAO();
	}
	
	@Override
	public Amministratore getById(Connection conn, long id) throws DAOException {
		Amministratore amministratore = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ADMIN_BYCOD);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				amministratore = new Amministratore();
				amministratore.setCodAdmin(rs.getLong(1));
				amministratore.setNomeAdmin(rs.getString(2));
				amministratore.setCognomeAdmin(rs.getString(3));
			}
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return amministratore;
	}

	@Override
	public Amministratore[] getAll(Connection conn) throws DAOException {
		Amministratore[] amministratori = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_ADMIN);
			rs.last();
			amministratori = new Amministratore[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Amministratore admin = new Amministratore();
				admin.setCodAdmin(rs.getLong(1));
				admin.setNomeAdmin(rs.getString(2));
				admin.setCognomeAdmin(rs.getString(3));
				amministratori[i] = admin;
			}
			rs.close();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return amministratori;
	}
}