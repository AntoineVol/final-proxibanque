-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 30 juil. 2018 à 11:08
-- Version du serveur :  10.1.32-MariaDB
-- Version de PHP :  7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanque_v4`
--
CREATE DATABASE IF NOT EXISTS `proxibanque_v4` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `proxibanque_v4`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clientNumber` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `clientNumber`, `email`, `firstName`, `lastName`, `tel`) VALUES
(1, '16589354', 'steve.jobs@gmail.com', 'Steve', 'Jobs', '0603015986'),
(2, '56996368', 'jim.morrisongmail.fr', 'Jim', 'Morrison', '0963568935');

-- --------------------------------------------------------

--
-- Structure de la table `response`
--

CREATE TABLE IF NOT EXISTS `response` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(600) DEFAULT NULL,
  `newClient` bit(1) NOT NULL,
  `positiveResponse` bit(1) NOT NULL,
  `id_client` int(11) DEFAULT NULL,
  `id_survey` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7bkqv1dgx1qhiynb0clrlpju6` (`id_client`),
  KEY `FKscaxble1ha55b1fgq25a8ktqc` (`id_survey`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `response`
--

INSERT INTO `response` (`id`, `comment`, `newClient`, `positiveResponse`, `id_client`, `id_survey`) VALUES
(1, 'Je suis déjà chez une autre banque', b'0', b'0', NULL, 1),
(2, NULL, b'0', b'1', 1, 1),
(3, NULL, b'1', b'1', 2, 1),
(4, NULL, b'0', b'1', 2, 2),
(5, 'L\'offre ne m\'interesse pas', b'0', b'0', NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `survey`
--

CREATE TABLE IF NOT EXISTS `survey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endDate` date DEFAULT NULL,
  `expectedDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `survey`
--

INSERT INTO `survey` (`id`, `endDate`, `expectedDate`, `startDate`) VALUES
(1, '2018-07-25', '2018-07-25', '2018-07-20'),
(2, NULL, '2018-08-03', '2018-07-26');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `response`
--
ALTER TABLE `response`
  ADD CONSTRAINT `FK7bkqv1dgx1qhiynb0clrlpju6` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKscaxble1ha55b1fgq25a8ktqc` FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
