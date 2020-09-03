/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
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

    public boolean registrarVenta(VentaVo venta) {
        boolean check = ventaDao.registrarVenta(venta);
        if (check) {
            System.out.println("\nSe registro la venta correctamente!!");
        } else {
            System.out.println("\nNo se pudo registrar la venta!!");
        }

        return check;
    }

    public boolean modificarVenta(VentaVo dataVenta) {
        boolean check = ventaDao.modificarVenta(dataVenta);
        if (check) {
            System.out.println("\nVenta con id" + dataVenta.getId() + " modificada correctamente!!");
        } else {
            System.out.println("\nNo se encontro la venta!!");
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
            System.out.println("\n/-- Venta encontrada --/");
            mostrarListaVenta(findList);
            return findList;
        } else {
            System.out.println("\nNo se encontro venta con id " + ref);
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
            System.out.println("\n/-- Lista de ventas registradas --/");
            mostrarListaVenta(listaVentas);
        } else {
            System.out.println("\n No hay ventas registradas!!");
        }
    }

    private void mostrarListaVenta(ArrayList<VentaVo> listaVentas) {
        for (VentaVo venta : listaVentas) {
            venta.mostrarVenta();
        }
    }

    public void setVentaDao(VentaDao ventaDao) {
        this.ventaDao = ventaDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

}
