-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2025 at 09:48 AM
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
-- Database: `jhay_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `id` int(10) NOT NULL,
  `uid` int(10) NOT NULL,
  `action` varchar(50) NOT NULL,
  `date_time` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(20) NOT NULL,
  `cname` varchar(60) NOT NULL,
  `pname` varchar(50) NOT NULL,
  `quant` varchar(60) NOT NULL,
  `amount` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `cname`, `pname`, `quant`, `amount`, `date`, `status`) VALUES
(1, 'jhay', 'pan', '2', '300', '3/5/25', 'Completed'),
(101, 'gjk', 'ioiuo', 'iuouio', 'ioy', 'oyuoy', 'Completed'),
(102, 'knoiyh', 'h 8', 'yiohoi', 'ypioh', 'ioyp', 'Completed'),
(103, 'jay', 'idk', 'jdhuhhf', 'gjfj', 'ihih', 'Completed');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(20) NOT NULL,
  `pname` varchar(50) NOT NULL,
  `price` varchar(30) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `status` varchar(60) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `pname`, `price`, `quantity`, `category`, `status`, `image`) VALUES
(1, 'ss', '200', '1', 'Cake', 'Available', ''),
(101, 'idk', '10', '500', 'Cake', 'Available', ''),
(102, 'bfiugw', '5', '300', 'Cake', 'Available', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_user` varchar(50) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_image` varchar(50) NOT NULL,
  `u_status` varchar(12) NOT NULL,
  `u_type` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_name`, `u_email`, `u_user`, `u_password`, `u_image`, `u_status`, `u_type`) VALUES
(15, 'osabel', 'osabel@gmail.com', 'isa', 'TPjFdtSRSioqWM8jDGPQqEuRwby23sDJU3dVC3aWWEQ=', '', 'pending', 'user '),
(16, 'hayds', 'hayde@gmail.com', 'hayds', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', '', 'active', 'admin'),
(17, 'vincent', 'vincent@gmail.com', 'vincent1', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', '', 'active', 'admin'),
(18, 'sad', 'sdasdas', 'dasdasd', 'asdadads', 'src/userimage/2.jpg', 'active', 'admin'),
(19, 'Jayson Anak. Lita', 'Benji@gmail.com', 'jayson143', '123123123', 'src/userimage/jayson.jpg', 'active', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
