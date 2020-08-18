/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

/**
 * Clase que conecta la Vista con el Modelo
 *
 * @author Shamir
 */
public class UsuariosController {

    UsuarioDao usuarioDao;

    /**
     * Metodo que pide al modelo la lista de usuarios registrados en la db Para
     * esta entrega se utilizara para mostrar la lista de usuarios
     *
     * @return Retorna la lista de usuarios registrados.
     */
    public void obtenerListaUsuarios() {
        mostrarListaUsuarios(usuarioDao.getListaUsuarios());
    }

    /**
     * Metodo que pide al modelo que se añada un usuario a la db
     *
     * @return true si se realizo la operación, false si no
     */
    public boolean añadirUsuario(int rol, int edad, int genero, String nombre, String correo, String direccion) {
        boolean check = this.usuarioDao.añadirUsuario(rol, edad, genero, nombre, correo, direccion);
        if (check) {
            System.out.println("\nUsuario " + nombre + " registrado correctamente!!");
        } else {
            System.out.println("\nError al registrar nuevo usuario!!");
        }

        return check;
    }

    /**
     * Metodo que pide al modelo modificar un usuario en la db
     *
     * @param user Datos que se desean actualizar para el usuario.
     * @return true si se realizo la operación, false si no
     */
    public boolean modificarUsuario(UsuarioVo user) {
        boolean check = this.usuarioDao.modificarUsuario(user);
        if (check) {
            System.out.println("\nUsuario modificado correctamente!!");
        } else {
            System.out.println("\nNo se encontro el usuario!!");
        }
        
        return check;
    }

    /**
     * Metodo que pide al modelo que elimine un usuario de la db
     *
     * @param id Id del usuario que se desea eliminar
     * @return true si se realizo la operación, false si no
     */
    public boolean eliminarUsuario(int id) {
        boolean check = this.usuarioDao.eliminarUsuario(id);
        if (check) {
            System.out.println("\nUsuario con id " + id + " eliminado correctamente!!");
        } else {
            System.out.println("\nNo se encontro usuario con id " + id);
        }
        
        return check;
    }

    // Esto se hace desde la vista, pero de momento para esta entrega se hara aca.
    private void mostrarListaUsuarios(ArrayList<UsuarioVo> listaUsuarios) {
        System.out.println("\n/-- Lista de usuarios registrados --/");

        System.out.println("Total: " + listaUsuarios.size());

        for (UsuarioVo user : listaUsuarios) {
            System.out.println(user);
        }
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
