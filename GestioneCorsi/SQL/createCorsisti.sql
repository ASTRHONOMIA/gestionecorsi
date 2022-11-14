create table corsisti(
nome_corsista varchar2(30) not null,
cognome_corsista varchar2(30) not null,
codice_corsista number(38),
precedenti_formativi number(1) not null check (precedenti_formativi=1 or precedenti_formativi=0),
constraint pk_codcorsista primary key (codice_corsista)
);