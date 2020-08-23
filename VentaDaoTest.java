import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VentaDaoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VentaDaoTest
{
    VentaDao ventaDao;
    UsuarioDao usuarioDao;
    ProductoDao productoDao;
    VentaVo venta1;
    
        
    /**
     * Default constructor for test class VentaDaoTest
     */
    public VentaDaoTest()
    {
        usuarioDao = new UsuarioDao();
        productoDao = new ProductoDao();
        ventaDao = new VentaDao();
        ventaDao.setUsuarioDao(usuarioDao);
        Singleton.getInstance();
        
        System.out.println(Singleton.getInstance().getNombre());
        
        usuarioDao.añadirUsuario(1, 20, 1, "Shamir Duran", "shamirduran@gmail.com", "La universidad"); // 1
        usuarioDao.añadirUsuario(2, 25, 1, "Pepito Perez", "pepitoperez@gmail.com", "La cumbre"); // 2
        usuarioDao.añadirUsuario(3, 40, 1, "Jose Manolo", "josemano@gmail.com", "San alonso"); // 3
        usuarioDao.añadirUsuario(1, 20, 1, "Nicolas Galvan", "nicolasgalvan@hotmail.com", "Centro"); // 4
        usuarioDao.añadirUsuario(3, 15, 0, "Marcela Lopez", "marcelolopez@hotmail.com", "Norte"); // 5
        usuarioDao.añadirUsuario(4, 55, 0, "Doña carmensa", "carmensita@gmail.com", "Lagos 2"); // 6
        usuarioDao.añadirUsuario(4, 65, 0, "Eduvigis Sarmiento", "eduvigisar@hotmail.com", "Castellana"); // 7
        usuarioDao.añadirUsuario(4, 25, 1, "Carlos Gomez", "carlooos@gmail.com", "La cumbre"); // 8
        
        productoDao.guardarProducto("DESENGRASANTE", 4000, 500, "ml", 100); // 1
        productoDao.guardarProducto("ARROZ", 1650, 500, "g", 69); // 2
        productoDao.guardarProducto("GASEOSA COCA COLA", 2790, 500, "ml", 72); // 3
        productoDao.guardarProducto("CREMA COLGATE", 2250, 75, "ml", 40); // 4
        productoDao.guardarProducto("PAPAS FRITAS KYTHOS", 1890, 115, "g", 30); // 5
        productoDao.guardarProducto("MAYONESA BAJA EN GRASA", 2250, 500, "g", 40); // 6
        productoDao.guardarProducto("MERMELADA DE MORA ZEV", 1750, 200, "g", 80); // 7
        productoDao.guardarProducto("GALLETA WAFER", 790, 22, "g", 51); // 8
        productoDao.guardarProducto("QUESO MOZZARELLA", 5690, 400, "g", 100); // 9
        productoDao.guardarProducto("SALSA DE PIÑA", 200, 20, "g", 91); // 10
        
        venta1 = new VentaVo(usuarioDao.buscarUsuarioId(6));
        venta1.añadirProducto(productoDao.obtenerProductoId(2), 5);
        venta1.añadirProducto(productoDao.obtenerProductoId(4), 2);
        venta1.añadirProducto(productoDao.obtenerProductoId(7), 1);
    }

    @Test
    public void testVentaRegistrar(){
        assertEquals(true, ventaDao.registrarVenta(venta1));
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
