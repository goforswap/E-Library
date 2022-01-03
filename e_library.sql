-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: e_library
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `branch_subject`
--

DROP TABLE IF EXISTS `branch_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch_subject` (
  `branch_name` varchar(150) DEFAULT NULL,
  `subject_name` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch_subject`
--

LOCK TABLES `branch_subject` WRITE;
/*!40000 ALTER TABLE `branch_subject` DISABLE KEYS */;
INSERT INTO `branch_subject` VALUES ('Computer Science and Engineering','Object Oriented Programming'),('Computer Science and Engineering','Data Structure and Algorithms'),('Computer Science and Engineering','Analysis and Design of Algorithms'),('Information Technology','Computer Peripherals and Interfaces'),('Information Technology','Data Communication'),('Information Technology','Computer Networks'),('Electrical Engineering','Digital Logic and Circuit Design'),('Electrical Engineering','Circuit Theory'),('Electrical Engineering','Electromagnetic Field Theory'),('Mechanical Engineering','Engineering Thermodynamics'),('Mechanical Engineering','Fluid Mechanics'),('Mechanical Engineering','Introduction to CAD and Solid Modelling'),('Civil Engineering','Construction Material and Construction Technology'),('Civil Engineering','Concrete Technology and Advanced Construction Material'),('Civil Engineering','Structural Mechanics');
/*!40000 ALTER TABLE `branch_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `name` varchar(150) DEFAULT NULL,
  `uname` varchar(150) NOT NULL,
  `pass` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('Admin1','admin1@gmail.com','48bvsy1o'),('Admin2','admin2@gmail.com','t472isb9'),('Admin3','admin3@gmail.com','6wd95qmn'),('Ajinkya Yogi','ajinkygi@gmail.com','a607e11e'),('Divya Vig','divyaig@gmail.com','408f4723'),('Kushal Bhargava','kushalva@gmail.com','c4f620e4'),('Mukti Mathew','muktihew@gmail.com','b7b91e10'),('Sabina Hetan Khurana','sabina@gmail.com','b7657be6'),('Teena Chaudhary','teenary@gmail.com','1bd2b472'),('Umesh Mander','umeshmder@gmail.com','75df1b03');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_ebook`
--

DROP TABLE IF EXISTS `subject_ebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_ebook` (
  `subject_name` varchar(150) DEFAULT NULL,
  `ebook_name` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_ebook`
--

LOCK TABLES `subject_ebook` WRITE;
/*!40000 ALTER TABLE `subject_ebook` DISABLE KEYS */;
INSERT INTO `subject_ebook` VALUES ('Object Oriented Programming','Object Oriented Programming In C++ by Robert Lafore'),('Object Oriented Programming','Object Oriented Programming With C++ by E Balagurusamy'),('Object Oriented Programming','Programming In C++ (Schaum) by John R. Hubbard'),('Data Structure and Algorithms','Data Structure Using C by E Balagurusamy'),('Data Structure and Algorithms','Data Structures And Algorithms In Java by Michael T. Goodrich'),('Data Structure and Algorithms','Data Structures Using C by Rema Thareja'),('Analysis and Design of Algorithms','Introduction To Algorithms by Thomas H. Cormen'),('Analysis and Design of Algorithms','Introduction To The Design And Analysis Of Algorithms by Anany Levitin'),('Analysis and Design of Algorithms','Computer Algorithms by Ellis Horowitz'),('Computer Peripherals and Interfaces','Newnes PC Troubleshooting Pocket Book by Howard Anderson'),('Computer Peripherals and Interfaces','PC Hardware A Beginners Guide by Ron Gilster'),('Computer Peripherals and Interfaces','Upgrading And Repairing PCs by Scott Mueller'),('Data Communication','Data And Computer Communications by William Stallings'),('Data Communication','Data Communication And Networking by Behrouz A. Forouzan'),('Data Communication','Computer Networks A Systems Approach by Larry L. Petersen'),('Computer Networks','Computer Networking A Top-Down Approach by James F. Kuroth'),('Computer Networks','Computer Networks by Andrew S. Tanenbaum'),('Computer Networks','TCP IP Protocol Suite by Beherouz A. Forouzan'),('Digital Logic and Circuit Design','Digital Logic And Computer Design by M. Morris Mano'),('Digital Logic and Circuit Design','Digital Systems Principles And Applications by Ronald J. Tocci'),('Digital Logic and Circuit Design','Fundamentals Of Digital Logic With Verilog Design by Stephen Brown'),('Circuit Theory','Network Analysis And Synthesis by Franklin F. Kuo'),('Circuit Theory','Electronics A System Approach by Neil Storey'),('Circuit Theory','Engineering Circuit Analysis by William H. Hyat'),('Electromagnetic Field Theory','Engineering Electromagnetics by William H. Hayt'),('Electromagnetic Field Theory','Schaums Outlines Of Electromagnetics by Joseph A. Edminister'),('Electromagnetic Field Theory','Principles Of Electromagnetics by Mathew N. O. Sadiku'),('Engineering Thermodynamics','Engineering Thermodynamics by P K Nag'),('Engineering Thermodynamics','Fundamentals Of Engineering Thermodynamics by Michael J. Moran'),('Engineering Thermodynamics','Fundamentals Of Thermodynamics by Claus Borgnakke'),('Fluid Mechanics','Fluid Mechanics And Hydraulic Machines by R. K. Bansal'),('Fluid Mechanics','Fluid Mechanics by Frank M. White'),('Fluid Mechanics','Fundamentals Of Fluid Mechanics by Bruce R. Munson'),('Introduction to CAD and Solid Modelling','CAD CAM CIM by P. Radhakrishnan'),('Introduction to CAD and Solid Modelling','CAD CAM Principles And Applications by P N Rao'),('Introduction to CAD and Solid Modelling','Mastering CAD CAM by Ibrahim Zeid'),('Construction Material and Construction Technology','Building Construction And Materials by Shrikant D. Bobade'),('Construction Material and Construction Technology','Building Material And Construction by Saurabh Kumar Soni'),('Construction Material and Construction Technology','Materials For Civil And Construction Engineering by Michael S. Mamlouk'),('Concrete Technology and Advanced Construction Material','Advanced Concrete Technology by Zongjin Li'),('Concrete Technology and Advanced Construction Material','Design Of Reinforced Concrete Structures by N Subramanian'),('Concrete Technology and Advanced Construction Material','Properties Of Concrete by A. M. Neville'),('Structural Mechanics','Strength Of Materials by G. H. Ryder'),('Structural Mechanics','Strength Of Materials by S. Timoshenko'),('Structural Mechanics','Structural Dynamics Theory And Computation by Mario Paz');
/*!40000 ALTER TABLE `subject_ebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_log` (
  `S_No` int NOT NULL AUTO_INCREMENT,
  `username` varchar(150) DEFAULT NULL,
  `ebook_name` varchar(150) DEFAULT NULL,
  `date` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`S_No`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_log`
--

LOCK TABLES `user_log` WRITE;
/*!40000 ALTER TABLE `user_log` DISABLE KEYS */;
INSERT INTO `user_log` VALUES (1,'umeshmder@gmail.com','Data Structure Using C by E Balagurusamy','18-05-2020 18:41:49'),(2,'muktihew@gmail.com','Fundamentals Of Engineering Thermodynamics by Michael J. Moran','18-05-2020 18:44:32'),(3,'teenary@gmail.com','Data Structures Using C by Rema Thareja','18-05-2020 18:46:53'),(4,'sabina@gmail.com','Fundamentals Of Engineering Thermodynamics by Michael J. Moran','18-05-2020 18:53:08'),(5,'muktihew@gmail.com','Data Structures Using C by Rema Thareja','18-05-2020 18:55:07'),(6,'divyaig@gmail.com','Engineering Circuit Analysis by William H. Hyat','18-05-2020 18:56:04'),(7,'sabina@gmail.com','Computer Networks A Systems Approach by Larry L. Petersen','18-05-2020 18:57:54'),(8,'kushalva@gmail.com','Data Structures And Algorithms In Java by Michael T. Goodrich','18-05-2020 18:58:42'),(9,'sabina@gmail.com','Properties Of Concrete by A. M. Neville','18-05-2020 18:59:49'),(10,'divyaig@gmail.com','Object Oriented Programming In C++ by Robert Lafore','18-05-2020 19:01:00'),(11,'kushalva@gmail.com','Computer Networks by Andrew S. Tanenbaum','18-05-2020 19:02:36'),(12,'teenary@gmail.com','Fundamentals Of Digital Logic With Verilog Design by Stephen Brown','18-05-2020 19:03:31'),(13,'divyaig@gmail.com','Strength Of Materials by S. Timoshenko','18-05-2020 19:04:36'),(14,'muktihew@gmail.com','Computer Algorithms by Ellis Horowitz','18-05-2020 19:06:04'),(15,'sabina@gmail.com','Object Oriented Programming With C++ by E Balagurusamy','18-05-2020 19:07:23'),(16,'divyaig@gmail.com','Electronics A System Approach by Neil Storey','18-05-2020 19:08:24'),(17,'kushalva@gmail.com','Data Communication And Networking by Behrouz A. Forouzan','18-05-2020 19:09:28'),(18,'teenary@gmail.com','Advanced Concrete Technology by Zongjin Li','18-05-2020 19:11:42'),(19,'umeshmder@gmail.com','CAD CAM Principles And Applications by P N Rao','18-05-2020 19:12:42'),(20,'ajinkygi@gmail.com','Programming In C++ (Schaum) by John R. Hubbard','18-05-2020 19:52:15');
/*!40000 ALTER TABLE `user_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-18 20:20:28
