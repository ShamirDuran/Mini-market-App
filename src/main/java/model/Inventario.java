/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Clase que contiene los productos registrados hasta el momento
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class Inventario {

    private ArrayList<Producto> productosList;

    /**
     *
     * Constructor de la clase Inventario
     *
     * @param productosList Lista de los productos en stock.
     */
    public Inventario(ArrayList<Producto> productosList) {
        this.productosList = productosList;
    }
}
