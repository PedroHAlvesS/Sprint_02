CREATE SCHEMA `sprint_02_Pedro` DEFAULT CHARACTER SET utf8 ;
USE sprint_02_Pedro;


CREATE TABLE `produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  `descrição` VARCHAR(150) NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` DECIMAL(10, 2),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE `filme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  `descrição` VARCHAR(150) NOT NULL,
  `ano` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO filme(nome, descrição, ano) VALUES ('Blade Runner 2049', '1', 2017);
INSERT INTO filme(nome, descrição, ano) VALUES ('The Batman', '2', 2022);
INSERT INTO filme(nome, descrição, ano) VALUES ('Homem Aranha 3', '3', 2007);
INSERT INTO filme(nome, descrição, ano) VALUES ('As traças do rei careca', '4', 2100);
INSERT INTO filme(nome, descrição, ano) VALUES ('A volta dos que não foram', '5', 2050);
INSERT INTO filme(nome, descrição, ano) VALUES ('Viagem ao Centro da Terra', '6', 2008);
INSERT INTO filme(nome, descrição, ano) VALUES ('Monty python em busca do cálice sagrado', '7', 1975);
INSERT INTO filme(nome, descrição, ano) VALUES ('Ponte para terabítia', '8', 2007);
INSERT INTO filme(nome, descrição, ano) VALUES ('As Crônicas de Nárnia O Leão - A Feiticeira e o Guarda Roupa', '9', 2005);
INSERT INTO filme(nome, descrição, ano) VALUES ('Incendio na caixa dágua', '10', 2039);
INSERT INTO filme(nome, descrição, ano) VALUES ('Kono Subarashii Sekai ni Shukufuku o!', '11', 2019);
INSERT INTO filme(nome, descrição, ano) VALUES ('Irmão Urso', '12', 2003);
INSERT INTO filme(nome, descrição, ano) VALUES ('Era do gelo', '13', 2002);
INSERT INTO filme(nome, descrição, ano) VALUES ('2001 - Uma Odisseia no Espaço', '14', 1968);
INSERT INTO filme(nome, descrição, ano) VALUES ('Pantera Negra', '15', 2018);
INSERT INTO filme(nome, descrição, ano) VALUES ('Matrix', '16', 1999);
INSERT INTO filme(nome, descrição, ano) VALUES ('Piratas do Caribe', '17', 2003);
INSERT INTO filme(nome, descrição, ano) VALUES ('Harry Potter e a Pedra Filosofal', '18', 2001);
INSERT INTO filme(nome, descrição, ano) VALUES ('O Senhor dos Anéis: A Sociedade do Anel', '19', 2001);
INSERT INTO filme(nome, descrição, ano) VALUES ('Warcraft - O Primeiro Encontro de Dois Mundos', '20', 2016);


