/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Clase que contiene la información del jefe de bodega
 * 
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class JefeBodega extends Usuario {

    public JefeBodega(int rol, int id, String nombre, int edad, String email, String telefono, String direccion, String cedula) {
        super(rol, id, nombre, edad, email, telefono, direccion, cedula);
    }
    
}
