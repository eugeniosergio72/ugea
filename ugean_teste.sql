drop database ugea;
create database ugea;
use ugea;

alter table tipo_sector add column tipo_acesso varchar(20) not null;

create table `tipo_sector` (
	cod_tipo_sector 		int primary key auto_increment,
    `nome`					varchar(250) not null,
    `responsavel` 			varchar(100) not null,
    tipo_acesso				varchar(10)
);
create table `sector` (
	cod_sector				int primary key auto_increment,
    cod_tipo_sector			int not null,
    `senha`					varchar(255) not null,
    `username`				varchar(50) not null,
    constraint tipoSector foreign key (cod_tipo_sector) references `tipo_sector`(cod_tipo_sector)
);
create table `solicitacao` (
	cod_solicitacao			int primary key auto_increment,
    cod_sector				int not null,
    `assunto`				varchar(150),
    `descricao`				text,
    `documento`				varchar(255),
    data					varchar(100),
    status					varchar(10),
    comentario				varchar(255),
    constraint sector foreign key (cod_sector) references `sector`(cod_sector)
);


create table `proposta` (
	cod_proposta				int primary key auto_increment,
    cod_solicitacao				int not null,
	`assunto`					varchar(150),
    `descricao`					varchar(250),
    `scanner_proposta`			varchar(255),
    data						varchar(100),
    status					varchar(10),
    comentario				varchar(255),
    constraint solicitacaoPr foreign key (cod_solicitacao) references `solicitacao`(cod_solicitacao)
);