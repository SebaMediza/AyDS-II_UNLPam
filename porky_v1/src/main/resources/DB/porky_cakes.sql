-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-10-2023 a las 00:24:18
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `porky_cakes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

CREATE TABLE `ingrediente` (
  `ID_MATERIA_PRIMA` int(11) NOT NULL,
  `ID_PRODUCTO` int(11) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `UNIDAD_MEDIDA` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`ID_MATERIA_PRIMA`, `ID_PRODUCTO`, `CANTIDAD`, `UNIDAD_MEDIDA`) VALUES
(1, 2, 90, 'Gramos'),
(1, 3, 100, 'Gramos'),
(1, 4, 400, 'Gramos'),
(1, 5, 500, 'Gramos'),
(1, 6, 130, 'Gramos'),
(5, 3, 100, 'Gramos'),
(5, 4, 100, 'Gramos'),
(5, 5, 300, 'Gramos'),
(5, 6, 200, 'Gramos'),
(6, 2, 1, 'Litro'),
(6, 7, 400, 'Cm3'),
(8, 1, 300, 'Gramos'),
(9, 4, 200, 'Cm3'),
(10, 2, 50, 'Gramos'),
(10, 6, 125, 'Gramos'),
(12, 3, 150, 'Gramos'),
(12, 7, 1, 'Unidad'),
(14, 1, 400, 'Gramos'),
(14, 6, 500, 'Gramos'),
(15, 8, 4, 'Kg'),
(16, 4, 1, 'Unidad'),
(16, 5, 1, 'Unidad'),
(21, 3, 100, 'Gramos'),
(22, 2, 4, 'Unidad'),
(22, 3, 4, 'Unidad'),
(22, 4, 4, 'Unidad'),
(22, 5, 8, 'Unidad'),
(22, 6, 3, 'Unidad'),
(23, 4, 1, 'Cda'),
(25, 3, 300, 'Gramos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia_prima`
--

