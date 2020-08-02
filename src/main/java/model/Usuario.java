/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Clase de los usuarios, son los que pueden manipular la aplicación
 * 
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class Usuario extends Persona{
    private int rol;

    public Usuario(int rol, int id, String nombre, int edad, String email, String telefono, String direccion, String cedula) {
        super(id, nombre, edad, email, telefono, direccion, cedula);
        this.rol = rol;
    }    
}
