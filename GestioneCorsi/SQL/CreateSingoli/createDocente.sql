create table docente(
nome_docente varchar2(30) not null,
coognome_docente varchar2(30) not null,
cv_docente varchar2(50),
cod_docente int,
constraint p_cod_docente primary key(cod_docente));