CREATE TABLE `materia_prima` (
  `ID_MATERIA_PRIMA` int(11) NOT NULL,
  `NOMBRE_MP` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia_prima`
--

INSERT INTO `materia_prima` (`ID_MATERIA_PRIMA`, `NOMBRE_MP`) VALUES
(1, 'Harina 0000'),
(2, 'Harina leudante'),
(3, 'Harina de coco'),
(4, 'Harina de ma�z'),
(5, 'Manteca'),
(6, 'Crema de leche'),
(7, 'Yogur'),
(8, 'Queso crema'),
(9, 'Leche'),
(10, 'Chocolate negro'),
(11, 'Chocolate blanco'),
(12, 'Chocolate amargo'),
(13, 'Chocolate con leche'),
(14, 'Dulce de leche'),
(15, 'Frutillas'),
(16, 'Limon'),
(17, 'Naranja'),
(18, 'Durazno'),
(19, 'Durazno en lata'),
(20, 'Almendras'),
(21, 'Nueces'),
(22, 'Huevo'),
(23, 'Miel'),
(24, 'Grasa'),
(25, 'Azúcar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasos_receta`
--

CREATE TABLE `pasos_receta` (
  `ID_PRODUCTO` int(11) NOT NULL,
  `NRO_PASO` int(11) NOT NULL,
  `DESCRIPCION` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasos_receta`
--

INSERT INTO `pasos_receta` (`ID_PRODUCTO`, `NRO_PASO`, `DESCRIPCION`) VALUES
(1, 1, 'En un bowl, mezclar el queso crema con el dulce de leche hasta que quede una crema de color uniforme.'),
(1, 2, 'En una fuente rectangular intercalar las galletitas humedecidas con el oporto con la crema de dulce de leche.'),
(1, 3, 'Repetir las capas hasta terminar las galletitas.'),
(1, 4, 'Finalizar decorando con una capa de la crema o, si se desea, ba ar en chocolate.'),
(2, 1, 'Batir las claras de los huevos a punto de nieve y reservar.'),
(2, 2, 'En otro bol batir las 4 yemas junto con 120 gr. de az car hasta que duplique su volumen inicial logrando una crema espumosa.'),
(2, 3, 'Colocar una pizca de sal sobre las claras batidas e incorporar esto a las yemas realizando movimientos envolventes y con mucho cuidado.'),
(2, 4, 'Sumar la harina tamizada y el cacao de a partes mientras se mezcla con suavidad.'),
(2, 5, 'Preparar un molde para bizcochuelo untando manteca en los bordes y cubri ndolo con papel manteca. Introducir en este la mezcla. Hornear por 25 minutos en un horno precalentado a 180  C.'),
(2, 6, 'Pasado el tiempo, comprobar su cocci n pinchando con un cuchillo que debe salir seco. Desmoldar y enfriar bien.'),
(3, 1, 'Batir los huevos con el az car s lo para unirlos.?'),
(3, 2, 'Derretir a ba o mar a el chocolate con la manteca y verterlos sobre los huevos batidos.?'),
(3, 3, 'Integrar la harina con las nueces y agregarlas a la mezcla del chocolate.'),
(3, 4, 'Verter en una placa enmantecada (de 16 x 26 cm o 20 x 20) y hornear a 180 /200, por 25 o 30 minutos. Dejar enfriar y cortar en cuadrados.'),
(4, 1, 'Batir con batidora la manteca blanda con el az car hasta obtener una crema.'),
(4, 2, 'Mezclar los huevos con la leche y agregar a la preparaci n. Perfumar con esencia de vainilla e ir agregando el resto de los ingredientes, el aceite, el juego de lim n, la miel. Integrar.'),
(4, 3, 'Luego mezclar la harina, el bicarbonato de sodio, y el polvo de hornear e incorporar. Batir hasta lograr una masa homog nea. Verter en los moldes, pirotines con forma de tulipa. Hornear a 180 , por 45 minutos. '),
(5, 1, 'La masa. En batidora (o a mano) batir la manteca con el az car.'),
(5, 2, 'Sumar el huevo y cuando se incorpore, a adir la harina. Batir hasta formar la masa.'),
(5, 3, 'Colocar en una bolsa o papel film y llevar a la heladera por 30 minutos.  Estirar y forrar una tartera de 24 cm. Pincharla con un tenedor. Recortar los bordes en forma prolija.'),
(5, 4, 'Colocar peso sobre la tarta y cocinarla a blanco 15 minutos. Luego, retirar el peso y cocinarla otros 10 minutos. Retirar del horno y dejar enfriar.'),
(5, 5, 'El relleno. Poner en una cacerola todos los ingredientes menos la gelarina. Cocinar a fuego bajo, revolviendo siempre. Cuando espese y comiencen las burbujas, apartar del fuego. Dejar entibiar.'),
(5, 6, 'Una vez tibia la crema, rellenar la tarta precocida, alisando la superficie.'),
(5, 7, 'El merengue. Realizar un alm bar con el az car y  cubriri con agua. Batir las claras hasta espumarlas. Cuando el alm bar llegue  los 118 , verterlo en forma de hilo sobre las claras, mientras se baten. Continuar el batido hasta que el bowl se sienta fr o. '),
(5, 8, 'Estacionar la tarta en la heladera hasta que la crema est  bien firme. Retirar la tarta de la heladera y cubrirla totalmente con el merengue. Para que quede \"doradita\", meterla en el horno un minuto. Enfriar.'),
(6, 1, 'En un bol, batir los huevos con el az car.'),
(6, 2, 'Fundir el chocolate cobertura en el microondas. A adirle la manteca blanda mezclando hasta formar una crema.'),
(6, 3, 'Unir la harina com n y el cacao amargo. reservar.'),
(6, 4, 'Sumar a la mezcla de huevos y az car la crema de chocolate ya fr a.'),
(6, 5, 'Por  ltimo, sumar el harina cernida junto con el cacao amargo e integrar en forma envolvente para que se mezcle bien con la preparaci n. Incorporar las nueces. Verter la mezcla en una placa de 20 cent metros por 30, enmantecada y forrada con papel manteca o aluminio, tambi n enmantecado.'),
(6, 6, 'Llevar a horno a 180 , por unos 25 minutos. Retirar del horno y dejar enfriar. Decorar con dulce de leche, pasta de avellanas y bombones.'),
(7, 1, 'Batir las yemas a ba o Mar a e incorporar el az car y el cognac o amaretto. Batimos por 5 minutos aproximadamente. Retirar del fuego y batir hasta que las yemas est n a temperatura ambiente. Van a notar que las yemas triplican su tama o y hacerse una especie de crema. Hermoso. Vamos bien.'),
(7, 2, 'batir un poco el mascarpone para que no tenga grumos. El paso mas f cil de la historia pero es muy importante  en esta receta de Tiramis .'),
(7, 3, 'Verter las yemas sobre el mascarpone e integrar con movimientos envolventes. Sumar la crema de leche semi batida y mezclar suavemente.'),
(7, 4, 'Hidratar los bizcochos de tiramis  en el caf . '),
(7, 5, 'Disponer la primer capa vainillas en la fuente. Tambi n se pueden hacer vasitos, lo que m s te haga feliz Mabel. No importa en qu  lo prepares, tiene que quedar una capa de vainillas, una de crema, una de vainillas y por  ltimo una de crema.'),
(7, 6, 'Espolvoreamos por arriba el cacao amargo y el chocolate semi amargo rallado o picado y a la heladera! El tiramis  fr o es mucho m s rico!');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID_PRODUCTO` int(11) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `PRECIO_VTA` int(11) DEFAULT NULL,
  `CANT_PORCIONES` int(11) DEFAULT NULL,
  `DESCRIPCION_PRODUCTO` varchar(500) DEFAULT NULL,
  `img_producto` varchar(200) NOT NULL,
  `img_aux1` varchar(150) DEFAULT NULL,
  `img_aux2` varchar(150) DEFAULT NULL,
  `img_aux3` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID_PRODUCTO`, `NOMBRE`, `PRECIO_VTA`, `CANT_PORCIONES`, `DESCRIPCION_PRODUCTO`, `img_producto`, `img_aux1`, `img_aux2`, `img_aux3`) VALUES
(1, 'Choco Torta', 3000, 12, 'Es una torta a base de dulce de leche y queso crema, con galletitas chocolinas intercaladas, mojadas en leche', 'chocoTorta.jpg', NULL, NULL, NULL),
(2, 'Selva Negra', 3100, 15, 'Bizcochuelo de chocolate relleno con dos cortes de crema chantilly con cerezas al marraschino. Decorada con crema chantilly, copos, cerezas, rulos y detalles a los costados de chocolate.', 'selvaNegra.jpeg', 'selvaNegra1.jpeg', 'selvaNegra2.jpg', 'selvaNegra3.png'),
(3, 'Brownie', 2000, 20, 'Los brownies de chocolate puede servirse a la hora del t  o como postre, acompa ados con una bocha de helado de crema', 'brownieDobel.jpg', NULL, NULL, NULL),
(4, 'Muffin', 600, 1, 'Es un producto de reposter a elaborado con pan dulce y otros ingredientes, sobre todo con dulces.Cocinado al horno en moldes al uso, presentan una base cil ndrica y una superficie m s ancha, con forma', 'muffin.webp', 'muffin1.jpeg', 'muffin2.jpeg', 'muffin3.jpg'),
(5, 'Lemon pie', 1500, 12, 'El lemon pie, uno de los postres m s cl sicos, en la versi n de la querida Blanca Cotta.', 'lemonPie.jpg', NULL, NULL, NULL),
(6, 'Torta bombón', 1200, 8, 'La tarta bombón es la combinación perfecta, con una mezcla de texturas y sabores realmente increíble: la galleta crujiente de la base con el sabor intenso de un buen dulce de leche, coronado con el chocolate amargo de la cobertura.', 'bruce.jpg', 'tortaBombon1.jpeg', 'tortaBombon2.jpg', 'tortaBombon3.jpg'),
(7, 'Tiramisu', 2000, 12, 'Con vainillas compradas o con vainillas caseras, con queso blanco o con mascarpone, con caf  y con cacao en polvo, este postre siempre es un golazo', 'tiramisu.jpeg', 'tiramisu1.jpg', 'tiramisu2.jpg', 'tiramisu3.jpeg'),
(8, 'Tarta de frutillas', 1900, 12, 'Esta receta de tarta de frutillas se prepara con crema chantill , si se quiere se puede optar por crema pastelera y, para los m s golosos se le puede sumar dulce de leche. Es ideal prepararla cuando l', '', NULL, NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD PRIMARY KEY (`ID_MATERIA_PRIMA`,`ID_PRODUCTO`),
  ADD KEY `ID_PRODUCTO` (`ID_PRODUCTO`);

--
-- Indices de la tabla `materia_prima`
--
ALTER TABLE `materia_prima`
  ADD PRIMARY KEY (`ID_MATERIA_PRIMA`);

--
-- Indices de la tabla `pasos_receta`
--
ALTER TABLE `pasos_receta`
  ADD PRIMARY KEY (`ID_PRODUCTO`,`NRO_PASO`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID_PRODUCTO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  MODIFY `ID_MATERIA_PRIMA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `materia_prima`
--
ALTER TABLE `materia_prima`
  MODIFY `ID_MATERIA_PRIMA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID_PRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD CONSTRAINT `ingrediente_ibfk_1` FOREIGN KEY (`ID_MATERIA_PRIMA`) REFERENCES `materia_prima` (`ID_MATERIA_PRIMA`),
  ADD CONSTRAINT `ingrediente_ibfk_2` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);

--
-- Filtros para la tabla `pasos_receta`
--
ALTER TABLE `pasos_receta`
  ADD CONSTRAINT `pasos_receta_ibfk_1` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
