/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.5.2-MariaDB, for osx10.19 (arm64)
--
-- Host: localhost    Database: RentaCar
-- ------------------------------------------------------
-- Server version	11.5.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `car_information`
--

DROP TABLE IF EXISTS `car_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `transmission_type` varchar(100) DEFAULT NULL,
  `fuel_type` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_information`
--

LOCK TABLES `car_information` WRITE;
/*!40000 ALTER TABLE `car_information` DISABLE KEYS */;
INSERT INTO `car_information` VALUES
(1,'Q2','Audi','Manuel','Diesel',145,'./images/Audi Q2.png'),
(13,'208','Peugeot','Automatic','Gas',95,'./images/Peugeot 208.png'),
(14,'Polo','Volkswagen','Automatic','Diesel',105,'./images/Volswagen Polo.png'),
(15,'Puma','Ford','Automatic','Diesel',115,'./images/Ford Puma.png'),
(16,'S60','Volvo','Automatic','Diesel',115,'./images/Volvo S60.png'),
(17,'A3','Audi','Automatic','Gas',120,'./images/Audi A3.png'),
(18,'GLA','Mercedes','Manuel','Gas',120,'./images/Mercedes GLA.png'),
(19,'T-Roc','Volkswagen','Manuel','Gas',110,'./images/Volkswagen T-Roc.png'),
(20,'MultiVan','Volkswagen','Manuel','Gas',130,'./images/Volkswagen MultiVan.png'),
(21,'CLA','Mercedes','Automatic','Gas',120,'./images/Mercedes CLA.png');
/*!40000 ALTER TABLE `car_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `protection_plans`
--

DROP TABLE IF EXISTS `protection_plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `protection_plans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_type` varchar(50) DEFAULT NULL,
  `collision_damage_protection` tinyint(1) DEFAULT NULL,
  `windscreen_glass_tyres_protection` tinyint(1) DEFAULT NULL,
  `key_and_licence_assurance` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protection_plans`
--

LOCK TABLES `protection_plans` WRITE;
/*!40000 ALTER TABLE `protection_plans` DISABLE KEYS */;
INSERT INTO `protection_plans` VALUES
(1,'Basic',1,0,0,0),
(2,'Standard',1,1,0,25),
(3,'Premium',1,1,1,52);
/*!40000 ALTER TABLE `protection_plans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_information`
--

DROP TABLE IF EXISTS `reservation_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_information` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `protection_id` int(11) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `pick_up_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `user_id` (`user_id`),
  KEY `car_id` (`car_id`),
  KEY `protection_id` (`protection_id`),
  CONSTRAINT `reservation_information_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_information` (`id`),
  CONSTRAINT `reservation_information_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car_information` (`id`),
  CONSTRAINT `reservation_information_ibfk_3` FOREIGN KEY (`protection_id`) REFERENCES `protection_plans` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_information`
--

LOCK TABLES `reservation_information` WRITE;
/*!40000 ALTER TABLE `reservation_information` DISABLE KEYS */;
INSERT INTO `reservation_information` VALUES
(1,5,1,2,'Berlin','2024-11-28','2024-12-02',200),
(2,5,13,3,'Paris','2024-12-10','2024-12-12',441),
(9,5,19,2,'Istanbul','2024-12-12','2024-12-14',405),
(18,37,21,2,'Berlin','2025-01-14','2025-01-16',435),
(22,37,13,1,'Berlin','2025-01-15','2025-01-17',285);
/*!40000 ALTER TABLE `reservation_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
INSERT INTO `user_information` VALUES
(5,'eylul','pwd'),
(37,'iu','computer');
/*!40000 ALTER TABLE `user_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2024-12-10 22:57:20
