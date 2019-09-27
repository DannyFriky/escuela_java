package com.sinensia.modelo.logica;

import com.sinensia.modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Singleton porque solo queremos un servicio por aplicacion/servidor
 *
 * @author Danny
 */
public class ServicioPersona {

	private static ServicioPersona instancia;

	private ServicioPersona() {
		personas = new ArrayList<>();
	}

	public static ServicioPersona getInstancia() {
		if (instancia == null) {
			instancia = new ServicioPersona();
		}
		return instancia;
	}
	private ArrayList<Persona> personas;

	public Persona addPersonas(Map mapa)
			throws NumberFormatException, IOException, IllegalArgumentException {

		String[] nombre = (String[]) mapa.get("nombre");
		String[] edad = (String[]) mapa.get("edad");
		String[] mail = (String[]) mapa.get("mail");
		String[] pass = (String[]) mapa.get("pass");
		int intEdad = Integer.parseInt(edad[0]);
		if (nombre.equals("")) {
			throw new IllegalArgumentException("El nombre esa vacio");
		} else if (nombre[0].length() < 2) {
			throw new IllegalArgumentException("El nombre es demasiado corto");

		} else if (edad.equals("")) {
			throw new IllegalArgumentException("La edad esta vacia");

		} else {
			if (intEdad <= 12) {
				throw new IllegalArgumentException("La edad debe ser mayor que 12");

			} else {
				Persona p = new Persona(intEdad, nombre[0], mail[0], pass[0]);
				personas.add(p);
				return p;
			}

		}

	}

	public Persona getPersona(String nombre) {
		for (Persona p : personas) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				return p;
			}
		}
		return null;
	}

	public Persona getMail(String mail) {
		for (Persona p : personas) {
			if (p.getMail().equalsIgnoreCase(mail)) {
				return p;
			}
		}
		return null;
	}

	public boolean borrarPersona(String nombre) {
		Persona perElim = null;
		for (Persona p : personas) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				perElim = p;
			}
		}
		if (perElim == null) {
			return false;
		} else {
			personas.remove(perElim);
			return true;
		}
	}

	public ArrayList<Persona> buscarPersonaNombre(String nombre)
			throws NumberFormatException, IOException, IllegalArgumentException {

		String[] nombresV = nombre.split(",");
		ArrayList<Persona> arrayP = new ArrayList<Persona>();
		int i;
		for (i = 0; i < nombresV.length; i++) {
			Persona p = ServicioPersona.getInstancia().getPersona(nombresV[i]);
			arrayP.add(p);
		}

		return arrayP;
	}

	public ArrayList<Persona> buscarPersonaMail(String mail)
			throws NumberFormatException, IOException, IllegalArgumentException {
		Persona p = ServicioPersona.getInstancia().getMail(mail);
		ArrayList<Persona> arrayP = new ArrayList<Persona>();
		arrayP.add(p);
		return arrayP;
	}

	public ArrayList<Persona> modificarPersona(Map mapa)
			throws NumberFormatException, IOException, IllegalArgumentException {

		String[] nombre = (String[]) mapa.get("nombre");
		String[] edad = (String[]) mapa.get("edad");
		String[] mail = (String[]) mapa.get("mail");
		String[] pass = (String[]) mapa.get("pass");
		String[] nombreA = (String[]) mapa.get("nombreA");
			
		int intEdad = Integer.parseInt(edad[0]);
		Persona p = ServicioPersona.getInstancia().getPersona(nombreA[0]);
		p.setNombre(nombre[0]);
		p.setEdad(intEdad);
		p.setMail(mail[0]);
		p.setPass(pass[0]);

		ArrayList<Persona> arrayP = new ArrayList<Persona>();
		arrayP.add(p);
		return arrayP;
	}
	
	
}
