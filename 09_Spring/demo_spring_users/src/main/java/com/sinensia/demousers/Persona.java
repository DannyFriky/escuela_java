package com.sinensia.demousers;

import java.io.Serializable;

/**
 * Esta clase es un POJO (Plain Old Java Object) Clases sin lógica, cin herencia
 * (o poco de...) Suelen corresponder a una ENTIDAD
 *
 * @author Danny
 */
public class Persona implements Serializable{

	private int edad;
	private String nombre;
	private String mail;
	private String pass;

	public Persona(int edad, String nombre, String mail, String pass) {
		this.edad = edad;
		this.nombre = nombre;
		this.mail = mail;
		this.pass = pass;
	}

	public Persona(String nombre, int edad) {
		// TODO Auto-generated constructor stub
		this.edad = edad;	
		this.nombre = nombre;
		this.mail = "mail";
		this.pass = "pass";
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
