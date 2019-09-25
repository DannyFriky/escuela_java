/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class TestEjemploHilos {

	public class ProcesoA extends Thread {

		@Override
		public void run() {
			//super.run(); //To change body of generated methods, choose Tools | Templates.
			mostrarLista();
		}

		public void mostrarLista() {
			for (int i = 0; i < 20; i++) {
				System.out.println("Proceso A: " + i);
			}
		}
	}

	public class ProcesoB extends Thread {

		@Override
		public void run() {
			//super.run(); //To change body of generated methods, choose Tools | Templates.
			mostrarLista();
		}

		public void mostrarLista() {
			for (int i = 0; i < 20; i++) {
				System.out.println("----------------" + i);
			}
		}
	}

	@Test
	public void probandoClasesConNombre() {
		ProcesoA procA = new ProcesoA();
		Thread procB = new Thread() {
			@Override
			public void run() {
				//super.run(); //To change body of generated methods, choose Tools | Templates.
				for (int i = 0; i < 20; i++) {
					System.out.println("----------------" + i);
				}
			}
		};

		procA.start();
		procB.start();
		try {
			procA.join();
			procB.join();
		} catch (InterruptedException ex) {
			Logger.getLogger(TestEjemploHilos.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
