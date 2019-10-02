package sinensia.controllers.apirest;

import com.google.gson.Gson;
import sinensia.controllers.*;
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
@WebServlet(asyncSupported = true, urlPatterns = "/api/users")
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

	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=UTF-8");
		try {
			List<User> userList=userSrv.getAll();
			//serializamos el list en un JSON
			
			Gson gson = new Gson();
			String textJson = gson.toJson(userList);
			//Devolvera [{"id":1, "email.....}, {},...]
			resp.getWriter().print(textJson);
		} catch (SQLException ex) {
			Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
			resp.getWriter().print("{\"error\": \" "
					+ ex.getMessage() + "\"");
		}
	}

}
