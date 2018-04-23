-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 20-Abr-2018 às 18:36
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.0.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetoclinica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadmedicos`
--

CREATE TABLE `cadmedicos` (
  `cod_med` int(3) NOT NULL,
  `nome_med` varchar(50) NOT NULL,
  `nasc_med` int(8) NOT NULL,
  `crm_med` int(20) NOT NULL,
  `end_med` varchar(50) NOT NULL,
  `email_med` varchar(50) NOT NULL,
  `tel_med` varchar(20) NOT NULL,
  `espec_med` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cadmedicos`
--

INSERT INTO `cadmedicos` (`cod_med`, `nome_med`, `nasc_med`, `crm_med`, `end_med`, `email_med`, `tel_med`, `espec_med`) VALUES
(1, 'Lougans', 16071996, 123456789, 'Arthuro Browe', 'lougans@teste.com', '4797795600', 'Cardiologista'),
(2, 'Danielle Monique', 5041997, 1212015467, 'Rua do Vila Nova', 'danielle@email.com', '4799991111', 'Cirurgião'),
(3, 'Alena Quinzel', 30072000, 778945164, 'Rua Backdoor', 'alena.smoack@email.com', '4199776600', 'Cirurgião'),
(4, 'Iris alves', 12082000, 6155516, 'Rua Altos morros', 'iris@email.com', '4196960000', 'Cardiologista'),
(5, 'Amélia Hurtz', 20091995, 115584165, 'Rua dos avionários', 'ame.lia@gmail.com', '4197970001', 'Cirurgião');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadusuarios`
--

CREATE TABLE `cadusuarios` (
  `cod_user` int(5) NOT NULL,
  `nome_user` varchar(50) NOT NULL,
  `usuario_user` varchar(20) NOT NULL,
  `email_user` varchar(30) NOT NULL,
  `rg_user` int(10) NOT NULL,
  `senha_user` varchar(50) NOT NULL,
  `senha2_user` varchar(50) NOT NULL,
  `acesso_user` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cadusuarios`
--

INSERT INTO `cadusuarios` (`cod_user`, `nome_user`, `usuario_user`, `email_user`, `rg_user`, `senha_user`, `senha2_user`, `acesso_user`) VALUES
(1, 'Lougans', 'lougans99', 'lougans.lougans99@gmail.com', 1301844443, 'nuttert99', 'nuttert99', 'Administrador'),
(5, 'Ivo', 'ivo', 'ivo@email.com', 121231231, '123456', '123456', 'Administrador'),
(7, 'Lane dias', 'lanedias', 'lane@email.com', 323213213, 'abc123', 'abc123', 'Recepcionista'),
(8, 'Lorel', 'lorel', 'lorel@email.com', 141471477, 'abc111', 'abc111', 'Médico'),
(9, 'Marcelo Petri', 'marcelopetri', 'marcelo.petri@sociesc.com.br', 112223331, 'marcelo123', 'marcelo123', 'Administrador');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cadmedicos`
--
ALTER TABLE `cadmedicos`
  ADD PRIMARY KEY (`cod_med`);

--
-- Indexes for table `cadusuarios`
--
ALTER TABLE `cadusuarios`
  ADD PRIMARY KEY (`cod_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cadmedicos`
--
ALTER TABLE `cadmedicos`
  MODIFY `cod_med` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `cadusuarios`
--
ALTER TABLE `cadusuarios`
  MODIFY `cod_user` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
