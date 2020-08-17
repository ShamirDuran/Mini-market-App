/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import control.StorageServiceAPI;

/**
 *
 * @author NICOLAS
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StorageServiceAPI store = new StorageServiceAPI();
        //se crean productos
        System.out.println("");
        store.guardarProducto(1, "DESENGRASANTE", 4000,500, "ml", 100);
        store.guardarProducto(2, "ARROZ", 1650,500, "g", 69);
        store.guardarProducto(3, "GASEOSA COCA COLA", 2790,500, "ml", 72);
        store.guardarProducto(4, "CREMA COLGATE", 2250,75, "ml", 40);
        store.guardarProducto(5, "PAPAS FRITAS KYTHOS", 1890,115, "g", 30);
        store.guardarProducto(6, "MAYONESA BAJA EN GRASA", 2250,500, "g", 40);
        store.guardarProducto(7, "MERMELADA DE MORA ZEV", 1750,200, "g", 80);
        store.guardarProducto(8, "GALLETA WAFER", 790,22, "g", 51);
        store.guardarProducto(9, "QUESO MOZZARELLA", 5690,400, "g", 100);
        store.guardarProducto(10, "SALSA DE PIÑA", 200,20, "g", 91);
        //se muestran todos los productos creados
        System.out.println("Se solicita la informacion de todos los productos.");
        store.obtenerProductos();
        System.out.println(" ");
        //se muestra un producto en especifico buscando por el nombre
        System.out.println("Se solicita la informacion del producto con el nombre Crema colgate.");
        store.obtenerProducto("CREMA COLGATE");
        System.out.println(" ");
        //modificar un producto seleccionandolo por el nombre
        System.out.println("Se modificara  un producto seleccionandolo por el nombre");
        store.modificarProducto("CREMA COLGATE");
        System.out.println("Se muestra la modificacion");
        store.obtenerProductos();
        System.out.println(" ");
        System.out.println("Se elimina el producto llamado Gaseosa coca cola");
        store.eliminarProducto("GASEOSA COCA COLA");
        System.out.println("Se muestran todos los productos luego de haber eliminado.");
        store.obtenerProductos();
    }

}
