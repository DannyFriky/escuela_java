package sinensia.tests;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sinensia.model.User;
import sinensia.model.logic.UserService;
import sinensia.persistence.IUserDAO;
import sinensia.persistence.UserDAO_DerbyDB;

/**
 *
 * @author usuario
 */
public class ProbarModeloDAO {

    UserService userServ;

    public ProbarModeloDAO() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        IUserDAO daoUsers = new UserDAO_DerbyDB();
        userServ = new UserService(daoUsers);
    }

    @After
    public void tearDown() {
    }

    //@Test
    public void createAndListUserFail() {
        List<User> allUsers;
        try {
            allUsers = userServ.getAll();
            int totalUsersBefore = allUsers.size();
            User u1 = userServ.create(null, null, null, 0);
            User u2 = userServ.create("", "pass", "jj", 100);
            User u3 = userServ.create("ppp@ppp.com", "", "nombre", 10);
            User u4 = userServ.create("ggg@ggg.com", "awde", "", 24);
            User u5 = userServ.create("eee@eee.com", "fewf", "fwewfvr", 0);

            assertNull(u1);
            assertNull(u2);
            assertNull(u3);
            assertNull(u4);
            assertNull(u5);

            assertEquals(totalUsersBefore, allUsers.size());
        } catch (SQLException ex) {
            System.out.println("Error en SQL! " + ex.getMessage());
        }
    }

    //@Test
    public void creteAndListUsersOK() {
        List<User> allUsers = null;
        try {
            allUsers = userServ.getAll();
            int totalUserBefore = allUsers.size();
            User u6 = userServ.create("eee@eee.com", "fewf", "AJ J", 10);
            User u7 = userServ.create("ccc@ccc.com", "Pass123", "JeCSE", 26);
            User u8 = userServ.create("hhh@hhh.com", "contrasee", "nhfn", 20);
            userServ.borrarPorID(u8);
            assertEquals(u6.getName(), "AJ J");
            assertTrue(u7.getEmail().equals("ccc@ccc.com"));
            assertFalse(u8.getAge() != 20);

            try {//Repetido que debe fallar
                User u9 = userServ.create("ccc@ccc.com", "dc1231", "fef", 23);
                fail("No debe crearse el usuario, esta duplicado");
            } catch (SQLException ex) {

            }
            allUsers = userServ.getAll();
            assertEquals(totalUserBefore + 4, allUsers.size());
        } catch (SQLException ex) {
            System.out.println("Error!!! " + ex.getMessage());
        }
    }

    
    //@Test
    public void borrar2() {
        try {
            userServ.borrarPorEmail("ccc@ccc.com");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProbarModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void modificar()
    {
        try {
            User usuario= userServ.getOneByEmail("ccc@ccc.com");
            usuario.setAge(79);
            usuario.setName("Jose Luis");
            userServ.modifyUser(usuario);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProbarModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
