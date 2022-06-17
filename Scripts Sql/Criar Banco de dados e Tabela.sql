CREATE SCHEMA `sprint_02` DEFAULT CHARACTER SET utf8 ;
USE sprint_02;


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
