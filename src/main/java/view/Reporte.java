/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProductosController;
import controller.UsuariosController;
import controller.VentasController;
import model.vo.ProductoVo;
import model.vo.UsuarioVo;

/**
 *
 * @author Shamir
 */
public class Reporte {

    ProductosController proController;
    UsuariosController usuController;
    VentasController ventaController;

    public void reporteVentasTotales() {
        int ventas_totales = 0;

        System.out.println("\n/-- VENTAS TOTALES --/");
        for (ProductoVo producto : proController.obtenerListaProductos()) {
            ventas_totales = ventas_totales + producto.getCantidadVendidos();
        }

        System.out.println("VENTAS TOTALES: " + ventas_totales);
    }

    public void reporteVentaPorProducto() {
        System.out.println("\n/-- VENTAS POR PRODUCTO --/");
        for (ProductoVo producto : proController.obtenerListaProductos()) {
            System.out.println(
                    "ID: " + producto.getId() + "   " + producto.getNombre() + "   " + producto.getCantidadVendidos());
        }
    }

    public void reporteVentaPorCajero() {
        System.out.println("\n/-- REPORTE VENTA POR CAJERO --/");
        for (UsuarioVo user : usuController.obtenerListaUsuarios()) {
            if (user.getRol() != 4) {
                System.out.println("ID: " + user.getId() + "   ROL: " + user.getRol() + "   " + user.getNombre()
                        + "   VENTAS: " + user.getTransacciones());
            }
        }
    }

    public void reporteCompraporCliente() {
        System.out.println("\n/-- REPORTE VENTA POR CLIENTE --/");
        for (UsuarioVo user : usuController.obtenerListaUsuarios()) {
            if (user.getRol() == 4) {
                System.out.println(
                        "ID: " + user.getId() + "   " + user.getNombre() + "   COMRPRAS: " + user.getTransacciones());
            }
        }
    }

    public void reporteGananciaTotal() {
        double ganancia_total = 0;

        System.out.println("\n/-- GANANCIA TOTAL --/");
        for (ProductoVo producto : proController.obtenerListaProductos()) {
            ganancia_total = ganancia_total + (producto.getPrecio() * producto.getCantidadVendidos());
        }
        System.out.println("TOTAL: " + ganancia_total);
    }

    public void reporteGananciaPorProducto() {
        System.out.println("\n /-- GANANCIA POR PRODUCTO --/");
        for (ProductoVo producto : proController.obtenerListaProductos()) {
            double ganancia = producto.getPrecio() * producto.getCantidadVendidos();
            System.out.println("ID: " + producto.getId() + "   " + producto.getNombre() + "   TOTAL: " + ganancia);
        }
    }

    public void hacerReporteCompleto() {
        reporteVentasTotales();
        reporteVentaPorProducto();
        reporteVentaPorCajero();
        reporteCompraporCliente();
        reporteGananciaTotal();
        reporteGananciaPorProducto();
    }

    public void setProController(ProductosController proController) {
        this.proController = proController;
    }

    public void setUsuController(UsuariosController usuController) {
        this.usuController = usuController;
    }

    public void setVentaController(VentasController ventaController) {
        this.ventaController = ventaController;
    }

}
