/*
SQLyog Ultimate v8.82 
MySQL - 5.5.13 : Database - training_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`training_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `training_db`;

/*Table structure for table `tbl_company` */

DROP TABLE IF EXISTS `tbl_company`;

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

/*Data for the table `tbl_company` */

insert  into `tbl_company`(`companyId`,`companyName`,`description`,`logo`,`logoName`,`logoExtension`,`status`,`isParentCompany`,`createdBy`,`createdDate`) values (1,'THimphu Techapr',NULL,NULL,NULL,NULL,'A','Y','MIG_USER','2020-09-19 22:42:21');

/*Table structure for table `tbl_screen` */

DROP TABLE IF EXISTS `tbl_screen`;

CREATE TABLE `tbl_screen` (
  `screenId` int(11) NOT NULL,
  `screenName` varchar(150) NOT NULL,
  `screenUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`screenId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_screen` */

insert  into `tbl_screen`(`screenId`,`screenName`,`screenUrl`) values (1,'User','createUser');

/*Table structure for table `tbl_student_name` */

DROP TABLE IF EXISTS `tbl_student_name`;

CREATE TABLE `tbl_student_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_student_name` */

/*Table structure for table `tbl_student_registration` */

DROP TABLE IF EXISTS `tbl_student_registration`;

CREATE TABLE `tbl_student_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_student_registration` */

insert  into `tbl_student_registration`(`id`,`studentName`) values (1,'Phuentsho karma'),(2,'Dorji Tenzin'),(4,'Tashi'),(5,'karma');

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

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

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`userId`,`userFullName`,`userMobileNo`,`userPassword`,`emailId`,`userStatus`,`userRoleTypeId`,`companyId`,`updatedBy`,`updatedDate`,`createdBy`,`createdDate`) values ('admin','Super Administrator 1',17302667,'$2a$10$4S6TW851SZRU5p9RFeOpMO2mBsnGBaVEqau6EUFz5wDG4VKLz9OkO','nzepa.ttpl@gmail.com','A',1,1,'admin','2020-10-08 20:18:54','MIG_USER','2020-09-19 22:42:21');

/*Table structure for table `tbl_user_a` */

DROP TABLE IF EXISTS `tbl_user_a`;

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

/*Data for the table `tbl_user_a` */

/*Table structure for table `tbl_user_role_type` */

DROP TABLE IF EXISTS `tbl_user_role_type`;

CREATE TABLE `tbl_user_role_type` (
  `userRoleTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `userRoleTypeName` varchar(100) NOT NULL,
  PRIMARY KEY (`userRoleTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_user_role_type` */

insert  into `tbl_user_role_type`(`userRoleTypeId`,`userRoleTypeName`) values (1,'Administrator'),(2,'Initiator'),(3,'Reviewer'),(4,'Approver'),(5,'Chief Approver'),(6,'Others');

/*Table structure for table `tbl_useraccesspermission` */

DROP TABLE IF EXISTS `tbl_useraccesspermission`;

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

/*Data for the table `tbl_useraccesspermission` */

insert  into `tbl_useraccesspermission`(`userAccessPermissionId`,`userRoleTypeId`,`screenId`,`isScreenAccessAllowed`,`isEditAccessAllowed`,`isDeleteAccessAllowed`,`isSaveAccessAllowed`,`updatedBy`,`updatedDate`,`createdBy`,`createdDate`) values (1,1,1,'Y','Y','Y','Y',NULL,NULL,'MIG_User','2020-09-24 09:36:34');

/* Function  structure for function  `UFN_USER_LOG` */

/*!50003 DROP FUNCTION IF EXISTS `UFN_USER_LOG` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `UFN_USER_LOG`(param_date datetime) RETURNS varchar(255) CHARSET utf8
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
    END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_GET_USER_LOG` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_GET_USER_LOG` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GET_USER_LOG`(in param_userId varchar(255))
BEGIN
     
	select a.userAuditId, a.cmdFlag, c.userFullName as createdByFullName, m.userFullName as updatedByFullName 
	,UFN_USER_LOG(a.createdDate) as createdTime,UFN_USER_LOG(a.updatedDate) as updatedTime
	from tbl_user_a a left join tbl_user c on a.createdBy = c.userId  
	left join tbl_user m on a.updatedBy = m.userId  
	where a.userId = param_userId;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
