/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.vo.UsuarioVo;
import java.util.ArrayList;
import model.conexion.Conexion;

/**
 * Clase que contiene los metodos de acceso a la db.
 *
 * @author Shamir
 */
public class UsuarioDao {

    Conexion c;
    Connection con;

    private ArrayList<UsuarioVo> listaUsuarios;

    /**
     * Constructor clase UsuarioDao
     */
    public UsuarioDao() {
        this.listaUsuarios = new ArrayList<UsuarioVo>();
        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerUsuarios() {
        String sql = "SELECT * FROM t_usuarios";
        return queryWithResultSet(sql);
    }

    /**
     * Metodo que agrega nuevos usuarios a la lista de registrados. Retorna un
     * boolean dependiendo de si se realizo la operación o no.
     *
     * @param rol rol del nuevo usuario
     * @param edad edad del nuevo usuario
     * @param nombre nombre del nuevo usuario
     * @param correo correo electronico del nuevo usuario
     * @param direccion direccion del nuevo usuario
     * @param cedula Número de identificación
     * @return true si se agrego correctamente, false si no
     */
//  * Tipos de rol 1 - Admin 2 - Jefe de bodega 3 - Cajero 4 - Cliente
    public boolean añadirUsuario(int rol, int edad, int genero, String nombre, String correo, String direccion, int cedula) {
        String sql = "INSERT INTO t_usuarios (rol, edad, genero, transacciones, nombre, correo, direccion,cedula) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        UsuarioVo user = new UsuarioVo(4, rol, edad, genero, nombre, correo, direccion, cedula);

        Boolean check = queryWithBoolean(sql, user, "execute");

        return check;
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

        String sql = "UPDATE t_usuarios SET rol = ?, edad = ?, genero = ?, transacciones = ?, nombre = ?, correo = ?, direccion = ?, cedula = ? WHERE id = ?";
        check = queryWithBoolean(sql, dataUser, "executeUpdate");
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
        String sql = "DELETE FROM t_usuarios WHERE id = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e);
            return false;
        }
    }

    /**
     * Metodo que busca un usuaruo en la db por el nombre
     *
     * @param nombre Nombre del usuario que se desea buscar
     * @return Regresa la lista de usuarios que contengan el string( nombre) de
     * busqueda.
     */
    public ResultSet buscarUsuario(String nombre) {
        String sql = "SELECT *FROM t_usuarios WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);

    }

    public UsuarioVo buscarUsuarioId(int cedula) {
        UsuarioVo find = null;

        for (UsuarioVo user : listaUsuarios) {
            if (user.getId() == cedula) {
                find = user;
            }
        }
        return find;
    }

    public ArrayList<UsuarioVo> getListaUsuarios() {
        return listaUsuarios;
    }

    private ResultSet queryWithResultSet(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error traer datos productos: " + e);
        }

        return rs;
    }

    private Boolean queryWithBoolean(String sql, UsuarioVo user, String type) {
        PreparedStatement ps = null;

        try {
            if (user != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, user.getRol());
                ps.setInt(2, user.getEdad());
                ps.setInt(3, user.getGenero());
                ps.setInt(4, user.getTransacciones());
                ps.setString(5, user.getNombre());
                ps.setString(6, user.getCorreo());
                ps.setString(7, user.getDireccion());
                ps.setInt(8, user.getCedula());

                switch (type) {
                    case "execute":
                        ps.execute();
                        break;

                    case "executeUpdate":
                        System.out.println(user.getId());
                        ps.setInt(9, user.getId());
                        ps.executeUpdate();
                        break;

                    default:
                        break;
                }
            }
            return true;

        } catch (Exception e) {
            System.out.println("Error en la petición de la db: " + e);
        }

        return false;
    }
}
