/*
SQLyog Ultimate v8.82 
MySQL - 5.5.5-10.4.6-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `tbl_dzongkhag` (
	`id` int (11),
	`dzongkhagName` varchar (765),
	`emailAddress` varchar (765)
); 
insert into `tbl_dzongkhag` (`id`, `dzongkhagName`, `emailAddress`) values('1','Thimphu','thimphu@gmail.com');
insert into `tbl_dzongkhag` (`id`, `dzongkhagName`, `emailAddress`) values('2','Punakha','punakha@gmail.com');
