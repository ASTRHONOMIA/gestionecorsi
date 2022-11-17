package com.roma.gestionecorsi.architecture.dao;

public interface DAOCostants {
	
	String SELECT_ADMIN ="Select * from amministratore";
	String SELECT_ADMIN_BYCOD ="Select * from amministratore where cod_admin = ?";
	
	String SELECT_CORSO_SEQ = "select seq_corso.nextval from dual";
	String SELECT_CORSISTA_SEQ= "select seq_corsisti.nextval from dual";

	String SELECT_CORSO="Select * from corso";
	String SELECT_CORSO_FROM_DATE="Select * from corso where data_fine > ?";
	String SELECT_DURATA_CORSO = "SELECT data_inizio, data_fine, (data_fine-data_inizio)-2*FLOOR((data_fine-data_inizio)/7)-DECODE(SIGN(TO_CHAR(data_fine,'D')-TO_CHAR(data_inizio,'D')),-1,2,0)+DECODE(TO_CHAR(data_inizio,'D'),7,1,0)-DECODE(TO_CHAR(data_fine,'D'),7,1,0) as WorkDays FROM corso where cod_corso = ? ORDER BY data_inizio,data_fine";
	String DELETE_CORSO ="Delete from corso where cod_corso = ?";
	String SELECT_CORSO_BYCOD ="Select * from corso where cod_corso = ?";
	String SELECT_DATA_INIZIO="select data_inizio from corso where cod_corso = ?";
	String SELECT_DATA_FINE="select data_fine from corso where cod_corso = ?";
	String SELECT_NUMERO_COMMENTI="select count(commento_corso) as Numero_commenti from corso";
	String UPDATE_CORSO_BYCOD="update corso set nome_corso = ?, data_inizio = ?, data_fine = ?, costo_corso = ?, commento_corso = ?, aula_corso = ?, cod_docente = ?, posti_occupati = ? where cod_corso = ?";
	String SELECT_CORSISTA="Select * from corsisti";
	String SELECT_CORSISTA_BYCOD ="Select * from corsisti where cod_corsista = ?";
	String SELECT_NUMERO_CORSISTI="Select count(*) from corsisti";
	String UPDATE_CORSISTI="update corsisti set nome_corsista = ?, cognome_corsista= ?, precedenti_formativi=? where cod_corsista=?";
	String DELETE_CORSISTI="Delete from corsisti where cod_corsista=?";
	String POSTI_DISPONIBILI="select posti_occupati from corso where cod_corso= ?";
	
	String SELECT_CORSO_CORSISTA="Select * from corso_corsista";
	String SELECT_CORSO_PIU_FREQUENTE="Select partecipanti, nome_corso from (select count(*) as partecipanti,nome_corso from corso_corsista, corso where corso.cod_corso=corso_corsista.cod_corso group by nome_corso) where partecipanti in (select max(partecipanti) from (select count(*) as partecipanti,nome_corso from corso_corsista, corso where corso.cod_corso=corso_corsista.cod_corso group by nome_corso))";
	String SELECT_CORSI_DEL_CORSISTA="Select corso_corsista.cod_corso from corso_corsista, corsisti where corsisti.cod_corsista = ? and corso_corsista.cod_corsista=corsisti.cod_corsista";
	
	String SELECT_DOCENTE="Select * from docente";
	String SELECT_DOCENTE_BYCOD ="Select * from docente where cod_docente = ?";
	String SELECT_CORSI_PRENOTABILI="select * from corso where cod_corso not in(select cod_corso from corso_corsista where cod_corsista=?)and posti_occupati<12 and data_fine>=SYSDATE";
}