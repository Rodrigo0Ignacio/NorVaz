-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 20-12-2020 a las 11:02:08
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `n0rvaz`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id_2venta` int(11) NOT NULL,
  `id_2pro` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  KEY `FK2_Detalle_Venta` (`id_2venta`),
  KEY `FK_Detalle_Venta` (`id_2pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id_2venta`, `id_2pro`, `cantidad`, `precio`) VALUES
(21, '226050', 1, 40000),
(22, '226050', 1, 40000),
(23, '226050', 1, 40000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE IF NOT EXISTS `direccion` (
  `region` varchar(50) NOT NULL,
  `comuna` varchar(50) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `nroCalle` varchar(10) NOT NULL,
  `nro_casaODepa` varchar(10) NOT NULL,
  `rut_2usuarioD` varchar(15) NOT NULL,
  UNIQUE KEY `rut_2usuarioD` (`rut_2usuarioD`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`region`, `comuna`, `calle`, `nroCalle`, `nro_casaODepa`, `rut_2usuarioD`) VALUES
('Atacama', 'ASD', '123', '666', '666123', '189408269');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id_pro` varchar(50) NOT NULL,
  `nombre_pro` varchar(50) NOT NULL,
  `stock_pro` int(11) NOT NULL,
  `precio_pro` int(11) NOT NULL,
  `peso_pro` varchar(10) NOT NULL,
  `categoria_pro` varchar(50) NOT NULL,
  `descripcion_pro` varchar(400) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_pro`, `nombre_pro`, `stock_pro`, `precio_pro`, `peso_pro`, `categoria_pro`, `descripcion_pro`, `url`) VALUES
('226050', 'mueble 4 cajones', 20, 40000, '10 kg', 'Comoda', 'ancho 200cm\r\nlargo 150cm\r\n', 'img/mueble1.jpg'),
('505050', 'closet 4 puertas 6 cajones', 20, 40000, '15kg', 'Closet', '300cm ancho\r\n200cm largo', 'img/closet1.jpg'),
('606060', 'silla de madera clasica', 5, 20000, '5kg', 'Silla', 'silla hecha con la mejor calidad del mercado para dar un estilo clásico a su casa', 'img/silla1.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `nombre`) VALUES
(2, 'Administrador'),
(1, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

DROP TABLE IF EXISTS `servicio`;
CREATE TABLE IF NOT EXISTS `servicio` (
  `rut_2usuario` varchar(15) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `poblacion` varchar(50) NOT NULL,
  `calle` varchar(30) NOT NULL,
  `NroCasa` varchar(10) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `requerimiento` varchar(500) NOT NULL,
  KEY `FK_Servicio` (`rut_2usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`rut_2usuario`, `tipo`, `poblacion`, `calle`, `NroCasa`, `telefono`, `fechaIngreso`, `requerimiento`) VALUES
('1894028269', 'Servicio de Gafiteria', 'la legua', 'matanza', '6666', '123123123', '2020-12-19', 'HOLY FUCK');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `rut` varchar(15) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `contraseNa` varchar(100) NOT NULL,
  `id_2roles` int(11) NOT NULL,
  PRIMARY KEY (`id_Usuario`),
  UNIQUE KEY `rut` (`rut`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_Usuario` (`id_2roles`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_Usuario`, `rut`, `nombre`, `apellidos`, `email`, `telefono`, `contraseNa`, `id_2roles`) VALUES
(8, '1894028269', 'felipe', 'silva', 'felipe_el_silva@hotmail.com', '972765023', 'hidra', 2),
(9, '189408269', 'pipe', 'kaponi', 'pipex6@hotmail.com', '972765023', 'hidra', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoracion`
--

DROP TABLE IF EXISTS `valoracion`;
CREATE TABLE IF NOT EXISTS `valoracion` (
  `id_2pro` varchar(50) DEFAULT NULL,
  `comentario` varchar(500) DEFAULT NULL,
  KEY `FK_Valoraion` (`id_2pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `valoracion`
--

INSERT INTO `valoracion` (`id_2pro`, `comentario`) VALUES
('226050', 'excelente calidad y muy bonita la silla'),
('226050', 'me gustaron los detalles que tiene la silla me hace recordar mi juventud');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `totales_venta` int(11) NOT NULL,
  `cod_seguimiento` varchar(50) NOT NULL,
  `fecha_venta` date NOT NULL,
  `estado` varchar(10) NOT NULL,
  `rut_2usuario` varchar(15) NOT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `totales_venta`, `cod_seguimiento`, `fecha_venta`, `estado`, `rut_2usuario`) VALUES
(21, 40000, '1894028269', '2020-12-19', 'Rechazada', '1894028269'),
(22, 40000, '1894028269', '2020-12-19', 'pendiente', '1894028269'),
(23, 40000, '189408269', '2020-12-20', 'pendiente', '189408269');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `FK2_Detalle_Venta` FOREIGN KEY (`id_2venta`) REFERENCES `venta` (`id_venta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Detalle_Venta` FOREIGN KEY (`id_2pro`) REFERENCES `producto` (`id_pro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `FK_Servicio` FOREIGN KEY (`rut_2usuario`) REFERENCES `usuario` (`rut`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_Usuario` FOREIGN KEY (`id_2roles`) REFERENCES `rol` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD CONSTRAINT `FK_Valoraion` FOREIGN KEY (`id_2pro`) REFERENCES `producto` (`id_pro`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
