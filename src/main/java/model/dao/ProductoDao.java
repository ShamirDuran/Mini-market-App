/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import model.conexion.Conexion;
import model.vo.ProductoVo;

/**
 *
 * @author NICOLAS
 */
public class ProductoDao {

    Conexion c;
    Connection con;

    int i = 1;
    private ArrayList<ProductoVo> listaProductos;
    Scanner teclado = new Scanner(System.in);

    public ProductoDao() {
        this.listaProductos = new ArrayList<ProductoVo>();

        c = new Conexion();
        con = c.getConexion();
    }
    /**
     * consulta que regresa la informacion de los productos registrados en la bd
     */
    public ResultSet obtenerProductos() {
        String sql = "SELECT * FROM t_productos";
        return queryWithResultSet(sql, 0);
    }
    /**
     * consulta que regresa la informacion de los productos registrados en la bd y los muestra por ordebn descendente
     */
    public ResultSet obtenerProductosReporte() {
        String sql = "SELECT id, nombre, cantidad_vendidos,precio FROM t_productos ORDER BY cantidad_vendidos DESC";
        return queryWithResultSet(sql, 0);
    }
    /**
     * consulta que regresa la informacion de los productos registrados en la bd
     */
    public ResultSet obtenerProductosReporteGrafico() {
        String sql = "SELECT  nombre, cantidad_vendidos FROM t_productos";
        return queryWithResultSet(sql, 0);
    }
    /**
     * consulta que regresa la informacion de los productos registrados en la bd
     */
    public ResultSet obtenerProductosReporteD() {
        String sql = "SELECT t_productos.id, t_productos.nombre,SUM(t_venta_producto.cantidad) as cantidad,t_productos.precio FROM t_productos INNER JOIN t_venta_producto ON t_venta_producto.fk_producto=t_productos.id INNER JOIN t_ventas ON t_ventas.id = t_venta_producto.fk_venta WHERE (SELECT Date_format(CURDATE(),'%Y-%m-%d')= STR_TO_DATE(t_ventas.fecha,'%d-%m-%Y')) GROUP BY t_productos.id ORDER BY cantidad_vendidos DESC";
        return queryWithResultSet(sql, 0);
    }

    public boolean guardarProducto(String nombre, double precio, double cant_medida, String uni_medida, int cantidad) {
        String sql = "INSERT INTO t_productos (nombre, precio, cant_medida, uni_medida, cantidad, cantidad_vendidos) "
                + "VALUES (?,?,?,?,?,?)";

        ProductoVo pro = new ProductoVo(
                1,
                nombre,
                precio,
                cant_medida,
                uni_medida,
                cantidad
        );
        return queryWithBoolean(sql, pro, "execute");
    }

//    public ProductoVo obtenerProductoId(int id) {
//        for (ProductoVo producto : listaProductos) {
//            if (producto.getId() == id) {
//                return producto;
//            }
//        }
//        return null;
//    }
    public ResultSet buscarProducto(String nombre) {
        String sql = "SELECT *FROM t_productos WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql, 0);
    }

    public ResultSet buscarProductoId(int id) {
        String sql = "SELECT *FROM t_productos WHERE id = ?";
        return queryWithResultSet(sql, id);
    }

    public boolean modificarProducto(ProductoVo dataProducto) {
        boolean check = false;

        String sql = "UPDATE t_productos SET nombre = ?, precio = ?, cant_medida = ?, uni_medida = ?, cantidad = ? WHERE id = ?";
        check = queryWithBoolean(sql, dataProducto, "executeUpdate");

        return check;
    }

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM t_productos WHERE id = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e);
            return false;
        }
    }

    private ResultSet queryWithResultSet(String sql, int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);

            // Al ser mayor de cero se entiende que se quiere buscar por id
            if (id > 0) {
                ps.setInt(1, id);
            }

            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error traer datos productos: " + e);
        }

        return rs;
    }

    private Boolean queryWithBoolean(String sql, ProductoVo pro, String type) {
        PreparedStatement ps = null;

        try {
            if (pro != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, pro.getNombre());
                ps.setDouble(2, pro.getPrecio());
                ps.setDouble(3, pro.getCant_medida());
                ps.setString(4, pro.getUni_medida());
                ps.setInt(5, pro.getCantidad());

                switch (type) {
                    case "execute":
                        ps.setInt(6, pro.getCantidadVendidos());
                        ps.execute();
                        break;

                    case "executeUpdate":
                        ps.setInt(6, pro.getId());
                        ps.executeUpdate();
                        break;

                    default:
                        break;
                }
            }
            return true;

        } catch (Exception e) {
            System.out.println("Error en la petición de la db: " + e);
        }

        return false;
    }
}
