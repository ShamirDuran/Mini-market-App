import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProductoDaoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductoDaoTest
{
    ProductoDao productoDao;
    ProductoVo prueba;
    
    /**
     * Default constructor for test class ProductoDaoTest
     */
    public ProductoDaoTest()
    {
        productoDao = new ProductoDao();
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
    }

    @Test
    public void testGetProductoByNombre(){
        assertEquals("CREMA COLGATE", productoDao.obtenerProducto("CREMA COLGATE").get(0).getNombre());
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
