/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProductosController;
import java.util.ArrayList;
import model.vo.ProductoVo;

/**
 *
 * @author Shamir
 */
public class Inventario {
    ProductosController proController;
    
    public void mostrarInventario(){
        ArrayList<ProductoVo> productos = proController.obtenerListaProductos();
        System.out.println("\nUnidades en stock por producto");
        for(ProductoVo producto : productos) {
            System.out.println("ID: " + producto.getId() + "   " + producto.getNombre() + "   Uni/Stock: " + producto.getCantidad());
        }
    }
    
    public void setProController(ProductosController proController) {
        this.proController = proController;
    }
    
}
