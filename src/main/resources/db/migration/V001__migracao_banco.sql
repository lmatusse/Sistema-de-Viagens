CREATE TABLE `aeronave` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `referencia` varchar(15) NOT NULL,
  `capacidade` int(5) DEFAULT NULL,
  `codigo_companhia_area` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `provincia` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `origem` varchar(15) NOT NULL,
  `destino` varchar(15) DEFAULT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `nacionalidade` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `pais` varchar(15) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bilhete` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `data_reserva` date NOT NULL,
  `codigo_voo` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `cliente` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `genero` char(1) NOT NULL,
  `tipo_documento` varchar(25) NOT NULL,
  `numero_documento` varchar(20) NOT NULL,
  `telef` varchar(15) NOT NULL,
  `email` varchar(40) NOT NULL,
  `data_nascimento` date NOT NULL,
  `codigo_nacionalidade` bigint NOT NULL,
  `codigo_bilhete` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `companhia_aerea` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `paisOrigem` varchar(20) NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `funcionario` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(40) NOT NULL,
  `senha` varchar(20) NOT NULL,
  Primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `voo` (
  `codigo` bigint NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora_partida` time NOT NULL,
  `hora_chegada` time NOT NULL,
  `preco` decimal NOT NULL,
  `codigo_aeronave` bigint NOT NULL,
  `codigo_provincia` bigint NOT NULL,
  primary key(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `aeronave`
  ADD KEY `fk_ca_codigo` (`codigo_companhia_area`);

ALTER TABLE `bilhete`
  ADD KEY `fk_voo_codigo` (`codigo_voo`);

ALTER TABLE `cliente`
  ADD KEY `fk_bilhete_codigo` (`codigo_bilhete`),
  ADD KEY `fk_nacionalidade_codigo` (`codigo_nacionalidade`);


--
ALTER TABLE `aeronave`
  ADD CONSTRAINT `fk_ca_codigo` FOREIGN KEY (`codigo_companhia_area`) REFERENCES `companhia_aerea` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_nacionalidade_codigo` FOREIGN KEY (`codigo_nacionalidade`) REFERENCES `nacionalidade` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_bilhete_codigo` FOREIGN KEY (`codigo_bilhete`) REFERENCES `bilhete` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `bilhete`
--
ALTER TABLE `bilhete`
  ADD CONSTRAINT `fk_voo_codigo` FOREIGN KEY (`codigo_voo`) REFERENCES `voo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Limitadores para a tabela `voo`
--
ALTER TABLE `voo`
  ADD CONSTRAINT `fk_provincia_codigo` FOREIGN KEY (`codigo_provincia`) REFERENCES `provincia` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_aeronave_codigo` FOREIGN KEY (`codigo_aeronave`) REFERENCES `aeronave` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
