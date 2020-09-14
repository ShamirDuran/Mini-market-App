/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

/**
 * Clase que conecta la Vista con el Modelo
 *
 * @author Shamir
 */
public class UsuariosController {

    private UsuarioDao usuarioDao;
    private JTable table;
    private DefaultTableModel model;

    public UsuariosController() {
        usuarioDao = new UsuarioDao();
        table = null;
        model = null;
    }

    /**
     * Metodo que pide al modelo la lista de usuarios registrados en la db Para
     * esta entrega se utilizara para mostrar la lista de usuarios
     *
     * @return Retorna la lista de usuarios registrados.
     */
    public Boolean obtenerListaUsuarios() {
        ResultSet rs = usuarioDao.obtenerUsuarios();

        if (rs != null && table != null && model != null) {
            try {
                model.setNumRows(0);
                String[] usuario = new String[8];

                while (rs.next()) {
                    usuario[0] = rs.getString("id");
                    usuario[1] = rs.getString("cedula");
                    usuario[2] = rs.getString("nombre");
                    usuario[3] = rs.getString("correo");
                    usuario[4] = rs.getString("direccion");
                    usuario[5] = rs.getString("edad");
                    usuario[6] = rs.getString("genero");
                    usuario[7] = rs.getString("transacciones");

                    model.addRow(usuario);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer usuarios: " + e);;
            }
        } else {
            System.out.println("No se recibio datos usuarios, null");
        }
        return false;
    }

    public Boolean buscarUsuario(String nombre) {
        ResultSet rs = usuarioDao.buscarUsuario(nombre);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] usuario = new String[8];

                while (rs.next()) {
                    usuario[0] = rs.getString("id");
                    usuario[1] = rs.getString("cedula");
                    usuario[2] = rs.getString("nombre");
                    usuario[3] = rs.getString("correo");
                    usuario[4] = rs.getString("direccion");
                    usuario[5] = rs.getString("edad");
                    usuario[6] = rs.getString("genero");
                    usuario[7] = rs.getString("transacciones");

                    model.addRow(usuario);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer usuarios buscados: " + e);;
            }
        } else {
            System.out.println("No se recibio datos usuarios buscados, null");
        }
        return false;
    }

    /**
     * Metodo que pide al modelo que se añada un usuario a la db
     *
     * @return true si se realizo la operación, false si no
     */
    public boolean añadirUsuario(int rol, int edad, int genero, String nombre, String correo, String direccion, int cedula) {
        boolean check = usuarioDao.añadirUsuario(rol, edad, genero, nombre, correo, direccion, cedula);
        if (check) {
            System.out.println("\nUsuario " + nombre + " registrado correctamente!!");
            obtenerListaUsuarios();
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
            obtenerListaUsuarios();
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
            obtenerListaUsuarios();
        } else {
            System.out.println("\nNo se encontro usuario con id " + id);
        }

        return check;
    }

//    public void setUsuarioDao(UsuarioDao usuarioDao) {
//        this.usuarioDao = usuarioDao;
//    }
    /**
     * Asigna una vista al controlador para que este pueda cargar los datos
     * recibidos
     *
     * @param table Tabla de la vista que se desea actualizar
     */
    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
}
