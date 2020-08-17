/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Scanner;
import model.Producto;

/**
 *
 * @author NICOLAS
 */
public class StorageServiceAPI {

    int i = 0;
    Producto producto1[] = new Producto[100];
    Scanner teclado = new Scanner(System.in);

    public void guardarProducto(int id, String nombre, double precio,double cant_medida, String uni_medida, int cantidad) {
        producto1[i] = new Producto(id, nombre, precio,cant_medida, uni_medida, cantidad);
        //producto1[i].mostrar();   muestra el producto que se acaba de crear
        i = i + 1;
    }

    public void obtenerProducto(String nombre) {
        for (int j = 0; j < i; j++) {
            if (nombre.equals(producto1[j].getNombre())) {
                producto1[j].mostrar();
            }
        }
    }

    public void obtenerProductos() {
        for (int j = 0; j < i; j++) {
            producto1[j].mostrar();
        }
    }

    public void modificarProducto(String nombre) {
        for (int j = 0; j < i; j++) {
            if (nombre.equals(producto1[j].getNombre())) {
                System.out.println("Va a modificar el Producto:" + nombre);
                System.out.println("ingrese el nuevo id:");
                int id = teclado.nextInt();
                teclado.nextLine();
                for(int l=0; l<i;l++){
                if(id==producto1[l].getId()){
                System.out.println("El id ya esta en uso, porfavor escriba uno nuevo.");
                id=teclado.nextInt();
                teclado.nextLine();
                l=-1;
                }
                }
               
                System.out.println("ingrese el nuevo nombre:");
                String nombre2 = teclado.nextLine();
                System.out.println("ingrese el nuevo precio del producto");
                double precio = teclado.nextFloat();
                System.out.println("ingrese la nueva cantidad de medida ejemplo:500   1000   1500");
                double cmedida= teclado.nextDouble();
                System.out.println("ingrese la nueva unidad de medida ejemplo: G Kg ml");
                String medida = teclado.next();
                System.out.println("ingrese la nueva cantidad de unidades disponibles en el almacen");
                int cantidad = teclado.nextInt();
                producto1[j].modificar(id, nombre2, precio,cmedida, medida, cantidad);
            }
        }
    }

    public void eliminarProducto(String nombre) {
        for (int j = 0; j < i; j++) {
            if (nombre.equals(producto1[j].getNombre())) {
                System.out.println("Va a eliminar el Producto:" + nombre);
                for (int o = j; o < i - 1; o++) {
                    producto1[o] = producto1[o + 1];
                }
                i = i - 1;
            }
        }
    }

}
