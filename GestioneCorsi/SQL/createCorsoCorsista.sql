create table corso_corsista(
cod_corso int,
cod_corsista int,
constraint p_cod_corso_corsista primary key(cod_corso, cod_corsista),
constraint f_cod_corso foreign key(cod_corso) references corso(cod_corso),
constraint f_cod_corsista foreign key(cod_corsista) references corsisti(codice_corsista))