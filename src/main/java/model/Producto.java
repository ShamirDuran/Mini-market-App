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

    String nombre, uni_medida;;
    double precio,cant_medida; 
    int cantidad, id;

    /**
     * @param id Valor autoingrementado que asigna la db al regitrar un
     * producto. Se trae desde la db al momento de listas los productos en la
     * vista ProductosView
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param cant_medida valor numerico cantidad de medida
     * @param uni_medida Unidad de medida. Ej: kg, g
     * @param cantidad Cantidad del producto en stock
     */
    public Producto(int id, String nombre, double precio,double cant_medida, String uni_medida, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cant_medida = cant_medida;
        this.uni_medida = uni_medida;
        this.cantidad = cantidad;
    }

    public void mostrar() {
        System.out.print(id+" ");
        System.out.print(nombre+" ");
        System.out.print(precio+"$  ");
        System.out.print(cant_medida+"");
        System.out.print(uni_medida+" ");
        System.out.print(cantidad+" Unidades ");
        System.out.println(" ");
    }

    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }

    public void modificar(int id, String nombre, double precio,double cant_medida, String uni_medida, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cant_medida = cant_medida;
        this.uni_medida = uni_medida;
        this.cantidad = cantidad;
    }

}
