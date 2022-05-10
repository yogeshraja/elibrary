-- MySQL dump 10.13  Distrib 8.0.29, for macos12.2 (arm64)
--
-- Host: localhost    Database: elibrary
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `uid` int NOT NULL,
  PRIMARY KEY (`aid`),
  KEY `FKqbfm5opfqjhdc338q6vmtyphc` (`uid`),
  CONSTRAINT `FKqbfm5opfqjhdc338q6vmtyphc` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_USER','yogesh',1),(2,'ROLE_ADMIN','admin',2);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorityid_generator`
--

DROP TABLE IF EXISTS `authorityid_generator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorityid_generator` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorityid_generator`
--

LOCK TABLES `authorityid_generator` WRITE;
/*!40000 ALTER TABLE `authorityid_generator` DISABLE KEYS */;
INSERT INTO `authorityid_generator` VALUES (1);
/*!40000 ALTER TABLE `authorityid_generator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_id_generator`
--

DROP TABLE IF EXISTS `book_id_generator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_id_generator` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_id_generator`
--

LOCK TABLES `book_id_generator` WRITE;
/*!40000 ALTER TABLE `book_id_generator` DISABLE KEYS */;
INSERT INTO `book_id_generator` VALUES (37);
/*!40000 ALTER TABLE `book_id_generator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `bid` int NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `pages` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (20,'Andrew Davison','/Users/yogeshwaran.rajendra/Documents/elibrary/books//killer game programming91097666-6484-49fb-8453-8be12f30f385.fileDB',998,'killer game programming',2005),(21,'John Horton','/Users/yogeshwaran.rajendra/Documents/elibrary/books//learning java by building android games879d8593-f98d-4504-8917-9b97a71faeaf.fileDB',392,'learning java by building android games',2015),(22,'Kathy Sierra Bert Bates','/Users/yogeshwaran.rajendra/Documents/elibrary/books//SCJP Sun Certified Programmer for Java 65de246c5-b700-495b-a436-eef2cd934c8f.fileDB',890,'SCJP Sun Certified Programmer for Java 6',2008),(23,'Noel Kalicharan','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Advanced Topics in Java698416fe-6a16-455b-a7b2-954b6010c0ea.fileDB',323,'Advanced Topics in Java',2013),(25,'STEVE LOUGHRAN ERIK HATCHER','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Ant, In Action8034ce6e-5bca-4d20-81d9-346c20589dfc.fileDB',600,'Ant, In Action',2007),(26,'Phillip A. Laplante,Colin J. Neill','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Antipatterns1c77cf94-7b41-4f50-a639-7937f2ec5eef.fileDB',333,'Antipatterns',2006),(27,'STEVE LOUGHRAN ERIK HATCHER','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Ant, In Action1140d1c9-65ee-4356-82e5-c616c2e0d09e.fileDB',600,'Ant, In Action',2007),(28,'Seirra,Kates','/Users/yogeshwaran.rajendra/Documents/elibrary/books//OCA OCP Java SE 7 Programmer I & II Study Guidecab32bb2-489a-434f-8318-ef5cf19e0f58.fileDB',1094,'OCA OCP Java SE 7 Programmer I & II Study Guide',2015),(29,'Dave Minter','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Beginning Spring 20778dad7-90ec-4717-8345-b46cef8fe68b.fileDB',298,'Beginning Spring 2',2008),(30,'Joseph Faisal','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Beginning JBoss Seama78fee1d-e715-4c18-8128-9c36ff631ca4.fileDB',751,'Beginning JBoss Seam',2007),(31,'Graeme,Keith','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Definite Guide to Grailsbebbe87f-be1e-402b-9277-b313d1a8deaa.fileDB',383,'Definite Guide to Grails',2006),(32,'David,Heffelfinger2007','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Java EE 5 with Glassfish Application Server1f54f21b-ecbc-4af7-95f3-7f3811827fbd.fileDB',421,'Java EE 5 with Glassfish Application Server',2006),(33,'Mitchell,Waite','/Users/yogeshwaran.rajendra/Documents/elibrary1/books//Data_Structures_and_Algorithms_in_Javab0db3018-0bc2-4583-aebe-c66675484867.fileDB',526,'Data_Structures_and_Algorithms_in_Java',1998),(35,'Daniel,Selman','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Java 3D Programminge3b3373a-0bc8-4d71-899e-0ca3e4ecbfb9.fileDB',352,'Java 3D Programming',2002),(36,'Richard,Monson','/Users/yogeshwaran.rajendra/Documents/elibrary/books//Java Message Service1dcef33f-eafb-4adb-915f-15a0c85a5c6d.fileDB',184,'Java Message Service',2001);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userid_generator`
--

DROP TABLE IF EXISTS `userid_generator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userid_generator` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userid_generator`
--

LOCK TABLES `userid_generator` WRITE;
/*!40000 ALTER TABLE `userid_generator` DISABLE KEYS */;
INSERT INTO `userid_generator` VALUES (1);
/*!40000 ALTER TABLE `userid_generator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '','yogesh','yogesh'),(2,_binary '','admin','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_authorities`
--

DROP TABLE IF EXISTS `users_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_authorities` (
  `user_uid` int NOT NULL,
  `authorities_aid` int NOT NULL,
  UNIQUE KEY `UK_3iomlq2twy84mqnp8goww73oy` (`authorities_aid`),
  KEY `FKgqd48nyqc2bbi2to28bklf6gi` (`user_uid`),
  CONSTRAINT `FKf6lb6mnyxnx0utivkuarxjibo` FOREIGN KEY (`authorities_aid`) REFERENCES `authorities` (`aid`),
  CONSTRAINT `FKgqd48nyqc2bbi2to28bklf6gi` FOREIGN KEY (`user_uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_authorities`
--

LOCK TABLES `users_authorities` WRITE;
/*!40000 ALTER TABLE `users_authorities` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_authorities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-10 13:27:38
