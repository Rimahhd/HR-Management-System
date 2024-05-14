-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2024 at 08:27 AM
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
-- Database: `hr-management-system`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`department_id`, `department_name`) VALUES
(1, 'Engineering'),
(2, 'Human Resources'),
(3, 'Finance');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `email`, `address`, `name`, `department_id`) VALUES
(1, 'john@example.com', '123 Main St, Anytown', 'John Doe', 1),
(2, 'jane@example.com', '456 Elm St, Othertown', 'Jane Smith', 1),
(3, 'mark@example.com', '789 Oak St, Anycity', 'Mark Johnson', 1),
(4, 'sarah@example.com', '101 Pine St, Somewhere', 'Sarah Brown', 2),
(5, 'mike@example.com', '202 Maple St, Anyville', 'Mike Wilson', 3);

-- --------------------------------------------------------

--
-- Table structure for table `employee_seq`
--

CREATE TABLE `employee_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_seq`
--

INSERT INTO `employee_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `expense_claim_entity`
--

CREATE TABLE `expense_claim_entity` (
  `expense_claim_id` int(11) NOT NULL,
  `expense_claim_total` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `expense_claim_date` date DEFAULT NULL,
  `expense_claim_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expense_claim_entity`
--

INSERT INTO `expense_claim_entity` (`expense_claim_id`, `expense_claim_total`, `description`, `employee_id`, `expense_claim_date`, `expense_claim_status`) VALUES
(1, 500, 'Software Licenses', 1, '2024-04-15', 'Pending'),
(2, 300, 'Team Lunch', 2, '2024-04-20', 'Approved'),
(3, 800, 'Conference Travel', 3, '2024-05-01', 'Pending'),
(4, 200, 'Office Supplies', 4, '2024-05-05', 'Approved');

-- --------------------------------------------------------

--
-- Table structure for table `expense_claim_entry`
--

CREATE TABLE `expense_claim_entry` (
  `entry_id` int(11) NOT NULL,
  `entry_date` date DEFAULT NULL,
  `entry_description` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `expense_type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expense_claim_entry`
--

INSERT INTO `expense_claim_entry` (`entry_id`, `entry_date`, `entry_description`, `total`, `expense_type_id`) VALUES
(1, '2024-05-01', 'dfghjfgh', 1233, 1),
(2, '2024-05-22', 'wertyujk', 12333, 2);

-- --------------------------------------------------------

--
-- Table structure for table `expense_type_entity`
--

CREATE TABLE `expense_type_entity` (
  `expense_type_id` int(11) NOT NULL,
  `expense_type_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expense_type_entity`
--

INSERT INTO `expense_type_entity` (`expense_type_id`, `expense_type_name`) VALUES
(1, 'Software Licenses'),
(2, 'Team Lunch'),
(3, 'Travel'),
(4, 'Office Supplies');

-- --------------------------------------------------------

--
-- Table structure for table `leaves_entity`
--

CREATE TABLE `leaves_entity` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `to_Date` date DEFAULT NULL,
  `leave_type` varchar(255) DEFAULT NULL,
  `from_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leaves_entity`
--

INSERT INTO `leaves_entity` (`id`, `employee_id`, `to_Date`, `leave_type`, `from_date`) VALUES
(1, 1, '2024-06-01', 'Vacation', '2024-05-28'),
(2, 2, '2024-05-10', 'Sick Leave', '2024-05-08'),
(3, 3, '2024-06-15', 'Maternity Leave', '2024-04-15'),
(4, 4, '2024-05-25', 'Personal Leave', '2024-05-22');

-- --------------------------------------------------------

--
-- Table structure for table `leavetype`
--

CREATE TABLE `leavetype` (
  `id` int(11) NOT NULL,
  `leave_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leavetype`
--

INSERT INTO `leavetype` (`id`, `leave_type`) VALUES
(1, 'Vacation'),
(2, 'Sick Leave'),
(3, 'Maternity Leave'),
(4, 'Personal Leave');

-- --------------------------------------------------------

--
-- Table structure for table `leave_type`
--

CREATE TABLE `leave_type` (
  `id` int(11) NOT NULL,
  `leave_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `expense_claim_entity`
--
ALTER TABLE `expense_claim_entity`
  ADD PRIMARY KEY (`expense_claim_id`);

--
-- Indexes for table `expense_claim_entry`
--
ALTER TABLE `expense_claim_entry`
  ADD PRIMARY KEY (`entry_id`);

--
-- Indexes for table `expense_type_entity`
--
ALTER TABLE `expense_type_entity`
  ADD PRIMARY KEY (`expense_type_id`);

--
-- Indexes for table `leaves_entity`
--
ALTER TABLE `leaves_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `leavetype`
--
ALTER TABLE `leavetype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `leave_type`
--
ALTER TABLE `leave_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `department_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `expense_claim_entry`
--
ALTER TABLE `expense_claim_entry`
  MODIFY `entry_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `expense_type_entity`
--
ALTER TABLE `expense_type_entity`
  MODIFY `expense_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `leaves_entity`
--
ALTER TABLE `leaves_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`);

--
-- Constraints for table `leaves_entity`
--
ALTER TABLE `leaves_entity`
  ADD CONSTRAINT `leaves_entity_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
