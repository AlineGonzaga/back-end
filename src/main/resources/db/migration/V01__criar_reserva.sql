create table reserva (
	id bigint auto_increment not null,
	local_filial varchar(100) not null,
    sala int not null,
    data_hora_inicial varchar(30) not null,
    data_hora_final varchar(30) not null,
    responsavel varchar(50) not null,
    cafe tinyint(1),
    quantidade int,
    descricao varchar(50),
    
    primary key(id)  
);