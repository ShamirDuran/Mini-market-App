/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Esta clase crea y guarda la información de los Usuarios al ser traidos de la db
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class Persona {

    private String nombre, email, telefono, direccion, cedula;
    private int id, edad;

    /**
     * @param id Valor autoingrementado que asigna la db al registrar un nuevo usuario.
     * @param nombre Nombre del usuario
     * @param edad Edad del usuario
     * @param email Correo electronico del usuario
     * @param telefono Telefono del usuario
     * @param direccion Direccion del usuario
     * @param cedula Cedula ciudadania del usuario
     */
    public Persona(int id, String nombre, int edad, String email, String telefono, String direccion, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cedula = cedula;
    }
}