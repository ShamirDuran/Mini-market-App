/**
 * Esta clase crea y contiene la informacion de los productos al ser traidos de
 * la db
 *
 * @author Shamir Duran, Nicolas Galvan
 * @version 0.1
 *
 */
public class ProductoVo {

    private String nombre, uni_medida;
    private double precio, cant_medida;
    private int id, cantidad, cantidadVendidos;

    /**
     * @param id Valor autoingrementado que asigna la db al regitrar un
     * producto. Se trae desde la db al momento de listas los productos en la
     * vista ProductosView
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param cant_medida valor numerico cantidad de medida
     * @param uni_medida Unidad de medida. Ej: kg, g
     * @param cantidad Cantidad del producto en stock
     */
    public ProductoVo(int id, String nombre, double precio, double cant_medida, String uni_medida, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cant_medida = cant_medida;
        this.uni_medida = uni_medida;
        this.cantidad = cantidad;
    }

    // recibir objeto
    public void modificar(int id, String nombre, double precio, double cant_medida, String uni_medida, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cant_medida = cant_medida;
        this.uni_medida = uni_medida;
        this.cantidad = cantidad;
    }

    /**
     * Cuando se quiere agrear un producto a una venta en progreso, se tiene que
     * validad primero si quedan unidades disponibles para la venta.
     *
     * @param cantidad Cantidad del producto que se desea comprar.
     * @return Booleano que indica el estado de la transacción
     */
    public boolean restarCantidad(int cantidad) {
        boolean check = false;
        int result = this.cantidad - cantidad;

        if (result >= 0) {
            this.cantidad = result;
            check = true;
        }

        return check;
    }

    public int sumarCantidadV(int cantidad) {
        cantidadVendidos = cantidadVendidos + cantidad;
        return cantidadVendidos;
    }

    public int restarCantidadV(int cantidad) {
        cantidadVendidos = cantidadVendidos - cantidad;
        return cantidadVendidos;
    }

    /**
     * Cuando se elimina una venta, o se elimina un producto de una venta este
     * metodo se utiliza para agregar a la cantidad en stock las unidades que se
     * recuperaron.
     *
     * @param cantidad
     */
    public void restaurarCantidad(int cantidad) {
        this.cantidad = this.cantidad + cantidad;
    }

    public String toString() {
        String str = "id: " + id + "  " + nombre + "  " + precio + "$" + "  " + cant_medida + "" + uni_medida + "  "
                + cantidad + " Unidades" + "  " + "Total Unidades Vendidas:" + cantidadVendidos;

        return str;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public double getcant_medida() {
        return cant_medida;
    }

    public void setcant_medida(double cant_medida) {
        this.cant_medida = cant_medida;

    }

    public String getuni_medida() {
        return uni_medida;
    }

    public void setuni_medida(String uni_medida) {
        this.uni_medida = uni_medida;
    }

    /**
     * @return the cantidadVendidos
     */
    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    /**
     * @param cantidadVendidos the cantidadVendidos to set
     */
    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

}
