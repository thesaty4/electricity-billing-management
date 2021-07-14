-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2021 at 06:26 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `billing`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `month` varchar(20) NOT NULL,
  `units` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `meterno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`month`, `units`, `amount`, `meterno`) VALUES
('January', 1, 307, 1),
('Febuary', 11, 377, 1),
('April', 33, 531, 1),
('July', 11, 377, 1),
('August', 11, 377, 1),
('March', 12, 384, 3),
('June', 22, 454, 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `name` varchar(50) NOT NULL,
  `meterno` int(11) NOT NULL,
  `address` varchar(55) NOT NULL,
  `state` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `email` varchar(55) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`name`, `meterno`, `address`, `state`, `city`, `email`, `phone`) VALUES
('satya mishra', 1, 'sant kabir nagar', 'uttar pradesh', 'khalilabad', 'satyamishra559@gmail.com', '9120829055'),
('irshad ahmad', 2, 'pdn', 'uttar pradesh', 'pdn', 'example.com', '4567890111'),
('md.asif', 3, 'gorakhpur', 'up', 'gorakhpur', 'mdasif@gmail.com', '2345678901');

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE `login_info` (
  `usr` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `mobile` varchar(14) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_info`
--

INSERT INTO `login_info` (`usr`, `name`, `gender`, `email`, `address`, `mobile`, `passwd`) VALUES
('irshad', 'irshad', 'male', 'irshad@example.com', 'address', '1234567890', '123'),
('thesatya', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tax`
--

CREATE TABLE `tax` (
  `meter_location` varchar(20) DEFAULT NULL,
  `meter_type` varchar(20) DEFAULT NULL,
  `phase_code` int(11) DEFAULT NULL,
  `bill_type` varchar(30) DEFAULT NULL,
  `month` int(11) NOT NULL,
  `meter_rent` int(11) DEFAULT NULL,
  `service_rent` int(11) DEFAULT NULL,
  `gst` int(11) DEFAULT NULL,
  `mcb_rent` int(11) DEFAULT NULL,
  `division_name` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD KEY `meterno` (`meterno`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`meterno`);

--
-- Indexes for table `login_info`
--
ALTER TABLE `login_info`
  ADD UNIQUE KEY `usr` (`usr`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `meterno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`meterno`) REFERENCES `customer_info` (`meterno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
