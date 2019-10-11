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
import sinensia.persistence.IUserDAO;
import sinensia.persistence.UserDAO_DerbyDB;

/**
 * @author Jaime Palomo
 */
@WebServlet(asyncSupported = true, urlPatterns = "/users.do")
public class UsersController extends HttpServlet {

    UserService userServ;

    @Override
    public void init() throws ServletException {
        IUserDAO usersDAO = new UserDAO_DerbyDB();
        this.userServ = new UserService(usersDAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String age = req.getParameter("age");

            String method = req.getParameter("method");
            if ("Delete".equals(method)) {
                userServ.delete(Integer.parseInt(id));
            } else if("Modify".equals(method))
            {
                User user= userServ.getOneById(Integer.parseInt(id));
                user.setPassword(password);
                user.setName(name);
                user.setAge(Integer.parseInt(age));
                userServ.modifyUser(user);
            }
            else {
                User newUser = userServ.create(email, password, name, Integer.parseInt(age));
                req.setAttribute("user", newUser);
            }

        } catch (SQLException e) {
            System.out.println("ERROR!! " + e.getMessage());
            req.setAttribute("errorMessage", e.getMessage());
        } finally {
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email=req.getParameter("email");
            String password_encrypt= req.getParameter("password_encrypt");
            if(email != null && password_encrypt != null)
            {
                User user= userServ.getValidUser(email, password_encrypt);
                if(user != null)
                {
                req.getSession().setAttribute("userLogged", user);
                resp.addCookie(new Cookie("email",email));
                req.getRequestDispatcher("result.jsp").forward(req, resp);
                }
                else
                {
                    req.getSession().removeAttribute("userLogged");
                    Cookie coEmail = new Cookie("email", null);
                    coEmail.setMaxAge(0);
                    resp.addCookie(coEmail);
                    throw new Exception ("Error en el enviar email y password");
                }
            }
            else{
            List<User> listUsers = userServ.getAll();
            req.setAttribute("usersList", listUsers);
            req.getRequestDispatcher("list_Users.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            System.out.println("ERROR!! " + e.getMessage());
            req.setAttribute("errorMessage", e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("errorMessage", ex.getMessage());
        } finally {
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        }
    }

}
