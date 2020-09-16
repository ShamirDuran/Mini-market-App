DELIMITER $$
CREATE PROCEDURE registrar_venta(IN vendedor INT, comprador INT, fecha VARCHAR(30), total DOUBLE)
BEGIN
	DECLARE venta_id INT;

	INSERT INTO t_ventas (fk_vendedor, fk_comprador, fecha, total)
    VALUES (vendedor, comprador, fecha, total);
    
    # se obtiene el id de la venta que se acaba de registrar
    SELECT LAST_INSERT_ID() INTO venta_id;
    
    UPDATE t_usuarios 
    SET transacciones = transacciones + 1 
    WHERE id = vendedor OR id = comprador;

	# se retorna el id de la venta que se realizo
	SELECT venta_id;
END; $$


DELIMITER $$
CREATE PROCEDURE registrar_venta_producto(IN venta INT, producto INT, comprados INT)
BEGIN
	INSERT INTO t_venta_producto(fk_venta, fk_producto, cantidad)
    VALUES (venta, producto, comprados);
    
    UPDATE t_productos p
    SET p.cantidad_vendidos = (SELECT SUM(cantidad) AS cantidad FROM t_venta_producto WHERE fk_producto = producto),
    p.cantidad = p.cantidad - (SELECT SUM(cantidad) AS cantidad FROM t_venta_producto WHERE fk_producto = producto)
    WHERE p.id = producto;
END; $$


DELIMITER $$
CREATE PROCEDURE obtener_transacciones()
BEGIN
	CREATE TEMPORARY TABLE t1
		SELECT v.id, v.fecha, v.fecha_mod, u.nombre as vendedor, v.total
		FROM t_ventas v INNER JOIN t_usuarios u
		ON v.fk_vendedor=u.id;
    
	CREATE TEMPORARY TABLE t2
		SELECT v.id, v.fecha, v.fecha_mod, u.nombre as comprador, v.total
		FROM t_ventas v INNER JOIN t_usuarios u
		ON v.fk_comprador=u.id;
		
	SELECT t1.id, t1.fecha, t1.fecha_mod, t1.vendedor, t2.comprador, t1.total
	FROM t1 INNER JOIN t2
	ON t1.id = t2.id;
    
    DROP TABLE t1, t2;
END; $$


DELIMITER $$
CREATE PROCEDURE detalles_venta(IN venta_id INT)
BEGIN
	SELECT p.id, p.nombre, p.precio, vp.cantidad, (p.precio*vp.cantidad) AS total
		FROM t_ventas v
		INNER JOIN t_venta_producto vp ON v.id = vp.fk_venta
		INNER JOIN t_productos p ON vp.fk_producto = p.id
		WHERE v.id = venta_id;
END; $$


DELIMITER $$
CREATE PROCEDURE filtro_venta(IN nombre VARCHAR(100))
BEGIN
	CREATE TEMPORARY TABLE t1
		SELECT v.id, v.fecha, v.fecha_mod, u.nombre as vendedor, v.total
		FROM t_ventas v INNER JOIN t_usuarios u
		ON v.fk_vendedor=u.id;
    
	CREATE TEMPORARY TABLE t2
		SELECT v.id, v.fecha, v.fecha_mod, u.nombre as comprador, v.total
		FROM t_ventas v INNER JOIN t_usuarios u
		ON v.fk_comprador=u.id;
		
	SELECT t1.id, t1.fecha, t1.fecha_mod, t1.vendedor, t2.comprador, t1.total
		FROM t1 INNER JOIN t2
		ON t1.id = t2.id
        WHERE t2.comprador LIKE CONCAT(nombre, '%');
    
    DROP TABLE t1, t2;
END; $$


DELIMITER $$
CREATE PROCEDURE eliminar_venta(IN venta_id INT)
BEGIN
	UPDATE t_usuarios 
    SET transacciones = transacciones - 1 
    WHERE id IN (SELECT fk_vendedor FROM t_ventas WHERE id = venta_id);

	UPDATE t_usuarios 
    SET transacciones = transacciones - 1 
    WHERE id IN (SELECT fk_comprador FROM t_ventas WHERE id = venta_id);

    UPDATE t_productos p 
    INNER JOIN t_venta_producto vp 
    ON vp.fk_venta = venta_id AND vp.fk_producto = p.id
    SET p.cantidad = p.cantidad + vp.cantidad, p.cantidad_vendidos = p.cantidad_vendidos - vp.cantidad;
    
    DELETE FROM t_venta_producto WHERE fk_venta = venta_id;
	DELETE FROM t_ventas WHERE id = venta_id;
    
END; $$


DELIMITER $$
CREATE PROCEDURE modificar_venta(IN venta_id INT, total_new DOUBLE, fecha_new VARCHAR(30))
BEGIN 
	UPDATE t_ventas 
    SET total = total_new, fecha_mod = fecha_new  
    WHERE id = venta_id;
END; $$


DELIMITER $$
CREATE PROCEDURE modificar_venta_pro(IN venta_id INT, producto_id INT, cantidad_new INT)
BEGIN
	UPDATE t_venta_producto
    SET cantidad = cantidad_new 
    WHERE fk_venta = venta_id AND fk_producto = producto_id;
END; $$


DELIMITER $$
CREATE PROCEDURE eliminar_venta_pro(IN venta_id INT, producto_id INT)
BEGIN
	UPDATE t_productos p
    SET 
    p.cantidad_vendidos = p.cantidad_vendidos - (SELECT SUM(cantidad) AS cantidad FROM t_venta_producto WHERE fk_producto = producto_id AND fk_venta = venta_id),
    p.cantidad = p.cantidad + (SELECT SUM(cantidad) AS cantidad FROM t_venta_producto WHERE fk_producto = producto_id)
    WHERE p.id = producto_id;
    
	DELETE FROM t_venta_producto WHERE fk_venta = venta_id AND fk_producto = producto_id;
END; $$

#DROP PROCEDURE IF EXISTS registrar_venta;
#DROP PROCEDURE IF EXISTS registrar_venta_producto;
#DROP PROCEDURE IF EXISTS obtener_transacciones;
#DROP PROCEDURE IF EXISTS detalles_venta;
#DROP PROCEDURE IF EXISTS filtro_venta;
#DROP PROCEDURE IF EXISTS eliminar_venta;
#DROP PROCEDURE IF EXISTS modificar_venta;
#DROP PROCEDURE IF EXISTS modificar_venta_pro;
#DROP PROCEDURE IF EXISTS eliminar_venta_pro;

#CALL registrar_venta(1, 7, '13/09/2020 15-05-55', 55000);
#CALL registrar_venta_producto(2, 1, 100);
#CALL obtener_transacciones();
#CALL detalles_venta(7);
#CALL filtro_venta('edu');
#CALL eliminar_venta(7);
