//(id_cliente, nombre_cliente, telefono_cliente, email_cliente, direccion_cliente, fecha_nac_cliente, pass_cliente)
Insert into cliente values (1, 'Joaquín Cenicero', 2355488168, 'joaquincenicero2000@hotmail.com', '105 oeste 546', to_date('01/03/2000','dd-mm-yyyy'), '42431701');
Insert into cliente values (2, 'Federico Pereyra', 2302624920, 'david99pereyra@hotmail.com', 'calle 329 64', to_date('30/01/1999','dd-mm-yyyy'), '1234');
Insert into cliente values (3, 'Felipe Santillan', 2302623328, 'felipesantillan@hotmail.com', 'calle 428 405 bis', to_date('05/11/2000','dd-mm-yyyy'), '1893');
Insert into cliente values (4, 'Sebastian Medisa', 2302230614, 'seba_medisa@hotmail.com', 'calle 32 ', to_date('30/04/1999','dd-mm-yyyy'), '1234');
Insert into cliente values (5, 'Melani Oronás', 2302661230, 'melicorazon@hotmail.com', 'Villa 21', to_date('16/07/2000','dd-mm-yyyy'), 'gatitovioleta1');
Insert into cliente values (6, 'Lionel Zapata', 2357411527, 'lionel_coloniasere@hotmail.com', 'Recoleta', to_date('09/11/1999','dd-mm-yyyy'),'4127');
Insert into cliente values (7, 'Leo Melchor', 295460245, 'leocapo1@hotmiail.com', 'Avellaneda', to_date('22/04/2000','dd,mm,yyyy'), '7colores');

//(id_Proveedor, CUIT, nombre_prov, direccion_prov, email_prov, telefono_prov)
Insert into Proveedor values (1, 20175623843, 'Jorge Rodriguez', '16 esq 4', 'jorgerodriguez@hotmail.com', 2302151123);
Insert into Proveedor values (2, 20162254873, 'Nelson Ruiz', 'Maipu 72', 'ruiznelson@gmail.com', 2302562403);
Insert into Proveedor values (3, 20183254313, 'Lucila Arce', 'av. San Marin esq 1', 'lucila_arce@hotmail.com', 2302145532);

//(id_Producto, nombre_producto, precio_vta, cant_porciones, descripcion_producto)
insert into Producto values(1, 'chocotorta', 3000.00, 12, 'Es una torta a base de dulce de leche y queso crema, con galletitas chocolinas intercaladas, mojadas en leche');
insert into Producto values(2, 'selva negra', 3100.00, 15, 'Bizcochuelo de chocolate relleno con dos cortes de crema chantilly con cerezas al marraschino. Decorada con crema chantilly, copos, cerezas, rulos y detalles a los costados de chocolate.');
insert into Producto values(3, 'Brownie', 2000.00, 20, 'Los brownies de chocolate puede servirse a la hora del té o como postre, acompañados con una bocha de helado de crema');
insert into Producto values(4, 'Muffin', 600.00, 1, 'Es un producto de repostería elaborado con pan dulce y otros ingredientes, sobre todo con dulces.Cocinado al horno en moldes al uso, presentan una base cilíndrica y una superficie más ancha, con forma de hongo');
insert into Producto values(5, 'Lemon pie', 1500.00, 12, 'El lemon pie, uno de los postres más clásicos, en la versión de la querida Blanca Cotta.');
insert into Producto values(6, 'Torta bombon', 1200.00, 8, 'La tarta bombón es la combinación perfecta, con una mezcla de texturas y sabores realmente increíble: la galleta crujiente de la base con el sabor intenso de un buen dulce de leche, coronado con el chocolate amargo de la cobertura.');
insert into Producto values(7, 'Tiramisu', 2000.00, 12, 'Con vainillas compradas o con vainillas caseras, con queso blanco o con mascarpone, con café y con cacao en polvo, este postre siempre es un golazo');
insert into Producto values(8, 'Tarta de frutillas', 1900.00, 12, 'Esta receta de tarta de frutillas se prepara con crema chantillí, si se quiere se puede optar por crema pastelera y, para los más golosos se le puede sumar dulce de leche. Es ideal prepararla cuando las frutillas están en temporada.');

//(id_Estado, descripcion_Estado)
insert into Estado values (1, 'Aceptado');
insert into Estado values (2, 'En proceso');
insert into Estado values (3, 'Cancelado');
insert into Estado values (4, 'Terminado');
insert into Estado values (5, 'En espera de confirmacion');
insert into Estado values (6, 'En espera de pago');

