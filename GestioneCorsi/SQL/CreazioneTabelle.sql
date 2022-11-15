--Corsisti
create table corsisti(
nome_corsista varchar2(30) not null,
cognome_corsista varchar2(30) not null,
cod_corsista number(38),
precedenti_formativi number(1) not null check (precedenti_formativi=1 or precedenti_formativi=0),
constraint pk_codcorsista primary key (cod_corsista));


--Docente
create table docente(
nome_docente varchar2(30) not null,
coognome_docente varchar2(30) not null,
cv_docente varchar2(50),
cod_docente int,
constraint p_cod_docente primary key(cod_docente));


--Amministratore
create table amministratore(
cod_admin int,
nome_admin varchar2(30) not null,
cognome_admin varchar2(30) not null,
constraint p_cod_admin primary key(cod_admin));


--Corso
create table corso(
cod_corso int,
nome_corso varchar2(30) not null,
data_inizio date not null,
data_fine date not null,
costo_corso number(6,2) not null,
commento_corso varchar2(200),
aula_corso varchar2(10) not null,
cod_docente int,
posti_occupati number(2) not null,
constraint p_cod_corso primary key(cod_corso),
constraint f_cod_docente foreign key(cod_docente) references docente(cod_docente));


--Corso_Corsista
create table corso_corsista(
cod_corso int,
cod_corsista int,
constraint p_cod_corso_corsista primary key(cod_corso, cod_corsista),
constraint f_cod_corso foreign key(cod_corso) references corso(cod_corso) on delete cascade,
constraint f_cod_corsista foreign key(cod_corsista) references corsisti(cod_corsista) on delete cascade);


--Sequenze
create sequence seq_corso;
create sequence seq_corsisti;