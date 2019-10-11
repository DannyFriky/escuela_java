/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinensia.springrestusers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * Singleton porque sólo queremos un servicio por aplicación/servidor
 *
 * @author alumno
 */
@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	UsersRepository miRepo;

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user)
            throws NumberFormatException, IOException, IllegalArgumentException {

        if (user.getName().equals("")) {
            throw new IllegalArgumentException("El nombre es vacío");
        } else if (user.getName().length() < 2) {
            throw new IllegalArgumentException("El nombre es demasiado corto");
        }/* else if (user.getAge().equals("")) {
            throw new NumberFormatException("La edad está vacía");
        } */else {
            int intEdad = user.getAge();
            if (intEdad <= 12) {
                throw new IllegalArgumentException("La edad debe ser mayor que 12");
            } else {
               /* Persona p = new Persona(nombre, intEdad);
                personas.add(p);*/
            	user=miRepo.save(user);
                return user;
            }
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
    	
    	return miRepo.findAll();
    }
	// O bien mapeamos una url como subdirectorio
    //@GetMapping("/pornombre")
	// O recibimos el nombre por parámetros
   
}
