package sinensia.model.logic;

import java.util.List;
import sinensia.model.User;
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyBD;

/**
 * @author Danny
 */
public class UserService {

	IUserDAO daoUsers;

	public UserService(IUserDAO daoUsers) {
		this.daoUsers = daoUsers;

	}

	public User create(String email, String password, String name, int age) {

		User u = null;
		if (email != null && password != null && name != null) {
			if (email.length() > 3
					&& !password.equals("")
					&& !name.equals("")
					&& age > 0) {
				//TODO: Create user object and add to the DB
				u = new User(email, password, name, age);
				u = daoUsers.create(u);
			}
		}

		return u;

	}

	public List<User> getAll() {
		return daoUsers.getAll();
	}

}
