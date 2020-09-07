/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.dao.ProductoDao;
import model.dao.UsuarioDao;
import model.dao.VentaDao;
import model.vo.VentaVo;

/**
 *
 * @author Shamir
 */
public class Factory {

    public void cargarDatosUsuario(UsuarioDao usuarioDao) {
        /**
         * Roles:
         *
         * 1 : Admin 2 : Jefe de bodega 3 : Cajero 4 : Cliente
         */

        // Añadir trabajadores
        usuarioDao.añadirUsuario(1, 20, 1, "Shamir Duran", "shamirduran@gmail.com", "La universidad", 1005333241); // 1
        usuarioDao.añadirUsuario(2, 25, 1, "Pepito Perez", "pepitoperez@gmail.com", "La cumbre", 1009665847); // 2
        usuarioDao.añadirUsuario(3, 40, 1, "Jose Manolo", "josemano@gmail.com", "San alonso", 1059111567); // 3
        usuarioDao.añadirUsuario(1, 20, 1, "Nicolas Galvan", "nicolasgalvan@hotmail.com", "Centro", 2005698520); // 4
        usuarioDao.añadirUsuario(3, 15, 0, "Marcela Lopez", "marcelolopez@hotmail.com", "Norte", 1008951672); // 5

        // Añadir clientes
        usuarioDao.añadirUsuario(4, 55, 0, "Doña carmensa", "carmensita@gmail.com", "Lagos 2", 2016998250); // 6
        usuarioDao.añadirUsuario(4, 65, 0, "Eduvigis Sarmiento", "eduvigisar@hotmail.com", "Castellana", 1506554951); // 7
        usuarioDao.añadirUsuario(4, 25, 1, "Carlos Gomez", "carlooos@gmail.com", "La cumbre", 1305334246); // 8
    }

    public void cargarDatosProducto(ProductoDao productoDao) {
        productoDao.guardarProducto("DESENGRASANTE", 4000, 500, "ml", 100); // 1
        productoDao.guardarProducto("ARROZ", 1650, 500, "g", 69); // 2
        productoDao.guardarProducto("GASEOSA COCA COLA", 2790, 500, "ml", 72); // 3
        productoDao.guardarProducto("CREMA COLGATE", 2250, 75, "ml", 40); // 4
        productoDao.guardarProducto("PAPAS FRITAS KYTHOS", 1890, 115, "g", 30); // 5
        productoDao.guardarProducto("MAYONESA BAJA EN GRASA", 2250, 500, "g", 40); // 6
        productoDao.guardarProducto("MERMELADA DE MORA ZEV", 1750, 200, "g", 80); // 7
        productoDao.guardarProducto("GALLETA WAFER", 790, 22, "g", 51); // 8
        productoDao.guardarProducto("QUESO MOZZARELLA", 5690, 400, "g", 100); // 9
        productoDao.guardarProducto("SALSA DE PIÑA", 200, 20, "g", 91); // 10
    }

    public void cargarDatosVenta(VentaDao ventaDao, UsuarioDao usuarioDao, ProductoDao productoDao) {

        if (usuarioDao.buscarUsuarioId(6) != null) {
            VentaVo venta1 = new VentaVo(usuarioDao.buscarUsuarioId(6));
            venta1.añadirProducto(productoDao.obtenerProductoId(2), 5);
            venta1.añadirProducto(productoDao.obtenerProductoId(4), 2);
            venta1.añadirProducto(productoDao.obtenerProductoId(7), 1);
            ventaDao.registrarVenta(venta1); // 1
        }

        if (usuarioDao.buscarUsuarioId(7) != null) {
            VentaVo venta2 = new VentaVo(usuarioDao.buscarUsuarioId(7));
            venta2.añadirProducto(productoDao.obtenerProductoId(10), 10);
            venta2.añadirProducto(productoDao.obtenerProductoId(5), 1);
            ventaDao.registrarVenta(venta2); // 2
        }

        if (usuarioDao.buscarUsuarioId(8) != null) {
            VentaVo venta3 = new VentaVo(usuarioDao.buscarUsuarioId(8));
            venta3.añadirProducto(productoDao.obtenerProductoId(1), 4);
            venta3.añadirProducto(productoDao.obtenerProductoId(2), 3);
            venta3.añadirProducto(productoDao.obtenerProductoId(3), 2);
            venta3.añadirProducto(productoDao.obtenerProductoId(4), 1);
            venta3.añadirProducto(productoDao.obtenerProductoId(10), 1);
            ventaDao.registrarVenta(venta3); // 3
        }

        if (usuarioDao.buscarUsuarioId(6) != null) {
            VentaVo venta4 = new VentaVo(usuarioDao.buscarUsuarioId(6));
            venta4.añadirProducto(productoDao.obtenerProductoId(10), 5);
            venta4.añadirProducto(productoDao.obtenerProductoId(9), 2);
            venta4.añadirProducto(productoDao.obtenerProductoId(8), 4);
            venta4.añadirProducto(productoDao.obtenerProductoId(7), 7);
            ventaDao.registrarVenta(venta4); // 4
        }
    }
}
