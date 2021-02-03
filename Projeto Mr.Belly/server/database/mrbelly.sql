-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 03-Fev-2021 às 20:09
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
-- Estrutura da tabela `apartamento`
--

DROP TABLE IF EXISTS `apartamento`;
CREATE TABLE IF NOT EXISTS `apartamento` (
  `idAPARTAMENTO` int NOT NULL AUTO_INCREMENT,
  `andar` varchar(45) DEFAULT NULL,
  `elevador` tinyint NOT NULL,
  `residencial` int NOT NULL,
  PRIMARY KEY (`idAPARTAMENTO`),
  KEY `fk_APARTAMENTO_RESIDENCIAL1_idx` (`residencial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `banco`
--

DROP TABLE IF EXISTS `banco`;
CREATE TABLE IF NOT EXISTS `banco` (
  `idtable1` int NOT NULL,
  `banco` int NOT NULL,
  `agencia` int NOT NULL,
  `conta` int NOT NULL,
  `locador` varchar(45) NOT NULL,
  PRIMARY KEY (`idtable1`),
  KEY `fk_BANCO_LOCADOR1_idx` (`locador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `casa`
--

DROP TABLE IF EXISTS `casa`;
CREATE TABLE IF NOT EXISTS `casa` (
  `idcasa` int NOT NULL AUTO_INCREMENT,
  `areaCoberta` varchar(45) NOT NULL,
  `areaDescoberta` varchar(45) NOT NULL,
  `residencial` int NOT NULL,
  PRIMARY KEY (`idcasa`),
  KEY `fk_casa_RESIDENCIAL1_idx` (`residencial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comercial`
--

DROP TABLE IF EXISTS `comercial`;
CREATE TABLE IF NOT EXISTS `comercial` (
  `idcomercial` int NOT NULL AUTO_INCREMENT,
  `vagaGaragem` int DEFAULT NULL,
  `sobreLoja` tinyint NOT NULL,
  `imovel` int NOT NULL,
  PRIMARY KEY (`idcomercial`),
  KEY `fk_comercial_IMOVEL_idx` (`imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contrato`
--

DROP TABLE IF EXISTS `contrato`;
CREATE TABLE IF NOT EXISTS `contrato` (
  `id` int NOT NULL,
  `flag` int NOT NULL,
  `inicio` date NOT NULL,
  `valor` double NOT NULL,
  `fiador` int NOT NULL,
  `locatario` int NOT NULL,
  `imovel` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_CONTRATO_PESSOA1_idx` (`fiador`),
  KEY `fk_CONTRATO_LOCATARIO1_idx` (`locatario`),
  KEY `fk_CONTRATO_IMOVEL1_idx` (`imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE IF NOT EXISTS `endereco` (
  `idtable1` int NOT NULL,
  `logadouro` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `complemento` varchar(45) NOT NULL,
  PRIMARY KEY (`idtable1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `garagem`
--

DROP TABLE IF EXISTS `garagem`;
CREATE TABLE IF NOT EXISTS `garagem` (
  `idGARAGEM` int NOT NULL AUTO_INCREMENT,
  `coberturaChuva` tinyint NOT NULL,
  `localizacao` varchar(45) NOT NULL,
  `imovel` int NOT NULL,
  PRIMARY KEY (`idGARAGEM`),
  KEY `fk_GARAGEM_IMOVEL1_idx` (`imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `imovel`
--

DROP TABLE IF EXISTS `imovel`;
CREATE TABLE IF NOT EXISTS `imovel` (
  `idIMOVEL` int NOT NULL AUTO_INCREMENT,
  `tamanho` double NOT NULL,
  `condominio` double DEFAULT NULL,
  `iptu` double DEFAULT NULL,
  `descricao` mediumtext NOT NULL,
  `endereco` int NOT NULL,
  `locador` varchar(45) NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`idIMOVEL`),
  KEY `fk_IMOVEL_ENDERECO1_idx` (`endereco`),
  KEY `fk_IMOVEL_LOCADOR1_idx` (`locador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locador`
--

DROP TABLE IF EXISTS `locador`;
CREATE TABLE IF NOT EXISTS `locador` (
  `id` varchar(45) NOT NULL,
  `login` int NOT NULL,
  `pessoa` int NOT NULL,
  `endereco` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_LOCADOR_ENDERECO1_idx` (`endereco`),
  KEY `fk_LOCADOR_LOGIN1_idx` (`login`),
  KEY `fk_LOCADOR_PESSOA1_idx` (`pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locatario`
--

DROP TABLE IF EXISTS `locatario`;
CREATE TABLE IF NOT EXISTS `locatario` (
  `id` int NOT NULL,
  `login` int NOT NULL,
  `pessoa` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_LOCATARIO_LOGIN1_idx` (`login`),
  KEY `fk_LOCATARIO_PESSOA1_idx` (`pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `idLOGIN` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `status` tinyint NOT NULL,
  `flag` int NOT NULL,
  PRIMARY KEY (`idLOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `mensalidade`
--

DROP TABLE IF EXISTS `mensalidade`;
CREATE TABLE IF NOT EXISTS `mensalidade` (
  `idmensalidade` int NOT NULL,
  `valor` double NOT NULL,
  `pago` tinyint NOT NULL,
  `numeroParcela` int NOT NULL,
  `codPag` varchar(45) NOT NULL,
  `referencia` date NOT NULL,
  `vencimento` date NOT NULL,
  `observacao` varchar(45) DEFAULT NULL,
  `contrato` int NOT NULL,
  `banco` int NOT NULL,
  PRIMARY KEY (`idmensalidade`),
  KEY `fk_mensalidade_CONTRATO1_idx` (`contrato`),
  KEY `fk_mensalidade_BANCO1_idx` (`banco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `idPESSOA` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `dataCadastro` date NOT NULL,
  `flag` int NOT NULL,
  PRIMARY KEY (`idPESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pes_fis`
--

DROP TABLE IF EXISTS `pes_fis`;
CREATE TABLE IF NOT EXISTS `pes_fis` (
  `idPES_FIS` int NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `rg` varchar(45) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `nascimento` date NOT NULL,
  `sexo` tinyint NOT NULL,
  `pessoa` int NOT NULL,
  PRIMARY KEY (`idPES_FIS`),
  KEY `fk_PES_FIS_PESSOA1_idx` (`pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pes_jur`
--

DROP TABLE IF EXISTS `pes_jur`;
CREATE TABLE IF NOT EXISTS `pes_jur` (
  `idPES_FIS` int NOT NULL,
  `razaoSocial` varchar(45) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `pessoa` int NOT NULL,
  `representante` int NOT NULL,
  PRIMARY KEY (`idPES_FIS`),
  KEY `fk_PES_FIS_PESSOA1_idx` (`pessoa`),
  KEY `fk_PES_JUR_PES_FIS1_idx` (`representante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `residencial`
--

DROP TABLE IF EXISTS `residencial`;
CREATE TABLE IF NOT EXISTS `residencial` (
  `idRESIDENCIAL` int NOT NULL,
  `quartos` int NOT NULL,
  `salas` int NOT NULL,
  `cozinhas` int NOT NULL,
  `banheiros` int NOT NULL,
  `garagem` int NOT NULL,
  `imovel` int NOT NULL,
  PRIMARY KEY (`idRESIDENCIAL`),
  KEY `fk_RESIDENCIAL_IMOVEL1_idx` (`imovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

DROP TABLE IF EXISTS `telefone`;
CREATE TABLE IF NOT EXISTS `telefone` (
  `idTELEFONE` int NOT NULL,
  `numero` varchar(45) NOT NULL,
  `ddd` varchar(3) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `pessoa` int NOT NULL,
  PRIMARY KEY (`idTELEFONE`),
  KEY `fk_TELEFONE_PESSOA1_idx` (`pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `apartamento`
--
ALTER TABLE `apartamento`
  ADD CONSTRAINT `fk_APARTAMENTO_RESIDENCIAL1` FOREIGN KEY (`residencial`) REFERENCES `residencial` (`idRESIDENCIAL`);

--
-- Limitadores para a tabela `banco`
--
ALTER TABLE `banco`
  ADD CONSTRAINT `fk_BANCO_LOCADOR1` FOREIGN KEY (`locador`) REFERENCES `locador` (`id`);

--
-- Limitadores para a tabela `casa`
--
ALTER TABLE `casa`
  ADD CONSTRAINT `fk_casa_RESIDENCIAL1` FOREIGN KEY (`residencial`) REFERENCES `residencial` (`idRESIDENCIAL`);

--
-- Limitadores para a tabela `comercial`
--
ALTER TABLE `comercial`
  ADD CONSTRAINT `fk_comercial_IMOVEL` FOREIGN KEY (`imovel`) REFERENCES `imovel` (`idIMOVEL`);

--
-- Limitadores para a tabela `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `fk_CONTRATO_IMOVEL1` FOREIGN KEY (`imovel`) REFERENCES `imovel` (`idIMOVEL`),
  ADD CONSTRAINT `fk_CONTRATO_LOCATARIO1` FOREIGN KEY (`locatario`) REFERENCES `locatario` (`id`),
  ADD CONSTRAINT `fk_CONTRATO_PESSOA1` FOREIGN KEY (`fiador`) REFERENCES `pessoa` (`idPESSOA`);

--
-- Limitadores para a tabela `garagem`
--
ALTER TABLE `garagem`
  ADD CONSTRAINT `fk_GARAGEM_IMOVEL1` FOREIGN KEY (`imovel`) REFERENCES `imovel` (`idIMOVEL`);

--
-- Limitadores para a tabela `imovel`
--
ALTER TABLE `imovel`
  ADD CONSTRAINT `fk_IMOVEL_ENDERECO1` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`idtable1`),
  ADD CONSTRAINT `fk_IMOVEL_LOCADOR1` FOREIGN KEY (`locador`) REFERENCES `locador` (`id`);

--
-- Limitadores para a tabela `locador`
--
ALTER TABLE `locador`
  ADD CONSTRAINT `fk_LOCADOR_ENDERECO1` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`idtable1`),
  ADD CONSTRAINT `fk_LOCADOR_LOGIN1` FOREIGN KEY (`login`) REFERENCES `login` (`idLOGIN`),
  ADD CONSTRAINT `fk_LOCADOR_PESSOA1` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`idPESSOA`);

--
-- Limitadores para a tabela `locatario`
--
ALTER TABLE `locatario`
  ADD CONSTRAINT `fk_LOCATARIO_LOGIN1` FOREIGN KEY (`login`) REFERENCES `login` (`idLOGIN`),
  ADD CONSTRAINT `fk_LOCATARIO_PESSOA1` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`idPESSOA`);

--
-- Limitadores para a tabela `mensalidade`
--
ALTER TABLE `mensalidade`
  ADD CONSTRAINT `fk_mensalidade_BANCO1` FOREIGN KEY (`banco`) REFERENCES `banco` (`idtable1`),
  ADD CONSTRAINT `fk_mensalidade_CONTRATO1` FOREIGN KEY (`contrato`) REFERENCES `contrato` (`id`);

--
-- Limitadores para a tabela `pes_fis`
--
ALTER TABLE `pes_fis`
  ADD CONSTRAINT `fk_PES_FIS_PESSOA1` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`idPESSOA`);

--
-- Limitadores para a tabela `pes_jur`
--
ALTER TABLE `pes_jur`
  ADD CONSTRAINT `fk_PES_FIS_PESSOA10` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`idPESSOA`),
  ADD CONSTRAINT `fk_PES_JUR_PES_FIS1` FOREIGN KEY (`representante`) REFERENCES `pes_fis` (`idPES_FIS`);

--
-- Limitadores para a tabela `residencial`
--
ALTER TABLE `residencial`
  ADD CONSTRAINT `fk_RESIDENCIAL_IMOVEL1` FOREIGN KEY (`imovel`) REFERENCES `imovel` (`idIMOVEL`);

--
-- Limitadores para a tabela `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `fk_TELEFONE_PESSOA1` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`idPESSOA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
