-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2019 at 11:03 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hbs`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `Bid` int(11) NOT NULL,
  `dateIn` timestamp NOT NULL DEFAULT current_timestamp(),
  `dateOut` timestamp NOT NULL DEFAULT current_timestamp(),
  `Gid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`Bid`, `dateIn`, `dateOut`, `Gid`) VALUES
(1, '2019-01-10 00:10:00', '2019-01-11 00:10:00', 201);

-- --------------------------------------------------------

--
-- Table structure for table `guests`
--

CREATE TABLE `guests` (
  `Gid` int(11) NOT NULL,
  `firstName` varchar(40) NOT NULL,
  `lastName` varchar(40) NOT NULL,
  `memberSince` timestamp NOT NULL DEFAULT current_timestamp(),
  `totalSpent` int(11) DEFAULT 0,
  `membershipLevel` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guests`
--

INSERT INTO `guests` (`Gid`, `firstName`, `lastName`, `memberSince`, `totalSpent`, `membershipLevel`) VALUES
(1, 'Vera', 'Irwin', '0000-00-00 00:00:00', 0, 0),
(2, 'Erica', 'Valenzuela', '0000-00-00 00:00:00', 0, 0),
(3, 'Oscar', 'Valencia', '0000-00-00 00:00:00', 0, 0),
(4, 'Quin', 'Barrera', '0000-00-00 00:00:00', 0, 0),
(5, 'Len', 'Moss', '0000-00-00 00:00:00', 0, 0),
(6, 'Ina', 'Deleon', '0000-00-00 00:00:00', 0, 0),
(7, 'Fredericka', 'Olsen', '0000-00-00 00:00:00', 0, 0),
(8, 'Upton', 'Graves', '0000-00-00 00:00:00', 0, 0),
(9, 'Hyatt', 'Petersen', '0000-00-00 00:00:00', 0, 0),
(10, 'Charissa', 'Dale', '0000-00-00 00:00:00', 0, 0),
(11, 'Elvis', 'Farrell', '0000-00-00 00:00:00', 0, 0),
(12, 'Hiram', 'Edwards', '0000-00-00 00:00:00', 0, 0),
(13, 'Miriam', 'Short', '0000-00-00 00:00:00', 0, 0),
(14, 'Harding', 'Sosa', '0000-00-00 00:00:00', 0, 0),
(15, 'Illiana', 'Cross', '0000-00-00 00:00:00', 0, 0),
(16, 'Hasad', 'Carey', '0000-00-00 00:00:00', 0, 0),
(17, 'Victor', 'Santos', '0000-00-00 00:00:00', 0, 0),
(18, 'Magee', 'Tanner', '0000-00-00 00:00:00', 0, 0),
(19, 'Ali', 'Vazquez', '0000-00-00 00:00:00', 0, 0),
(20, 'Rahim', 'Kelley', '0000-00-00 00:00:00', 0, 0),
(21, 'Latifah', 'Estrada', '0000-00-00 00:00:00', 0, 0),
(22, 'Prescott', 'Fields', '0000-00-00 00:00:00', 0, 0),
(23, 'Duncan', 'Finch', '0000-00-00 00:00:00', 0, 0),
(24, 'Brandon', 'Wilkins', '0000-00-00 00:00:00', 0, 0),
(25, 'Melyssa', 'Hull', '0000-00-00 00:00:00', 0, 0),
(26, 'Knox', 'Hester', '0000-00-00 00:00:00', 0, 0),
(27, 'Otto', 'Meadows', '0000-00-00 00:00:00', 0, 0),
(28, 'Nina', 'Dickerson', '0000-00-00 00:00:00', 0, 0),
(29, 'Vera', 'Irwin', '0000-00-00 00:00:00', 0, 0),
(30, 'Erica', 'Valenzuela', '0000-00-00 00:00:00', 0, 0),
(31, 'Oscar', 'Valencia', '0000-00-00 00:00:00', 0, 0),
(32, 'Quin', 'Barrera', '0000-00-00 00:00:00', 0, 0),
(33, 'Len', 'Moss', '0000-00-00 00:00:00', 0, 0),
(34, 'Ina', 'Deleon', '0000-00-00 00:00:00', 0, 0),
(35, 'Fredericka', 'Olsen', '0000-00-00 00:00:00', 0, 0),
(36, 'Upton', 'Graves', '0000-00-00 00:00:00', 0, 0),
(37, 'Hyatt', 'Petersen', '0000-00-00 00:00:00', 0, 0),
(38, 'Charissa', 'Dale', '0000-00-00 00:00:00', 0, 0),
(39, 'Elvis', 'Farrell', '0000-00-00 00:00:00', 0, 0),
(40, 'Hiram', 'Edwards', '0000-00-00 00:00:00', 0, 0),
(41, 'Miriam', 'Short', '0000-00-00 00:00:00', 0, 0),
(42, 'Harding', 'Sosa', '0000-00-00 00:00:00', 0, 0),
(43, 'Illiana', 'Cross', '0000-00-00 00:00:00', 0, 0),
(44, 'Hasad', 'Carey', '0000-00-00 00:00:00', 0, 0),
(45, 'Victor', 'Santos', '0000-00-00 00:00:00', 0, 0),
(46, 'Magee', 'Tanner', '0000-00-00 00:00:00', 0, 0),
(47, 'Ali', 'Vazquez', '0000-00-00 00:00:00', 0, 0),
(48, 'Rahim', 'Kelley', '0000-00-00 00:00:00', 0, 0),
(49, 'Latifah', 'Estrada', '0000-00-00 00:00:00', 0, 0),
(50, 'Prescott', 'Fields', '0000-00-00 00:00:00', 0, 0),
(51, 'Duncan', 'Finch', '0000-00-00 00:00:00', 0, 0),
(52, 'Brandon', 'Wilkins', '0000-00-00 00:00:00', 0, 0),
(53, 'Melyssa', 'Hull', '0000-00-00 00:00:00', 0, 0),
(54, 'Knox', 'Hester', '0000-00-00 00:00:00', 0, 0),
(55, 'Otto', 'Meadows', '0000-00-00 00:00:00', 0, 0),
(56, 'Nina', 'Dickerson', '0000-00-00 00:00:00', 0, 0),
(57, 'Tiger', 'Clarke', '0000-00-00 00:00:00', 0, 0),
(58, 'Ginger', 'Michael', '0000-00-00 00:00:00', 0, 0),
(59, 'Finn', 'Prince', '0000-00-00 00:00:00', 0, 0),
(60, 'Owen', 'Rios', '0000-00-00 00:00:00', 0, 0),
(61, 'Hyacinth', 'Hudson', '0000-00-00 00:00:00', 0, 0),
(62, 'Justina', 'Petersen', '0000-00-00 00:00:00', 0, 0),
(63, 'Brianna', 'Mcconnell', '0000-00-00 00:00:00', 0, 0),
(64, 'Shana', 'Garrison', '0000-00-00 00:00:00', 0, 0),
(65, 'Odessa', 'Allison', '0000-00-00 00:00:00', 0, 0),
(66, 'Rana', 'Whitley', '0000-00-00 00:00:00', 0, 0),
(67, 'Zeph', 'Faulkner', '0000-00-00 00:00:00', 0, 0),
(68, 'Hedy', 'Sloan', '0000-00-00 00:00:00', 0, 0),
(69, 'Ocean', 'Allen', '0000-00-00 00:00:00', 0, 0),
(70, 'Jonah', 'Conway', '0000-00-00 00:00:00', 0, 0),
(71, 'Jaime', 'Cobb', '0000-00-00 00:00:00', 0, 0),
(72, 'Dante', 'Landry', '0000-00-00 00:00:00', 0, 0),
(73, 'Grady', 'Lynch', '0000-00-00 00:00:00', 0, 0),
(74, 'Christian', 'Wiggins', '0000-00-00 00:00:00', 0, 0),
(75, 'Oscar', 'Green', '0000-00-00 00:00:00', 0, 0),
(76, 'Cedric', 'Chavez', '0000-00-00 00:00:00', 0, 0),
(77, 'Amity', 'Jensen', '0000-00-00 00:00:00', 0, 0),
(78, 'Lavinia', 'Hale', '0000-00-00 00:00:00', 0, 0),
(79, 'Kevin', 'Mcintosh', '0000-00-00 00:00:00', 0, 0),
(80, 'Caesar', 'Buck', '0000-00-00 00:00:00', 0, 0),
(81, 'Megan', 'Boyer', '0000-00-00 00:00:00', 0, 0),
(82, 'Imelda', 'Forbes', '0000-00-00 00:00:00', 0, 0),
(83, 'Anastasia', 'Goodman', '0000-00-00 00:00:00', 0, 0),
(84, 'Demetria', 'Giles', '0000-00-00 00:00:00', 0, 0),
(85, 'Alika', 'Dorsey', '0000-00-00 00:00:00', 0, 0),
(86, 'Marvin', 'Rojas', '0000-00-00 00:00:00', 0, 0),
(87, 'Quinlan', 'Parker', '0000-00-00 00:00:00', 0, 0),
(88, 'Tashya', 'Marks', '0000-00-00 00:00:00', 0, 0),
(89, 'Inez', 'Leblanc', '0000-00-00 00:00:00', 0, 0),
(90, 'Veda', 'Oneal', '0000-00-00 00:00:00', 0, 0),
(91, 'Mason', 'Nelson', '0000-00-00 00:00:00', 0, 0),
(92, 'Keegan', 'Brock', '0000-00-00 00:00:00', 0, 0),
(93, 'Beau', 'Adkins', '0000-00-00 00:00:00', 0, 0),
(94, 'Kamal', 'Hodges', '0000-00-00 00:00:00', 0, 0),
(95, 'Britanni', 'Hall', '0000-00-00 00:00:00', 0, 0),
(96, 'Hedy', 'Page', '0000-00-00 00:00:00', 0, 0),
(97, 'Omar', 'Pace', '0000-00-00 00:00:00', 0, 0),
(98, 'Mufutau', 'Blair', '0000-00-00 00:00:00', 0, 0),
(99, 'Neil', 'Pierce', '0000-00-00 00:00:00', 0, 0),
(100, 'Mary', 'Williams', '0000-00-00 00:00:00', 0, 0),
(101, 'Sylvia', 'Klein', '0000-00-00 00:00:00', 0, 0),
(102, 'August', 'Fry', '0000-00-00 00:00:00', 0, 0),
(103, 'Jackson', 'Kidd', '0000-00-00 00:00:00', 0, 0),
(104, 'Keely', 'Chen', '0000-00-00 00:00:00', 0, 0),
(105, 'Dai', 'Thornton', '0000-00-00 00:00:00', 0, 0),
(106, 'Carl', 'Burt', '0000-00-00 00:00:00', 0, 0),
(107, 'Hollee', 'Day', '0000-00-00 00:00:00', 0, 0),
(108, 'Alexander', 'Bishop', '0000-00-00 00:00:00', 0, 0),
(109, 'Hyatt', 'Goodwin', '0000-00-00 00:00:00', 0, 0),
(110, 'Kennedy', 'French', '0000-00-00 00:00:00', 0, 0),
(111, 'Nathaniel', 'Wells', '0000-00-00 00:00:00', 0, 0),
(112, 'Travis', 'Barnes', '0000-00-00 00:00:00', 0, 0),
(113, 'Wesley', 'Hickman', '0000-00-00 00:00:00', 0, 0),
(114, 'Risa', 'Hutchinson', '0000-00-00 00:00:00', 0, 0),
(115, 'Alden', 'Barrett', '0000-00-00 00:00:00', 0, 0),
(116, 'Declan', 'Gallagher', '0000-00-00 00:00:00', 0, 0),
(117, 'Megan', 'Kent', '0000-00-00 00:00:00', 0, 0),
(118, 'Venus', 'Anderson', '0000-00-00 00:00:00', 0, 0),
(119, 'Marsden', 'Puckett', '0000-00-00 00:00:00', 0, 0),
(120, 'Rajah', 'Cruz', '0000-00-00 00:00:00', 0, 0),
(121, 'Zane', 'Rodgers', '0000-00-00 00:00:00', 0, 0),
(122, 'Joseph', 'Long', '0000-00-00 00:00:00', 0, 0),
(123, 'Whilemina', 'Burnett', '0000-00-00 00:00:00', 0, 0),
(124, 'Jael', 'Cantrell', '0000-00-00 00:00:00', 0, 0),
(125, 'Gary', 'Weiss', '0000-00-00 00:00:00', 0, 0),
(126, 'Buffy', 'Reid', '0000-00-00 00:00:00', 0, 0),
(127, 'Hoyt', 'Acevedo', '0000-00-00 00:00:00', 0, 0),
(128, 'Felix', 'Thomas', '0000-00-00 00:00:00', 0, 0),
(129, 'Aristotle', 'Emerson', '0000-00-00 00:00:00', 0, 0),
(130, 'Fredericka', 'Mcmahon', '0000-00-00 00:00:00', 0, 0),
(131, 'Barry', 'Garza', '0000-00-00 00:00:00', 0, 0),
(132, 'Virginia', 'Mullen', '0000-00-00 00:00:00', 0, 0),
(133, 'William', 'Bean', '0000-00-00 00:00:00', 0, 0),
(134, 'Shana', 'Fox', '0000-00-00 00:00:00', 0, 0),
(135, 'Cleo', 'Elliott', '0000-00-00 00:00:00', 0, 0),
(136, 'Mannix', 'Stanley', '0000-00-00 00:00:00', 0, 0),
(137, 'Wesley', 'Heath', '0000-00-00 00:00:00', 0, 0),
(138, 'Malcolm', 'Daugherty', '0000-00-00 00:00:00', 0, 0),
(139, 'Yardley', 'Clemons', '0000-00-00 00:00:00', 0, 0),
(140, 'Nora', 'Gallagher', '0000-00-00 00:00:00', 0, 0),
(141, 'Justin', 'Mccarty', '0000-00-00 00:00:00', 0, 0),
(142, 'Kai', 'George', '0000-00-00 00:00:00', 0, 0),
(143, 'Daniel', 'Buck', '0000-00-00 00:00:00', 0, 0),
(144, 'Mira', 'Cain', '0000-00-00 00:00:00', 0, 0),
(145, 'Robert', 'Fuller', '0000-00-00 00:00:00', 0, 0),
(146, 'Abraham', 'Keith', '0000-00-00 00:00:00', 0, 0),
(147, 'Ezekiel', 'Bailey', '0000-00-00 00:00:00', 0, 0),
(148, 'Florence', 'Baldwin', '0000-00-00 00:00:00', 0, 0),
(149, 'Hammett', 'Marquez', '0000-00-00 00:00:00', 0, 0),
(150, 'Kareem', 'Reed', '0000-00-00 00:00:00', 0, 0),
(151, 'Martina', 'Mercer', '0000-00-00 00:00:00', 0, 0),
(152, 'Camille', 'Cleveland', '0000-00-00 00:00:00', 0, 0),
(153, 'Flavia', 'Williamson', '0000-00-00 00:00:00', 0, 0),
(154, 'Jolie', 'Cook', '0000-00-00 00:00:00', 0, 0),
(155, 'Bertha', 'Parsons', '0000-00-00 00:00:00', 0, 0),
(156, 'Raphael', 'Holcomb', '0000-00-00 00:00:00', 0, 0),
(157, 'Nero', 'Salazar', '0000-00-00 00:00:00', 0, 0),
(158, 'Darrel', 'Ballard', '0000-00-00 00:00:00', 0, 0),
(159, 'Xenos', 'Berger', '0000-00-00 00:00:00', 0, 0),
(160, 'Keefe', 'Buck', '0000-00-00 00:00:00', 0, 0),
(161, 'Cally', 'Brady', '0000-00-00 00:00:00', 0, 0),
(162, 'Brooke', 'Burris', '0000-00-00 00:00:00', 0, 0),
(163, 'Clio', 'Boyer', '0000-00-00 00:00:00', 0, 0),
(164, 'Christen', 'Greene', '0000-00-00 00:00:00', 0, 0),
(165, 'Owen', 'Massey', '0000-00-00 00:00:00', 0, 0),
(166, 'Wang', 'Leon', '0000-00-00 00:00:00', 0, 0),
(167, 'Marsden', 'Evans', '0000-00-00 00:00:00', 0, 0),
(168, 'Joel', 'Ray', '0000-00-00 00:00:00', 0, 0),
(169, 'Oren', 'Alford', '0000-00-00 00:00:00', 0, 0),
(170, 'Bree', 'Gentry', '0000-00-00 00:00:00', 0, 0),
(171, 'Cynthia', 'Martin', '0000-00-00 00:00:00', 0, 0),
(172, 'Aristotle', 'Price', '0000-00-00 00:00:00', 0, 0),
(173, 'Jackson', 'Stephens', '0000-00-00 00:00:00', 0, 0),
(174, 'Ori', 'Wynn', '0000-00-00 00:00:00', 0, 0),
(175, 'Eagan', 'Guerrero', '0000-00-00 00:00:00', 0, 0),
(176, 'Gillian', 'Holland', '0000-00-00 00:00:00', 0, 0),
(177, 'Emerson', 'Vazquez', '0000-00-00 00:00:00', 0, 0),
(178, 'Fredericka', 'Velez', '0000-00-00 00:00:00', 0, 0),
(179, 'Lewis', 'Wright', '0000-00-00 00:00:00', 0, 0),
(180, 'Wing', 'Fields', '0000-00-00 00:00:00', 0, 0),
(181, 'Hanna', 'Beach', '0000-00-00 00:00:00', 0, 0),
(182, 'Myles', 'Gordon', '0000-00-00 00:00:00', 0, 0),
(183, 'Irma', 'Lee', '0000-00-00 00:00:00', 0, 0),
(184, 'Abdul', 'Rogers', '0000-00-00 00:00:00', 0, 0),
(185, 'Kyle', 'Holden', '0000-00-00 00:00:00', 0, 0),
(186, 'Selma', 'Peters', '0000-00-00 00:00:00', 0, 0),
(187, 'Dominic', 'Golden', '0000-00-00 00:00:00', 0, 0),
(188, 'Neville', 'Hill', '0000-00-00 00:00:00', 0, 0),
(189, 'Barbara', 'Sparks', '0000-00-00 00:00:00', 0, 0),
(190, 'Rebekah', 'Hanson', '0000-00-00 00:00:00', 0, 0),
(191, 'Anjolie', 'Rush', '0000-00-00 00:00:00', 0, 0),
(192, 'Curran', 'Haynes', '0000-00-00 00:00:00', 0, 0),
(193, 'Emi', 'Lamb', '0000-00-00 00:00:00', 0, 0),
(194, 'Judith', 'Oneil', '0000-00-00 00:00:00', 0, 0),
(195, 'Kiara', 'Maldonado', '0000-00-00 00:00:00', 0, 0),
(196, 'Phoebe', 'Sloan', '0000-00-00 00:00:00', 0, 0),
(197, 'Ruby', 'Collier', '0000-00-00 00:00:00', 0, 0),
(198, 'Camille', 'Hanson', '0000-00-00 00:00:00', 0, 0),
(199, 'Otto', 'Campbell', '0000-00-00 00:00:00', 0, 0),
(200, 'William', 'Byrd', '0000-00-00 00:00:00', 0, 0),
(201, 'Mechelle', 'Todd', '0000-00-00 00:00:00', 0, 0),
(202, 'Emery', 'Reyes', '0000-00-00 00:00:00', 0, 0),
(203, 'Amity', 'Conway', '0000-00-00 00:00:00', 0, 0),
(204, 'Xanthus', 'Gilmore', '0000-00-00 00:00:00', 0, 0),
(205, 'Harriet', 'Craft', '0000-00-00 00:00:00', 0, 0),
(206, 'Angela', 'Sherman', '0000-00-00 00:00:00', 0, 0),
(207, 'Jaime', 'Murray', '0000-00-00 00:00:00', 0, 0),
(208, 'Urielle', 'Frazier', '0000-00-00 00:00:00', 0, 0),
(209, 'Francesca', 'Reynolds', '0000-00-00 00:00:00', 0, 0),
(210, 'Murphy', 'Conner', '0000-00-00 00:00:00', 0, 0),
(211, 'Chanda', 'Shepard', '0000-00-00 00:00:00', 0, 0),
(212, 'Wylie', 'Knapp', '0000-00-00 00:00:00', 0, 0),
(213, 'Josephine', 'Buckley', '0000-00-00 00:00:00', 0, 0),
(214, 'Mollie', 'Shepard', '0000-00-00 00:00:00', 0, 0),
(215, 'Astra', 'Olson', '0000-00-00 00:00:00', 0, 0),
(216, 'Asher', 'Albert', '0000-00-00 00:00:00', 0, 0),
(217, 'Chandler', 'Harris', '0000-00-00 00:00:00', 0, 0),
(218, 'Ryan', 'Humphrey', '0000-00-00 00:00:00', 0, 0),
(219, 'Adara', 'Richardson', '0000-00-00 00:00:00', 0, 0),
(220, 'Quynn', 'Madden', '0000-00-00 00:00:00', 0, 0),
(221, 'Brett', 'Ryan', '0000-00-00 00:00:00', 0, 0),
(222, 'Jessica', 'Ratliff', '0000-00-00 00:00:00', 0, 0),
(223, 'Nichole', 'England', '0000-00-00 00:00:00', 0, 0),
(224, 'Octavius', 'Whitaker', '0000-00-00 00:00:00', 0, 0),
(225, 'Lucius', 'Mcguire', '0000-00-00 00:00:00', 0, 0),
(226, 'Elizabeth', 'Joseph', '0000-00-00 00:00:00', 0, 0),
(227, 'Stacy', 'Gray', '0000-00-00 00:00:00', 0, 0),
(228, 'Germane', 'Gilmore', '0000-00-00 00:00:00', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `Hid` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Country` varchar(40) NOT NULL,
  `City` varchar(40) NOT NULL,
  `Rooms` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`Hid`, `Name`, `Country`, `City`, `Rooms`) VALUES
