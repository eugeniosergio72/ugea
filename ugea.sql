drop database ugea;
create database ugea;
use ugea;
drop table ``;
drop table `solicitacao`;
drop table `solicitacao_deferida`;
drop table `solicitacao_indeferida`;
drop table `proposta`;
drop table `proposta_deferida`;
drop table `proposta_indeferida`;

create table `tipo_sector` (
	cod_tipo_sector 		int primary key auto_increment,
    `nome`					varchar(250) not null,
    `responsavel` 			varchar(100) not null
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
    data_					varchar(100),
    constraint sector foreign key (cod_sector) references `sector`(cod_sector)
);

create table `solicitacao_deferida` (
	cod_solicitacao_deferida 		int primary key auto_increment,
    cod_solicitacao					int not null,
    data_							varchar(100),
    constraint solicitacaoDe foreign key (cod_solicitacao) references `solicitacao`(cod_solicitacao)
);
create table `solicitacao_indeferida` (
	cod_solicitacao_indeferida 	int primary key auto_increment,
    cod_solicitacao				int not null,
    `observacao`				varchar(200) not null,
    data_						varchar(100),
    constraint solicitacaoIn foreign key (cod_solicitacao) references `solicitacao`(cod_solicitacao)
);
create table `proposta` (
	cod_proposta				int primary key auto_increment,
    cod_solicitacao				int not null,
	`assunto`					varchar(150),
    `descricao`					varchar(250),
    `scanner_proposta`			varchar(255),
    data_						varchar(100),
    constraint solicitacaoPr foreign key (cod_solicitacao) references `solicitacao`(cod_solicitacao)
);
create table `proposta_deferida` (
	cod_proposta_deferida		int primary key auto_increment,
    cod_proposta				int not null,
    data_						varchar(100),
    constraint propostaDe foreign key (cod_proposta) references `proposta`(cod_proposta)
);


create table `proposta_indeferida` (
	cod_proposta_indeferida		int primary key auto_increment,
    cod_proposta				int not null,
    `observacao`				varchar(200),
	data_						varchar(100),
    constraint propostaIn foreign key (cod_proposta) references proposta(cod_proposta)
);