/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.conexion.Conexion;
import model.vo.VentaVo;

/**
 *
 * @author Shamir
 */
public class VentaDao {

    Conexion c;
    Connection con;
    UsuarioDao usuarioDao;

    int contador = 1;

    private ArrayList<VentaVo> listaVentas;

    public VentaDao() {
        this.listaVentas = new ArrayList<VentaVo>();

        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerTransacciones() {
        String sql = "{CALL obtener_transacciones()}";
        ResultSet rs = null;
        try {
            CallableStatement call = con.prepareCall(sql);
            rs = call.executeQuery();

        } catch (SQLException e) {
            System.out.println("VentaDao: Error call obtener transacciones " + e);
        }
        return rs;
    }

    public ResultSet obtenerDatosTransaccion(int venta_id) {
        String sql = "{CALL detalles_venta(" + venta_id + ")}";
        ResultSet rs = null;
        try {
            CallableStatement call = con.prepareCall(sql);
            rs = call.executeQuery();

        } catch (SQLException e) {
            System.out.println("VentaDao: Error call obtener transacciones " + e);
        }
        return rs;
    }

    public boolean registrarVenta(VentaVo venta) {
        String sql = "{CALL registrar_venta(?,?,?,?)}";
        int venta_id = queryCallInsert(sql, venta);
        if (venta_id > 0) {
            sql = "{CALL registrar_venta_producto(?,?,?)}";
            if (queryCallInsertPro(sql, venta, venta_id)) {
                return true;
            }
        }
        return false;
    }

    public ResultSet buscarProductos(String nombre) {
        String sql = "SELECT *FROM t_productos WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);
    }

    public ResultSet buscarClientes(String nombre) {
        String sql = "SELECT * FROM t_usuarios WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);
    }

    public ResultSet filtrarPorCliente(String nombre) {
        String sql = "{CALL filtro_venta('" + nombre + "')}";
        ResultSet rs = null;
        try {
            CallableStatement call = con.prepareCall(sql);
            rs = call.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("VentaDao: Error call filtro ventas " + e);
        }
        return rs;
    }

    public boolean modificarVenta(VentaVo venta, ArrayList<Integer> eliminar, ArrayList<Integer> devuelto) {
        String sql = "{CALL modificar_venta("
                + venta.getId()
                + ","
                + venta.getTotal()
                + ",'"
                + venta.getFecha_mod()
                + "')}";
        try {
            CallableStatement call = con.prepareCall(sql);
            call.execute();
            modificarPro(venta, eliminar, devuelto);
            return true;

        } catch (SQLException e) {
            System.out.println("VentaDao: Error call modificar_venta " + e);
        }
        return false;
    }

    private void modificarPro(VentaVo venta, ArrayList<Integer> eliminar, ArrayList<Integer> devuelto) {
        for (int i = 0; i < venta.getProductos().size(); i++) {
            String sql = "UPDATE t_productos SET cantidad = cantidad + " + devuelto.get(i) + ", "
                    + "cantidad_vendidos = cantidad_vendidos - " + devuelto.get(i)
                    + " WHERE id = " + (int) venta.getProductos().get(i);
            PreparedStatement ps = null;
            try {
                ps = con.prepareStatement(sql);
                ps.execute();
                modificarVentaPro(venta, eliminar);
            } catch (SQLException e) {
                System.out.println("VentaDao: Error al actualizar cantidades en productos " + e);
            }
        }
    }

    private void modificarVentaPro(VentaVo venta, ArrayList<Integer> eliminar) {
        for (int i = 0; i < venta.getProductos().size(); i++) {
            int producto_id = Integer.parseInt(venta.getProductos().get(i).toString());
            int cantidad = Integer.parseInt(venta.getCantidad().get(i).toString());

            String sql = "{CALL modificar_venta_pro("
                    + venta.getId()
                    + ","
                    + producto_id
                    + ","
                    + cantidad
                    + ")}";
            try {
                CallableStatement call = con.prepareCall(sql);
                call.execute();
            } catch (SQLException e) {
                System.out.println("VentaDao: Error al modificar los datos en t_venta_pro " + e);
            }
        }
        eliminarVentaPro(venta, eliminar);
    }

    private void eliminarVentaPro(VentaVo venta, ArrayList<Integer> eliminar) {
        if (eliminar.size() > 0) {
            int venta_id = venta.getId();
            for (int i = 0; i < eliminar.size(); i++) {
                String sql = "{CALL eliminar_venta_pro("
                        + venta_id
                        + ","
                        + eliminar.get(i)
                        + ")}";
                try {
                    CallableStatement call = con.prepareCall(sql);
                    call.execute();
                } catch (SQLException e) {
                    System.out.println("VentaDao: Error call eliminar_venta_pro " + e);
                }
            }
        }
    }

    public boolean eliminarVenta(int id) {
        String sql = "{CALL eliminar_venta(" + id + ")}";
        try {
            ResultSet rs = null;
            CallableStatement call = con.prepareCall(sql);
            rs = call.executeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println("VentasDao: Error call eliminar venta con id " + id);
        }
        return false;
    }

    private ResultSet queryWithResultSet(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("VentaDao: Error al traer datos " + e);
        }

        return rs;
    }

    private int queryCallInsert(String sql, VentaVo venta) {
        int venta_id = 0;
        try {
            ResultSet rs = null;
            CallableStatement call = con.prepareCall(sql);
            call.setInt(1, venta.getVendedor());
            call.setInt(2, venta.getComprador());
            call.setString(3, venta.getFecha());
            call.setDouble(4, venta.getTotal());

            rs = call.executeQuery();

            while (rs.next()) {
                venta_id = rs.getInt("venta_id");
            }

            return venta_id;
        } catch (SQLException e) {
            System.out.println("VentaDao: Error al registrar venta: " + e);
        }

        return venta_id;
    }

    private Boolean queryCallInsertPro(String sql, VentaVo venta, int venta_id) {
        try {
            ResultSet rs = null;
            CallableStatement call = null;

            for (int i = 0; i < venta.getProductos().size(); i++) { //para cada producto registrado en la factura
                int producto_id = Integer.parseInt(venta.getProductos().get(i).toString());
                int cantidad = Integer.parseInt(venta.getCantidad().get(i).toString());

                System.out.println("cantidad: " + cantidad);

                call = con.prepareCall(sql);
                call.setInt(1, venta_id);
                call.setInt(2, producto_id);
                call.setInt(3, cantidad);

                rs = call.executeQuery();
            }

            return true;
        } catch (Exception e) {
            System.out.println("VentaDao: Error al registrar productos en tabla t_ventas_productos " + e);
        }

        return false;
    }

    public ArrayList<VentaVo> getListaVentas() {
        return listaVentas;
    }
}
