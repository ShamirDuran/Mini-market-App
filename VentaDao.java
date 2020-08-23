import java.util.ArrayList;

/**
 *
 * @author Shamir
 */
public class VentaDao {

    UsuarioDao usuarioDao;

    int contador = 1;

    private ArrayList<VentaVo> listaVentas;

    public VentaDao() {
        this.listaVentas = new ArrayList<VentaVo>();
    }

    public boolean registrarVenta(VentaVo venta) {
        venta.setId(contador);
        venta.date();
        listaVentas.add(venta);
        contador++;
        Singleton.getInstance().sumarCantidadV();
        
        UsuarioVo user = usuarioDao.buscarUsuarioId(venta.getVendedor().getId());
        if (user != null) {
            user.sumarCantidadC();
        }
        venta.getComprador().sumarCantidadC();
        return true;
    }

    public boolean modificarVenta(VentaVo dataVenta) {
        boolean check = false;

        for (VentaVo venta : this.listaVentas) {
            if (venta.getId() == dataVenta.getId()) {
                venta = dataVenta;
                venta.date_mod();
                check = true;
                break;
            }
        }

        return check;
    }

    /**
     * Metodo que elimina una venta ya registrada, al ejecutarse tambien llama
     * al metodo de restaurar cantidad para sumarle las unidades recuperadas al
     * productos respectivo
     *
     * @param id Id de la venta a eliminar
     * @return Boolean indicando el estado de la transacción
     */
    public boolean eliminarVenta(int id) {
        int index = 0;
        boolean check = false;

        for (VentaVo venta : listaVentas) {
            if (venta.getId() == id) {
                restaurarCantidad(venta);
                Singleton.getInstance().restarCantidadV();
                UsuarioVo user = usuarioDao.buscarUsuarioId(venta.getVendedor().getId());
                if (user != null) {
                    user.restarCantidadC();
                }
                venta.getComprador().restarCantidadC();
                listaVentas.remove(index);
                check = true;
                break;
            } else {
                index++;
            }
        }
        return check;
    }

    // Añadir otro parametro llamado type, de acuerdo al tipo sera la forma de
    // busqueda -Vendedor - Comprador, -Fecha, - Id
    public ArrayList<VentaVo> buscarVenta(String ref) {
        ArrayList<VentaVo> findList = new ArrayList<VentaVo>();

        for (VentaVo venta : listaVentas) {
            if (venta.getId() == Integer.parseInt(ref)) {
                findList.add(venta);
            }
        }

        return findList;
    }

    /**
     * Le suma a las unidades en stock del producto las recuperadas al eliminar
     * un producto de una venta
     *
     * @param venta Venta que se va a eliminar
     */
    private void restaurarCantidad(VentaVo venta) {
        int index = 0;
        for (ProductoVo producto : venta.getProductosList()) {
            producto.restaurarCantidad(venta.getCantidadList().get(index));
        }
    }

    public ArrayList<VentaVo> getListaVentas() {
        return listaVentas;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

}
