package sinensia.controllers.apirest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sinensia.controllers.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import sinensia.model.User;
import sinensia.model.logic.UserService;
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyBD;

/**
 * @author Danny
 */
@WebServlet(asyncSupported = true, urlPatterns = "/api/users/*")
public class UsersController extends HttpServlet {

	UserService userSrv;

	@Override
	public void init() throws ServletException {
		super.init();
		IUserDAO usersDAO = new UserDAO_DerbyBD();
		this.userSrv = new UserService(usersDAO);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		String id = req.getQueryString();
		//String jsonUser = req.getReader().readLine();
		setAccessControlHeader(resp);

		//User userObject = new Gson().fromJson(jsonUser, User.class);
		try {
			userSrv.delete(Integer.parseInt(id));
		} catch (SQLException ex) {
			Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
		}

		String json = "{ \"borrado\": \"true\", \"mensaje\": EXITO }";
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

		resp.getWriter().print(jsonObject);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		String jsonUser = req.getReader().readLine();
		setAccessControlHeader(resp);
		//String jsonUser = req.getParameter("json");
		//String jsonUser ="{'email':'dani@gmail.com','edad':'32'}";

		User userObject = new Gson().fromJson(jsonUser, User.class);

		try {
			userObject = userSrv.create(
					userObject.getEmail(),
					userObject.getPassword(),
					userObject.getName(),
					userObject.getAge());
		} catch (SQLException ex) {
			Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
		}

		Gson gson = new Gson();
		String textJson = gson.toJson(userObject);

		resp.getWriter().print(textJson);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=UTF-8");
		setAccessControlHeader(resp);
		try {
			List<User> userList = userSrv.getAll();
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
	
	    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonUser = req.getReader().readLine();
        User userObject = new Gson().fromJson(jsonUser, User.class);
		setAccessControlHeader(resp);
        try { // Debe venir ya con el id
            userObject = userSrv.modify(userObject);
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(new Gson().toJson(userObject));
    }


	private void setAccessControlHeader(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "OPTIONS,HEAD,GET,PUT,DELETE,POST"); //get post put delete
		resp.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER,Origin,X-Requested-With,Content-Type,Accept");
		resp.setHeader("Access-Control-Max-Age", "1728000");//20 dias
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		setAccessControlHeader(resp);
		resp.setStatus(HttpServletResponse.SC_OK);
	}

}
