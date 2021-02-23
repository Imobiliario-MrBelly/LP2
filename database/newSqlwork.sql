----------------------------------------
-- Schema mrbelly
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mrbelly` ;

CREATE SCHEMA IF NOT EXISTS `mrbelly` DEFAULT CHARACTER SET utf8 ;
USE `mrbelly` ;

-- -----------------------------------------------------
-- Table `mrbelly`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`pessoa` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`pessoa` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `nascimento` DATE NOT NULL,
  `sexo` TINYINT NOT NULL,
  `dataCadastro` DATE NOT NULL,
  `flag` INT NOT NULL,
  PRIMARY KEY (`id`))
;


-- -----------------------------------------------------
-- Table `mrbelly`.`telefone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`telefone` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`telefone` (
  `id` INT NOT NULL,
  `ddd` VARCHAR(3) NOT NULL,
  `numero` VARCHAR(9) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `pessoa` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_telefone_pessoa_idx` (`pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_pessoa`
    FOREIGN KEY (`pessoa`)
    REFERENCES `mrbelly`.`pessoa` (`id`))
;


-- -----------------------------------------------------
-- Table `mrbelly`.`pessoaFisica`
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `mrbelly`.`pessoaJuridica`



-- -----------------------------------------------------
-- Table `mrbelly`.`login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`login` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`login` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `flag` INT NOT NULL,
  PRIMARY KEY (`id`))
;


-- -----------------------------------------------------
-- Table `mrbelly`.`locatario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`locatario` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`locatario` (
  `id` INT NOT NULL,
  `pessoa` INT NOT NULL,
  `login` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_locatario_pessoa1_idx` (`pessoa` ASC) VISIBLE,
  INDEX `fk_locatario_login1_idx` (`login` ASC) VISIBLE,
  CONSTRAINT `fk_locatario_pessoa1`
    FOREIGN KEY (`pessoa`)
    REFERENCES `mrbelly`.`pessoa` (`id`)
    
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_locatario_login1`
    FOREIGN KEY (`login`)
    REFERENCES `mrbelly`.`login` (`id`)
    
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mrbelly`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`endereco` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`endereco` (
  `idendereco` INT NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `uf` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idendereco`))
;


-- -----------------------------------------------------
-- Table `mrbelly`.`locador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`locador` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`locador` (
  `id` INT NOT NULL,
  
  `login` INT NOT NULL,
  `pessoa` INT NOT NULL,
  `endereco` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_locador_login1_idx` (`login` ASC) VISIBLE,
  INDEX `fk_locador_pessoa1_idx` (`pessoa` ASC) VISIBLE,
  INDEX `fk_locador_endereco1_idx` (`endereco` ASC) VISIBLE,
  CONSTRAINT `fk_locador_login1`
    FOREIGN KEY (`login`)
    REFERENCES `mrbelly`.`login` (`id`)
    
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_locador_pessoa1`
    FOREIGN KEY (`pessoa`)
    REFERENCES `mrbelly`.`pessoa` (`id`)
    
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_locador_endereco1`
    FOREIGN KEY (`endereco`)
    REFERENCES `mrbelly`.`endereco` (`idendereco`)
    
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mrbelly`.`contaBancaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`contaBancaria` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`contaBancaria` (
  `id` INT NOT NULL,
  `banco` VARCHAR(45) NOT NULL,
  `agencia` VARCHAR(45) NOT NULL,
  `conta` VARCHAR(45) NOT NULL,
  `locador` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contaBancaria_locador1_idx` (`locador` ASC) VISIBLE,
  CONSTRAINT `fk_contaBancaria_locador1`
    FOREIGN KEY (`locador`)
    REFERENCES `mrbelly`.`locador` (`id`)
    
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mrbelly`.`imovel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`imovel` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`imovel` (
  `id` INT NOT NULL,
  `tamanho` DOUBLE NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `garagem` INT NOT NULL,
  `iptu` DOUBLE NOT NULL,
  `condomino` DOUBLE NOT NULL,
  `endereco` INT NOT NULL,
  `locador` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_imovel_endereco1_idx` (`endereco` ASC) VISIBLE,
  INDEX `fk_imovel_locador1_idx` (`locador` ASC) VISIBLE,
  CONSTRAINT `fk_imovel_endereco1`
    FOREIGN KEY (`endereco`)
    REFERENCES `mrbelly`.`endereco` (`idendereco`)
    
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_locador1`
    FOREIGN KEY (`locador`)
    REFERENCES `mrbelly`.`locador` (`id`)
    
    ON UPDATE NO ACTION)
;








-- -----------------------------------------------------
-- Table `mrbelly`.`contrato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mrbelly`.`contrato` ;

CREATE TABLE IF NOT EXISTS `mrbelly`.`contrato` (
  `idcontrato` INT NOT NULL,
  `dataInicio` DATE NOT NULL,
  `dataTermino` DATE NOT NULL,
  
  `valor` DOUBLE NOT NULL,
  `imovel` INT NOT NULL,
  `locatario` INT NOT NULL,
  `fiador` INT NOT NULL,
  PRIMARY KEY (`idcontrato`),
  INDEX `fk_contrato_imovel1_idx` (`imovel` ASC) VISIBLE,
  INDEX `fk_contrato_locatario1_idx` (`locatario` ASC) VISIBLE,
  CONSTRAINT `fk_contrato_imovel1`
    FOREIGN KEY (`imovel`)
    REFERENCES `mrbelly`.`imovel` (`id`)
    
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contrato_locatario1`
    FOREIGN KEY (`locatario`)
    REFERENCES `mrbelly`.`locatario` (`id`)
    CONSTRAINT `fk_contrato_fiador`
    FOREIGN KEY (`fiador`)
    REFERENCES `mrbelly`.`pessoa` (`id`)
    ON UPDATE NO ACTION)
;

