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
	
	public long[] corsiDelCorsista(Connection conn, long cod) throws DAOException 
	{
		long[] codici=null;
		PreparedStatement ps;
		try {
			
			ps=conn.prepareStatement(SELECT_CORSI_DEL_CORSISTA,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, cod);
			ResultSet rs= ps.executeQuery();
			rs.last();
			codici= new long[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0;rs.next(); i++) 
				codici[i] = rs.getLong(1);
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return codici;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		CorsoCorsista[] corsoCorsista = null;
		try {
			Statement stmt = conn.createStatement(
					RowSet.TYPE_SCROLL_INSENSITIVE,
					RowSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_CORSO_CORSISTA);
			
			rs.last();
			
			corsoCorsista = new CorsoCorsista[rs.getRow()];
			
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				CorsoCorsista corcors = new CorsoCorsista();
				
				corcors.setCodCorso(rs.getLong(1));
				corcors.setCodCorsista(rs.getLong(2));
				corsoCorsista[i] = corcors;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return corsoCorsista;
	}
	
	public Corso[] getCorsiPrenotabili(Connection conn, long cod) throws DAOException {
		
		Corso[] corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSI_PRENOTABILI,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			rs.last();
			corso= new Corso[rs.getRow()];
			rs.beforeFirst();
			
			for(int i = 0; rs.next(); i++) {
				Corso cor = new Corso();
				cor.setCodCorso(rs.getLong(1));;
				cor.setNomeCorso(rs.getString(2));;
				cor.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));;
				cor.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
				cor.setCosto(rs.getDouble(5));;
				cor.setCommento(rs.getString(6));;
				cor.setAulaCorso(rs.getString(7));;
				cor.setCodDocente(rs.getLong(8));;
				cor.setPostiOccupati(rs.getInt(9));;
				
				corso[i] = cor;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return corso;
	}
	
	
	
	
}
