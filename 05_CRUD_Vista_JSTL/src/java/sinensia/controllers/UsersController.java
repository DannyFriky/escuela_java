package sinensia.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sinensia.model.User;
import sinensia.model.logic.UserService;
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyBD;

/**
 * @author Danny
 */
@WebServlet(asyncSupported = true, urlPatterns = "/users.do")
public class UsersController extends HttpServlet {

	UserService userSrv;

	@Override
	public void init() throws ServletException {
		super.init();
		IUserDAO usersDAO = new UserDAO_DerbyBD();
		this.userSrv = new UserService(usersDAO);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String id = req.getParameter("id");
			String email = req.getParameter("email");
			String password = req.getParameter("password_encrypt");
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));

			String method = req.getParameter("method");
/*
			switch (method) {
				case "Delete":
					userSrv.remove(Integer.parseInt(id));
					break;
				case "Modify":
					User u = new User(email, password, name, age);
					u.setId(Integer.parseInt(id));
					userSrv.modify(u);
					break;
				default:
					User newUser = userSrv.create(email, password, name, age);
					req.setAttribute("user", newUser);
			}*/
			if ("Delete".equals(method)) {
                userSrv.remove(Integer.parseInt(id));
            } else if ("Update".equals(method)) {
				User u = new User(email, password, name, age);
                User updUsr = userSrv.modify(u);
                req.setAttribute("user", updUsr);
            } else {
                User newUser = userSrv.create(email, password, name, age);
                req.setAttribute("user", newUser);
            }

		} catch (SQLException ex) {
			Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
			req.getSession().setAttribute("errorMessage", ex.getMessage());
		}
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String email = req.getParameter("email");
			String passwordEncrypt = req.getParameter("password_encrypt");
			if (email != null && passwordEncrypt != null) {
				User user = userSrv.validateUser(email, passwordEncrypt);
				req.getSession().setAttribute("userLogged", user);
				if (user == null) {
					Cookie cookie = new Cookie("email", "");
					cookie.setMaxAge(0);
					resp.addCookie(cookie);

				} else {
					resp.addCookie(new Cookie("email", email));
				}
				req.getRequestDispatcher("result.jsp").forward(req, resp);
			}
			List<User> listUsers = userSrv.getAll();
			req.setAttribute("usersList", listUsers);
			req.getRequestDispatcher("listUsers.jsp").forward(req, resp);

		} catch (Exception ex) {
			Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

}
