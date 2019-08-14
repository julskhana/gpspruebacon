-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-08-2019 a las 01:38:26
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
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `dispositivo`
--

INSERT INTO `dispositivo` (`id`, `mac`, `nombre`, `descripcion`) VALUES
(1, 'e0:db:55:cd:33:79', 'derivador1', 'Raspberry Pi 3'),
(2, 'b8:27:eb:a4:de:bf', 'Derivador2', 'Raspberry Pi 2'),
(4, '9c:d2:1e:7b:59:5d', 'Derivador 3', 'Antena Oficina'),
(5, 'fsdfsdf|', 'prueba', 'aedfnalsfdjm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `tiempo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `id_derivador` int(11) NOT NULL,
  `latitud` float DEFAULT NULL,
  `longitud` float DEFAULT NULL,
  `elevacion` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`id`, `tipo`, `descripcion`, `tiempo`, `id_derivador`, `latitud`, `longitud`, `elevacion`) VALUES
(1, 'rango', 'El derivador esta fuera de rango', '2019-08-09 09:43:20.3', 1, NULL, NULL, NULL),
(2, 'rango', 'El derivador esta fuera de rango', '2019-08-09 09:45:28.4', 1, NULL, NULL, NULL),
(3, 'rango', 'El derivador esta fuera de rango', '2019-08-09 09:50:38.973', 1, NULL, NULL, NULL),
(4, 'rango', 'El derivador esta fuera de rango', '2019-08-09 09:50:58.453', 1, NULL, NULL, NULL),
(5, 'rango', 'El derivador esta fuera de rango', '2019-08-09 09:51:55.313', 1, NULL, NULL, NULL),
(6, 'rango', 'El derivador esta fuera de rango', '2019-08-09 09:51:59.203', 1, NULL, NULL, NULL),
(7, 'rango', 'El derivador esta fuera de rango', '2019-08-09 10:02:34.213', 1, NULL, NULL, NULL),
(8, 'rango', 'El derivador esta fuera de rango', '2019-08-09 10:05:38.133', 1, NULL, NULL, NULL),
(9, 'rango', 'El derivador esta fuera de rango', '2019-08-13 15:24:21.04', 1, NULL, NULL, NULL),
(10, 'rango', 'El derivador esta fuera de rango', '2019-08-13 15:24:32.26', 1, NULL, NULL, NULL),
(11, 'rango', 'El derivador esta fuera de rango', '2019-08-13 15:24:33.994', 1, NULL, NULL, NULL),
(12, 'rango', 'El derivador esta fuera de rango', '2019-08-13 15:24:35.932', 1, NULL, NULL, NULL),
(13, 'rango', 'El derivador esta fuera de rango', '2019-08-13 15:24:40.276', 1, NULL, NULL, NULL),
(14, 'rango', 'El derivador esta fuera de rango', '2019-08-13 15:24:44.011', 1, NULL, NULL, NULL),
(15, 'rango', 'El derivador esta fuera de rango', '2019-08-13 20:19:23.513', 1, NULL, NULL, NULL);

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
  `tiempo` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `id_dispositivo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ubicacion_dispositivo` (`id_dispositivo`)
) ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`id`, `latitud`, `longitud`, `elevacion`, `tiempo`, `id_dispositivo`) VALUES
(48, -0.927982, -80.747, -0.0752897, '2019-07-29 01:32:39.716000', 1),
(47, -0.922424, -80.7219, -0.581058, '2019-07-29 01:32:29.147000', 1),
(46, -0.932894, -80.7309, 0.711436, '2019-07-29 01:32:27.062000', 1),
(45, -0.924091, -80.7224, 0.464835, '2019-07-29 01:30:59.764000', 1),
(44, -0.930012, -80.7103, -0.138628, '2019-07-29 01:30:52.958000', 1),
(43, -0.920217, -80.7085, -0.651792, '2019-07-28 17:26:57.103000', 1),
(42, -0.935843, -80.7315, -0.197983, '2019-07-28 15:45:02.137000', 1),
(41, -0.931539, -80.7132, -0.3546, '2019-07-28 14:20:57.493000', 1),
(40, -0.929389, -80.7106, -0.447971, '2019-07-28 14:20:56.060000', 1),
(39, -0.922469, -80.721, 0.298364, '2019-07-28 14:20:54.150000', 1),
(38, -0.933978, -80.7091, 0.662213, '2019-07-28 14:20:52.525000', 1),
(37, -0.925173, -80.7478, 0.725326, '2019-07-28 14:20:51.000000', 1),
(36, -0.927355, -80.7411, 0.517011, '2019-07-28 14:20:15.350000', 1),
(35, -0.924775, -80.7341, 0.327381, '2019-07-28 14:20:12.910000', 1),
(34, -0.93975, -80.7007, 0.680024, '2019-07-28 14:15:19.753000', 1),
(33, -0.935623, -80.7289, -0.494098, '2019-07-28 14:15:11.184000', 1),
(49, -0.931749, -80.7251, 0.654339, '2019-07-29 01:32:41.324000', 1),
(50, -0.92602, -80.7446, 0.235236, '2019-08-02 02:41:04.469000', 1),
(51, -0.930606, -80.7118, -0.61294, '2019-08-03 15:15:41.241000', 1),
(52, -0.923416, -80.7194, -0.837558, '2019-08-03 15:17:07.627000', 1),
(53, -0.934922, -80.7015, -0.304151, '2019-08-03 15:17:17.221000', 1),
(54, -0.926904, -80.7078, 0.584388, '2019-08-03 15:38:20.070000', 1),
(55, -0.934524, -80.7146, 0.0904372, '2019-08-09 15:05:38.156837', 1),
(56, -0.927283, -80.727, -0.262433, '2019-08-09 15:05:41.397486', 1),
(57, -0.931157, -80.7093, -0.986781, '2019-08-13 20:24:21.069530', 1),
(58, -0.936339, -80.7013, 0.918918, '2019-08-13 20:24:32.280235', 1),
(59, -0.933588, -80.7278, -0.81666, '2019-08-13 20:24:34.016849', 1),
(60, -0.932417, -80.7138, 0.464462, '2019-08-13 20:24:35.950295', 1),
(61, -0.925557, -80.7187, -0.845344, '2019-08-13 20:24:38.549127', 1),
(62, -0.931264, -80.7114, -0.595816, '2019-08-13 20:24:40.291757', 1),
(63, -0.926735, -80.7277, -0.23124, '2019-08-13 20:24:42.372527', 1),
(64, -0.930539, -80.7324, 0.42167, '2019-08-13 20:24:44.036244', 1),
(65, -0.931376, -80.7076, -0.622406, '2019-08-14 01:19:23.540084', 1);

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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `cuenta`, `clave`, `nombre`, `cedula`, `telefono`, `rol`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Administrador', '0999999991', '04123456', 'admin'),
(2, 'prueba1', '81dc9bdb52d04dc20036dbd8313ed055', 'usuario prueba 1', '0999999992', '04111111', 'Usuario'),
(3, 'prueba3', '81dc9bdb52d04dc20036dbd8313ed055', 'Usuario Prueba 3', '0933333333', '04333333', 'Usuario');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