//(id_TipoPago, descripcion_TP)
insert into Tipo_Pago values (1, 'Tarjeta de Credito');
insert into Tipo_Pago values (2, 'Tarjeta de Débito');
insert into Tipo_Pago values (3, 'Efectivo');
insert into Tipo_Pago values (4, 'Mercado Pago');
insert into Tipo_Pago values (5, 'Transferencia');
insert into Tipo_Pago values (6, 'Deposito');

//(id_TipoMP, descripcion_TipoMP)
insert into Tipo_MateriaPrima values (1, 'Chocolates');
insert into Tipo_MateriaPrima values (2, 'Harinas');
insert into Tipo_MateriaPrima values (3, 'Lácteos');
insert into Tipo_MateriaPrima values (4, 'Frutas');
insert into Tipo_MateriaPrima values (5, 'Frutos secos');
insert into Tipo_MateriaPrima values (6, 'Origen animal');
insert into Tipo_MateriaPrima values (7, 'Endulzantes');

//(id_MateriaPrima, Nombre_MP, Fecha_vto_Proxima, stock, unidades, id_TipoMP)
insert into Materia_Prima (id_MateriaPrima, Nombre_MP, Fecha_vto_Proxima, stock, unidades, id_TipoMP) values (1, 'Harina 0000', to_date('12/01/2024','dd,mm,yyyy'),20 , 'Kg', 2);
insert into Materia_Prima values (2, 'Harina leudante', to_date('12/01/2024','dd,mm,yyyy'),10 , 'Kg', 2);
insert into Materia_Prima values (3, 'Harina de coco', to_date('04/11/2023','dd,mm,yyyy'),4 , 'Kg', 2);
insert into Materia_Prima values (4, 'Harina de maíz', to_date('01/12/2023','dd,mm,yyyy'),4 , 'Kg', 2);
insert into Materia_Prima values (5, 'Manteca', to_date('20/06/2023','dd,mm,yyyy'),100 , 'Gramos', 3);
insert into Materia_Prima values (6, 'Crema de leche', to_date('25/05/2023','dd,mm,yyyy'),8 , 'Gramos', 3);
insert into Materia_Prima values (7, 'Yogur', to_date('12/01/2023','dd,mm,yyyy'),5 , 'Gramos', 3);
insert into Materia_Prima values (8, 'Queso crema', to_date('10/04/2023','dd,mm,yyyy'),25 , 'Gramos', 3);
insert into Materia_Prima values (9, 'Leche', to_date('16/04/2023','dd,mm,yyyy'),25 , 'Litro', 3);
insert into Materia_Prima values (10, 'Chocolate negro', to_date('04/09/2023','dd,mm,yyyy'),6 , 'kg', 1);
insert into Materia_Prima values (11, 'Chocolate blanco', to_date('25/07/2023','dd,mm,yyyy'),6 , 'kg', 1);
insert into Materia_Prima values (12, 'Chocolate amargo', to_date('18/08/2023','dd,mm,yyyy'),3 , 'kg', 1);
insert into Materia_Prima values (13, 'Chocolate con leche', to_date('04/08/2023','dd,mm,yyyy'),6 , 'kg', 1);
insert into Materia_Prima values (14, 'Dulce de leche', to_date('13/02/2024','dd,mm,yyyy'),6 , 'Kg', 3);
insert into Materia_Prima values (15, 'Frutillas','', 6, 'Kg', 4);
insert into Materia_Prima values (16, 'Limon','', 8, 'kg', 4);
insert into Materia_Prima values (17, 'Naranja','', 5, 'kg', 4);
insert into Materia_Prima values (18, 'Durazno','', 5, 'kg', 4);
insert into Materia_Prima values (19, 'Durazno en lata', to_date('16/03/2024','dd,mm,yyyy'),8 , 'Kg', 4);
insert into Materia_Prima values (20, 'Almendras','', 200, 'Gramo', 5);
insert into Materia_Prima values (21, 'Nueces','', 200, 'Gramos', 5);
insert into Materia_Prima values (22, 'Huevo','', 7, 'Unidad', 5);
insert into Materia_Prima values (23, 'Miel','', 200, 'Gramos', 5);
insert into Materia_Prima values (24, 'grasa','', 200, 'Gramos', 5);
insert into Materia_Prima values (25, 'Azúcar','', 3, 'Km', 7);

