package sinensia.model.persistence;

import java.sql.Connection;
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
	public User create(User user) throws SQLException {
		Connection con = DriverManager.getConnection(CONE_DB, USER_DB, PSSW_DB);
		/*
		String sqlQuery = "INSERT INTO users (email,password,name,age) VALUES('"+ user.getEmail() + "','"+ user.getPassword() + "','"+ user.getName() + "',"+ user.getAge() + ")";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sqlQuery);
		 */
		String sqlQuery = "INSERT INTO users (email,password,name,age) VALUES( ?, ?, ?, ?)";
		PreparedStatement prepStmt = con.prepareCall(sqlQuery);
		prepStmt.setString(1, user.getEmail());
		prepStmt.setString(2, user.getPassword());
		prepStmt.setString(3, user.getName());
		prepStmt.setInt(4, user.getAge());

		prepStmt.executeUpdate();

		String sqlSelect = "SELECT id FROM users WHERE email=?";
		PreparedStatement prepStmtSel = con.prepareCall(sqlSelect);
		prepStmtSel.setString(1, user.getEmail());

		ResultSet sol = prepStmtSel.executeQuery();

		while (sol.next()) {
			user.setId(sol.getInt("id"));
		}

		con.close();

		return user;

	}

	@Override
	public List<User> getAll() throws SQLException {
		//Si todo ha ido bien el mismo se encarga de hacer el close de la base de datos
		try (Connection con = DriverManager.getConnection(CONE_DB, USER_DB, PSSW_DB)) {

			ArrayList<User> usersList = new ArrayList<>();
			String sqlQuery = "SELECT id, email, password, name, age FROM users";
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

	}

	@Override
	public boolean remove(int id) throws SQLException {
		try (Connection con = DriverManager.getConnection(CONE_DB, USER_DB, PSSW_DB)) {
			String sqlQuery = "DELETE FROM users WHERE id=?";
			PreparedStatement prepStmt = con.prepareCall(sqlQuery);
			prepStmt.setInt(1, id);
			
			prepStmt.executeUpdate();
		}
		
		

		return true;
	}

	@Override
	public User modify(User user) throws SQLException {

		try (Connection con = DriverManager.getConnection(CONE_DB, USER_DB, PSSW_DB)) {
			String sqlQuery = "UPDATE users "
					+ "SET email =?,"
					+ "password =?,"
					+ "name=?,"
					+ "age=?"
					+ "WHERE id=?";
			PreparedStatement prepStmt = con.prepareCall(sqlQuery);
			
			prepStmt.setString(1, user.getEmail());
			prepStmt.setString(2, user.getPassword());
			prepStmt.setString(3, user.getName());
			prepStmt.setInt(4, user.getAge());
			prepStmt.setInt(5, user.getId());
			
			prepStmt.executeUpdate();
		}

		return user;

	}

	@Override
	public User validateUser(String email, String password) throws SQLException {
		
		   try (Connection con = DriverManager.getConnection(CONE_DB, USER_DB, PSSW_DB)) {
            String sqlQueryBusqId = "SELECT id, name, age FROM users WHERE email=? AND password =?";
            PreparedStatement prepStmtBusqId = con.prepareCall(sqlQueryBusqId);
            prepStmtBusqId.setString(1, email);
			prepStmtBusqId.setString(2, password);
            ResultSet res = prepStmtBusqId.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int age = res.getInt("age");
                User user = new User(email, password, name, age);
                user.setId(id);
                return user;
            }
        }
        return null;
	}
}
