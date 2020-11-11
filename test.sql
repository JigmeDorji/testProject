-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: test_db
-- ------------------------------------------------------
-- Server version	5.5.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_company`
--

DROP TABLE IF EXISTS `tbl_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_company` (
  `companyId` int(11) NOT NULL,
  `companyName` longtext CHARACTER SET utf8 NOT NULL,
  `description` longtext CHARACTER SET utf8,
  `logo` blob,
  `logoName` varchar(100) DEFAULT NULL,
  `logoExtension` varchar(5) DEFAULT NULL,
  `status` char(1) NOT NULL,
  `isParentCompany` char(1) DEFAULT NULL,
  `createdBy` varchar(45) NOT NULL,
  `createdDate` datetime NOT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_company`
--

LOCK TABLES `tbl_company` WRITE;
/*!40000 ALTER TABLE `tbl_company` DISABLE KEYS */;
INSERT INTO `tbl_company` VALUES (1,'THimphu Techapr',NULL,NULL,NULL,NULL,'A','Y','MIG_USER','2020-09-19 22:42:21');
/*!40000 ALTER TABLE `tbl_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_screen`
--

DROP TABLE IF EXISTS `tbl_screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_screen` (
  `screenId` int(11) NOT NULL,
  `screenName` varchar(150) NOT NULL,
  `screenUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`screenId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_screen`
--

LOCK TABLES `tbl_screen` WRITE;
/*!40000 ALTER TABLE `tbl_screen` DISABLE KEYS */;
INSERT INTO `tbl_screen` VALUES (1,'User','createUser');
/*!40000 ALTER TABLE `tbl_screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `userId` varchar(255) NOT NULL,
  `userFullName` varchar(255) NOT NULL,
  `userMobileNo` bigint(20) DEFAULT NULL,
  `userPassword` varchar(255) NOT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `userStatus` char(1) NOT NULL,
  `userRoleTypeId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `createdBy` varchar(45) NOT NULL,
  `createdDate` datetime NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `userRoleTypeId_idx` (`userRoleTypeId`),
  KEY `companyId_fk_idx` (`companyId`),
  CONSTRAINT `companyId_fk` FOREIGN KEY (`companyId`) REFERENCES `tbl_company` (`companyId`),
  CONSTRAINT `userRoleTypeId_fk` FOREIGN KEY (`userRoleTypeId`) REFERENCES `tbl_user_role_type` (`userRoleTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES ('admin','Super Administrator 1',17302667,'$2a$10$4S6TW851SZRU5p9RFeOpMO2mBsnGBaVEqau6EUFz5wDG4VKLz9OkO','nzepa.ttpl@gmail.com','A',1,1,'admin','2020-10-08 20:18:54','MIG_USER','2020-09-19 22:42:21');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_a`
--

DROP TABLE IF EXISTS `tbl_user_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_a` (
  `userAuditId` bigint(20) NOT NULL,
  `cmdFlag` char(1) NOT NULL,
  `userId` varchar(255) NOT NULL,
  `userFullName` varchar(255) NOT NULL,
  `userMobileNo` bigint(20) DEFAULT NULL,
  `userPassword` varchar(255) NOT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `userStatus` char(1) NOT NULL,
  `userRoleTypeId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `createdBy` varchar(45) NOT NULL,
  `createdDate` datetime NOT NULL,
  PRIMARY KEY (`userAuditId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_a`
--

LOCK TABLES `tbl_user_a` WRITE;
/*!40000 ALTER TABLE `tbl_user_a` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_user_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_role_type`
--

DROP TABLE IF EXISTS `tbl_user_role_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_role_type` (
  `userRoleTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `userRoleTypeName` varchar(100) NOT NULL,
  PRIMARY KEY (`userRoleTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_role_type`
--

LOCK TABLES `tbl_user_role_type` WRITE;
/*!40000 ALTER TABLE `tbl_user_role_type` DISABLE KEYS */;
INSERT INTO `tbl_user_role_type` VALUES (1,'Administrator'),(2,'Initiator'),(3,'Reviewer'),(4,'Approver'),(5,'Chief Approver'),(6,'Others');
/*!40000 ALTER TABLE `tbl_user_role_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_useraccesspermission`
--

DROP TABLE IF EXISTS `tbl_useraccesspermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_useraccesspermission` (
  `userAccessPermissionId` bigint(20) NOT NULL,
  `userRoleTypeId` int(11) NOT NULL,
  `screenId` int(11) NOT NULL,
  `isScreenAccessAllowed` char(1) NOT NULL,
  `isEditAccessAllowed` char(1) NOT NULL,
  `isDeleteAccessAllowed` char(1) NOT NULL,
  `isSaveAccessAllowed` char(1) NOT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `createdBy` varchar(45) NOT NULL,
  `createdDate` datetime NOT NULL,
  PRIMARY KEY (`userAccessPermissionId`),
  KEY `userRoleTypeId_idx` (`userRoleTypeId`),
  KEY `screenId_fk_idx` (`screenId`),
  CONSTRAINT `screenId_fk` FOREIGN KEY (`screenId`) REFERENCES `tbl_screen` (`screenId`),
  CONSTRAINT `userRoleTypeId` FOREIGN KEY (`userRoleTypeId`) REFERENCES `tbl_user_role_type` (`userRoleTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_useraccesspermission`
--

LOCK TABLES `tbl_useraccesspermission` WRITE;
/*!40000 ALTER TABLE `tbl_useraccesspermission` DISABLE KEYS */;
INSERT INTO `tbl_useraccesspermission` VALUES (1,1,1,'Y','Y','Y','Y',NULL,NULL,'MIG_User','2020-09-24 09:36:34');
/*!40000 ALTER TABLE `tbl_useraccesspermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'test_db'
--
/*!50003 DROP FUNCTION IF EXISTS `UFN_USER_LOG` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `UFN_USER_LOG`(param_date datetime) RETURNS varchar(255) CHARSET utf8
BEGIN
	declare var_second_diff int;
	declare var_minute_diff int;
	declare var_hour_diff int; 
	declare var_day_diff int; 
	declare var_month_diff int; 
	declare var_year_diff int; 	
	 
	declare var_return_value varchar(255); 
	
	set var_second_diff = (select timestampdiff(second, param_date, now()));
	set var_minute_diff = (select timestampdiff(minute, param_date, now())); 
	set var_hour_diff = (select timestampdiff(hour, param_date, now()));
	set var_day_diff = (select timestampdiff(day, param_date, now()));   
	set var_month_diff = (select timestampdiff(month, now(), param_date));
	set var_year_diff = (select timestampdiff(year, now(), param_date));
	
	if(var_year_diff > 0)
	then
	set var_return_value = (select concat(abs(var_year_diff), ' years ago'));
	end if;
	if(var_month_diff < 12)
	then
	set var_return_value = (select concat(abs(var_month_diff), ' months ago'));                 
	end if;
	if(var_day_diff < 31)
	then
	set var_return_value = (select concat(abs(var_day_diff), ' days ago'));	                
	end if;
	if(var_hour_diff < 24)
	then
	set var_return_value = (select concat(abs(var_hour_diff), ' hours ago')); 
	end if;
	if(var_minute_diff < 60)
	then 
	set var_return_value = (select concat(abs(var_minute_diff), ' minutes ago')); 
	end if;
	if(var_second_diff < 60)
	then 
	set var_return_value = (select concat(abs(var_second_diff), ' seconds ago'));	     
	end if;		
	
	return var_return_value;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_GET_USER_LOG` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GET_USER_LOG`(in param_userId varchar(255))
BEGIN
     
	select a.userAuditId, a.cmdFlag, c.userFullName as createdByFullName, m.userFullName as updatedByFullName 
	,UFN_USER_LOG(a.createdDate) as createdTime,UFN_USER_LOG(a.updatedDate) as updatedTime
	from tbl_user_a a left join tbl_user c on a.createdBy = c.userId  
	left join tbl_user m on a.updatedBy = m.userId  
	where a.userId = param_userId;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-08 12:52:59
