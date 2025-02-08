CREATE DATABASE IF NOT EXISTS cadastro;

USE cadastro;
SELECT * FROM cadastro_pessoa;
SELECT * FROM fornecedor;
SELECT * FROM uf;

CREATE TABLE IF NOT EXISTS cadastro_pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    email VARCHAR(100),
    telefone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_fantasia VARCHAR(100) NOT NULL,
    razao_social VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    inscricao_estadual VARCHAR(20) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS uf (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_estado VARCHAR(100) NOT NULL,
    sigla CHAR(2) NOT NULL UNIQUE
);

