/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Esta clase crea y contiene la informacion de los productos al ser traidos de
 * la db
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 *
 */
public class Producto {

    String nombre;
    double precio, uni_medida;
    int cantidad, id;

    /**
     * @param id Valor autoingrementado que asigna la db al regitrar un producto. Se trae desde la db al momento de listas los productos en la vista ProductosView
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param uni_medida Unidad de medida. Ej: kg, g
     * @param cantidad Cantidad del producto en stock
     */
    public Producto(int id, String nombre, double precio, double uni_medida, int cantidad) {
        this.cantidad = id;
        this.nombre = nombre;
        this.precio = precio;
        this.uni_medida = uni_medida;
        this.cantidad = cantidad;
    }
}

