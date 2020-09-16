############################################### INSERT DATA ###############################################

INSERT INTO t_productos(nombre, precio, cant_medida, uni_medida, cantidad, cantidad_vendidos)
VALUES
("DESENGRASANTE", 4000, 500, "ml", 100, 0),
("ARROZ", 1650, 500, "g", 69, 0),
("GASEOSA COCA COLA", 2790, 500, "ml", 72, 0),
("CREMA COLGATE", 2250, 75, "ml", 40, 0),
("PAPAS FRITAS KYTHOS", 1890, 115, "g", 30, 0),
("MAYONESA BAJA EN GRASA", 2250, 500, "g", 40, 0),
("MERMELADA DE MORA ZEV", 1750, 200, "g", 80, 0),
("GALLETA WAFER", 790, 22, "g", 51, 0),
("QUESO MOZZARELLA", 5690, 400, "g", 100, 0),
("SALSA DE PIÑA", 200, 20, "g", 91, 0);

INSERT INTO t_usuarios(rol, edad, genero, nombre, correo, direccion, cedula, transacciones)
VALUES
(1, 20, 1, "Shamir Duran", "shamirduran@gmail.com", "La universidad", 1005333241, 0),
(2, 25, 1, "Pepito Perez", "pepitoperez@gmail.com", "La cumbre", 1009665847, 0),
(3, 40, 1, "Jose Manolo", "josemano@gmail.com", "San alonso", 1059111567, 0),
(1, 20, 1, "Nicolas Galvan", "nicolasgalvan@hotmail.com", "Centro", 2005698520, 0),
(3, 15, 0, "Marcela Lopez", "marcelolopez@hotmail.com", "Norte", 1008951672, 0),
(4, 55, 0, "Doña carmensa", "carmensita@gmail.com", "Lagos 2", 2016998250, 0),
(4, 65, 0, "Eduvigis Sarmiento", "eduvigisar@hotmail.com", "Castellana", 1506554951, 0),
(4, 25, 1, "Carlos Gomez", "carlooos@gmail.com", "La cumbre", 1305334246, 0);


CALL registrar_venta(1,8 , "15-09-2020 15:57:47",19050);
CALL registrar_venta(1,7 , "15-09-2020 15:58:08",6800);
CALL registrar_venta(1,6 , "16-09-2020 15:58:23",9450);
CALL registrar_venta(1,3 , "16-09-2020 15:59:04",7160);
CALL registrar_venta(1,2 , "16-09-2020 16:16:59",18960);
CALL registrar_venta(1,5 , "16-09-2020 15:59:24",39830);
CALL registrar_venta(4,7 , "16-09-2020 16:59:24",6830);
CALL registrar_venta(4,5 , "16-09-2020 17:16:43",4500);
CALL registrar_venta(4,3 , "16-09-2020 17:16:58",8970);
CALL registrar_venta(1,8 , "16-09-2020 17:17:14",800);
CALL registrar_venta(1,6 , "16-09-2020 17:17:32",4000);

CALL registrar_venta_producto(1,7,2);
CALL registrar_venta_producto(1,4,3);
CALL registrar_venta_producto(1,1,2);
CALL registrar_venta_producto(1,10,4);
CALL registrar_venta_producto(2,2,2);
CALL registrar_venta_producto(3,5,5);
CALL registrar_venta_producto(4,3,2);
CALL registrar_venta_producto(4,8,2);
CALL registrar_venta_producto(5,9,3);
CALL registrar_venta_producto(5,5,1);
CALL registrar_venta_producto(6,9,7);
CALL registrar_venta_producto(7,7,3);
CALL registrar_venta_producto(7,8,2);
CALL registrar_venta_producto(8,4,2);
CALL registrar_venta_producto(9,5,3);
CALL registrar_venta_producto(9,2,2);
CALL registrar_venta_producto(10,10,4);
CALL registrar_venta_producto(11,1,1);





