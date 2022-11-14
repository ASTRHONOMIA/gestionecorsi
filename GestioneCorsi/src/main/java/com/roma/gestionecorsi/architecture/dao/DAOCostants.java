package com.roma.gestionecorsi.architecture.dao;

public interface DAOCostants {
	
	String SELECT_ADMIN ="Select * from admin";
	String SELECT_ADMIN_BYCOD ="Select * from admin where cod_admin = ?";

	String SELECT_CORSO="Select * from corso";
	String DELETE_CORSO ="Delete from corso where cod_corso = ?";
	String SELECT_CORSO_BYCOD ="Select * from corso where cod_corso = ?";
	String SELECT_DATA_INIZIO="select data_inizio from corso where cod_corso = ?";
	String SELECT_DATA_FINE="select data_fine from corso where cod_corso = ?";
	String SELECT_NUMERO_COMMENTI="select count(commento_corso) as Numero_commenti from corso";
	String UPDATE_CORSO_BYCOD="update corso set nome_corso = ?, data_inizio = ?, data_fine = ?, costo = ?, cod_docente = ? where cod_corso = ?";

	String SELECT_CORSISTA="Select * from corsisti";
	String SELECT_CORSISTA_BYCOD ="Select * from corsisti where codice_corsista = ?";
	String SELECT_NUMERO_CORSISTI="Select count(*) from corsisti";
	String UPDATE_CORSISTI="update corsisti set nome_corsista = ?, cognome_corsista= ?, precedenti_formativi=? where cod_corsista=?";
	String DELETE_CORSISTI="Delete from corsisti where cod_corsista=?";
	
	String SELECT_DOCENTE="Select * from docente";
	String SELECT_DOCENTE_BYCOD ="Select * from docente where cod_docente = ?";
}