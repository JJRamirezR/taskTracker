CREATE DATABASE  IF NOT EXISTS `task_tracker`;
USE `task_tracker`;

--
-- Estructura de la tabla `task`
--

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Algunos registro de puerba para la tabla `task`
--

INSERT INTO `task` VALUES 
	(1,'Crear base de datos','Completada'),
	(2,'Actulizar base de datos','En progreso'),
	(3,'Borrar base de datos','Pendiente');

