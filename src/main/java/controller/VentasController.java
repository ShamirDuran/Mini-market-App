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
    private JTable tblPro, tblCli, tblTran, tblFac;
    private DefaultTableModel modelPro, modelCli, modelTran, modelFac;

    public VentasController() {
        usuarioDao = new UsuarioDao();
        ventaDao = new VentaDao();
    }

    public boolean obtenerTransacciones() {
        ResultSet rs = ventaDao.obtenerTransacciones();
        if (rs != null) {
            try {
                modelTran.setNumRows(0);
                String[] tran = new String[6];

                while (rs.next()) {
                    tran[0] = rs.getString("id");
                    tran[1] = rs.getString("fecha");
                    tran[2] = rs.getString("fecha_mod");
                    tran[3] = rs.getString("vendedor");
                    tran[4] = rs.getString("comprador");
                    tran[5] = rs.getString("total");
                    modelTran.addRow(tran);
                }
                return true;

            } catch (SQLException e) {
                System.out.println("VentasCon: Error al recorrer data de transacciones " + e);
            }
        } else {
            System.out.println("VentasCon: No se trajo info de transacciones, null ");
        }

        return false;
    }

    public boolean obtenerDatosTransaccion(int venta_id) {
        ResultSet rs = ventaDao.obtenerDatosTransaccion(venta_id);
        if (rs != null) {
            try {
                modelFac.setNumRows(0);
                String[] tran = new String[5];
                while (rs.next()) {
                    tran[0] = rs.getString("id");
                    tran[1] = rs.getString("nombre");
                    tran[2] = rs.getString("precio");
                    tran[3] = rs.getString("cantidad");
                    tran[4] = rs.getString("total");
                    modelFac.addRow(tran);
                }
                return true;

            } catch (Exception e) {
                System.out.println("VentasCon: Error al recorer data de la transaccion " + e);
            }
        } else {
            System.out.println("VentasCon: No se trajo info de la transaccion, null");
        }
        return false;
    }

    public boolean filtrarPorCliente(String nombre) {
        ResultSet rs = ventaDao.filtrarPorCliente(nombre);
        if (rs != null) {
            try {
                modelTran.setNumRows(0);
                String[] tran = new String[6];

                while (rs.next()) {
                    tran[0] = rs.getString("id");
                    tran[1] = rs.getString("fecha");
                    tran[2] = rs.getString("fecha_mod");
                    tran[3] = rs.getString("vendedor");
                    tran[4] = rs.getString("comprador");
                    tran[5] = rs.getString("total");
                    modelTran.addRow(tran);
                }
                return true;

            } catch (SQLException e) {
                System.out.println("VentasCon: Error al recorrer data de transacciones filtradas " + e);
            }
        } else {
            System.out.println("VentasCon: No se trajo info de transacciones filtradas, null");
        }
        return false;
    }

    public boolean registrarVenta(VentaVo venta) {
        boolean check = ventaDao.registrarVenta(venta);
        if (check) {
            System.out.println("\nVentasCon: Se registro la venta correctamente!!");
            check = true;
        } else {
            System.out.println("\nVentasCon: No se pudo registrar la venta!!");
        }
        return check;
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

    public Boolean modificarVenta(VentaVo venta, ArrayList<Integer> eliminar, ArrayList<Integer> devuelto) {
        if (ventaDao.modificarVenta(venta, eliminar, devuelto)) {
            System.out.println("VentaCon: Venta con id " + venta.getId() + " modificada correctamente!");
            obtenerTransacciones();
            return true;
        } else {
            System.out.println("VentaCon: Error al modificar la venta con id " + venta.getId());
        }
        return false;
    }

    public Boolean eliminarVenta(int id) {
        if (ventaDao.eliminarVenta(id)) {
            System.out.println("VentaCon: venta eliminada correctamente");
            obtenerTransacciones();
            return true;
        } else {
            System.out.println("VentaCon: error al tratar de eliminar venta");
        }
        return false;
    }

    public void setTableProductos(JTable table) {
        this.tblPro = table;
        modelPro = (DefaultTableModel) tblPro.getModel();
    }

    public void setTableClientes(JTable table) {
        this.tblCli = table;
        modelCli = (DefaultTableModel) tblCli.getModel();
    }

    public void setTableTran(JTable table) {
        this.tblTran = table;
        modelTran = (DefaultTableModel) tblTran.getModel();
    }

    public void setTableFac(JTable table) {
        this.tblFac = table;
        modelFac = (DefaultTableModel) tblFac.getModel();
    }
    
    public void hacerReporte(int venta_id) {
        ventaDao.hacerReporte(venta_id);
    }
}
