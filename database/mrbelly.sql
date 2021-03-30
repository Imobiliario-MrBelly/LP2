-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Tempo de geração: 20-Mar-2021 às 14:12
-- Versão do servidor: 8.0.21
-- versão do PHP: 7.3.21
 drop database if exists mrbelly ;
create database mrbelly;
use  mrbelly;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mrbelly`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `contrato`
--

DROP TABLE IF EXISTS `contrato`;
CREATE TABLE IF NOT EXISTS `contrato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imovel` int NOT NULL,
  `locatario` int NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `imovel` (`imovel`),
  KEY `locatario` (`locatario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `contrato`
--

INSERT INTO `contrato` (`id`, `imovel`, `locatario`, `dataInicio`, `dataFim`, `valor`) VALUES
(1, 1, 1, '2018-10-29', '2021-01-05', 400.5),
(2, 2, 2, '2019-07-11', '2020-10-06', 700.1),
(3, 3, 3, '2018-06-30', '2020-10-25', 300.4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE IF NOT EXISTS `endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rua` varchar(40) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `rua`, `numero`, `cep`, `cidade`, `uf`, `complemento`) VALUES
(1, 'rua', '11', '11111111', 'cidade1', 'MG', 'cA'),
(2, 'rua', '22', '22222222', 'cidade2', 'MG', 'cB'),
(3, 'rua', '33', '33333333', 'cidade3', 'MG', 'cC'),
(4, 'rua', '44', '44444444', 'cidade4', 'MG', 'cD'),
(5, 'rua', '55', '55555555', 'cidade5', 'MG', 'cE'),
(6, 'rua', '6', '66666666', 'cidade6', 'MG', 'cF'),
(7, 'rua', '77', '77777777', 'cidade7', 'MG', 'cG'),
(8, 'rua', '88', '88888888', 'cidade8', 'MG', 'cH'),
(9, 'rua', '99', '99999999', 'cidade9', 'MG', 'cI');

-- --------------------------------------------------------

--
-- Estrutura da tabela `imovel`
--

DROP TABLE IF EXISTS `imovel`;
CREATE TABLE IF NOT EXISTS `imovel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `garagem` int NOT NULL,
  `condominio` double NOT NULL,
  `area` double NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `iptu` double NOT NULL,
  `endereco` int NOT NULL,
  `locador` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `locador` (`locador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `imovel`
--

INSERT INTO `imovel` (`id`, `garagem`, `condominio`, `area`, `descricao`, `iptu`, `endereco`, `locador`) VALUES
(1, 4, 100.2, 100.4, 'descricao1', 400.7, 7, 1),
(2, 3, 150.2, 200.9, 'descricao2', 600.8, 8, 2),
(3, 2, 120.45, 300, 'descricao3', 378.1, 9, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locador`
--

DROP TABLE IF EXISTS `locador`;
CREATE TABLE IF NOT EXISTS `locador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pessoa` int NOT NULL,
  `login` int NOT NULL,
  `endereco` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pessoa` (`pessoa`),
  KEY `login` (`login`),
  KEY `endereco` (`endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `locador`
--

INSERT INTO `locador` (`id`, `pessoa`, `login`, `endereco`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2),
(3, 3, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locatario`
--

DROP TABLE IF EXISTS `locatario`;
CREATE TABLE IF NOT EXISTS `locatario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pessoa` int NOT NULL,
  `login` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pessoa` (`pessoa`),
  KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `locatario`
--

INSERT INTO `locatario` (`id`, `pessoa`, `login`) VALUES
(1, 4, 4),
(2, 5, 5),
(3, 6, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `senha` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `senha`, `email`, `status`) VALUES
(1, 'adailton', 'rennan', 1),
(2, '1234', 'rennandamiao@gmail.com', 1),
(3, 'junior', 'adailton', 0),
(4, 'adm', 'adm', 1),
(5, '123', '123', 0),
(6, 'olamundo', 'olamundo', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `sobrenome` varchar(50) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cadastro` date NOT NULL,
  `telefone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `cpf`, `rg`, `sobrenome`, `sexo`, `cadastro`, `telefone`) VALUES
(1, 'Rennan', '11111111111', '11111111', 'Damião', 'M', '2021-03-20', '111111'),
(2, 'Junio', '22222222222', '22222222', 'Goulartizinho', 'M', '2021-03-20', '111111'),
(3, 'Vinícius', '33333333333', '33333333', 'Vasconcelos', 'M', '2021-03-20', '111111'),
(4, 'Claudemir', '44444444444', '44444444', 'Valdisnei', 'M', '2021-03-20', '111111'),
(5, 'Tony', '55555555555', '55555555', 'Ramos', 'M', '2021-03-20', '111111'),
(6, 'Luís', '66666666666', '66666666', 'Inácio', 'M', '2021-03-20', '111111');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`imovel`) REFERENCES `imovel` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`locatario`) REFERENCES `locatario` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `imovel`
--
ALTER TABLE `imovel`
  ADD CONSTRAINT `imovel_ibfk_1` FOREIGN KEY (`locador`) REFERENCES `locador` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `locador`
--
ALTER TABLE `locador`
  ADD CONSTRAINT `locador_ibfk_1` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `locador_ibfk_2` FOREIGN KEY (`login`) REFERENCES `login` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `locador_ibfk_3` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `locatario`
--
ALTER TABLE `locatario`
  ADD CONSTRAINT `locatario_ibfk_1` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `locatario_ibfk_2` FOREIGN KEY (`login`) REFERENCES `login` (`id`) ON DELETE CASCADE;
COMMIT;

select * from pessoa;