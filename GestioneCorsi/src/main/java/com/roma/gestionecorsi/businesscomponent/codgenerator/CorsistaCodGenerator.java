package com.roma.gestionecorsi.businesscomponent.codgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.roma.gestionecorsi.architecture.dao.DAOCostants;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;

public class CorsistaCodGenerator implements CodGeneratorInterface , DAOCostants {
	private static CorsistaCodGenerator codGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	@Override
	public long getNextCod() throws DAOException, IOException, ClassNotFoundException {
		long cod = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
			rs.next();
			cod = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return cod;
	}
	
	private CorsistaCodGenerator() throws DAOException, IOException, ClassNotFoundException {
		conn = DBAccess.getConnection();
	}

	public static CorsistaCodGenerator getInstance() throws DAOException, IOException, ClassNotFoundException {
		if (codGen == null)
			codGen = new CorsistaCodGenerator();
		return codGen;
	}

}
