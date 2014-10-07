create database if not exists projetoFaculdade;

use provamobicare;
create table if not exists departamento(
	idDepartamento int AUTO_INCREMENT not null primary key,
	descricao varchar(60) not null,
	dataCriacao date,
	ativo boolean
);


create table if not exists empregado (
	idEmpregado int AUTO_INCREMENT not null primary key,
	nome varchar(60) not null,
	funcao varchar(50) not null,
	salario double not null,
	dataNascimento date,
	ativo boolean,
	idDepartamento int not null
);

create table if not exists paciente (
	idPaciente int AUTO_INCREMENT not null primary key,
	nome varchar(60) not null,
	email varchar(50) not null,
	dataNascimento date,
	telefone varchar(12) not null,
	ativo boolean
);

create table if not exists plano (
	idPlano int AUTO_INCREMENT not null primary key,
	nome varchar(60) not null,
	ans varchar(50) not null,
	cnpj varchar(18) not null,
	dataEntrega date,
	desconto double not null
);

create table if not exists medicamento (
	idMedicamento int AUTO_INCREMENT not null primary key,
	descricao varchar(60) not null,
	indicacao varchar(50) not null,
	dataValidade date not null,
	preco double not null
);

ALTER TABLE empregado
ADD CONSTRAINT FK_empregado_idDepartamento FOREIGN KEY (idDepartamento)
    REFERENCES departamento(idDepartamento);
    
    
insert into departamento values(null, 'MARKETING', '2014-10-13', true);
insert into departamento values(null, 'INFORMATICA', '2013-10-13', true);
insert into departamento values(null, 'RH', '2012-01-11', true);
insert into departamento values(null, 'FINANCEIRO', '2014-10-13', true);

