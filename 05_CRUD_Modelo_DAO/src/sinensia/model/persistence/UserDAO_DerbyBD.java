package sinensia.model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sinensia.model.User;

/**
 * @author Danny
 */
public class UserDAO_DerbyBD implements IUserDAO {

	private static final String CONE_DB = "jdbc:derby://localhost:1527/db_users";
	private static final String USER_DB = "root";
	private static final String PSSW_DB = "1234";

	public UserDAO_DerbyBD() {

		try {
			// Cargamos el driver de Derby DB. Esta basado en JDBC.
			// Una implementacion de ODBC para Java

			Class.forName("org.apache.derby.jdbc.ClientDriver");
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
		} catch (Exception ex) {
			Logger.getLogger(UserDAO_DerbyBD.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public User create(User user) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONE_DB, USER_DB, PSSW_DB);
			String sqlQuery = "INSERT INTO users (email,password,name,age) VALUES('"
					+ user.getEmail() + "','"
					+ user.getPassword() + "','"
					+ user.getName() + "',"
					+ user.getAge() + ")";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlQuery);
			con.close();
			return user;

		} catch (SQLException ex) {
			Logger.getLogger(UserDAO_DerbyBD.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	@Override
	public List<User> getAll() {
		//Si todo ha ido bien el mismo se encarga de hacer el close de la base de datos
		try (Connection con = DriverManager.getConnection(CONE_DB, USER_DB, PSSW_DB)) {
			
			ArrayList<User> usersList = new ArrayList<>();
			String sqlQuery = "SELECT id, email, password, name, age FROM users";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sqlQuery);
			while(res.next()){
				int id = res.getInt("id");
				String email = res.getString("email");
				String password = res.getString("password");
				String name = res.getString("name");
				int age = res.getInt("age");
				User newUser = new User(email,password,name,age);
				newUser.setId(id);
				usersList.add(newUser);
			}
			return usersList;
		} catch (Exception ex) {
			Logger.getLogger(UserDAO_DerbyBD.class.getName()).log(Level.SEVERE, null, ex);

		}
		return null;

	}
}
