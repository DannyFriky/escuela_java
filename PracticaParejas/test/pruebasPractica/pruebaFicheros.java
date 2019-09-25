/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasPractica;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import practicaparejas.*;

/**
 *
 * @author Formacion
 */
public class pruebaFicheros {

	public pruebaFicheros() {
	}

	@Test
	public void testLanzarFicheros() {
		

	}

	@Test
	public void testSecuencial() {
		double inicio;
		inicio = tiempoInicio();
		QuitaEs1 metodo1 = new QuitaEs1();
		QuitaEs2 metodo2 = new QuitaEs2();
		QuitaEs3 metodo3 = new QuitaEs3();
		HiloCrearFichero hFich1 = new HiloCrearFichero("texto_esp.txt", metodo1);
		HiloCrearFichero hFich2 = new HiloCrearFichero("texto_esp.txt", metodo2);
		HiloCrearFichero hFich3 = new HiloCrearFichero("texto_esp.txt", metodo3);
		hFich1.leerFicheroEjem();
		hFich2.leerFicheroEjem();
		hFich3.leerFicheroEjem();
		System.out.println(tiempoTotal(inicio) + "ms Tardados Secuencial");

	}

	public double tiempoInicio() {
		return new Date().getTime();
	}

	public double tiempoTotal(double inicio) {
		return new Date().getTime() - inicio;
	}
}
