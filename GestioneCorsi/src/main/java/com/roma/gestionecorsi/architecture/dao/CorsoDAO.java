package com.roma.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.roma.gestionecorsi.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOCostants {
	private CachedRowSet rowSet;
	
	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}
	
	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateString(2, entity.getNomeCorso());
			rowSet.updateDate(3, new java.sql.Date(entity.getDataInizio().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getDataFine().getTime()));
			rowSet.updateDouble(5, entity.getCosto());
			rowSet.updateString(6, entity.getCommento());
			rowSet.updateString(7, entity.getAulaCorso());
			rowSet.updateLong(8, entity.getCodDocente());
			
			rowSet.insertRow();
			
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSO_BYCOD);
			
			ps.setString(1, entity.getNomeCorso());
			ps.setDate(2, new java.sql.Date(entity.getDataInizio().getTime()));
			ps.setDate(3, new java.sql.Date(entity.getDataFine().getTime()));
			ps.setDouble(4, entity.getCosto());
			ps.setString(5, entity.getCommento());
			ps.setString(6, entity.getAulaCorso());
			ps.setLong(7, entity.getCodDocente());
			ps.setLong(8, entity.getCodCorso());
			
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			
			ps.setLong(1, entity.getCodCorso());
			
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Corso getById(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		Corso corso = null;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_BYCOD);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corso = new Corso();
				
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCosto(rs.getDouble(5));
				corso.setCommento(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
				
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(
					RowSet.TYPE_SCROLL_INSENSITIVE,
					RowSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			
			rs.last();
			
			corsi = new Corso[rs.getRow()];
			
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corso corso = new Corso();
				
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCosto(rs.getDouble(5));
				corso.setCommento(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
				
				corsi[i] = corso;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return corsi;
	}

}
