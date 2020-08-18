/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

/**
 *
 * @author Shamir
 */
public class Factory {

    public void cargarDatosUsuario(UsuarioDao usuarioDao) {
        usuarioDao.añadirUsuario(1, 20, 1, "Shamir Duran", "shamirduran@gmail.com", "La universidad");
        usuarioDao.añadirUsuario(2, 25, 1, "Pepito perez", "pepitoperez@gmail.com", "La cumbre");
        usuarioDao.añadirUsuario(3, 40, 1, "Jose Manolo", "josemano@gmail.com", "San alonso");
        usuarioDao.añadirUsuario(1, 20, 1, "Nicolas Galvan", "nicolasgalvan@hotmail.com", "Centro");
        usuarioDao.añadirUsuario(2, 15, 0, "Marcela Lopez", "marcelolopez@hotmail.com", "Norte");
        usuarioDao.añadirUsuario(2, 35, 0, "Johana Uribe", "johanauribe@gmail.com", "Diamante");
    }
}
