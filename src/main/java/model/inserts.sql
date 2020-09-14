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




