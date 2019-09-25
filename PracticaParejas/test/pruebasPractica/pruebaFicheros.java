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
    public void testLanzarFicheros(){
            double inicio;
            inicio = tiempoInicio();
            Thread procA = new Thread(){
                @Override
                public void run(){
                    QuitaEs1 quitar1 = new QuitaEs1();
                    HiloCrearFichero hFichero1 = new HiloCrearFichero("texto_esp.txt", quitar1); 
                    hFichero1.leerFicheroEjem();
                }
            };

            Thread procB = new Thread(){
                @Override
                public void run(){
                    QuitaEs2 quitar2 = new QuitaEs2();
                    HiloCrearFichero hFichero2 = new HiloCrearFichero("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java_practica", quitar2); 
                    hFichero2.leerFicheroEjem();
                }
            };
            
            Thread procC = new Thread(){
                @Override
                public void run(){
                    QuitaEs3 quitar3 = new QuitaEs3();
                    HiloCrearFichero hFichero3 = new HiloCrearFichero("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java_practica", quitar3); 
                    hFichero3.leerFicheroEjem();
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
            System.out.println(tiempoTotal(inicio) + "ms Tardados");
    }

	@Test
	public void testSecuencial() {
		double inicio;
		inicio = tiempoInicio();
		QuitaEs1 metodo1 = new QuitaEs1();
		QuitaEs2 metodo2 = new QuitaEs2();
		QuitaEs3 metodo3 = new QuitaEs3();
		HiloCrearFichero hFich1 = new HiloCrearFichero("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt", metodo1);
		HiloCrearFichero hFich2 = new HiloCrearFichero("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt", metodo2);
		HiloCrearFichero hFich3 = new HiloCrearFichero("C:\\Users\\alumno\\Desktop\\ESCUELA_java\\escuela_java.git\\01_EjemploJava\\texto_esp.txt", metodo3);
		hFich1.leerFicheroEjem();
		hFich2.leerFicheroEjem();
		hFich3.leerFicheroEjem();
		System.out.println(tiempoTotal(inicio) + "ms Tardados");
	}
	
	public double tiempoInicio(){
		return new Date().getTime();
	}
	
	public double tiempoTotal(double inicio){
		return new Date().getTime() - inicio;
	}
}
