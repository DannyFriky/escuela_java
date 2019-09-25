/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasPractica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import practicaparejas.HiloCrearFichero;
import practicaparejas.QuitaEs1;
import practicaparejas.QuitaEs2;
import practicaparejas.QuitaEs3;

/**
 *
 * @author Formacion
 */
public class pruebaFicheros {
    
    public pruebaFicheros() {
    }
    
    @Test
    public void testLanzarFicheros(){
        
    }

	@Test
	public void testSecuencial() {
		QuitaEs1 metodo1 = new QuitaEs1();
		QuitaEs2 metodo2 = new QuitaEs2();
		QuitaEs3 metodo3 = new QuitaEs3();
		HiloCrearFichero hFich1 = new HiloCrearFichero("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt", metodo1);
		HiloCrearFichero hFich2 = new HiloCrearFichero("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt", metodo2);
		HiloCrearFichero hFich3 = new HiloCrearFichero("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt", metodo3);
		hFich1.leerFicheroEjem();
		hFich2.leerFicheroEjem();
		hFich3.leerFicheroEjem();

	}
}
