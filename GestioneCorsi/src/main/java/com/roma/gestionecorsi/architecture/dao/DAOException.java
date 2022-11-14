package com.roma.gestionecorsi.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {
	private static final long serialVersionUID = -6588469207839979199L;
	private final static int ORA1017 = 1017;
	private final static int ORA17002 = 17002;
	private final static int ORA00001 = 0;

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public DAOException(SQLException sql) {
		String chiave = "";
		if (sql != null) {
			switch (sql.getErrorCode()) {
			case ORA1017:
				chiave = "Credenziali di accesso errate";
				log(sql);
			case ORA17002:
				chiave = "IO error di Oracle Database ";
				log(sql);
			case ORA00001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;
			default:
				chiave = "Eccezione sql non prevista";
				log(sql);
			}
		}
		message=chiave;
	}

	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("Motivo: "+sql.getMessage());
		System.err.println("Codice: "+sql.getErrorCode());
		System.err.println("Stato app: "+sql.getSQLState());
		System.err.println("Cause: "+sql.getCause());
		
	}
}