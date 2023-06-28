-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 28, 2023 at 06:00 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `internship`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Matricule` varchar(255) NOT NULL,
  `Comment` longtext NOT NULL,
  `Work_id` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`Id`, `Matricule`, `Comment`, `Work_id`, `Date`) VALUES
(2, 'SI5678', 'Excuse me for saying that, i don\'t know what got into me !', 5, '2019-10-25 00:51:19'),
(5, 'SI5678', 'My works !', 1, '2019-10-25 00:51:19');

-- --------------------------------------------------------

--
-- Table structure for table `evaluate`
--

DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE IF NOT EXISTS `evaluate` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Rating` int(11) NOT NULL,
  `Publication_id` int(11) NOT NULL,
  `Matricule` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evaluate`
--

INSERT INTO `evaluate` (`Id`, `Rating`, `Publication_id`, `Matricule`) VALUES
(1, 5, 2, 'SI2589');

-- --------------------------------------------------------

--
-- Table structure for table `travaux`
--

DROP TABLE IF EXISTS `travaux`;
CREATE TABLE IF NOT EXISTS `travaux` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Entitled` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Content` longtext NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travaux`
--

INSERT INTO `travaux` (`Id`, `Entitled`, `Type`, `Content`) VALUES
(1, 'FLIGHT PRICE PREDICTION', 'TFC', 'We want to predict the plane flight price based on data we will collect'),
(2, 'JOB POSTING MANAGEMENT APPLICATION', 'Memory', 'I\'ll design an application that will manage job offers');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Matricule` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Id`, `Name`, `Email`, `Matricule`) VALUES
(1, 'Nathan Katanga', 'katanganathan17@gmail.com', 'SI1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
