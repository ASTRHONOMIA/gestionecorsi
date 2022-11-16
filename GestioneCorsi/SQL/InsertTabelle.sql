--Corsisti
insert into corsisti values('Claudia', 'Viola', 1, 1);
insert into corsisti values('Serena', 'Bruno', 2, 0);

--Docente
insert into docente values('Marco', 'Rossi', 'ass', 1);
insert into docente values('Maria', 'Bianchi', 'cv', 2);

--Amministratore
insert into amministratore values(1234, 'Mario', 'Verdi');

--Corso
insert into corso values(1, 'Java', '15-FEB-2022', '20-MAR-2022', 150, 'Impara Java', 'N5', 1, 4);
insert into corso values(2, 'Html', '17-MAR-2023', '20-APR-2023', 150, 'Impara Html', 'N3', 2, 7);

--CorsoCorsista
insert into corso_corsista values(1, 1);
insert into corso_corsista values(1, 2);
insert into corso_corsista values(2, 1);

commit