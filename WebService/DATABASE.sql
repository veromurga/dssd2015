/*
SQLyog Ultimate v8.61 
MySQL - 5.6.24 : Database - garc
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

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resumen` varchar(60) DEFAULT NULL,
  `nombre_resumen` varchar(60) DEFAULT NULL,
  `estado` varchar(80) DEFAULT NULL,
  `id_revista` int(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `articulo` */

insert  into `articulo`(`id`,`resumen`,`nombre_resumen`,`estado`,`id_revista`) values (1,'Nota de la ONU','ONU','aceptado',1),(2,'Guerra en Irak','Guerra en medio Oriente','publicado',1),(3,'resumem','nombre de oko','Publicado',1),(4,'resumem2','nombre de oko2','Publicado',1),(5,'resumem2','nombre de oko2','Publicado',1),(6,'resumem3','nombre de oko3','Publicado',1);

/*Table structure for table `articulo_palabra_clave` */

DROP TABLE IF EXISTS `articulo_palabra_clave`;

CREATE TABLE `articulo_palabra_clave` (
  `id` int(90) NOT NULL,
  `id_articulo` int(90) DEFAULT NULL,
  `id_palabra_clave` int(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articulo_palabra_clave` */

insert  into `articulo_palabra_clave`(`id`,`id_articulo`,`id_palabra_clave`) values (1,1,3),(2,1,4);

/*Table structure for table `palabra_clave` */

DROP TABLE IF EXISTS `palabra_clave`;

CREATE TABLE `palabra_clave` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `palabra_clave` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `palabra_clave` */

insert  into `palabra_clave`(`id`,`descripcion`,`palabra_clave`) values (1,'Guerra','key_war'),(2,'Futbol','key_futbol'),(3,'Basquet','key_basquet'),(4,'Noticias locales','key_local_noticia');

/*Table structure for table `revista` */

DROP TABLE IF EXISTS `revista`;

CREATE TABLE `revista` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

/*Data for the table `revista` */

insert  into `revista`(`id`,`nombre`) values (1,'Mondo'),(2,'FOX-News'),(70,NULL);

/*Table structure for table `revista_articulo` */

DROP TABLE IF EXISTS `revista_articulo`;

CREATE TABLE `revista_articulo` (
  `id` int(90) NOT NULL AUTO_INCREMENT,
  `id_revista` int(89) DEFAULT NULL,
  `id_articulo` int(89) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `revista_articulo` */

insert  into `revista_articulo`(`id`,`id_revista`,`id_articulo`) values (2,1,5),(3,1,6);

/*Table structure for table `revista_palabra_clave` */

DROP TABLE IF EXISTS `revista_palabra_clave`;

CREATE TABLE `revista_palabra_clave` (
  `id` int(90) NOT NULL,
  `id_revista` int(90) DEFAULT NULL,
  `id_palabra_clave` int(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `revista_palabra_clave` */

insert  into `revista_palabra_clave`(`id`,`id_revista`,`id_palabra_clave`) values (1,1,4),(2,1,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
