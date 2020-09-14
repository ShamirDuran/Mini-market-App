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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Singleton;
import model.conexion.Conexion;
import model.vo.ProductoVo;
import model.vo.UsuarioVo;
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

    public boolean modificarVenta(VentaVo dataVenta) {
        boolean check = false;

        for (VentaVo venta : this.listaVentas) {
            if (venta.getId() == dataVenta.getId()) {
                venta = dataVenta;
                venta.date_mod();
                check = true;
                break;
            }
        }

        return check;
    }

    /**
     * Metodo que elimina una venta ya registrada, al ejecutarse tambien llama
     * al metodo de restaurar cantidad para sumarle las unidades recuperadas al
     * productos respectivo
     *
     * @param id Id de la venta a eliminar
     * @return Boolean indicando el estado de la transacción
     */
    public boolean eliminarVenta(int id) {
        int index = 0;
        boolean check = false;

        for (VentaVo venta : listaVentas) {
            if (venta.getId() == id) {
                restaurarCantidad(venta);
                Singleton.getInstance().restarCantidadV();
//                UsuarioVo user = usuarioDao.buscarUsuarioId(venta.getVendedor().getId());
//                if (user != null) {
//                    user.restarCantidadC();
//                }
//                venta.getComprador().restarCantidadC();
                listaVentas.remove(index);
                check = true;
                break;
            } else {
                index++;
            }
        }
        return check;
    }

    // Añadir otro parametro llamado type, de acuerdo al tipo sera la forma de
    // busqueda -Vendedor - Comprador, -Fecha, - Id
    public ArrayList<VentaVo> buscarVenta(String ref) {
        ArrayList<VentaVo> findList = new ArrayList<VentaVo>();

        for (VentaVo venta : listaVentas) {
            if (venta.getId() == Integer.parseInt(ref)) {
                findList.add(venta);
            }
        }

        return findList;
    }

    public ResultSet buscarProductos(String nombre) {
        String sql = "SELECT *FROM t_productos WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);
    }

    public ResultSet buscarClientes(String nombre) {
        String sql = "SELECT * FROM t_usuarios WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);
    }

    /**
     * Le suma a las unidades en stock del producto las recuperadas al eliminar
     * un producto de una venta
     *
     * @param venta Venta que se va a eliminar
     */
    private void restaurarCantidad(VentaVo venta) {
        int index = 0;
//        for (ProductoVo producto : venta.getProductosList()) {
//            producto.restaurarCantidad(venta.getCantidadList().get(index));
//        }
    }

    public ArrayList<VentaVo> getListaVentas() {
        return listaVentas;
    }

//    public void setUsuarioDao(UsuarioDao usuarioDao) {
//        this.usuarioDao = usuarioDao;
//    }
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
}
