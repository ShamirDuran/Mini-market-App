/**
 *
 * @author NICOLAS
 */
import java.util.ArrayList;

public class ProductosController {

    ProductoDao productoDao;

    public ArrayList<ProductoVo> obtenerListaProductos() {
        return productoDao.obtenerProductos();
    }

    public void mostrarListaProductos() {
        System.out.println("\n/-- Lista de productos registrados --/");
        mostrarListaProducto(productoDao.obtenerProductos());
    }

    public ArrayList<ProductoVo> buscarProducto(String nombre) {
        ArrayList<ProductoVo> findList = new ArrayList<ProductoVo>();
        findList = this.productoDao.obtenerProducto(nombre);

        if (!findList.isEmpty()) {
            System.out.println("\n/-- Productos encontrados para <-" + nombre + "-> --/");
            mostrarListaProducto(findList);
            return findList;
        } else {
            System.out.println("\nNo se encontraron Productos con el nombre " + nombre + "!!");
            return null;
        }
    }

    public ProductoVo buscarProductoId(int id) {
        ProductoVo producto = productoDao.obtenerProductoId(id);

        if (producto != null) {
            System.out.println("\n/-- Producto con id " + id + " encontrado");
            return producto;
        } else {
            System.out.println("\nProducto con id " + id + " no encontrado!!");
            return null;
        }
    }

    /**
     * Metodo que pide al modelo que se añada un usuario a la db
     *
     * @return true si se realizo la operación, false si no
     */
    public boolean añadirProducto(String nombre, double precio, double cant_medida, String uni_medida, int cantidad) {
        boolean check = this.productoDao.guardarProducto(nombre, precio, cant_medida, uni_medida, cantidad);
        if (check) {
            System.out.println("\nProducto " + nombre + " registrado correctamente!!");
        } else {
            System.out.println("\nError al registrar nuevo Producto!!");
        }

        return check;
    }

    /**
     * Metodo que pide al modelo modificar un usuario en la db
     *
     * @param producto Datos que se desean actualizar para el usuario.
     * @return true si se realizo la operación, false si no
     */
    public boolean modificarProducto(ProductoVo producto) {
        boolean check = this.productoDao.modificarProducto(producto);
        if (check) {
            System.out.println("\nProducto modificado correctamente!!");
        } else {
            System.out.println("\nNo se encontro el Producto!!");
        }

        return check;
    }

    /**
     * Metodo que pide al modelo que elimine un usuario de la db
     *
     * @param id Id del usuario que se desea eliminar
     * @return true si se realizo la operación, false si no
     */
    public boolean eliminarProducto(int id) {
        boolean check = this.productoDao.eliminarProducto(id);
        if (check) {
            System.out.println("\nProducto con id " + id + " eliminado correctamente!!");
        } else {
            System.out.println("\nNo se encontro producto con id " + id);
        }

        return check;
    }

    // Esto se hace desde la vista, pero de momento para esta entrega se hara aca.
    private void mostrarListaProducto(ArrayList<ProductoVo> listaProductos) {
//        System.out.println("Total: " + listaProductos.size());

        for (ProductoVo producto : listaProductos) {
            System.out.println(producto);
        }
    }

    public void setProductoDao(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

}