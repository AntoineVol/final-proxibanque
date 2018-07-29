-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 26 juil. 2018 à 18:03
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

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `clientNumber`, `email`, `firstName`, `lastName`, `tel`) VALUES
(1, '16589354', 'steve.jobs@gmail.com', 'Steve', 'Jobs', '0603015986'),
(2, '56996368', 'jim.morrisongmail.fr', 'Jim', 'Morrison', '0963568935');


--
-- Déchargement des données de la table `survey`
--

INSERT INTO `survey` (`id`, `endDate`, `expectedDate`, `startDate`) VALUES
(1, '2018-07-25', '2018-07-25', '2018-07-20'),
(2, NULL, '2018-07-26', '2018-08-03');


--
-- Déchargement des données de la table `response`
--

INSERT INTO `response` (`id`, `comment`, `newClient`, `positiveResponse`, `id_client`, `id_survey`) VALUES
(1, 'Je suis déjà chez une autre banque', b'0', b'0', NULL, 1),
(2, NULL, b'0', b'1', 1, 1),
(3, NULL, b'1', b'1', 2, 1),
(4, NULL, b'0', b'1', 2, 2),
(5, 'L\'offre ne m\'interesse pas', b'0', b'0', NULL, 2);

COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
