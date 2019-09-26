/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasPractica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
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
    public void testLanzarFicheros(){
            double inicio;
			String nombre ="";
			ArrayList<Object> objeto = new ArrayList<Object>();
			inicio = tiempoInicio();
			objeto.add(inicio);
			objeto.add(nombre);
			objeto.get(1);
			
			Observador observar = new Observador();
			
			Observer observa = new Observer(){
				
				@Override
				public void update(Observable o, Object arg) {
					ArrayList al1 = (ArrayList) arg;
					double a;
					a = new Date().getTime() - (double) al1.get(0);
					System.out.println("Aviso de "+al1.get(1)+ "+ " + a);
				}
			};
            Thread procA = new Thread(){
                @Override
                public void run(){
					objeto.set(1, "Hilo1");
                    QuitaEs1 quitar1 = new QuitaEs1();
                    HiloCrearFichero hFichero1 = new HiloCrearFichero("texto_esp.txt", quitar1); 
                    hFichero1.leerFicheroEjem();
					//observar.acabar(inicio, "Hilo 1");
					observa.update(hFichero1, objeto);
                }
            };

            Thread procB = new Thread(){
                @Override
                public void run(){
                    QuitaEs2 quitar2 = new QuitaEs2();
                    HiloCrearFichero hFichero2 = new HiloCrearFichero("texto_esp.txt", quitar2); 
                    hFichero2.leerFicheroEjem();
					
					observar.acabar(inicio, "Hilo 2");
                }
            };
            
            Thread procC = new Thread(){
                @Override
                public void run(){
                    QuitaEs3 quitar3 = new QuitaEs3();
                    HiloCrearFichero hFichero3 = new HiloCrearFichero("texto_esp.txt", quitar3); 
                    hFichero3.leerFicheroEjem();
					
					observar.acabar(inicio, "Hilo 3");
                }
            };
            procA.start();
            procB.start();
            procC.start();
            try {
                procA.join();
                procB.join();
                procC.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(pruebaFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(tiempoTotal(inicio) + "ms Tardados Hilos Total");
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
				System.out.println(tiempoTotal(inicio) + "ms Tardados Secuencial 1");

		hFich2.leerFicheroEjem();
				System.out.println(tiempoTotal(inicio) + "ms Tardados Secuencial 2");

		hFich3.leerFicheroEjem();
		System.out.println(tiempoTotal(inicio) + "ms Tardados Secuencial 3");

		System.out.println(tiempoTotal(inicio) + "ms Tardados Secuencial");

	}

	public double tiempoInicio() {
		return new Date().getTime();
	}

	public double tiempoTotal(double inicio) {
		return new Date().getTime() - inicio;
	}
}
