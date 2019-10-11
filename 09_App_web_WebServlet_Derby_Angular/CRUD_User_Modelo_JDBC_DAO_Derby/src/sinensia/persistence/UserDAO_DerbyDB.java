package sinensia.persistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sinensia.model.User;

/**
 * @author Jaime Palomo
 */
public class UserDAO_DerbyDB implements IUserDAO {

    private static final String CONEX_DB = "jdbc:derby://localhost:1527/db_users";
    private static final String USER_DB = "root";
    private static final String PWD_DB = "1234";

    public UserDAO_DerbyDB() {
        try {
            //Cargamos el driver de Derby DB. Esta basado en JDBC
            //Una implementación de JDBC para Java
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(UserDAO_DerbyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User create(User user) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        /*String sqlQuery = "INSERT INTO users (email,password,name,age) VALUES ("+ " '" + user.getEmail() + "', '" + user.getPassword()+ "', '" + user.getNombre() + "', " + user.getAge() + ")";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlQuery);*/
        // Los ? son los parametros de las sentencia SQL. Evitamos SQL injection.
        String sqlQuery = "INSERT INTO users (email,password,name,age) VALUES (?,?,?,?)";
        PreparedStatement prepStmt = con.prepareCall(sqlQuery);
        prepStmt.setString(1, user.getEmail());
        prepStmt.setString(2, user.getPassword());
        prepStmt.setString(3, user.getName());
        prepStmt.setInt(4, user.getAge());
        prepStmt.executeUpdate();

        //Aqui buscamos el Id a través del email
        user = getByEmail(user.getEmail());
        con.close();
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        ArrayList<User> usersList = new ArrayList<User>();
        String sqlQuery = "Select id,email,password,name,age FROM users";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sqlQuery);
        while (res.next()) {
            int id = res.getInt("id");
            String email = res.getString("email");
            String password = res.getString("password");
            String name = res.getString("name");
            int age = res.getInt("age");

            User newUser = new User(email, password, name, age);
            newUser.setId(id);
            usersList.add(newUser);
        }
        return usersList;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        String sqlQuery = "DELETE FROM users WHERE id = ?";
        PreparedStatement prepStat = con.prepareCall(sqlQuery);
        prepStat.setInt(1, id);
        return prepStat.executeUpdate() != 0;
    }

    @Override
    public boolean remove(User user) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        String sqlQuery = "DELETE FROM users WHERE id = ?";
        PreparedStatement prepStat = con.prepareCall(sqlQuery);
        prepStat.setInt(1, user.getId());
        return prepStat.executeUpdate() != 0;
    }

    @Override
    public User getByEmail(String email) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        String sqlQuery = "Select id,email,password,name,age FROM users WHERE email = ?";
        PreparedStatement prep = con.prepareCall(sqlQuery);
        prep.setString(1, email);
        ResultSet resul = prep.executeQuery();
        resul.next();
        int id = resul.getInt("id");
        User user = new User(resul.getString("email"), resul.getString("password"), resul.getString("name"), resul.getInt("age"));
        user.setId(id);
        return user;
    }

    @Override
    public User modifyUser(User user) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        String sqlQuery = "UPDATE users SET email = ? , password = ?, name = ?, age=? WHERE id = ?";
        PreparedStatement prepStat = con.prepareCall(sqlQuery);
        prepStat.setString(1, user.getEmail());
        prepStat.setString(2, user.getPassword());
        prepStat.setString(3, user.getName());
        prepStat.setInt(4, user.getAge());
        prepStat.setInt(5, user.getId());
        prepStat.executeUpdate();
        return user;
    }

    @Override
    public User getById(int id) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        User user = null;
        String sqlQuery = "Select id,email,password,name,age FROM users WHERE id = ?";
        PreparedStatement prep = con.prepareCall(sqlQuery);
        prep.setInt(1, id);
        ResultSet resul = prep.executeQuery();
        resul.next();

        int idUser = resul.getInt("id");
        user = new User(resul.getString("email"), resul.getString("password"), resul.getString("name"), resul.getInt("age"));
        user.setId(id);
        return user;
    }

    @Override
    public User validateUser(String email, String pass) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PWD_DB);
        String sqlQuery = "Select id,name,age FROM users WHERE email = ? AND password=?";
        PreparedStatement prep = con.prepareCall(sqlQuery);
        prep.setString(1, email);
        prep.setString(2, pass);
        ResultSet resul = prep.executeQuery();
        while (resul.next()) {
            int id = resul.getInt("id");
            String name = resul.getString("name");
            int age = resul.getInt("age");
            User user = new User(email, pass, resul.getString("name"), resul.getInt("age"));
            user.setId(id);
            return user;
        }
        return null;
    }

}
