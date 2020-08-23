

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VentaVoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VentaVoTest
{
    ProductoVo producto;
    UsuarioVo comprador;
    VentaVo venta;
    /**
     * Default constructor for test class VentaVoTest
     */
    public VentaVoTest()
    {
        producto = new ProductoVo(1, "GASEOSA COCA COLA", 2790, 500, "ml", 72);
        comprador = new UsuarioVo(1, 4, 65, 0, "Eduvigis Sarmiento", "eduvigisar@hotmail.com", "Castellana");
        venta = new VentaVo(comprador);
    }

    @Test
    public void testValidarVentaProducto(){
        assertEquals(false, venta.validarVentaProducto(producto, 80));
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
