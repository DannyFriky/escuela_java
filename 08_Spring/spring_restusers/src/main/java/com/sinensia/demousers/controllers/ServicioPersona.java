/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.demousers.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.demousers.model.Persona;

/**
 * Singleton porque sólo queremos un servicio por aplicación/servidor
 *
 * @author alumno
 */
@RestController
@RequestMapping("/personas")
public class ServicioPersona {

    private ArrayList<Persona> personas;

    @RequestMapping(method = RequestMethod.POST)
    public Persona addPersonas(
    		@RequestParam(value = "nombre") String nombre, 
    		@RequestParam(value = "edad", 
    					  defaultValue = "1") String edad)
            throws NumberFormatException, IOException, IllegalArgumentException {

        if (nombre.equals("")) {
            throw new IllegalArgumentException("El nombre es vacío");
        } else if (nombre.length() < 2) {
            throw new IllegalArgumentException("El nombre es demasiado corto");
        } else if (edad.equals("")) {
            throw new NumberFormatException("La edad está vacía");
        } else {
            int intEdad = Integer.parseInt(edad);
            if (intEdad <= 12) {
                throw new IllegalArgumentException("La edad debe ser mayor que 12");
            } else {
                Persona p = new Persona(nombre, intEdad);
                personas.add(p);
                return p;
            }
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Persona> getPersonas() {
    	if (personas  == null) {
    		personas = new ArrayList<Persona>();
    		personas.add(new Persona("Fulanito", 20));
    		personas.add(new Persona("Fulanita", 30));
    		personas.add(new Persona("Mengano", 40));
    	}
    	return this.personas;
    }
	// O bien mapeamos una url como subdirectorio
    //@GetMapping("/pornombre")
	// O recibimos el nombre por parámetros
    @GetMapping( params = "nombre")
    public Persona getPersona(
    		@RequestParam(value = "nombre") String nombre) {

        for (Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
	// O recibimos el parámetro como ruta en la url
    @RequestMapping( value = "/{edad}", 
    		method = RequestMethod.GET)
    public Persona getEdad(
    		@PathVariable int edad) {

        for (Persona p : personas) {
            if (p.getEdad() == edad) {
                return p;
            }
        }
        return null;
    }
	
    @DeleteMapping()
    public boolean removePersona(
    		@RequestParam(value = "nombre") String nombre) {
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
}
