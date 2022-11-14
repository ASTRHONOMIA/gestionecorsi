package com.roma.gestionecorsi.architecture.dao;

public interface DAOCostants {
	
	String SELECT_ADMIN ="Select * from admin";
	String SELECT_ADMIN_BYCOD ="Select * from admin where cod_admin = ?";

	String SELECT_CORSO="Select * from corso";
	String DELETE_CORSO ="Delete from corso where cod_corso = ?";
	String SELECT_CORSO_BYCOD ="Select * from corso where cod_corso = ?";

	String SELECT_CORSISTA="Select * from corsista";
	String SELECT_CORSISTA_BYCOD ="Select * from corsista where codice_corsista = ?";

	String SELECT_DOCENTE="Select * from docente";
	String SELECT_DOCENTE_BYCOD ="Select * from docente where cod_docente = ?";
}