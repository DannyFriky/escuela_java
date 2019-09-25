/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

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
 * @author alumno
 */
public class testFicheros {

	@Test
	public void testFicheros() {
		QuitaEs1 metodo1 = new QuitaEs1();
		QuitaEs2 metodo2 = new QuitaEs2();
		QuitaEs3 metodo3 = new QuitaEs3();
		HiloCrearFichero hFich = new HiloCrearFichero ("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt", metodo2);
		//HiloCrearFichero.crearFicheroEjem("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt");
		hFich.leerFicheroEjem();
	}
}
