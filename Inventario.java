import java.util.ArrayList;

/**
 *
 * @author Shamir
 */
public class Inventario {
    ProductosController proController;
    
    public void mostrarInventario(){
        ArrayList<ProductoVo> productos = proController.obtenerListaProductos();
        System.out.println("\nUnidades en stock por producto");
        for(ProductoVo producto : productos) {
            System.out.println("ID: " + producto.getId() + "   " + producto.getNombre() + "   Uni/Stock: " + producto.getCantidad());
        }
    }
    
    public void setProController(ProductosController proController) {
        this.proController = proController;
    }
    
}