(1, 'The Swayne', 'Netherlands', 'Amsterdam', 70),
(2, 'The Duggans', 'Ireland', 'Galway', 50),
(3, 'The McDonaghs', 'Iceland', 'Reykjavik', 25),
(4, 'The Taddeis', 'Italy', 'Rome', 150),
(5, 'The Marczaks', 'Japan', 'Kyoto', 200),
(6, 'Azure Hotel', 'Germany', 'Berlin', 120),
(7, 'Sapphire Hotel', 'England', 'London', 300),
(8, 'Bronze Motel', 'France', 'Lyon', 80),
(9, 'Stellar Hotel', 'Spain', 'Barcelona', 110),
(10, 'Atlantic Hotel', 'Portugal', 'Lisbon', 60),
(11, 'Drizzle Hotel', 'USA', 'New York', 500);

-- --------------------------------------------------------

--
-- Table structure for table `logins`
--

CREATE TABLE `logins` (
  `Lid` int(11) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `LoginTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `LogoutTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `TotalTime` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logins`
--

INSERT INTO `logins` (`Lid`, `FirstName`, `LastName`, `LoginTime`, `LogoutTime`, `TotalTime`) VALUES
(15, 'Ian', 'Duggan', '2019-11-20 21:37:41', '2019-11-20 21:37:41', 0);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `Pid` int(11) NOT NULL,
  `IsPaid` tinyint(1) NOT NULL,
  `TotalPrice` int(11) NOT NULL,
  `Bid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `Rid` int(11) NOT NULL,
  `Rnumber` int(11) NOT NULL,
  `Type` varchar(40) NOT NULL,
  `available` tinyint(1) DEFAULT 1,
  `Price` int(11) DEFAULT 0,
  `Hid` int(11) NOT NULL,
  `Bid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`Rid`, `Rnumber`, `Type`, `available`, `Price`, `Hid`, `Bid`) VALUES
(1, 1, 'Single', NULL, 50, 1, NULL),
(2, 2, 'Double', 1, 100, 1, NULL),
(3, 3, 'King', 1, 150, 1, NULL),
(4, 1, 'Single', 1, 50, 2, NULL),
(5, 2, 'Double', 1, 100, 2, NULL),
(6, 3, 'King', 1, 150, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Uid` int(11) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `ManagementLevel` int(11) NOT NULL,
  `Password` varchar(40) NOT NULL,
  `Wages` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Uid`, `FirstName`, `LastName`, `ManagementLevel`, `Password`, `Wages`) VALUES
(1, 'Caolan', 'McDonagh', 1, 'nana', 100000),
(2, 'Ian', 'Duggan', 2, 'devops', 20000),
(3, 'Adam', 'Swayne', 1, 'Apple1', 50000),
(4, 'Sabina', 'Taddei', 3, 'MIA', 35000),
(5, 'Patryk', 'Marczak', 2, 'easy', 40000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`Bid`),
  ADD KEY `Gid` (`Gid`);

--
-- Indexes for table `guests`
--
ALTER TABLE `guests`
  ADD PRIMARY KEY (`Gid`);

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`Hid`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`Pid`),
  ADD KEY `Bid` (`Bid`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`Rid`),
  ADD KEY `Hid` (`Hid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `Bid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `guests`
--
ALTER TABLE `guests`
  MODIFY `Gid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=229;

--
-- AUTO_INCREMENT for table `hotels`
--
ALTER TABLE `hotels`
  MODIFY `Hid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `Pid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `Rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`Gid`) REFERENCES `guests` (`Gid`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`Bid`) REFERENCES `bookings` (`Bid`);

--
-- Constraints for table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`Hid`) REFERENCES `hotels` (`Hid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