//(id_Proveedor, id_MateriaPrima, fecha_compra, cantidad-compra, precio-compra)
insert into Compra values (1, 1, to_date('21/03/2023','dd,mm,yyyy'), 5, 240.00);
insert into Compra values (1, 2, to_date('21/03/2023','dd,mm,yyyy'), 5, 240.00);
insert into Compra values (1, 8, to_date('21/12/2022','dd,mm,yyyy'), 3, 320.00);
insert into Compra values (1, 1, to_date('28/03/2023','dd,mm,yyyy'), 5, 250.00);
insert into Compra values (2, 14, to_date('22/03/2023','dd,mm,yyyy'), 5, 500.00);
insert into Compra values (2, 15, to_date('14/11/2022','dd,mm,yyyy'), 4, 510.00);
insert into Compra values (2, 12, to_date('02/07/2022','dd,mm,yyyy'), 6, 350.00);
insert into Compra values (2, 10, to_date('28/03/2022','dd,mm,yyyy'), 5, 300.00);
insert into Compra values (3, 14, to_date('24/03/2023','dd,mm,yyyy'), 10, 1000.00);
insert into Compra values (3, 6, to_date('24/06/2022','dd,mm,yyyy'), 10, 260.00);
insert into Compra values (3, 5, to_date('17/05/2022','dd,mm,yyyy'), 10, 240.00);
insert into Compra values (3, 9, to_date('24/03/2023','dd,mm,yyyy'), 12, 150.00);
insert into Compra values (3, 21, to_date('24/03/2023','dd,mm,yyyy'), 3, 200.00);

//(id_MateriaPrima, id_Producto, cantidad, unidades)
insert into Ingrediente values(1, 2, 90, 'Gramos');
insert into Ingrediente values(10, 2, 50, 'Gramos');
insert into Ingrediente values(22, 2, 4, 'Unidad');
insert into Ingrediente values(6, 2, 1, 'Litro');
insert into Ingrediente values(5, 3, 100, 'Gramos');
insert into Ingrediente values(22, 3, 4, 'Unidad');
insert into Ingrediente values(1, 3, 100, 'Gramos');
insert into Ingrediente values(12, 3, 150, 'Gramos');
insert into Ingrediente values(21, 3, 100, 'Gramos');
insert into Ingrediente values(25, 3, 300, 'Gramos');
insert into Ingrediente values(8, 1, 300, 'Gramos');
insert into Ingrediente values(14, 1, 400, 'Gramos');
insert into Ingrediente values(1, 4, 400, 'Gramos');
insert into Ingrediente values(22, 4, 4, 'Unidad');
insert into Ingrediente values(16, 4, 1, 'Unidad');
insert into Ingrediente values(9, 4, 200, 'Cm3');
insert into Ingrediente values(5, 4, 100, 'Gramos');
insert into Ingrediente values(23, 4, 1, 'Cda');
insert into Ingrediente values(1, 5, 500, 'Gramos');
insert into Ingrediente values(5, 5, 300, 'Gramos');
insert into Ingrediente values(16, 5, 1, 'Unidad');
insert into Ingrediente values(22, 5, 8, 'Unidad');
insert into Ingrediente values(22, 6, 3, 'Unidad');
insert into Ingrediente values(10, 6, 125, 'Gramos');
insert into Ingrediente values(5, 6, 200, 'Gramos');
insert into Ingrediente values(1, 6, 130, 'Gramos');
insert into Ingrediente values(14, 6, 500, 'Gramos');
insert into Ingrediente values(6, 7, 400, 'Cm3');
insert into Ingrediente values(12, 7, 1, 'Unidad');
insert into Ingrediente values(15, 8, 4, 'Kg');

//(id_Producto, paso_nro, descripcion)
insert into Pasos_Receta values(1, 1, 'En un bowl, mezclar el queso crema con el dulce de leche hasta que quede una crema de color uniforme.');
insert into Pasos_Receta values(1, 2, 'En una fuente rectangular intercalar las galletitas humedecidas con el oporto con la crema de dulce de leche.');
insert into Pasos_Receta values(1, 3, 'Repetir las capas hasta terminar las galletitas.');
insert into Pasos_Receta values(1, 4, 'Finalizar decorando con una capa de la crema o, si se desea, bañar en chocolate.');
insert into Pasos_Receta values(2, 1, 'Batir las claras de los huevos a punto de nieve y reservar.');
insert into Pasos_Receta values(2, 2, 'En otro bol batir las 4 yemas junto con 120 gr. de azúcar hasta que duplique su volumen inicial logrando una crema espumosa.');
insert into Pasos_Receta values(2, 3, 'Colocar una pizca de sal sobre las claras batidas e incorporar esto a las yemas realizando movimientos envolventes y con mucho cuidado.');
insert into Pasos_Receta values(2, 4, 'Sumar la harina tamizada y el cacao de a partes mientras se mezcla con suavidad.');
insert into Pasos_Receta values(2, 5, 'Preparar un molde para bizcochuelo untando manteca en los bordes y cubriéndolo con papel manteca. Introducir en este la mezcla. Hornear por 25 minutos en un horno precalentado a 180 °C.');
insert into Pasos_Receta values(2, 6, 'Pasado el tiempo, comprobar su cocción pinchando con un cuchillo que debe salir seco. Desmoldar y enfriar bien.');

