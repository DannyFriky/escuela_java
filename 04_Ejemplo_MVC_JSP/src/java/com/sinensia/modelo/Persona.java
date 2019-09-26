package com.sinensia.modelo;

/**Esta clase es un POJO (Plain Old Java Object)
 * Clases sin lógica, cin herencia (o poco de...)
 * Suelen corresponder a una ENTIDAD
 * @author Danny
 */
public class Persona {

	private int edad;
	private String nombre;

	public Persona(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
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
