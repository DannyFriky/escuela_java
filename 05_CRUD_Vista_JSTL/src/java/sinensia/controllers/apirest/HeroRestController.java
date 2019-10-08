package sinensia.controllers.apirest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sinensia.controllers.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(asyncSupported = true, urlPatterns = "/api/heroes")
public class HeroRestController extends HttpServlet {

	public class Hero implements Serializable {

		private int id;
		private String name;
		private String url;

		Hero() {

		}

		Hero(int id, String nombre, String file) {
			this.id = id;
			this.name = nombre;
			this.url = file;

		}

		public String getFile() {
			return url;
		}

		public void setFile(String file) {
			this.url = file;
		}

		public String getNombre() {
			return name;
		}

		public void setNombre(String nombre) {
			this.name = nombre;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}

	ArrayList<Hero> listaHeroes;

	@Override
	public void init() throws ServletException {
		super.init();
		listaHeroes = new ArrayList<>();
		listaHeroes.add(new Hero(1, "AllMight", "--/am.jpg"));
		listaHeroes.add(new Hero(2, "Endeavor", "--/end.jpg"));
		listaHeroes.add(new Hero(3, "Hawks", "--/haw.jpg"));
		
	}

	/*@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		String jsonUser = req.getReader().readLine();

		User userObject = new Gson().fromJson(jsonUser, User.class);
		try {
			userSrv.delete(userObject.getId());
		} catch (SQLException ex) {
			Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
		}

		String json = "{ \"borrado\": \"true\", \"mensaje\": EXITO }";
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

		resp.getWriter().print(jsonObject);
	}*/

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jsonUser = req.getReader().readLine();
		Hero heroObject = new Gson().fromJson(jsonUser, Hero.class);
			setAccessControlHeader(resp);

		try {
			listaHeroes.add(heroObject);
			resp.setContentType("application/json;charset=UTF-8");

			Gson gson = new Gson();
			String textJson = gson.toJson(listaHeroes);

			resp.getWriter().print(textJson);
		} catch (Exception ex) {
			Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=UTF-8");
		setAccessControlHeader(resp);
		try {

			Gson gson = new Gson();
			String textJson = gson.toJson(listaHeroes);
			resp.getWriter().print(textJson);
		} catch (Exception ex) {
			Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
			resp.getWriter().print("{\"error\": \" "
					+ ex.getMessage() + "\"");
		}
	}
	
	
	private void setAccessControlHeader(HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods","OPTIONS,HEAD,GET,PUT,DELETE,POST"); //get post put delete
		resp.setHeader("Access-Control-Allow-Headers","X-PINGOTHER,Origin,X-Requested-With,Content-Type,Accept");
		resp.setHeader("Access-Control-Max-Age","1728000");//20 dias
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		setAccessControlHeader(resp);
		resp.setStatus(HttpServletResponse.SC_OK);
	}

}
