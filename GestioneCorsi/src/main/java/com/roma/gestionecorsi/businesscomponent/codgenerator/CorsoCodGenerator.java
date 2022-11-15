package com.roma.gestionecorsi.businesscomponent.codgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.roma.gestionecorsi.architecture.dao.DAOCostants;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;

public class CorsoCodGenerator implements DAOCostants {
	private static CorsoCodGenerator cCG;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public static CorsoCodGenerator getIstance() throws ClassNotFoundException, DAOException, IOException {
		if(cCG == null)
			cCG = new CorsoCodGenerator();
		return cCG;
	}
	
	private CorsoCodGenerator() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public long getNextId() throws DAOException {
		long id;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(SELECT_CORS_SEQ);
			
			id = rs.getLong(1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return id;
	}
}