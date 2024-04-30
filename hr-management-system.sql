-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2024 at 09:58 AM
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
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, 'Human Resources'),
(2, 'Finance'),
(3, 'IT');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `department_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `email`, `address`, `department_id`) VALUES
(1, 'John Doe', 'john.doe@example.com', '123 Main St', 1),
(2, 'Jane Smith', 'jane.smith@example.com', '456 Oak St', 1),
(3, 'Mike Johnson', 'mike.johnson@example.com', '789 Elm St', 2),
(4, 'Emily Brown', 'emily.brown@example.com', '101 Pine St', 3);

-- --------------------------------------------------------

--
-- Table structure for table `expenseclaim`
--

CREATE TABLE `expenseclaim` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `description` text DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expenseclaim`
--

INSERT INTO `expenseclaim` (`id`, `date`, `description`, `total`, `status`, `employee_id`) VALUES
(1, '2024-04-01', 'Travel expenses for conference', 500.00, 'Submitted', 1),
(2, '2024-04-02', 'Office supplies for department', 200.00, 'Approved', 3);

-- --------------------------------------------------------

--
-- Table structure for table `expenseclaimentry`
--

CREATE TABLE `expenseclaimentry` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `expense_type_id` int(11) DEFAULT NULL,
  `expense_claim_id` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expenseclaimentry`
--

INSERT INTO `expenseclaimentry` (`id`, `date`, `expense_type_id`, `expense_claim_id`, `description`, `total`) VALUES
(1, '2024-04-01', 1, 1, 'Flight ticket', 300.00),
(2, '2024-04-01', 2, 1, 'Hotel accommodation', 200.00),
(3, '2024-04-02', 2, 2, 'Printer ink cartridges', 100.00),
(4, '2024-04-02', 3, 2, 'Team lunch', 100.00);

-- --------------------------------------------------------

--
-- Table structure for table `expensetype`
--

CREATE TABLE `expensetype` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expensetype`
--

INSERT INTO `expensetype` (`id`, `name`) VALUES
(1, 'Travel'),
(2, 'Office Supplies'),
(3, 'Entertainment');

-- --------------------------------------------------------

--
-- Table structure for table `leaves`
--

CREATE TABLE `leaves` (
  `id` int(11) NOT NULL,
  `leave_type_id` int(11) DEFAULT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `number_of_days` int(11) NOT NULL,
  `note` text DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leaves`
--

INSERT INTO `leaves` (`id`, `leave_type_id`, `from_date`, `to_date`, `number_of_days`, `note`, `employee_id`) VALUES
(1, 1, '2024-05-01', '2024-05-03', 3, 'Vacation trip', 2),
(2, 2, '2024-04-10', '2024-04-11', 2, 'Sick with flu', 3);

-- --------------------------------------------------------

--
-- Table structure for table `leavetype`
--

CREATE TABLE `leavetype` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leavetype`
--

INSERT INTO `leavetype` (`id`, `name`) VALUES
(1, 'Vacation'),
(2, 'Sick Leave'),
(3, 'Maternity Leave');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `expenseclaim`
--
ALTER TABLE `expenseclaim`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `expenseclaimentry`
--
ALTER TABLE `expenseclaimentry`
  ADD PRIMARY KEY (`id`),
  ADD KEY `expense_type_id` (`expense_type_id`),
  ADD KEY `expense_claim_id` (`expense_claim_id`);

--
-- Indexes for table `expensetype`
--
ALTER TABLE `expensetype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `leaves`
--
ALTER TABLE `leaves`
  ADD PRIMARY KEY (`id`),
  ADD KEY `leave_type_id` (`leave_type_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `leavetype`
--
ALTER TABLE `leavetype`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `expenseclaim`
--
ALTER TABLE `expenseclaim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `expenseclaimentry`
--
ALTER TABLE `expenseclaimentry`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `expensetype`
--
ALTER TABLE `expensetype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `leaves`
--
ALTER TABLE `leaves`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `leavetype`
--
ALTER TABLE `leavetype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `expenseclaim`
--
ALTER TABLE `expenseclaim`
  ADD CONSTRAINT `expenseclaim_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `expenseclaimentry`
--
ALTER TABLE `expenseclaimentry`
  ADD CONSTRAINT `expenseclaimentry_ibfk_1` FOREIGN KEY (`expense_type_id`) REFERENCES `expensetype` (`id`),
  ADD CONSTRAINT `expenseclaimentry_ibfk_2` FOREIGN KEY (`expense_claim_id`) REFERENCES `expenseclaim` (`id`);

--
-- Constraints for table `leaves`
--
ALTER TABLE `leaves`
  ADD CONSTRAINT `leaves_ibfk_1` FOREIGN KEY (`leave_type_id`) REFERENCES `leavetype` (`id`),
  ADD CONSTRAINT `leaves_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
