/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Clase que contiene la informacion de una venta
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class Venta {

    private int id;
    private Usuario usuario;
    private Cliente cliente;
    private ArrayList<Producto> productosList;

    /**
     * Constructor de la clase Venta
     * 
     * @param id Valor autoincrementado que asigna la db para diferenciar cada venta. Se trae al listar las ventas..
     * @param cajero Datos del cajero que realizo la venta.
     * @param cliente Datos del cliente que compro.
     * @param productosList Lista de productos que compro el cliente.
     */
    public Venta(int id, Usuario usuario, Cliente cliente, ArrayList<Producto> productosList) {
        this.id = id;
        this.usuario = usuario;
        this.cliente = cliente;
        this.productosList = productosList;
    }
}
