/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Scanner;
import model.vo.ProductoVo;

/**
 *
 * @author NICOLAS
 */
public class ProductoDao {

    int i = 1;
    private ArrayList<ProductoVo> listaProductos;
    Scanner teclado = new Scanner(System.in);

    public ProductoDao() {
        this.listaProductos = new ArrayList<ProductoVo>();
    }

    public boolean guardarProducto(String nombre, double precio, double cant_medida, String uni_medida, int cantidad) {
        ProductoVo productos = new ProductoVo(i, nombre, precio, cant_medida, uni_medida, cantidad);
        // listaProductos.mostrar(); muestra el producto que se acaba de crear
        this.listaProductos.add(productos);
        i++;
        return true;
    }

    public ProductoVo obtenerProductoId(int id) {
        for (ProductoVo producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public ArrayList<ProductoVo> obtenerProducto(String nombre) {
        ArrayList<ProductoVo> findList = new ArrayList<ProductoVo>();
        for (ProductoVo productos : listaProductos) {
            if (productos.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                findList.add(productos);
            }
        }
        return findList;
    }

    public boolean modificarProducto(ProductoVo dataProducto) {
        boolean check = false;

        for (ProductoVo productos : listaProductos) {
            if (productos.getId() == dataProducto.getId()) {
                productos = dataProducto;
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean eliminarProducto(int id) {
        boolean check = false;
        int index = 0;

        for (ProductoVo productos : listaProductos) {
            if (productos.getId() == id) {
                listaProductos.remove(index);
                check = true;
                break;
            } else {
                index++;
            }
        }
        return check;
    }

     public ArrayList<ProductoVo> obtenerProductos() {
        return listaProductos;
    }
}
