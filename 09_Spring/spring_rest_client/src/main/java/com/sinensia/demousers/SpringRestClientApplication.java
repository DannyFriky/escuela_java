package com.sinensia.demousers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestClientApplication.class, args);
		
		System.out.println(">> Recogiendo usuarios");
		RestClient clienteRest = new RestClient();
		String jsonUsers = clienteRest.get("/users");
		System.out.println(">> Usuarios recogidos : \n"+jsonUsers);
	}
	//public List<User> getTodosUsuarios(){
		
	//}

}
