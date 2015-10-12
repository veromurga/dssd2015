/*
SQLyog Ultimate v8.61 
MySQL - 5.6.26-log : Database - garc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`garc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `garc`;

/*Table structure for table `agente_externo` */

DROP TABLE IF EXISTS `agente_externo`;

CREATE TABLE `agente_externo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `agente_externo` */

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL,
  `resumen` varchar(60) DEFAULT NULL,
  `nombre_resumen` varchar(60) DEFAULT NULL,
  `estado` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articulo` */

/*Table structure for table `director` */

DROP TABLE IF EXISTS `director`;

CREATE TABLE `director` (
  `id` int(11) NOT NULL,
  `id_investigador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `director` */

/*Table structure for table `experimento` */

DROP TABLE IF EXISTS `experimento`;

CREATE TABLE `experimento` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `resultado` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `experimento` */

/*Table structure for table `investigador` */

DROP TABLE IF EXISTS `investigador`;

CREATE TABLE `investigador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `investigador` */

/*Table structure for table `palabra_clave` */

DROP TABLE IF EXISTS `palabra_clave`;

CREATE TABLE `palabra_clave` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `palabra_clave` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `palabra_clave` */

/*Table structure for table `pasante` */

DROP TABLE IF EXISTS `pasante`;

CREATE TABLE `pasante` (
  `id` int(11) NOT NULL,
  `id_investigador` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pasante` */

/*Table structure for table `proyecto` */

DROP TABLE IF EXISTS `proyecto`;

CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL,
  `objetivo` varchar(60) DEFAULT NULL,
  `id_investigador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proyecto` */

/*Table structure for table `resvista` */

DROP TABLE IF EXISTS `resvista`;

CREATE TABLE `resvista` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resvista` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
