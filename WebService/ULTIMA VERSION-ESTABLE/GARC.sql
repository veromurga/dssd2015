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

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resumen` varchar(60) DEFAULT NULL,
  `nombre_resumen` varchar(60) DEFAULT NULL,
  `estado` varchar(80) DEFAULT NULL,
  `id_revista` int(70) DEFAULT NULL,
  `investigador` varchar(100) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `articulo` */

insert  into `articulo`(`id`,`resumen`,`nombre_resumen`,`estado`,`id_revista`,`investigador`,`director`) values (1,'Nota de la ONU','ONU','aceptado',1,'investigador1','director1'),(2,'Guerra en Irak','Guerra en medio Oriente','publicado',1,'investigador1','director1'),(7,'resumen','nombre_resumen','estado',0,'investigador','director'),(8,'retyertytreyerty','null','Publicado',1,'investigador1','director1'),(9,'Este es el resumen del articulo de antman !!!','El articulo de ANTMAN','Publicado',1,'investigador1','director1'),(10,'dasdadasdasdasdasd','dadadasdas','Publicado',1,'investigador1','director1'),(11,'sssssssssssssssssssssssssssssssssssss','adasdadasd','Publicado',1,'investigador1','director1'),(12,'vxcxvxcvxcvxcvxvxcvvxsdfsfd','eqwe','Publicado',1,'investigador1','director1'),(13,'yrtyrytyrtyrtryryryt','rt','Publicado',1,'investigador1','director1'),(14,'ddddddddddddddddddddddddddddddddddddddddddddddddddddddd','sdadasdasd','Publicado',1,'investigador1','director1'),(15,'sadasdasd','das','Publicado',1,'investigador1','director1'),(16,'dadadadasdsddasd','adasdas','Publicado',1,'investigador1','director1');

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

/*Table structure for table `pasante_respuesta` */

DROP TABLE IF EXISTS `pasante_respuesta`;

CREATE TABLE `pasante_respuesta` (
  `id` int(90) NOT NULL AUTO_INCREMENT,
  `username_pasante` varchar(99) DEFAULT NULL,
  `mensaje` varchar(90) DEFAULT NULL,
  `nombre_proyecto` varchar(89) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `pasante_respuesta` */

insert  into `pasante_respuesta`(`id`,`username_pasante`,`mensaje`,`nombre_proyecto`) values (1,'pasante1','aadasdasdasdasd','dadasda'),(2,'pasante2','fdsfsdf','qweqweweqweqe'),(3,'pasante3','alua akuuu','Amar');

/*Table structure for table `revista` */

DROP TABLE IF EXISTS `revista`;

CREATE TABLE `revista` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `puede_publicar` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `revista` */

insert  into `revista`(`id`,`nombre`,`puede_publicar`) values (1,'Mondo',1),(2,'FOX-News',0),(3,'TELEFE',0);

/*Table structure for table `revista_palabra_clave` */

DROP TABLE IF EXISTS `revista_palabra_clave`;

CREATE TABLE `revista_palabra_clave` (
  `id` int(90) NOT NULL,
  `id_revista` int(90) DEFAULT NULL,
  `id_palabra_clave` int(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `revista_palabra_clave` */

insert  into `revista_palabra_clave`(`id`,`id_revista`,`id_palabra_clave`) values (1,1,2),(2,2,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
