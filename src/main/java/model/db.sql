CREATE DATABASE IF NOT EXISTS minimarket;
USE minimarket;

############################################### CREATE TABLES ###############################################

CREATE TABLE IF NOT EXISTS t_productos (
	id				INT AUTO_INCREMENT NOT NULL,
    nombre				VARCHAR(60) NOT NULL,
    precio				DOUBLE NOT NULL,
    cant_medida			DOUBLE NOT NULL,
    uni_medida			VARCHAR(25) NOT NULL,
    cantidad			INT NOT NULL,
    cantidad_vendidos	INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS t_usuarios (
	id		INT AUTO_INCREMENT NOT NULL,
    rol				INT NOT NULL,
    edad			INT NULL,
    genero			CHAR(1) NULL,
    transacciones	INT NOT NULL,
    nombre			VARCHAR(65) NOT NULL,
    correo			VARCHAR(60) NULL,
    direccion		VARCHAR(120) NULL,
    cedula			INT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS t_ventas (
	id			INT AUTO_INCREMENT NOT NULL,
    fk_vendedor		INT NOT NULL,
    fk_comprador	INT NULL,
    fecha			VARCHAR(30) NOT NULL,
    fecha_mod		VARCHAR(30) NOT NULL,
    total			DOUBLE NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(fk_vendedor) REFERENCES t_usuarios(id),
    FOREIGN KEY(fk_comprador) REFERENCES t_usuarios(id)
);

CREATE TABLE IF NOT EXISTS t_venta_producto (
	id				INT AUTO_INCREMENT,
    fk_venta		INT NOT NULL,
    fk_producto		INT NOT NULL,
    cantidad		INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(fk_venta) REFERENCES t_ventas(id),
    FOREIGN KEY(fk_producto) REFERENCES t_productos(id)
);