insert into Pasos_Receta values(3, 1, 'Batir los huevos con el azúcar sólo para unirlos.?');
insert into Pasos_Receta values(3, 2, 'Derretir a baño maría el chocolate con la manteca y verterlos sobre los huevos batidos.?');
insert into Pasos_Receta values(3, 3, 'Integrar la harina con las nueces y agregarlas a la mezcla del chocolate.');
insert into Pasos_Receta values(3, 4, 'Verter en una placa enmantecada (de 16 x 26 cm o 20 x 20) y hornear a 180°/200, por 25 o 30 minutos. Dejar enfriar y cortar en cuadrados.');

insert into Pasos_Receta values(4, 1, 'Batir con batidora la manteca blanda con el azúcar hasta obtener una crema.');
insert into Pasos_Receta values(4, 2, 'Mezclar los huevos con la leche y agregar a la preparación. Perfumar con esencia de vainilla e ir agregando el resto de los ingredientes, el aceite, el juego de limón, la miel. Integrar.');
insert into Pasos_Receta values(4, 3, 'Luego mezclar la harina, el bicarbonato de sodio, y el polvo de hornear e incorporar. Batir hasta lograr una masa homogénea. Verter en los moldes, pirotines con forma de tulipa. Hornear a 180°, por 45 minutos. ');
insert into Pasos_Receta values(5, 1, 'La masa. En batidora (o a mano) batir la manteca con el azúcar.');
insert into Pasos_Receta values(5, 2, 'Sumar el huevo y cuando se incorpore, añadir la harina. Batir hasta formar la masa.');
insert into Pasos_Receta values(5, 3, 'Colocar en una bolsa o papel film y llevar a la heladera por 30 minutos.  Estirar y forrar una tartera de 24 cm. Pincharla con un tenedor. Recortar los bordes en forma prolija.');
insert into Pasos_Receta values(5, 4, 'Colocar peso sobre la tarta y cocinarla a blanco 15 minutos. Luego, retirar el peso y cocinarla otros 10 minutos. Retirar del horno y dejar enfriar.');
insert into Pasos_Receta values(5, 5, 'El relleno. Poner en una cacerola todos los ingredientes menos la gelarina. Cocinar a fuego bajo, revolviendo siempre. Cuando espese y comiencen las burbujas, apartar del fuego. Dejar entibiar.');
insert into Pasos_Receta values(5, 6, 'Una vez tibia la crema, rellenar la tarta precocida, alisando la superficie.');
insert into Pasos_Receta values(5, 7, 'El merengue. Realizar un almíbar con el azúcar y  cubriri con agua. Batir las claras hasta espumarlas. Cuando el almíbar llegue  los 118°, verterlo en forma de hilo sobre las claras, mientras se baten. Continuar el batido hasta que el bowl se sienta frío. ');
insert into Pasos_Receta values(5, 8, 'Estacionar la tarta en la heladera hasta que la crema esté bien firme. Retirar la tarta de la heladera y cubrirla totalmente con el merengue. Para que quede "doradita", meterla en el horno un minuto. Enfriar.');
insert into Pasos_Receta values(6, 1, 'En un bol, batir los huevos con el azúcar.');
insert into Pasos_Receta values(6, 2, 'Fundir el chocolate cobertura en el microondas. Añadirle la manteca blanda mezclando hasta formar una crema.');
insert into Pasos_Receta values(6, 3, 'Unir la harina común y el cacao amargo. reservar.');
insert into Pasos_Receta values(6, 4, 'Sumar a la mezcla de huevos y azúcar la crema de chocolate ya fría.');
insert into Pasos_Receta values(6, 5, 'Por último, sumar el harina cernida junto con el cacao amargo e integrar en forma envolvente para que se mezcle bien con la preparación. Incorporar las nueces. Verter la mezcla en una placa de 20 centímetros por 30, enmantecada y forrada con papel manteca o aluminio, también enmantecado.');
insert into Pasos_Receta values(6, 6, 'Llevar a horno a 180°, por unos 25 minutos. Retirar del horno y dejar enfriar. Decorar con dulce de leche, pasta de avellanas y bombones.');
insert into Pasos_Receta values(7, 1, 'Batir las yemas a baño María e incorporar el azúcar y el cognac o amaretto. Batimos por 5 minutos aproximadamente. Retirar del fuego y batir hasta que las yemas estén a temperatura ambiente. Van a notar que las yemas triplican su tamaño y hacerse una especie de crema. Hermoso. Vamos bien.');
insert into Pasos_Receta values(7, 2, 'batir un poco el mascarpone para que no tenga grumos. El paso mas fácil de la historia pero es muy importante  en esta receta de Tiramisú.');
insert into Pasos_Receta values(7, 3, 'Verter las yemas sobre el mascarpone e integrar con movimientos envolventes. Sumar la crema de leche semi batida y mezclar suavemente.');
insert into Pasos_Receta values(7, 4, 'Hidratar los bizcochos de tiramisú en el café. ');
insert into Pasos_Receta values(7, 5, 'Disponer la primer capa vainillas en la fuente. También se pueden hacer vasitos, lo que más te haga feliz Mabel. No importa en qué lo prepares, tiene que quedar una capa de vainillas, una de crema, una de vainillas y por último una de crema.');
insert into Pasos_Receta values(7, 6, 'Espolvoreamos por arriba el cacao amargo y el chocolate semi amargo rallado o picado y a la heladera! El tiramisú frío es mucho más rico!');

