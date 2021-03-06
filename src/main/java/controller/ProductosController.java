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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.ProductoDao;
import model.vo.ProductoVo;
import org.jfree.data.general.DefaultPieDataset;

public class ProductosController {

    private ProductoDao productoDao;
    private JTable table;
    private DefaultTableModel model;
    private DefaultPieDataset pieDataset = new DefaultPieDataset();

    public ProductosController() {
        productoDao = new ProductoDao();
    }

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

    /**
     * Este metodo carga los productos registrados en la tabla de la
     * reportetotal Productos
     *
     * @return
     */
    public Boolean obtenerListaProductosReporte() {
        ResultSet rs = productoDao.obtenerProductosReporte();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] producto = new String[7];

                while (rs.next()) {
                    producto[0] = rs.getString("id");
                    producto[1] = rs.getString("nombre");
                    producto[2] = rs.getString("cantidad_vendidos");
                    producto[3] = Integer.toString(rs.getInt("precio") * rs.getInt("cantidad_vendidos"));

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

    /**
     * Este metodo carga los productos registrados en el grafico de la vista
     * Productos
     *
     * @return
     */
    public Boolean obtenerListaProductosReporteGrafico() {
        ResultSet rs = productoDao.obtenerProductosReporteGrafico();

        if (rs != null) {
            try {
                while (rs.next()) {
                    pieDataset.setValue(rs.getString("nombre"), rs.getInt("cantidad_vendidos"));
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

    /**
     * Este metodo carga los productos registrados en el grafico de la vista
     * reportediario Productos
     *
     * @return
     */
    public Boolean obtenerListaProductosReporteGraficoD() {
        ResultSet rs = productoDao.obtenerProductosReporteD();

        if (rs != null) {
            try {
                while (rs.next()) {
                    pieDataset.setValue(rs.getString("t_productos.nombre"), rs.getInt("cantidad"));
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

    /**
     * Este metodo carga los productos registrados en la tabla de la vista
     * ReporteDiario Productos
     *
     * @return
     */
    public Boolean obtenerListaProductosReporteD() {
        ResultSet rs = productoDao.obtenerProductosReporteD();
        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] producto = new String[7];

                while (rs.next()) {
                    producto[0] = rs.getString("id");
                    producto[1] = rs.getString("nombre");
                    producto[2] = rs.getString("cantidad");
                    producto[3] = Integer.toString(rs.getInt("precio") * rs.getInt("cantidad"));
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

    public Boolean obtenerListaInventario() {
        ResultSet rs = productoDao.obtenerProductos();
        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] producto = new String[4];

                while (rs.next()) {
                    producto[0] = rs.getString("id");
                    producto[1] = rs.getString("nombre");
                    producto[2] = rs.getString("cant_medida");
                    producto[3] = rs.getString("cantidad");
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

    public Boolean buscarProducto(String nombre, String vista) {
        ResultSet rs = productoDao.buscarProducto(nombre);
        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] producto = new String[7];
                while (rs.next()) {
                    switch (vista) {
                        case "producto":
                            producto[0] = rs.getString("id");
                            producto[1] = rs.getString("nombre");
                            producto[2] = rs.getString("precio");
                            producto[3] = rs.getString("cant_medida");
                            producto[4] = rs.getString("uni_medida");
                            producto[5] = rs.getString("cantidad");
                            producto[6] = rs.getString("cantidad_vendidos");
                            break;
                        case "inventario":
                            producto[0] = rs.getString("id");
                            producto[1] = rs.getString("nombre");
                            producto[2] = rs.getString("cant_medida");
                            producto[3] = rs.getString("cantidad");
                            break;
                    }
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

    public ProductoVo buscarProductoId(int id) {
        ResultSet rs = productoDao.buscarProductoId(id);
        if (rs != null) {
            try {
                while (rs.next()) {
                    ProductoVo pro = new ProductoVo(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getDouble("cant_medida"),
                            rs.getString("uni_medida"),
                            rs.getInt("cantidad")
                    );
                    pro.setCantidadVendidos(rs.getInt("cantidad_vendidos"));
                    return pro;
                }
            } catch (Exception e) {
                System.out.println("Error al buscar producto por id " + e);
            }
        }
        return null;
    }

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
            if (model.getColumnCount() > 4) {
                obtenerListaProductos();
            } else {
                obtenerListaInventario();
            }
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

//    public void setProductoDao(ProductoDao productoDao) {
//        this.productoDao = productoDao;
//    }
    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }

    /**
     * @return the pieDataset
     */
    public DefaultPieDataset getPieDataset() {
        return pieDataset;
    }
}
