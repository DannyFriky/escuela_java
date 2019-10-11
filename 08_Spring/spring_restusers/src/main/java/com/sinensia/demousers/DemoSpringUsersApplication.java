package com.sinensia.demousers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringUsersApplication.class, args);
		
		System.out.println(">>> Inicio de hilos y otras tareas");
	}

}