//(id_Cliente, id_Producto, fecha_valoracion, cant_estrellas, comentario)
insert into Valoracion values(1, 1, to_date('04/01/2022','dd,mm,yyyy'), 5, 'Muy buen producto');
insert into Valoracion values(2, 1, to_date('25/02/2023','dd,mm,yyyy'), 4, 'Producto recomendado');
insert into Valoracion values(3, 4, to_date('15/07/2021','dd,mm,yyyy'), 4, '');
insert into Valoracion values(4, 3, to_date('11/01/2023','dd,mm,yyyy'), 3, '');
insert into Valoracion values(3, 2, to_date('14/12/2022','dd,mm,yyyy'), 5, 'Muy rica torta');
insert into Valoracion values(2, 2, to_date('12/10/2022','dd,mm,yyyy'), 3, '');

//(id_Pedido,id_Cliente, fecha_pedido, fecha_entrega, lugar_entrega, id_estado, id_TipoPago)
insert into Pedido values(1, 1, to_date('30/03/2023','dd,mm,yyyy'), to_date('03/04/2023','dd,mm,yyyy'), '105 oeste 546', 1, 5);
insert into Pedido values(2, 2, to_date('12/03/2023','dd,mm,yyyy'), to_date('25/03/2023','dd,mm,yyyy'), 'calle 329 64', 3, 2);
insert into Pedido values(3, 4, to_date('11/03/2023','dd,mm,yyyy'), to_date('25/03/2023','dd,mm,yyyy'), 'av. Sarmiento', 1, 2);
insert into Pedido values(4, 6, to_date('16/04/2023','dd,mm,yyyy'), to_date('28/04/2023','dd,mm,yyyy'), 'sarmiento 231', 5, 4);
insert into Pedido values(5, 6, to_date('21/04/2023','dd,mm,yyyy'), to_date('02/05/2023','dd,mm,yyyy'), 'sarmiento 231', 3, 4);
insert into Pedido values(6, 3, to_date('14/01/2023','dd,mm,yyyy'), to_date('25/01/2023','dd,mm,yyyy'), 'calle 32 534', 2, 4);
insert into Pedido values(7, 5, to_date('01/02/2023','dd,mm,yyyy'), to_date('23/02/2023','dd,mm,yyyy'), 'av. San Martiin 105', 3, 2);

//(id_Pedido, id_Producto, cantidad_pedido, precio, observación)
insert into productosXpedido values(1, 1, 2, 1250.00, '');
insert into productosXpedido values(4, 2, 1, 3000.00, '');
insert into productosXpedido values(4, 4, 6, 250.00, '3 de limón y 3 de naranja');
insert into productosXpedido values(2, 6, 1, 1400.00, '');
insert into productosXpedido values(3, 5, 2, 1500.00, '');
insert into productosXpedido values(7, 5, 1, 1500.00, '');
insert into productosXpedido values(7, 3, 3, 2500.00, 'Un paquete cerrado con moño rosa y los otros dos con moño blanco');

