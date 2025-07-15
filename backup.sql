-- MySQL dump 10.13  Distrib 8.0.41, for Linux (x86_64)
--
-- Host: localhost    Database: LMSNew
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.24.04.1

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
-- Table structure for table `Assignment`
--

DROP TABLE IF EXISTS `Assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Assignment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `assignment` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `assignmentKey` varchar(255) DEFAULT NULL,
  `module` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKuvmvpuwvikjolpv8mgo5ob3l` (`module`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Assignment`
--

LOCK TABLES `Assignment` WRITE;
/*!40000 ALTER TABLE `Assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AssignmentSubmission`
--

DROP TABLE IF EXISTS `AssignmentSubmission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AssignmentSubmission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `assignment` int DEFAULT NULL,
  `enrollment` int DEFAULT NULL,
  `submissionStatus` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnxbjys93t1o0ogst6clqtqrqp` (`assignment`),
  KEY `FKipjngy5nantna7vp3vseirq17` (`enrollment`),
  KEY `FKmjsyw2qf482647jaq4bu6de0q` (`submissionStatus`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AssignmentSubmission`
--

LOCK TABLES `AssignmentSubmission` WRITE;
/*!40000 ALTER TABLE `AssignmentSubmission` DISABLE KEYS */;
/*!40000 ALTER TABLE `AssignmentSubmission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Attendance`
--

DROP TABLE IF EXISTS `Attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isPresent` bit(1) DEFAULT NULL,
  `enrollment` int DEFAULT NULL,
  `module` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKflw1e953ur4upufx954f6dd1m` (`enrollment`),
  KEY `FK4vuxjma10aar5uvoof7c0k4s4` (`module`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attendance`
--

LOCK TABLES `Attendance` WRITE;
/*!40000 ALTER TABLE `Attendance` DISABLE KEYS */;
INSERT INTO `Attendance` VALUES (1,_binary '',2,2),(2,_binary '',2,2),(3,_binary '',2,2),(4,_binary '',4,2),(5,_binary '',4,2);
/*!40000 ALTER TABLE `Attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Batch`
--

DROP TABLE IF EXISTS `Batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Batch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `batch` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `batchStatus` int DEFAULT NULL,
  `country` int DEFAULT NULL,
  `course` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4lh0k1hs76ycoyq9dri0ja29d` (`batchStatus`),
  KEY `FKm82bi32k8d6d4kb9b3e5y0ym4` (`country`),
  KEY `FKccie81pxt0ck2kjri3vm4wn1d` (`course`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Batch`
--

LOCK TABLES `Batch` WRITE;
/*!40000 ALTER TABLE `Batch` DISABLE KEYS */;
INSERT INTO `Batch` VALUES (2,'english','lucknow','2025-03-16 07:19:21',1,3,3),(3,'lakshya','Gurugram','2025-03-17 06:03:39',1,4,2),(6,'new test','luckniow','2025-03-19 14:27:16',2,3,2);
/*!40000 ALTER TABLE `Batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BatchStatus`
--

DROP TABLE IF EXISTS `BatchStatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BatchStatus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `batchStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BatchStatus`
--

LOCK TABLES `BatchStatus` WRITE;
/*!40000 ALTER TABLE `BatchStatus` DISABLE KEYS */;
INSERT INTO `BatchStatus` VALUES (1,'Active'),(2,'Inactive');
/*!40000 ALTER TABLE `BatchStatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Country`
--

DROP TABLE IF EXISTS `Country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Country`
--

LOCK TABLES `Country` WRITE;
/*!40000 ALTER TABLE `Country` DISABLE KEYS */;
INSERT INTO `Country` VALUES (4,'UAE'),(3,'India');
/*!40000 ALTER TABLE `Country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES (2,'Course 2','lorem ipsum 123'),(3,'Sample ','sample course description'),(7,'SOGC','SOGC Class'),(6,'CCBT','CCBT Class'),(8,'CBTF','CBTF Class'),(9,'Master Training','Master Training Class');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enrollment`
--

DROP TABLE IF EXISTS `Enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Enrollment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `batch` int DEFAULT NULL,
  `student` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg0e2l19cf7f46aw70y79tfr0` (`batch`),
  KEY `FK61pxqebt44pkjcmnsc4lue72f` (`student`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enrollment`
--

LOCK TABLES `Enrollment` WRITE;
/*!40000 ALTER TABLE `Enrollment` DISABLE KEYS */;
INSERT INTO `Enrollment` VALUES (2,2,12),(3,2,1),(4,3,1),(5,2,7),(6,4,1);
/*!40000 ALTER TABLE `Enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Image`
--

DROP TABLE IF EXISTS `Image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `defaultImage` bit(1) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `fileSize` int DEFAULT NULL,
  `fileType` varchar(255) DEFAULT NULL,
  `image` longblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Image`
--

LOCK TABLES `Image` WRITE;
/*!40000 ALTER TABLE `Image` DISABLE KEYS */;
/*!40000 ALTER TABLE `Image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Module`
--

DROP TABLE IF EXISTS `Module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Module` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  `course` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1bo36yi4w6gm03urch32v7qm9` (`course`)
) ENGINE=MyISAM AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Module`
--

LOCK TABLES `Module` WRITE;
/*!40000 ALTER TABLE `Module` DISABLE KEYS */;
INSERT INTO `Module` VALUES (1,'sample topic desc','sample topic',NULL),(2,'test topic desc updated','test topic',2),(4,'hello Test','Hello test',2),(8,'Session 1  Inaguaral Session','Inaguaral Session',6),(9,'Session 2  History of Translation','History of Translation',6),(10,'Session 3 Why Bible Translation, What is translation','Why Bible Translation, What is translation',6),(11,'Session 4 Translation Theories','Translation Theories',6),(12,'Session 5 Basic Principles of Translation','Basic Principles of Translation',6),(13,'Session 6 How to study your own culture','How to study your own culture',6),(14,'Session 7 Introduction To Biblical Exegesis','Introduction To Biblical Exegesis',6),(15,'Session 8 Church Centric Bible translation Movement','Church Centric Bible translation Movement',6),(16,'Session 9 Vachan Online Introduction - BCS','Vachan Online Introduction - BCS',6),(17,'Session 10 Idioms','Idioms',6),(18,'Session 11 Bible Translation An introduction','Bible Translation An introduction',6),(19,'Session 12 Church Centric Bible Translation','Church Centric Bible Translation',6),(20,'Session 13 Figures of Speech','Figures of Speech',6),(21,'Session 14 Figures of Speech - Personification','Figures of Speech - Personification',6),(22,'Session 15 Active & Passive Expression','Active & Passive Expression',6),(23,'Session 16 Active & Passive Expression','Active & Passive Expression',6),(24,'Session 17 Event Ideas and Abstract Noun','Event Ideas and Abstract Noun',6),(25,'Session 18 Event Ideas and Abstract Noun II','Event Ideas and Abstract Noun II',6),(26,'Session 19 Rhetorical Questions - I','Rhetorical Questions - I',6),(27,'Session 20 Rhetorical Questions - II','Rhetorical Questions - II',6),(28,'Session 21 Translating Implied Information','Translating Implied Information',6),(29,'Session 22 Translating Implicit Information','Translating Implicit Information',6),(30,'Session 23 How to translate Unknown ideas','How to translate Unknown ideas',6),(31,'Session 24 Translating unknown Names - I','Translating unknown Names - I',6),(32,'Session 25 Unknown Biblical Measurements - 1','Unknown Biblical Measurements - 1',6),(33,' Unknown Biblical Measurements - 2','Unknown Biblical Measurements - 2',6),(34,' Translating Key Biblical Terms - 1','Translating Key Biblical Terms - 1',6),(35,' Translating Symbolic Actions','Translating Symbolic Actions',6),(36,' Translating Symbolic Prophecies','Translating Symbolic Prophecies',6),(37,' Translating Key Biblical Terms - 2 ','Translating Key Biblical Terms - 2 ',6),(38,' Figures of Speech - 3','Figures of Speech - 3',6),(39,' Figures of Speech - 4','Figures of Speech - 4',6),(40,' How to Translate OF Phrases - 1','How to Translate OF Phrases - 1',6),(41,' How to Translate OF Phrases - 2','How to Translate OF Phrases - 2',6),(42,' Checking and Testing your Translation - 1','Checking and Testing your Translation - 1',6),(43,' Checking and Testing your Translation - 2','Checking and Testing your Translation - 2',6),(44,' Checking and Testing your Translation - 3','Checking and Testing your Translation - 3',6),(45,' Qualifications & Training of MTTs - 1','Qualifications & Training of MTTs - 1',6),(46,' Qualification & Training of MTTs - 2','Qualification & Training of MTTs - 2',6),(47,' Translation Core Presentation','Translation Core Presentation',6),(48,' An Introduction to Paratext','An Introduction to Paratext',6),(49,' Autographa MT','Autographa MT',6),(50,' Paratext 9 - I','Paratext 9 - I',6),(51,' Paratext 9 - II','Paratext 9 - II',6),(52,' Paratext 9 - III','Paratext 9 - III',6),(53,' Basics of Computers','Basics of Computers',6),(54,' IT Basics - I','IT Basics - I',6),(55,' IT Basics - II','IT Basics - II',6),(56,' Concluding Session of 1st Academic year','Concluding Session of 1st Academic year',6),(57,' Biblical Exegesis','Biblical Exegesis',6),(58,'The Great Commission Introduction','The Great Commission Introduction',7),(59,'Understanding the Great Commission in the Light of the Big Story of the Bible Part 1 & Part 2','Understanding the Great Commission in the Light of the Big Story of the Bible Part 1 & Part 2',7),(60,'Four Fields Analogy','Four Fields Analogy',7),(61,'The Gospel Vision (Understanding the Great Commission)','The Gospel Vision (Understanding the Great Commission)',7),(62,'Gospel Preparation (Pre Evangelism)','Gospel Preparation (Pre Evangelism)',7),(63,'Gospel Exposure (Evangelism)','Gospel Exposure (Evangelism)',7),(64,'Oikos Evangelism and Personal Evangelism','Oikos Evangelism and Personal Evangelism',7),(65,'Revision of Four Fields ','Revision of Four Fields ',7),(66,'Gospel Invitation and Gospel Response','Gospel Invitation and Gospel Response',7),(67,'Objections to the Gospel Part I','Objections to the Gospel Part I',7),(68,'Objections to the Gospel Part II','Objections to the Gospel Part II',7),(69,'Discipleship Part I (Gospel Maturity)','Discipleship Part I (Gospel Maturity)',7),(70,'Discipleship Part II (Gospel Maturity)','Discipleship Part II (Gospel Maturity)',7),(71,'Church Formation Part I (Gospel Impact)','Church Formation Part I (Gospel Impact)',7),(72,'Church Formation Part II (Gospel Impact)','Church Formation Part II (Gospel Impact)',7),(73,'Gospel Multiplication and Gospel Movement','Gospel Multiplication and Gospel Movement',7),(74,'Gospel Conclusion','Gospel Conclusion',7),(75,'SOGC - Inagural Session ','SOGC - Inagural Session ',7),(76,'Introduction to the Great Commission ','Introduction to the Great Commission ',7),(77,'Great Commission in the Big Story of Bible','Great Commission in the Big Story of Bible',7),(78,'The Four Field Analogy','The Four Field Analogy',7),(79,'Gospel Vision – Great Commission','Gospel Vision – Great Commission',7),(80,'Gospel Preparation – Pre evangelism','Gospel Preparation – Pre evangelism',7),(81,'Gospel Exposure I – Message, Messenger, method','Gospel Exposure I – Message, Messenger, method',7),(82,'Gospel Exposure Part II – Personal Evangelism -1','Gospel Exposure Part II – Personal Evangelism -1',7),(83,'Gospel Exposure Part III - Personal Evangelism -2','Gospel Exposure Part III - Personal Evangelism -2',7),(84,'Gospel Objections','Gospel Objections',7),(85,'Gospel Invitation and Gospel Response','Gospel Invitation and Gospel Response',7),(86,'Gospel Maturity Part -1 Discipleship.','Gospel Maturity Part -1 Discipleship.',7),(87,'Gospel Maturity Part -2 Discipleship Part 2','Gospel Maturity Part -2 Discipleship Part 2',7),(88,'Gospel Impact – Church Formation Part -1','Gospel Impact – Church Formation Part -1',7),(89,'Gospel Impact – Church Formation Part -2','Gospel Impact – Church Formation Part -2',7),(90,'Gospel Multiplication – Leadership part 1','Gospel Multiplication – Leadership part 1',7),(91,'Gospel Multiplication – Leadership part -2 ','Gospel Multiplication – Leadership part -2 ',7),(92,'Gospel Movements – Part 1','Gospel Movements – Part 1',7),(93,'Gospel Movements – Part 2','Gospel Movements – Part 2',7),(94,'The Great Conclusion of the Great Commission.\n','The Great Conclusion of the Great Commission.\n',7),(95,'Introductory Session','Introductory Session',8),(96,'Biblical Exegesis of 2 Peter','Biblical Exegesis of 2 Peter',8),(97,'Biblical Theology - Book of Ruth','Biblical Theology - Book of Ruth',8),(98,'Church Centric Bible Translation - Hermenutics','Church Centric Bible Translation - Hermenutics',8),(99,'Biblical Theology - Book of Philippians','Biblical Theology - Book of Philippians',8),(100,'Church Centric Bible Translation - Exegesis','Church Centric Bible Translation - Exegesis',8),(101,'Biblical Theology - Gospel of Mark I','Biblical Theology - Gospel of Mark I',8),(102,'Towards Developing a Frame Work for Theological Formation','Towards Developing a Frame Work for Theological Formation',8),(103,'Biblical Theology - Gospel of Mark II','Biblical Theology - Gospel of Mark II',8),(104,'Biblical Theology - Book of Genesis Ch. 1-3','Biblical Theology - Book of Genesis Ch. 1-3',8),(105,'Church Centric Theological Formation','Church Centric Theological Formation',8),(106,'Biblical Theology - Book of Job - I','Biblical Theology - Book of Job - I',8),(107,'Biblical Theology - Book of Job - II','Biblical Theology - Book of Job - II',8),(108,'Biblical Theology - Book of Job - III','Biblical Theology - Book of Job - III',8),(109,'Biblical Theology - Book of Job - IV','Biblical Theology - Book of Job - IV',8),(110,'Biblical Theology - Book of Job - V','Biblical Theology - Book of Job - V',8),(111,'Biblical Theology - Book of Job - VI','Biblical Theology - Book of Job - VI',8),(112,'Biblical Theology - Book of Job - VII','Biblical Theology - Book of Job - VII',8),(113,'Biblical Theology - Book of Job - VIII','Biblical Theology - Book of Job - VIII',8),(114,'Church Centric Theological Formation - Genesis 1-2 (I)','Church Centric Theological Formation - Genesis 1-2 (I)',8),(115,'Church Centric Theological Formation - Genesis 1-2 (II)','Church Centric Theological Formation - Genesis 1-2 (II)',8),(116,'Church Centric Theological Formation - Genesis 3','Church Centric Theological Formation - Genesis 3',8),(117,'Biblical Theology - Book of Job Discussion & Introduction to OBS','Biblical Theology - Book of Job Discussion & Introduction to OBS',8),(118,'OBS Translation Process - I','OBS Translation Process - I',8),(119,'OBS Translation Process - II','OBS Translation Process - II',8),(120,'OBS Translation Process - III','OBS Translation Process - III',8),(121,'OBS Translation Process - IV','OBS Translation Process - IV',8),(122,'OBS - Story Fellowship - I','OBS - Story Fellowship - I',8),(123,'OBS - Story Fellowship - II','OBS - Story Fellowship - II',8),(124,'Work Plan for OBS','Work Plan for OBS',8),(125,'Quality Checking Process for OBS - I','Quality Checking Process for OBS - I',8),(126,'Quality Checking Process for OBS - II','Quality Checking Process for OBS - II',8),(127,'Quality Checking Process for OBS - III','Quality Checking Process for OBS - III',8),(128,'OBS Review & Introduction to English Learning','OBS Review & Introduction to English Learning',8),(129,'English Learning - I','English Learning - I',8),(130,'English Learning - II','English Learning - II',8),(131,'English Learning - III','English Learning - III',8),(132,'English Learning - IV','English Learning - IV',8),(133,'English Learning - V','English Learning - V',8),(134,'English Learning - VI','English Learning - VI',8),(135,'13-01-2021-Why Bible Translation - What is translation, Two types of translation','Why Bible Translation - What is translation, Two types of translation',9),(136,'Qualities of a good translation - I','Qualities of a good translation - I',9),(137,'Idioms','Idioms',9),(138,'Qualities of a good translation - II','Qualities of a good translation - II',9),(139,'Introduction to exegesis','Introduction to exegesis',9),(140,'Introductory Session (All Regions)','Introductory Session (All Regions)',9),(141,'Advance study of Idioms','Advance study of Idioms',9),(142,'Qualities of a good translation - I (combined session)','Qualities of a good translation - I (combined session)',9),(143,'Qualities of a good translation - II (combined session)','Qualities of a good translation - II (combined session)',9),(144,'Exegesis - I','Exegesis - I',9),(145,'Exegesis -II','Exegesis -II',9),(146,'Figures of speech in general','Figures of speech in general',9),(147,'Figures of speech - Synecdoche & Metonymy - For advance Learners','Figures of speech - Synecdoche & Metonymy - For advance Learners',9),(148,'How to translate OF phrases','How to translate OF phrases',9),(149,'Active and Passive Construction - I','Active and Passive Construction - I',9),(150,'Active and Passive Construction - II','Active and Passive Construction - II',9),(151,'Rhetorical Questions - I','Rhetorical Questions - I',9),(152,'Rhetorical Questions - II','Rhetorical Questions - II',9),(153,'Passive Construction','Passive Construction',9),(154,'Implied Information','Implied Information',9),(155,'Unknown Ideas - I','Unknown Ideas - I',9),(156,'Unknown Ideas - II','Unknown Ideas - II',9),(157,'How to translate Key Terms','How to translate Key Terms',9);
/*!40000 ALTER TABLE `Module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'sd650032@gmail.com','Sunny','Kumar','9625761852'),(2,'jaggur588@gmail.com','Jaggu','Ram','9805116254'),(3,'VIRENDER3106@GMAIL.COM','Virender','Singh','7807203212'),(4,'negiipawan896@gmail.com','Pawan Negi','Dev','8278723896'),(5,'kulwindernahar13@gmail.com','Kulwinder','N/A','9815236947'),(6,'ashokkumar892016@gmail.com','Ashok','Kumar','7876881793'),(7,'ankushkumar63070@gmail.com','Karam','Singh','6230032356'),(8,'raviabc1987@gmail.com','Ram','Singh','7876703845'),(9,'kr5568313@gmail.com','Khem','Raj','8580833714'),(10,'rtejsinghroy00@gmail.com','Tej','Singh','8219131484'),(11,'manpreetmasih123@gmail.com','Manpreet','Masih','9914996479'),(12,'anantkumar25071992@gmail.com','Anant','Kumar','7018283713');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubmissionStatus`
--

DROP TABLE IF EXISTS `SubmissionStatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubmissionStatus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `submissionStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubmissionStatus`
--

LOCK TABLES `SubmissionStatus` WRITE;
/*!40000 ALTER TABLE `SubmissionStatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubmissionStatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `id` int NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `personId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8ye3siwn2epoo32pg5yyj2ewf` (`personId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK7ir6hi5jr98lclgjgbyxafneu` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-24 11:39:33
