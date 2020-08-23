import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProductoVoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductoVoTest
{
    ProductoVo producto1;
    
    /**
     * Default constructor for test class ProductoVoTest
     */
    public ProductoVoTest()
    {
        producto1 = new ProductoVo(1, "ARROZ", 1650, 500, "g", 69);
    }

    @Test
    public void testRestarCantidad(){
        //Verifica que existan las cantidades disponibles del producto que se desea comprar.
        assertEquals(true, producto1.restarCantidad(10));
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
