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

    public ResultSet obtenerUsuariosReporte() {
        String sql = "SELECT t_usuarios.id, t_usuarios.nombre,t_usuarios.transacciones, SUM(t_ventas.total) AS gasto FROM t_usuarios INNER JOIN t_ventas ON t_usuarios.id=t_ventas.fk_comprador GROUP BY t_usuarios.id ORDER BY transacciones DESC";
        return queryWithResultSet(sql);
    }

    public ResultSet obtenerUsuariosReporteD() {
        String sql = "SELECT t_usuarios.id, t_usuarios.nombre,COUNT(t_usuarios.transacciones) AS transacciones , SUM(t_ventas.total) AS gasto FROM t_usuarios \n"
                + "INNER JOIN t_ventas ON t_usuarios.id=t_ventas.fk_comprador \n"
                + "WHERE (SELECT Date_format(CURDATE(),'%Y-%m-%d')= STR_TO_DATE(t_ventas.fecha,'%d-%m-%Y')) GROUP BY t_usuarios.id ORDER BY transacciones DESC";
        return queryWithResultSet(sql);
    }

    public ResultSet obtenerVendedorReporte() {
        String sql = "SELECT t_usuarios.id, t_usuarios.nombre,t_usuarios.transacciones, SUM(t_ventas.total) AS gasto FROM t_usuarios INNER JOIN t_ventas ON t_usuarios.id=t_ventas.fk_vendedor GROUP BY t_usuarios.id ORDER BY t_usuarios.transacciones DESC";
        return queryWithResultSet(sql);
    }

    public ResultSet obtenerVendedorReporteD() {
        String sql = "SELECT t_usuarios.id, t_usuarios.nombre,COUNT(t_usuarios.transacciones) AS transacciones , SUM(t_ventas.total) AS gasto FROM t_usuarios \n"
                + "INNER JOIN t_ventas ON t_usuarios.id=t_ventas.fk_vendedor\n"
                + "WHERE (SELECT Date_format(CURDATE(),'%Y-%m-%d')= STR_TO_DATE(t_ventas.fecha,'%d-%m-%Y')) GROUP BY t_usuarios.id ORDER BY t_usuarios.transacciones DESC";
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
        Boolean check = queryInsert(sql, user);
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
        String sql = "UPDATE t_usuarios SET edad = ?, genero = ?, nombre = ?, correo = ?, direccion = ?, cedula = ? WHERE id = ?";
        check = queryUpdate(sql, dataUser);
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

    private Boolean queryInsert(String sql, UsuarioVo user) {
        PreparedStatement ps = null;
        try {
            if (user != null) {
                ps = con.prepareStatement(sql);

                ps.setInt(1, user.getRol());

                if (user.getEdad() != 0) {
                    ps.setInt(2, user.getEdad());

                } else {
                    ps.setString(2, null);
                }

                ps.setInt(3, user.getGenero());

                ps.setInt(4, 0); //transacciones

                ps.setString(5, user.getNombre());

                if (user.getCorreo() != null) {
                    ps.setString(6, user.getCorreo());
                } else {
                    ps.setString(6, null);
                }

                if (user.getDireccion() != null) {
                    ps.setString(7, user.getDireccion());
                } else {
                    ps.setString(7, null);
                }

                if (user.getCedula() != 0) {
                    ps.setInt(8, user.getCedula());
                } else {
                    ps.setString(8, null);
                }

                ps.execute();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en la petición de la db: " + e);
        }
        return false;
    }

    private Boolean queryUpdate(String sql, UsuarioVo user) {
        PreparedStatement ps = null;
        try {
            if (user != null) {
                ps = con.prepareStatement(sql);

                if (user.getEdad() != 0) {
                    ps.setInt(1, user.getEdad());
                } else {
                    ps.setString(1, null);
                }

                ps.setInt(2, user.getGenero());
                ps.setString(3, user.getNombre());
                ps.setString(4, user.getCorreo());
                ps.setString(5, user.getDireccion());

                if (user.getCedula() != 0) {
                    ps.setInt(6, user.getCedula());
                } else {
                    ps.setString(6, null);
                }

                ps.setInt(7, user.getId());
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en actualizar usuaruo de la db: " + e);
        }
        return false;
    }
}
