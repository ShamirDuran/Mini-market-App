import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UsuarioVoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UsuarioVoTest
{
    UsuarioVo userPrueba;
    UsuarioDao usuarioDao;
    
    /**
     * Default constructor for test class UsuarioVoTest
     */
    public UsuarioVoTest()
    {
        userPrueba = new UsuarioVo(1, 1, 20, 1, "Shamir Duran", "shamirduran@gmail.com", "La universidad");

        usuarioDao = new UsuarioDao();
        usuarioDao.añadirUsuario(1, 20, 1, "Shamir Duran", "shamirduran@gmail.com", "La universidad"); //id 1
        usuarioDao.añadirUsuario(3, 40, 1, "Jose Manolo", "josemano@gmail.com", "San alonso"); //id 2
        usuarioDao.añadirUsuario(4, 55, 0, "Doña carmensa", "carmensita@gmail.com", "Lagos 2"); //id 3
    }
    
    @Test
    public void testGetUserById() {
        assertEquals(userPrueba.getId(), usuarioDao.buscarUsuarioId(1).getId());
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
