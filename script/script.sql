CREATE DATABASE `jogodavelha`;

use jogodavelha;

CREATE TABLE `jogador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apelido` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `ranking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_jogador` int(11) NOT NULL,
  `jogos` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_jogador`),
  KEY `fk_jogador_idx` (`id_jogador`),
  CONSTRAINT `fk_jogador` FOREIGN KEY (`id_jogador`) REFERENCES `jogador` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_jogador` int(11) NOT NULL,
  `linha` int(11) DEFAULT NULL,
  `coluna` int(11) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jogadorr_idx` (`id_jogador`),
  CONSTRAINT `fk_jogadorr` FOREIGN KEY (`id_jogador`) REFERENCES `jogador` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);
