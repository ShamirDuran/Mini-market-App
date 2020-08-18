/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 * Clase que representa las entidades de la tabla Usuarios en la db. Es la
 * abstracción de un usuario.
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class UsuarioVo {

    /**
     * Tipos de rol 1 - Admin 2 - Vendedor 3 - Jefe de bodega
     */
    /**
     * Tipos de genero 0 - Mujer 1 - Hombre
     */
    private int id, rol, edad, genero;
    private String nombre, correo, direccion;

    /**
     * Constructor de la clase UsuarioVo
     *
     * @param id Identificador unico para cada Usuario
     * @param rol Representa el rol que tiene el Usuario en la empresa.
     * @param edad Edad del Usuario
     * @param genero Genero del usuario
     * @param nombre Nombre del Usuario
     * @param correo Correo electronico del Usuario
     * @param direccion Dirección en la que reside el Usuario
     */
    public UsuarioVo(int id,int rol, int edad, int genero, String nombre, String correo, String direccion) {
        this.id = id;
        this.rol = rol;
        this.edad = edad;
        this.genero = genero;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        String str = "uid: " + id
                + ", Rol: " + rol
                + ", Edad: " + edad
                + ", Genero: " + genero
                + ", Nombre: " + nombre
                + ", Correo: " + correo
                + ", Dirección: " + direccion;

        return str;
    }

    public int getId() {
        return id;
    }

    public int getRol() {
        return rol;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
