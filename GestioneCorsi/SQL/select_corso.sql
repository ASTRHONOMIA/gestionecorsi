-- select_corso
select * from corso;

-- select_corso_by_cod
select * from corso where cod_corso = ?;

-- select_nome_corso_frequente
select count(nome_corso) as Numero_Corsi from corso;

-- update_corso_by_cod
update corso set nome_corso = ?, data_inizio = ?, data_fine = ?, costo = ?, cod_docente = ? where cod_corso = ?;

-- select_data_inizio_corso
select data_inizio from corso where cod_corso = ?;

-- select_data_fine_corso
select data_fine from corso where cod_corso = ?;

-- select_numero_commenti_corso
select count(commento_corso) as Numero_commenti from corso;

-- delete_corso_by_cod
delete from corso where cod_corso = ?;