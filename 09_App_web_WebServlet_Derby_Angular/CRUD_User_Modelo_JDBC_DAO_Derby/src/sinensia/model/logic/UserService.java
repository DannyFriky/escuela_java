package sinensia.model.logic;

import java.sql.SQLException;
import java.util.List;
import sinensia.model.User;
import sinensia.persistence.IUserDAO;
import sinensia.persistence.UserDAO_DerbyDB;

/**
 * @author Jaime Palomo
 */
public class UserService {

    IUserDAO daoUser;

    public UserService() {
        daoUser = new UserDAO_DerbyDB();
    }

    public UserService(IUserDAO daoUser) {
        this.daoUser = daoUser;
    }

    public User create(String email, String password, String name, int age) throws SQLException {
        User u = null;
        if (email != null && password != null && name != null) {
            if (email.length() > 3 && !password.equals("") && !name.equals("") && age > 0) {
                u = new User(email, password, name, age);
                u = daoUser.create(u);
            }
        }
        return u;
    }

    public List<User> getAll() throws SQLException {
        return daoUser.getAll();
    }
    public boolean borrarPorEmail(String email) throws SQLException
    {
        return daoUser.remove(daoUser.getByEmail(email));
    }
     public boolean borrarPorID(User user) throws SQLException
    {
        return daoUser.remove(user.getId());
    }
     public User modifyUser(User user) throws SQLException
     {
         return daoUser.modifyUser(user);
     }
     public User getOneByEmail(String email) throws SQLException    
     {
         return daoUser.getByEmail(email);
     }
     public boolean delete(Integer id) throws SQLException
     {
         return daoUser.remove(daoUser.getById(id));
     }
     public User getOneById(int id) throws SQLException
     {
        
         return daoUser.getById(id);
     }
     public User getValidUser(String email,String password) throws SQLException
     {
         return daoUser.validateUser(email, password);
     }
}
