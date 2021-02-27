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
  `periodo` int NOT NULL,
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
  `bairro` varchar(45) DEFAULT NULL,
  `cep` varchar(8) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `senha`, `email`) VALUES
(1, 'adailton', 'rennan'),
(2, '1234', 'rennandamiao@gmail.com'),
(3, 'junior', 'adailton');

-- --------------------------------------------------------

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
  `sexo` tinyint(1) NOT NULL,
  `cadastro` date NOT NULL,
  `login` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `login` (`login`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `cpf`, `rg`, `sobrenome`, `sexo`, `cadastro`, `login`) VALUES
(1, 'Rennan', '149633', 'sasldkas', '', 0, '0000-00-00', 1),
(2, 'Rennan', '149633', 'sasldkas', '', 0, '0000-00-00', 1);

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
