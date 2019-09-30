package sinensia.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sinensia.model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Interfaz DAO para gestion de usuarios. Todas las sentencias 
 *  pueden lanzar SWLException
 *
 * @author alumno
 */
public interface IUserDAO {
	
	User create(User user) throws SQLException;

	List<User> getAll() throws SQLException;
	
	boolean remove(int id) throws SQLException;
	
	User modify(User user) throws SQLException;
}
