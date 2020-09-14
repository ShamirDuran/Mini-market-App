/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.UsuarioDao;
import model.dao.VentaDao;
import model.vo.VentaVo;

/**
 *
 * @author Shamir
 */
public class VentasController {

    UsuarioDao usuarioDao;
    VentaDao ventaDao;
    private JTable tblPro, tblCli;
    private DefaultTableModel modelPro, modelCli;

    public VentasController() {
        usuarioDao = new UsuarioDao();
        ventaDao = new VentaDao();
    }

    public boolean registrarVenta(VentaVo venta) {
        boolean check = ventaDao.registrarVenta(venta);
        if (check) {
            System.out.println("\nVentasCon: Se registro la venta correctamente!!");
        } else {
            System.out.println("\nVentasCon: No se pudo registrar la venta!!");
        }

        return check;
    }

    public boolean modificarVenta(VentaVo dataVenta) {
        boolean check = ventaDao.modificarVenta(dataVenta);
        if (check) {
            System.out.println("\nVentaCon: Venta con id" + dataVenta.getId() + " modificada correctamente!!");
        } else {
            System.out.println("\nVentaCon: No se encontro la venta!!");
        }

        return check;
    }

    public boolean eliminarVenta(int id) {
        boolean check = ventaDao.eliminarVenta(id);
        if (check) {
            System.out.println("\nVenta con id " + id + " eliminada correctamente");
        } else {
            System.out.println("\nVenta con id " + id + " no encontrada!!");
        }

        return check;
    }

    public ArrayList<VentaVo> buscarVenta(String ref) {
        ArrayList<VentaVo> findList = new ArrayList<VentaVo>();
        findList = ventaDao.buscarVenta(ref);

        if (!findList.isEmpty()) {
            System.out.println("VentaCon: \n/-- Venta encontrada --/");
            mostrarListaVenta(findList);
            return findList;
        } else {
            System.out.println("VentaCon: \nNo se encontro venta con id " + ref);
            return null;
        }
    }

    public ArrayList<VentaVo> obtenerListaVentas() {
        return ventaDao.getListaVentas();
    }

    public void mostrarListaVentas() {
        ArrayList<VentaVo> listaVentas = new ArrayList<VentaVo>();
        listaVentas = ventaDao.getListaVentas();

        if (!listaVentas.isEmpty()) {
            System.out.println("VentaCon: \n/-- Lista de ventas registradas --/");
            mostrarListaVenta(listaVentas);
        } else {
            System.out.println("VentaCon: \n No hay ventas registradas!!");
        }
    }

    public Boolean buscarProductos(String nombre) {
        ResultSet rs = ventaDao.buscarProductos(nombre);

        if (rs != null) {
            try {
                modelPro.setNumRows(0);
                String[] pro = new String[5];

                while (rs.next()) {
                    pro[0] = rs.getString("id");
                    pro[1] = rs.getString("nombre");
                    pro[2] = rs.getString("precio");
                    pro[3] = rs.getString("cantidad");
                    
                    modelPro.addRow(pro);
                }
                return true;

            } catch (Exception e) {
                System.out.println("VentaCon: Error al recorrer los productos " + e);
            }
        } else {
            System.out.println("VentaCon: No se recibieron datos de productos, null");
        }
        return false;
    }

    public Boolean buscarClientes(String nombre) {
        ResultSet rs = ventaDao.buscarClientes(nombre);

        if (rs != null) {
            try {
                modelCli.setNumRows(0);
                String[] cli = new String[4];

                while (rs.next()) {
                    cli[0] = rs.getString("id");
                    cli[1] = rs.getString("nombre");
                    cli[2] = rs.getString("edad");
                    cli[3] = rs.getString("cedula");
                    modelCli.addRow(cli);
                }
                return true;
                
            } catch (SQLException e) {
                System.out.println("VentaCon: Error al recorrer los clientes " + e);
            }

        } else {
            System.out.println("VentaCon: No se recibieron datos de clientes, null");
        }

        return false;
    }

    private void mostrarListaVenta(ArrayList<VentaVo> listaVentas) {
        for (VentaVo venta : listaVentas) {
//            venta.mostrarVenta();
        }
    }

//    public void setVentaDao(VentaDao ventaDao) {
//        this.ventaDao = ventaDao;
//    }
//
//    public void setUsuarioDao(UsuarioDao usuarioDao) {
//        this.usuarioDao = usuarioDao;
//    }
    
    public void setTableProductos(JTable table) {
        this.tblPro = table;
        modelPro = (DefaultTableModel) tblPro.getModel();
    }

    public void setTableClientes(JTable table) {
        this.tblCli = table;
        modelCli = (DefaultTableModel) tblCli.getModel();
    }
}
