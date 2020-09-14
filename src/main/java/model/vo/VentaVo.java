/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.text.SimpleDateFormat;
import model.Singleton;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que contiene la informacion de una venta
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class VentaVo {

    private int id, vendedor, comprador;
    private ArrayList productos;
    private ArrayList cantidad;
    private double total;
    private String fecha, fecha_mod;
    private Date date;
    private SimpleDateFormat format;

    /**
     * Constructor de la clase Venta
     */
    public VentaVo() {
        // se inicializan para luego irse agregando a medida de que progresa la venta
        this.vendedor = Singleton.getInstance().getId();
        this.comprador = 0;
        this.total = 0;
        this.cantidad = new ArrayList<Integer>();
        this.productos = new ArrayList<Integer>();
        this.fecha_mod = null;
        this.format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    }

    public void addProducto(int producto, int cantidad) {
        this.productos.add(producto);
        this.cantidad.add(cantidad);
    }
    
    /**
     * Obtiene la hora y fecha exacta en la que se realiza la venta
     */
    public void date() {
        this.date = new Date();
        this.fecha = this.format.format(this.date);
    }

    /**
     * Obtiene la hora y fecha exacta en la que se modifico la venta
     */
    public void date_mod() {
        this.date = new Date();
        this.fecha_mod = this.format.format(this.date);
    }

    @Override
    public String toString() {
        String venta = "Venta: \n"
                + "# pro: " + productos.size();
        
        return venta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendedor() {
        return vendedor;
    }

    public int getComprador() {
        return comprador;
    }

    public void setComprador(int comprador) {
        this.comprador = comprador;
    }

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }

    public ArrayList getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(String fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }
}
