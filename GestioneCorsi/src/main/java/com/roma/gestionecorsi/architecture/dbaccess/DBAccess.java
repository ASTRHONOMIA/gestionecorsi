package com.roma.gestionecorsi.architecture.dbaccess;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.roma.gestionecorsi.architecture.dao.DAOException;

public class DBAccess {

	private static Connection conn;

	public static synchronized Connection getConnection() throws IOException, ClassNotFoundException, DAOException {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("properties/config.properties");
			Properties p = new Properties();
			p.load(input);
			Class.forName(p.getProperty("jdbcDRIVER"));
			try {
			conn = DriverManager.getConnection(p.getProperty("jdbcURL"), p.getProperty("username"),
					p.getProperty("password"));
			}
			catch(SQLException sql)
			{
				conn = DriverManager.getConnection(p.getProperty("jdbcURL2"), p.getProperty("username"),
						p.getProperty("password"));
			}
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static void closeConnetion() throws DAOException {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}