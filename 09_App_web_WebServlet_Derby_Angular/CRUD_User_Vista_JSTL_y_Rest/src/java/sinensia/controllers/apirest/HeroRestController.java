package sinensia.controllers.apirest;

import com.google.gson.Gson;
import sinensia.controllers.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
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
import sinensia.persistence.IUserDAO;
import sinensia.persistence.UserDAO_DerbyDB;

/**
 * @author Jaime Palomo
 */
@WebServlet(asyncSupported = true, urlPatterns = "/api/heroes")
public class HeroRestController extends HttpServlet {

    public class Hero implements Serializable {

        private int id;
        private String name;
        private String imagen;

        public Hero(int id, String name, String imagen) {
            this.id = id;
            this.name = name;
            this.imagen = imagen;
        }

        public Hero() {
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    ArrayList<Hero> listaHeroes;
    UserService userServ;

    @Override
    public void init() throws ServletException {
        listaHeroes = new ArrayList<Hero>();
        listaHeroes.add(new Hero(1, "Mepin", "../mepin.jpg"));
        listaHeroes.add(new Hero(2, "Phil", "../phil.jpg"));
        listaHeroes.add(new Hero(3, "Reos", "../reos.jpg"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        setAccessControlHeaders(resp);
        resp.setContentType("application/json; charset=UTF-8");

        Gson gson = new Gson();
        Hero hero = gson.fromJson(req.getReader(), Hero.class);

        try {
            listaHeroes.add(hero);
            String json = gson.toJson(hero);
            resp.getWriter().print(json);
        } catch (Exception ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setContentType("application/json; charset=UTF-8");

        try {
            Gson gson = new Gson();
            String textJson = gson.toJson(listaHeroes);
            resp.getWriter().print(textJson);
        } catch (Exception ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
            resp.getWriter().print("{\"error\", \"" + ex.getMessage() + "\"}");
        }
    }

    /*@Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");

        Gson gson = new Gson();
        User user = gson.fromJson(req.getReader(), User.class);

        try {

            User newUser = userServ.getOneByEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setAge(user.getAge());
            userServ.modifyUser(newUser);
            String json = gson.toJson(newUser);
            resp.getWriter().print(json);

        } catch (SQLException ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");

        Gson gson = new Gson();
        User user = gson.fromJson(req.getReader(), User.class);

        try {
            userServ.borrarPorEmail(user.getEmail());

            String json = gson.toJson(user);
            resp.getWriter().print(json);

        } catch (SQLException ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK); //Devovlemos cod 200 = OK
    }
    
    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "OPTIONS,HEAD,GET,PUT,DELETE,POST");
        resp.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER,Origin,X-Requested-With, Content-Type,Accept");
        resp.setHeader("Access-Control-Allow-Max-Age", "1728000"); //20 dias
    }

    
    
    

}
