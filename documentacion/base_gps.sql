-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 04-08-2019 a las 21:36:43
-- Versión del servidor: 5.7.26
-- Versión de PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `base_gps`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivo`
--

DROP TABLE IF EXISTS `dispositivo`;
CREATE TABLE IF NOT EXISTS `dispositivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mac` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `dispositivo`
--

INSERT INTO `dispositivo` (`id`, `mac`, `nombre`, `descripcion`) VALUES
(1, 'e0:db:55:cd:33:79', 'derivador1', 'Raspberry Pi 3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
CREATE TABLE IF NOT EXISTS `ubicacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitud` float NOT NULL,
  `longitud` float NOT NULL,
  `elevacion` float NOT NULL,
  `tiempo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `id_dispositivo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ubicacion_dispositivo` (`id_dispositivo`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`id`, `latitud`, `longitud`, `elevacion`, `tiempo`, `id_dispositivo`) VALUES
(48, -0.927982, -80.747, -0.0752897, '2019-07-28 20:32:39.716', 1),
(47, -0.922424, -80.7219, -0.581058, '2019-07-28 20:32:29.147', 1),
(46, -0.932894, -80.7309, 0.711436, '2019-07-28 20:32:27.062', 1),
(45, -0.924091, -80.7224, 0.464835, '2019-07-28 20:30:59.764', 1),
(44, -0.930012, -80.7103, -0.138628, '2019-07-28 20:30:52.958', 1),
(43, -0.920217, -80.7085, -0.651792, '2019-07-28 12:26:57.103', 1),
(42, -0.935843, -80.7315, -0.197983, '2019-07-28 10:45:02.137', 1),
(41, -0.931539, -80.7132, -0.3546, '2019-07-28 09:20:57.493', 1),
(40, -0.929389, -80.7106, -0.447971, '2019-07-28 09:20:56.06', 1),
(39, -0.922469, -80.721, 0.298364, '2019-07-28 09:20:54.15', 1),
(38, -0.933978, -80.7091, 0.662213, '2019-07-28 09:20:52.525', 1),
(37, -0.925173, -80.7478, 0.725326, '2019-07-28 09:20:51.0', 1),
(36, -0.927355, -80.7411, 0.517011, '2019-07-28 09:20:15.35', 1),
(35, -0.924775, -80.7341, 0.327381, '2019-07-28 09:20:12.91', 1),
(34, -0.93975, -80.7007, 0.680024, '2019-07-28 09:15:19.753', 1),
(33, -0.935623, -80.7289, -0.494098, '2019-07-28 09:15:11.184', 1),
(49, -0.931749, -80.7251, 0.654339, '2019-07-28 20:32:41.324', 1),
(50, -0.92602, -80.7446, 0.235236, '2019-08-01 21:41:04.469', 1),
(51, -0.930606, -80.7118, -0.61294, '2019-08-03 10:15:41.241', 1),
(52, -0.923416, -80.7194, -0.837558, '2019-08-03 10:17:07.627', 1),
(53, -0.934922, -80.7015, -0.304151, '2019-08-03 10:17:17.221', 1),
(54, -0.926904, -80.7078, 0.584388, '2019-08-03 10:38:20.07', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `cuenta` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `clave` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `cedula` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `rol` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `cuenta`, `clave`, `nombre`, `cedula`, `telefono`, `rol`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Administrador', '0999999991', '04123456', 'adm');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
