import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que contiene la informacion de una venta
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 */
public class VentaVo {

    private int id;
    private UsuarioVo vendedor;
    private UsuarioVo comprador;
    private ArrayList<ProductoVo> productosList;
    private ArrayList<Integer> cantidadList;
    private double total;
    private String fecha;
    private String fecha_mod;

    private Date date;
    private SimpleDateFormat format;

    /**
     * Constructor de la clase Venta
     *
     * @param comprador Datos del cliente que compro.
     */
    public VentaVo(UsuarioVo comprador) {
        vendedor = new UsuarioVo(Singleton.getInstance().getId(), Singleton.getInstance().getRol(),
                Singleton.getInstance().getEdad(), Singleton.getInstance().getGenero(),
                Singleton.getInstance().getNombre(), Singleton.getInstance().getCorreo(),
                Singleton.getInstance().getDireccion());

        this.cantidadList = new ArrayList<Integer>();
        this.productosList = new ArrayList<ProductoVo>();
        this.comprador = comprador;
        this.fecha_mod = null;

        format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    }

    /**
     * Metodo que agrega un producto a la venta
     * 
     * @param producto Producto que se va a agregar a la venta
     * @param cantidad Cantidad del producto que se desea comprar
     */
    public void añadirProducto(ProductoVo producto, int cantidad) {
        if (producto != null) {
            if (validarVentaProducto(producto, cantidad)) {
                this.productosList.add(producto);
                this.cantidadList.add(cantidad);
                this.total = calcularTotal();
                producto.sumarCantidadV(cantidad); //aqui se suman la cantidad total de ventas de un producto
                System.out.println("Producto " + producto.getNombre() + " añadido!");
            }
        } else {
            System.out.println("No se pudo añadir el producto!");
        }
    }

    /**
     * Elimina un producto de esta venta Al eliminar el producto de la venta se suma
     * a la cantidad en stock la cantidad que se habia comprado.
     * 
     * @param id Id del producto que se quiere eliminar de la venta
     */
    public void eliminarProducto(int id) {
        boolean check = false;
        int index = 0;

        for (ProductoVo producto : productosList) {
            if (producto.getId() == id) {
                check = true;
                break;
            }
            index++;
        }

        if (check) {
            System.out.println("\nSe elimino " + productosList.get(index).getNombre() + " de la factura.");
            productosList.get(index).restaurarCantidad(cantidadList.get(index));
            productosList.get(index).restarCantidadV(cantidadList.get(index));
            productosList.remove(index);
            cantidadList.remove(index);
            this.total = calcularTotal();
        } else {
            System.out.println("\nNo se pudo eliminar el producto con id " + id + " de la venta " + this.id);
        }
    }

    public void mostrarVenta() {
        String str = "\nVentaID: " + this.id + ", Vendedor: " + this.vendedor.getNombre() + ", Comprador: "
                + this.comprador.getNombre() + "\n" + "Fecha: " + this.fecha;

        System.out.println(str);

        if (fecha_mod != null) {
            System.out.println("Fecha modificación; " + this.fecha_mod);
        }
        System.out.println("\n<- PRODUCTOS COMPRADOS ->");

        listarProductos();

        System.out.println(" TOTAL: " + total);
    }

    /**
     * Metodo que verifica si quedan unidades suficientes para satisfacer las
     * unidades solicitadas
     * 
     * @param producto El producto que se desea comprar
     * @param cantidad La cantidad del producto que se desea comprar
     * @return
     */
    public boolean validarVentaProducto(ProductoVo producto, int cantidad) {
        boolean check = false;

        if (producto.restarCantidad(cantidad)) {
            check = true;
        }

        return check;
    }

    private void listarProductos() {
        int cont = 1;
        int index = 0;

        for (ProductoVo producto : productosList) {
            System.out.println(" * " + cont + " " + producto.getNombre() + " " + producto.getPrecio() + " "
                    + cantidadList.get(index) + " " + producto.getPrecio() * cantidadList.get(index));
            cont++;
            index++;
        }
    }

    /**
     * Calcula el precio total de esta venta
     * 
     * @return la cantidad que se debe cobrar
     */
    private double calcularTotal() {
        double total = 0;
        int index = 0;

        for (ProductoVo producto : this.productosList) {
            total = total + (producto.getPrecio() * cantidadList.get(index));
            index++;
        }

        return total;
    }

    /**
     * Obtiene la hora y fecha exacta en la que se realiza la venta
     */
    public void date() {
        this.date = new Date();
        this.fecha = this.format.format(this.date);
    }

    public void date_mod() {
        this.date = new Date();
        this.fecha_mod = this.format.format(this.date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioVo getVendedor() {
        return vendedor;
    }

    public void setVendedor(UsuarioVo vendedor) {
        this.vendedor = vendedor;
    }

    public UsuarioVo getComprador() {
        return comprador;
    }

    public void setComprador(UsuarioVo comprador) {
        this.comprador = comprador;
    }

    public ArrayList<ProductoVo> getProductosList() {
        return productosList;
    }

    public void setProductosList(ArrayList<ProductoVo> productosList) {
        this.productosList = productosList;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(String fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Integer> getCantidadList() {
        return cantidadList;
    }
}
