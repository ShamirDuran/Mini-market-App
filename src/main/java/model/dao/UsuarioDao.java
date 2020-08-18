/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.vo.UsuarioVo;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los metodos de acceso a la db.
 *
 * @author Shamir
 */
public class UsuarioDao {
    int contador = 1;
    
    private ArrayList<UsuarioVo> listaUsuarios;

    /**
     * Constructor clase UsuarioDao
     */
    public UsuarioDao() {
        this.listaUsuarios = new ArrayList<UsuarioVo>();
    }

    /**
     * Metodo que agrega nuevos usuarios a la lista de registrados. Retorna un
     * boolean dependiendo de si se realizo la operación o no.
     *
     * @param id id del nuevo usuario
     * @param rol rol del nuevo usuario
     * @param edad edad del nuevo usuario
     * @param nombre nombre del nuevo usuario
     * @param correo correo electronico del nuevo usuario
     * @param direccion direccion del nuevo usuario
     * @return true si se agrego correctamente, false si no
     */
    public boolean añadirUsuario(int rol, int edad, int genero, String nombre, String correo, String direccion) {
        UsuarioVo user = new UsuarioVo(this.contador, rol, edad, genero, nombre, correo, direccion);
        this.listaUsuarios.add(user);
        this.contador++;
        
        return true;
    }

    public void mostrarUsuarios() {
        System.out.println("/-- Lita de usuarios registrado --/");

        for (UsuarioVo user : listaUsuarios) {
            System.out.println(user);
        }
    }

    /**
     * Metodo que modifica un Usuario. Recibe como parametro el Usuario con los
     * datos modificados y busca en la lista al Usuario que tenga la mimsa id,
     * al encontrarlo modifica al usuario de la lista.
     *
     * @param dataUser Objeto Usuario con la nueva data
     * @return True si se encontro el usuario, False si no se encontro
     */
    public boolean modificarUsuario(UsuarioVo dataUser) {
        boolean check = false;

        for (UsuarioVo user : listaUsuarios) {
            if (user.getId() == dataUser.getId()) {
                user = dataUser;
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * Metodo que busca en la lista de Usuarios registrado usando el Id y luego
     * lo elimina
     *
     * @param id Id del usuario que se desea eliminar
     * @return True si se pudo eliminar, False si no.
     */
    public boolean eliminarUsuario(int id) {
        boolean check = false;
        int index = 0;

        for (UsuarioVo user : listaUsuarios) {
            if (user.getId() == id) {
                listaUsuarios.remove(index);
                check = true;
                break;
            } else {
                index++;
            }
        }
        return check;
    }
    
    /**
     * Metodo que busca un usuaruo en la db por el nombre
     * @param nombre
     * @return 
     */
    public ArrayList<UsuarioVo> buscarUsuario(String nombre) {
        ArrayList<UsuarioVo> findList = new ArrayList<UsuarioVo>();
        
        // FALTA HACERLO
        return findList;
    }

    public ArrayList<UsuarioVo> getListaUsuarios() {
        return listaUsuarios;
    }
}
