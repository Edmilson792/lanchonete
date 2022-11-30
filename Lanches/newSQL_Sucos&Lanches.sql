CREATE DATABASE lanchonete;
USE lanchonete;

CREATE TABLE funcionarios(
    id_funcionarios int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    cpf varchar(20) NOT NULL,
    dataNasc varchar(50) NOT NULL,
    telefone varchar(16) NOT NULL,
    sexo varchar(12) NOT NULL,
    email varchar(100),
    dataAdmissao varchar(100) NOT NULL,
    salario decimal(10,2) NOT NULL,
    endereco varchar(100) NOT NULL,
    numero int(5),
    bairro varchar(100) NOT NULL,
    cidade varchar(100) NOT NULL,
    PRIMARY KEY(id_funcionarios)
)ENGINE=InnoDB;

CREATE TABLE mesas(
    id_mesas int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    numero int(5) NOT NULL,
    tipo varchar(50) NOT NULL,
    referencias text(250),
    PRIMARY KEY(id_mesas)
)ENGINE=InnoDB;

CREATE TABLE recebimento(
    id_recebimento int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    id_mesas int(5) UNSIGNED NOT NULL,
    dataAbertura datetime NULL,
    codigoPedido int(5) NOT NULL,
    produtos varchar(100) NOT NULL,
    quantidade int(5) NOT NULL,
    valorUnitario decimal(5,2) NOT NULL,
    totalParcial decimal(5,2) NOT NULL,
    PRIMARY KEY(id_recebimento),

    CONSTRAINT mesas_fk
    FOREIGN KEY (id_mesas)
    REFERENCES mesas (id_mesas)
)ENGINE=InnoDB;

CREATE TABLE usuarios(
    id_usuario int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    telefone varchar(15),
    email varchar(100),
    usuario varchar(50) NOT NULL,
    senha varchar(64) NOT NULL,
    PRIMARY KEY(id_usuario)
)ENGINE=InnoDB;

CREATE TABLE tipoProduto(
    id_tipoProduto int UNSIGNED NOT NULL AUTO_INCREMENT,
    tipo varchar(100) NOT NULL,
    PRIMARY KEY(id_tipoProduto)
)ENGINE=InnoDB;

CREATE TABLE produtos(
    id_produtos int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    id_tipoProduto int UNSIGNED NOT NULL,
    nome varchar(100) NOT NULL,
    valUnit decimal(10,2) NOT NULL,
    marca varchar(100),
    composicao text(200),
    PRIMARY KEY (id_produtos),

    CONSTRAINT tipoProduto_fk
    FOREIGN KEY (id_tipoProduto)
    REFERENCES tipoProduto (id_tipoProduto) 
)ENGINE=InnoDB;

CREATE TABLE pedidos(
    id_pedidos int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    id_mesas int(5) UNSIGNED,
    id_produtos int(5) UNSIGNED,
    datapedido datetime NOT NULL,
    qtd int(5) NOT NULL,
    valUnit decimal(10,2) NOT NULL,
    status boolean NOT NULL,
    PRIMARY KEY(id_pedidos),

    CONSTRAINT mesasPedidos_fk
    FOREIGN KEY (id_mesas)
    REFERENCES mesas (id_mesas),
    
    CONSTRAINT produtosPedidos_fk
    FOREIGN KEY (id_produtos)
    REFERENCES produtos (id_produtos)
)ENGINE=InnoDB;

CREATE TABLE caixa(
    id_caixa int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    dataAbertura datetime NULL,
    dataFechamento datetime NULL,
    valor_receb decimal(10,2) NULL,
    valor_total decimal(10,2) NULL,
    PRIMARY KEY(id_caixa)
)ENGINE=InnoDB;