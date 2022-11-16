package com.roma.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.roma.gestionecorsi.businesscomponent.model.Corsista;

public class CorsistiDAO implements DAOCostants,GenericDAO<Corsista> {
	
	private CachedRowSet rowSet;
	
	public static CorsistiDAO getFactory() throws DAOException {
		return new CorsistiDAO();
	}
	
	private CorsistiDAO() throws DAOException
	{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		try
		{
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNomeCorsista());
			rowSet.updateString(2, entity.getCognomeCorsista());
			rowSet.updateLong(3, entity.getCodiceCorsista());
			if(entity.isPrecedentiFormativi())
				rowSet.updateInt(4, 1);
			else
				rowSet.updateInt(4, 0);
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		}
		catch(SQLException exc)
		{
			throw new DAOException(exc);
		}
		
	}

	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSISTI);
			ps.setString(1, entity.getNomeCorsista());
			ps.setString(2, entity.getCognomeCorsista());
			if(entity.isPrecedentiFormativi())
				ps.setInt(3, 1);
			else
				ps.setInt(3, 0);
			ps.setLong(4, entity.getCodiceCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void delete(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTI);
			ps.setLong(1, entity.getCodiceCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public Corsista getById(Connection conn, long id) throws DAOException {
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BYCOD);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corsista = new Corsista();
				corsista.setNomeCorsista(rs.getString(1));
				corsista.setCognomeCorsista(rs.getString(2));
				corsista.setCodiceCorsista(rs.getLong(3));
				corsista.setPrecedentiFormativi( (rs.getInt(4) == 1 ? true : false ));
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsisti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0;rs.next(); i++) {
				Corsista c = new Corsista();
				c.setNomeCorsista(rs.getString(1));
				c.setCognomeCorsista(rs.getString(2));
				c.setCodiceCorsista(rs.getLong(3));
				c.setPrecedentiFormativi(rs.getInt(4)==1 ? true : false);
				corsisti[i] = c;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
	
	public int getNumberCorsisti(Connection conn) throws DAOException
	{
		int numero=0;
		try {
			Statement stmt;
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_NUMERO_CORSISTI);
			if(rs.next())
				numero=rs.getInt(1);
		
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return numero;
	}

}
