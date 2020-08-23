import java.util.ArrayList;

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
     * @param id        id del nuevo usuario
     * @param rol       rol del nuevo usuario
     * @param edad      edad del nuevo usuario
     * @param nombre    nombre del nuevo usuario
     * @param correo    correo electronico del nuevo usuario
     * @param direccion direccion del nuevo usuario
     * @return true si se agrego correctamente, false si no
     */
    public boolean añadirUsuario(int rol, int edad, int genero, String nombre, String correo, String direccion) {
        UsuarioVo user = new UsuarioVo(this.contador, rol, edad, genero, nombre, correo, direccion);
        this.listaUsuarios.add(user);
        this.contador++;

        return true;
    }

    /**
     * Metodo que modifica un Usuario. Recibe como parametro el Usuario con los
     * datos modificados y busca en la lista al Usuario que tenga la mimsa id, al
     * encontrarlo modifica al usuario de la lista.
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
     * Metodo que busca en la lista de Usuarios registrado usando el Id y luego lo
     * elimina
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
     *
     * @param nombre Nombre del usuario que se desea buscar
     * @return Regresa la lista de usuarios que contengan el string( nombre) de
     *         busqueda.
     */
    public ArrayList<UsuarioVo> buscarUsuario(String nombre) {
        ArrayList<UsuarioVo> findList = new ArrayList<UsuarioVo>();

        for (UsuarioVo user : listaUsuarios) {
            if (user.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                findList.add(user);
            }
        }

        return findList;
    }

    public UsuarioVo buscarUsuarioId(int cedula) {
        UsuarioVo find = null;

        for (UsuarioVo user : this.listaUsuarios) {
            if (user.getId() == cedula) {
                find = user;
            }
        }
        return find;
    }

    public ArrayList<UsuarioVo> getListaUsuarios() {
        return listaUsuarios;
    }
}
