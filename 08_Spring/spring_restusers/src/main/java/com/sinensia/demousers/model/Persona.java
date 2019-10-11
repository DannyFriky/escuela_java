/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.demousers.model;

import java.io.Serializable;

/** Esta clase es un POJO (Plain Old Java Object)
 *  Clases sin lógica, sin herencia (o poco de...)
 * Suelen corresponder a una ENTIDAD
 * @author alumno
 */
public class Persona implements Serializable {
    
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
