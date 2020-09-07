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

        Boolean check = queryWithBoolean(sql, pro);

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
        String sql = "SELECT *FROM t_productos WHERE nombre LIKE '"+ nombre + "%'";
        return queryWithResultSet(sql);
    }

    public boolean modificarProducto(ProductoVo dataProducto) {
        boolean check = false;

        for (ProductoVo productos : listaProductos) {
            if (productos.getId() == dataProducto.getId()) {
                productos = dataProducto;
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean eliminarProducto(int id) {
        boolean check = false;
        int index = 0;

        for (ProductoVo productos : listaProductos) {
            if (productos.getId() == id) {
                listaProductos.remove(index);
                check = true;
                break;
            } else {
                index++;
            }
        }
        return check;
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

    private Boolean queryWithBoolean(String sql, ProductoVo pro) {
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

                ps.execute();
            }
            return true;

        } catch (Exception e) {
            System.out.println("Error al tratar de agregar producto a la db: " + e);
        }
        return false;
    }
}
