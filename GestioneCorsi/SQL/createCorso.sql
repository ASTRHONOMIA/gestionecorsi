create table corso(
cod_corso int,
nome_corso varchar2(30) not null,
data_inizio date not null,
data_fine date not null,
costo number(6,2) not null,
cod_docente int,
constraint p_cod_corso primary key(cod_corso),
constraint f_cod_docente foreign key(cod_docente) references docente(cod_docente));

create sequence seq_corso;