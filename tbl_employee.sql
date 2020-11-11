/*
SQLyog Ultimate v8.82 
MySQL - 5.5.5-10.4.6-MariaDB : Database - training_db
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

/*Table structure for table `tbl_employee` */

DROP TABLE IF EXISTS `tbl_employee`;

CREATE TABLE `tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_Name` varchar(255) DEFAULT NULL,
  `emp_Designation` varchar(255) NOT NULL,
  `emp_Department` varchar(255) NOT NULL,
  `emp_Contact_No` varchar(255) NOT NULL,
  `emp_Dob` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_employee` */

insert  into `tbl_employee`(`id`,`emp_Name`,`emp_Designation`,`emp_Department`,`emp_Contact_No`,`emp_Dob`) values (1,'Passang Waiba','Program Officer','SWE','17659565','2020-09-12'),(4,'Karma Dorji','DO','IT','1314132rt3','2020-11-09'),(6,'Jigme Choeling','Officer','Claim','98127653','2020-11-10'),(8,'Ratu','DO','Insurance','132142523','2020-11-10'),(9,'Tshering Jatsho','Officer','Claim','98127653','2020-11-10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
