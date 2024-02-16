-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Feb 16, 2024 at 01:50 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gritacademy`
--
CREATE DATABASE IF NOT EXISTS `gritacademy` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gritacademy`;

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentsid` int(11) NOT NULL,
  `subjectsid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `onlyOneCourse` (`studentsid`,`subjectsid`),
  KEY `attendance_ibfk_2` (`subjectsid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `attendance`:
--   `studentsid`
--       `students` -> `ID`
--   `subjectsid`
--       `courses` -> `id`
--

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `studentsid`, `subjectsid`) VALUES
(18, 1, 1),
(1, 1, 2),
(2, 1, 5),
(4, 2, 2),
(3, 2, 4),
(6, 3, 1),
(5, 3, 4),
(8, 4, 2),
(7, 4, 3),
(13, 4, 4),
(10, 5, 1),
(9, 5, 5),
(35, 14, 11);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `YHP` int(11) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `courses`:
--

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `name`, `YHP`, `description`) VALUES
(1, 'Advanced JAVA programming', 25, 'Build on your knowledge as a JAVA programmer and become more self sufficient.'),
(2, 'HTML and CSS', 20, 'Learn the basics of hos to develop your own webpages.'),
(3, 'Java Web-services', 20, 'Learn how to connect to internet services and use them.'),
(4, 'JavaScript', 25, 'Learn how to build dynamic websites using JavaScript'),
(5, 'Mobile Development With JAVA', 25, 'Learn how to build mobile applications using JAVA.'),
(11, 'Meaning of life', 42, 'What is the meaning of life?');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `town` varchar(255) NOT NULL,
  `hobby` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `students`:
--

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `fname`, `lname`, `town`, `hobby`, `email`, `phone`, `username`, `password`) VALUES
(1, 'Joel', 'Bech', 'Helsingborg', 'Programming', 'joel.bech@gritacademy.se', 701234567, 'jolleboi', 'password'),
(2, 'Andreas', 'Jabrell', 'Malmö', 'Guitar', '', 0, '', ''),
(3, 'Nikolina', 'Vikberg', 'Bjärred', 'Dogs', '', 0, '', ''),
(4, 'Sam', 'Danielsson', 'Rosengården', 'Gamerboi', '', 0, '', ''),
(5, 'Hasse', 'Nisse', 'Nisselandet', 'Eat', '', 0, '', ''),
(14, 'Oliver', 'Nilsson', 'Hemligt', 'Hemligt', '', 0, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `students_courses`
--

CREATE TABLE IF NOT EXISTS `students_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentsid` int(11) NOT NULL,
  `coursesid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `onlyOneCourse` (`studentsid`,`coursesid`),
  KEY `students_courses_ibfk_2` (`coursesid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `students_courses`:
--   `studentsid`
--       `students` -> `id`
--   `coursesid`
--       `courses` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `superadmins`
--

CREATE TABLE IF NOT EXISTS `superadmins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff.id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `staff.id` (`staff.id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `superadmins`:
--   `staff.id`
--       `teachers` -> `ID`
--

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE IF NOT EXISTS `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `town` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `privilage_type` enum('admin','user') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `teachers`:
--

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`id`, `fname`, `lname`, `town`, `email`, `phone`, `username`, `password`, `privilage_type`) VALUES
(1, 'Martin', 'Haagen', 'Höör', 'martin.haagen@gritacademy.se', 704546478, 'martincool', 'password', 'admin'),
(3, 'Neil', 'Ivarsson', 'Egeby', 'neil.ivarsson@gritacademy.se', 701234568, 'Neil', 'password', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `teachers_courses`
--

CREATE TABLE IF NOT EXISTS `teachers_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teachersid` int(11) NOT NULL,
  `coursesid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `onlyOneCourse` (`teachersid`,`coursesid`),
  KEY `teachers_courses_ibfk_1` (`coursesid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `teachers_courses`:
--   `coursesid`
--       `courses` -> `id`
--   `teachersid`
--       `teachers` -> `ID`
--

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`studentsid`) REFERENCES `students` (`ID`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`subjectsid`) REFERENCES `courses` (`id`);

--
-- Constraints for table `students_courses`
--
ALTER TABLE `students_courses`
  ADD CONSTRAINT `students_courses_ibfk_1` FOREIGN KEY (`studentsid`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `students_courses_ibfk_2` FOREIGN KEY (`coursesid`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `superadmins`
--
ALTER TABLE `superadmins`
  ADD CONSTRAINT `superadmins_ibfk_1` FOREIGN KEY (`staff.id`) REFERENCES `teachers` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teachers_courses`
--
ALTER TABLE `teachers_courses`
  ADD CONSTRAINT `teachers_courses_ibfk_1` FOREIGN KEY (`coursesid`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teachers_courses_ibfk_2` FOREIGN KEY (`teachersid`) REFERENCES `teachers` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
