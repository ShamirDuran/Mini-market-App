DELIMITER $$
CREATE PROCEDURE registrar_venta(IN vendedor INT, comprador INT, fecha VARCHAR(30), total DOUBLE)
BEGIN
	DECLARE venta_id INT;

	INSERT INTO t_ventas (fk_vendedor, fk_comprador, fecha, total)
    VALUES (vendedor, comprador, fecha, total);
    
    # se obtiene el id de la venta que se acaba de registrar
    SELECT LAST_INSERT_ID() INTO venta_id;
    
    UPDATE t_usuarios SET transacciones = transacciones + 1 WHERE id = vendedor OR id = comprador;

	# se retorna el id de la venta que se realizo
	SELECT venta_id;
END; $$

DELIMITER $$
CREATE PROCEDURE registrar_venta_producto(IN venta INT, producto INT, comprados INT)
BEGIN
	INSERT INTO t_venta_producto(fk_venta, fk_producto, cantidad)
    VALUES (venta, producto, cantidad);
    
    UPDATE t_productos SET cantidad = cantidad - comprados, cantidad_vendidos = cantidad_vendidos + comprados WHERE id = producto;
END; $$


#DROP PROCEDURE IF EXISTS registrar_venta;
#DROP PROCEDURE IF EXISTS registrar_venta_producto;

#CALL registrar_venta(1, 7, '13/09/2020 15-05-55', 55000);
#CALL registrar_venta_producto(2, 1, 100);
