package sinensia.model.persistence;

import java.util.ArrayList;
import java.util.List;
import sinensia.model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public interface IUserDAO {
	
	User create(User user);

	List<User> getAll();
	
}
