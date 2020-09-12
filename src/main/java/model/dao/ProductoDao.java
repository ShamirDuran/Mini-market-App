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

    public ResultSet obtenerProductos() {
        String sql = "SELECT * FROM t_productos";
        return queryWithResultSet(sql);
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

        Boolean check = queryWithBoolean(sql, pro, "execute");

        return check;
    }

    public ProductoVo obtenerProductoId(int id) {
        for (ProductoVo producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public ResultSet buscarProducdo(String nombre) {
        String sql = "SELECT *FROM t_productos WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);
    }

    public boolean modificarProducto(ProductoVo dataProducto) {
        boolean check = false;

        String sql = "UPDATE t_productos SET nombre = ?, precio = ?, cant_medida = ?, uni_medida = ?, cantidad = ?, cantidad_vendidos = ? WHERE id = ?";
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

    private ResultSet queryWithResultSet(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
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
                ps.setInt(6, pro.getCantidadVendidos());

                switch (type) {
                    case "execute":
                        ps.execute();
                        break;

                    case "executeUpdate":
                        ps.setInt(7, pro.getId());
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
