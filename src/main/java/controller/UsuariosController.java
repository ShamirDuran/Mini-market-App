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

    UsuarioDao usuarioDao;
    private JTable table;
    /**
     * Metodo que pide al modelo la lista de usuarios registrados en la db Para
     * esta entrega se utilizara para mostrar la lista de usuarios
     *
     * @return Retorna la lista de usuarios registrados.
     */
    
    public Boolean obtenerListaUsuarios(){
        ResultSet rs = usuarioDao.obtenerUsuarios();

        if (rs != null) {
            try {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
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
    private void limpiarTabla(){
     DefaultTableModel model = (DefaultTableModel) table.getModel();
     int rowCount = model.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
        model.removeRow(i);
    }
    }
    
    public void mostrarListaUsuarios() {
        System.out.println("\n/-- Lista de usuarios registrados --/");
        mostrarListaUsuario(usuarioDao.getListaUsuarios());
    }

    public Boolean buscarUsuario(String nombre) {
        ResultSet rs = usuarioDao.buscarUsuario(nombre);

        if (rs != null) {
            try {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
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

    public UsuarioVo buscarUsuarioId(int id) {
        UsuarioVo user = usuarioDao.buscarUsuarioId(id);

        if (user != null) {
            System.out.println("\n/-- Usuario con id " + id + " encontrado --/");
            return user;
        } else {
            System.out.println("\n Usuario con id " + id + " no encontrado!!");
            return null;
        }
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
            limpiarTabla();
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
            limpiarTabla();
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
            limpiarTabla();
            obtenerListaUsuarios();
        } else {
            System.out.println("\nNo se encontro usuario con id " + id);
        }

        return check;
    }

    // Esto se hace desde la vista, pero de momento para esta entrega se hara aca.
    private void mostrarListaUsuario(ArrayList<UsuarioVo> listaUsuarios) {
//        System.out.println("Total: " + listaUsuarios.size());

        for (UsuarioVo user : listaUsuarios) {
            System.out.println(user);
        }
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    /**
     * @param table the table to set
     */
    public void setTable(JTable table) {
        this.table = table;
    }
}
