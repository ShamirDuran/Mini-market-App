/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author NICOLAS
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.ProductoDao;
import model.vo.ProductoVo;

public class ProductosController {

    private ProductoDao productoDao;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Este metodo carga los productos registrados en la tabla de la vista
     * Productos
     *
     * @return
     */
    public Boolean obtenerListaProductos() {
        ResultSet rs = productoDao.obtenerProductos();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] producto = new String[7];

                while (rs.next()) {
                    producto[0] = rs.getString("id");
                    producto[1] = rs.getString("nombre");
                    producto[2] = rs.getString("precio");
                    producto[3] = rs.getString("cant_medida");
                    producto[4] = rs.getString("uni_medida");
                    producto[5] = rs.getString("cantidad");
                    producto[6] = rs.getString("cantidad_vendidos");

                    model.addRow(producto);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer productos: " + e);;
            }
        } else {
            System.out.println("No se recibio datos productos, null");
        }
        return false;
    }
//
//    private void limpiarTabla() {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        int rowCount = model.getRowCount();
//        for (int i = rowCount - 1; i >= 0; i--) {
//            model.removeRow(i);
//        }
//    }

//    public void mostrarListaProductos() {
//        System.out.println("\n/-- Lista de productos registrados --/");
//        mostrarListaProducto(productoDao.obtenerProductos());
//    }
    public Boolean buscarProducto(String nombre) {
        ResultSet rs = productoDao.buscarProducdo(nombre);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] producto = new String[7];

                while (rs.next()) {
                    producto[0] = rs.getString("id");
                    producto[1] = rs.getString("nombre");
                    producto[2] = rs.getString("precio");
                    producto[3] = rs.getString("cant_medida");
                    producto[4] = rs.getString("uni_medida");
                    producto[5] = rs.getString("cantidad");
                    producto[6] = rs.getString("cantidad_vendidos");

                    model.addRow(producto);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer productos buscados: " + e);;
            }
        } else {
            System.out.println("No se recibio datos productos buscados, null");
        }
        return false;
    }

//    public ProductoVo buscarProductoId(int id) {
//        ProductoVo producto = productoDao.obtenerProductoId(id);
//
//        if (producto != null) {
//            System.out.println("\n/-- Producto con id " + id + " encontrado");
//            return producto;
//        } else {
//            System.out.println("\nProducto con id " + id + " no encontrado!!");
//            return null;
//        }
//    }

    /**
     * Metodo que pide al modelo que se añada un usuario a la db
     *
     * @return true si se realizo la operación, false si no
     */
    public boolean añadirProducto(String nombre, double precio, double cant_medida, String uni_medida, int cantidad) {
        boolean check = productoDao.guardarProducto(nombre, precio, cant_medida, uni_medida, cantidad);

        if (check) {
            System.out.println("\nProducto " + nombre + " registrado correctamente!!");
//            limpiarTabla();
            obtenerListaProductos();
        } else {
            System.out.println("\nError al registrar nuevo Producto!!");
        }

        return check;
    }

    /**
     * Metodo que pide al modelo modificar un usuario en la db
     *
     * @param producto Datos que se desean actualizar para el usuario.
     * @return true si se realizo la operación, false si no
     */
    public boolean modificarProducto(ProductoVo producto) {
        boolean check = productoDao.modificarProducto(producto);
        if (check) {
            System.out.println("\nProducto modificado correctamente!!");
//            limpiarTabla();
            obtenerListaProductos();
        } else {
            System.out.println("\nNo se encontro el Producto!!");
        }

        return check;
    }

    /**
     * Metodo que pide al modelo que elimine un usuario de la db
     *
     * @param id Id del usuario que se desea eliminar
     * @return true si se realizo la operación, false si no
     */
    public boolean eliminarProducto(int id) {
        boolean check = this.productoDao.eliminarProducto(id);
        if (check) {
            System.out.println("\nProducto con id " + id + " eliminado correctamente!!");
//            limpiarTabla();
            obtenerListaProductos();
        } else {
            System.out.println("\nNo se encontro producto con id " + id);
        }

        return check;
    }

//    // Esto se hace desde la vista, pero de momento para esta entrega se hara aca.
//    private void mostrarListaProducto(ArrayList<ProductoVo> listaProductos) {
////        System.out.println("Total: " + listaProductos.size());
//
//        for (ProductoVo producto : listaProductos) {
//            System.out.println(producto);
//        }
//    }

    public void setProductoDao(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
}
