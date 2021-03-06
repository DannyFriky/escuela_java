/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyBD;

/**
 *
 * @author alumno
 */
public class ProbandoModeloDAO {

	UserService userSrv;

	public ProbandoModeloDAO() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		IUserDAO daoUsers = new UserDAO_DerbyBD();
		userSrv = new UserService(daoUsers);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void createAndListUsersFail() {

		try {
			List<User> allUsers = userSrv.getAll();

			int totalUsersBefore = allUsers.size();

			User u1 = userSrv.create(null, null, null, 0);
			User u2 = userSrv.create("", "p1234", "J J", 20);
			User u3 = userSrv.create("er@dd", null, "J J", 20);
			User u4 = userSrv.create("er@dd", "p1234", "", 20);
			User u5 = userSrv.create("er@dd", "p1234", "J J", 0);
			assertNull(u1);
			assertNull(u2);
			assertNull(u3);
			assertNull(u4);
			assertNull(u5);


			assertEquals(allUsers.size(), 0);
		} catch (SQLException ex) {
			Logger.getLogger(ProbandoModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Test
	public void createAndListUsersOK() {
		try {
			List<User> allUsers = userSrv.getAll();

			int totalUsersBefore = allUsers.size();

			User u1 = userSrv.create("aaa@mail.com", "a1234", "AAaaa", 20);
			User u2 = userSrv.create("bbb@mail.com", "b1234", "BBbbb", 30);
			User u3 = userSrv.create("ccc@mail.com", "c1234", "CCccc", 40);
			User u4 = userSrv.create("ddd@mail.com", "d1234", "DDddd", 50);
			assertNotNull(u1);
			assertEquals(u2.getName(), "BBbbb");
			assertTrue(u3.getEmail().equals("ccc@mail.com"));
			assertFalse(u4.getAge() != 50);
			userSrv.delete(u1.getId());
			userSrv.delete(u2.getId());
			userSrv.delete(u3.getId());
			u4.setName("Danny");
			u4.setAge(24);
			u4 = userSrv.modify(u4);

			assertEquals(totalUsersBefore+1, userSrv.getAll().size());
		} catch (SQLException ex) {
			Logger.getLogger(ProbandoModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
			fail();
		}

	}
}
