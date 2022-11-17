--Corsisti
insert into corsisti values('Claudia', 'Viola', 1, 1);
insert into corsisti values('Serena', 'Bruno', 2, 0);
insert into corsisti values('Michele', 'De Lorenzi', 3, 1);
insert into corsisti values('Giulia', 'Liuti', 4, 0);

--Docente
insert into docente values('Marco', 'Rossi', 'ass', 1);
insert into docente values('Maria', 'Bianchi', 'cv', 2);
insert into docente values('Federico', 'Simonetti', 'cv', 3);
insert into docente values('Angela', 'Alberti', 'cv', 4);

--Amministratore
insert into amministratore values(1234, 'Mario', 'Verdi');

--Corso
insert into corso values(1, 'Java', '15-FEB-2022', '20-MAR-2022', 150, 'Impara Java', 'N5', 1, 4);
insert into corso values(2, 'Html', '17-MAR-2023', '20-APR-2023', 130, 'Impara Html', 'N3', 2, 7);
insert into corso values(3, 'Php', '22-FEB-2023', '20-MAG-2023', 120, 'Impara Php', 'N7', 2, 3);
insert into corso values(4, 'SQL', '30-MAR-2023', '20-GIU-2023', 100, 'Impara SQL', 'N1', 4, 12);

--CorsoCorsista
insert into corso_corsista values(1, 1);
insert into corso_corsista values(1, 2);
insert into corso_corsista values(2, 1);
insert into corso_corsista values(3, 3);
insert into corso_corsista values(4, 4);

commit