

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UsuarioDaoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UsuarioDaoTest
{
    UsuarioDao usuarioDao;

    /**
     * Default constructor for test class UsuarioDaoTest
     */
    public UsuarioDaoTest()
    {
        usuarioDao = new UsuarioDao();
    }

    @Test
    public void testAñadirUsuario(){
        assertEquals(true, usuarioDao.añadirUsuario(1, 20, 1, "Nicolas Galvan", "nicolasgalvan@hotmail.com", "Centro"));
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
