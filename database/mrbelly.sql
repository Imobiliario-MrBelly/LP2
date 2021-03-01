-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 27-Fev-2021 às 19:50
-- Versão do servidor: 8.0.21
-- versão do PHP: 7.3.21

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
CREATE DATABASE IF NOT EXISTS mrbelly;
USE mrbelly;
-- --------------------------------------------------------

--
-- Estrutura da tabela `contrato`
--

DROP TABLE IF EXISTS `contrato`;
CREATE TABLE IF NOT EXISTS `contrato` (
  `id` int NOT NULL,
  `imovel` int NOT NULL,
  `locatario` int NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `valor` double NOT NULL,
  KEY `imovel` (`imovel`),
  KEY `locatario` (`locatario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `imovel`
--

DROP TABLE IF EXISTS `imovel`;
CREATE TABLE IF NOT EXISTS `imovel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `salas` int NOT NULL,
  `quartos` int NOT NULL,
  `cozinha` int NOT NULL,
  `banheiro` int NOT NULL,
  `garagem` int NOT NULL,
  `area` double NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `endereco` int NOT NULL,
  `locador` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `locador` (`locador`),
  KEY `endereco` (`endereco`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locador`
--

DROP TABLE IF EXISTS `locador`;
CREATE TABLE IF NOT EXISTS `locador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `endereco` int NOT NULL,
  `pessoa` int NOT NULL,
  `login` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `endereco` (`endereco`),
  KEY `pessoa` (`pessoa`),
  KEY `login` (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `senha` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `status` boolean not null,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `rg` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sobrenome` varchar(50) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cadastro` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

DROP TABLE IF EXISTS `telefone`;
CREATE TABLE IF NOT EXISTS `telefone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` varchar(9) NOT NULL,
  `ddd` varchar(3) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `pessoa` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pessoa` (`pessoa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- --------------------------------------------------------------------------------------------------
-- INSERÇÃO DE DADOS NO BANCO

INSERT INTO `login` ( `senha`, `email`, `status`) VALUES
( 'adailton', 'rennan', true),
('1234', 'rennandamiao@gmail.com', true),
('junior', 'adailton', false),
('adm', 'adm', true),
('123', '123', false),
('olamundo', 'olamundo', true);

INSERT INTO `pessoa` ( `nome`, `cpf`, `rg`, `sobrenome`, `sexo`, `cadastro`) VALUES
('Rennan', '11111111111', '11111111', 'Damião', 'M', curdate()),
('Junio', '22222222222', '22222222', 'Goulartizinho', 'M', curdate()),
('Vinicius', '33333333333', '33333333', 'Vasconcelos', 'M', curdate()),
('Claudemir', '44444444444', '44444444', 'Valdisnei', 'M', curdate()),
('Tony', '55555555555', '55555555', 'Ramos', 'M', curdate()),
('Luís', '66666666666', '66666666', 'Inácio', 'M', curdate());

INSERT INTO `endereco` (`rua`,`numero`,`cep`,`cidade`, `uf`, `complemento`) VALUES
('rua','11','11111111','cidade1', 'MG', 'cA'),
('rua','22','22222222','cidade2', 'MG', 'cB'),
('rua','33','33333333','cidade3', 'MG', 'cC'),
('rua','44','44444444','cidade4', 'MG', 'cD'),
('rua','55','55555555','cidade5', 'MG', 'cE'),
('rua','6' ,'66666666','cidade6', 'MG', 'cF'),
('rua','77','77777777','cidade7', 'MG', 'cG'),
('rua','88','88888888','cidade8', 'MG', 'cH'),
('rua','99','99999999','cidade9', 'MG', 'cI');

INSERT INTO `locador` (`endereco`,`pessoa`,`login`) VALUES
(1,1,1),
(2,2,2),
(3,3,3);

INSERT INTO `locatario` (`pessoa`,`login`) VALUES
(4,4),
(5,5),
(6,6);

INSERT INTO `imovel` (`salas`,`quartos`,`cozinha`,`banheiro`,`garagem`,`area`,`descricao`,`endereco`,`locador`) VALUES
( 4, 5, 1, 2, 2, 100.4,'descricao1', 7, 1),
( 3, 9, 2, 3, 1, 200.9,'descricao2', 8, 2),
( 2, 4, 1, 1, 3, 300.0,'descricao3', 9, 3);

INSERT INTO `contrato` (`imovel`,`locatario`,`dataInicio`,`dataFim`,`valor`) VALUES
(1,1,'2018-10-29','2021-01-05',400.5),
(2,2,'2019-07-11','2020-10-06',700.1),
(3,3,'2018-06-30','2020-10-25',300.4);


INSERT INTO `telefone` (`numero`,`ddd`,`descricao`,`pessoa`) VALUES
('988451214','32','Empresa', 1),
('988854212','32','Particular', 2),
('988563214','21','Trabalho', 3),
('988955452','32','Particular', 4),
('988998555','32','Trabalho', 5),
('988924778','32','Particular', 6);

select * from pessoa;
