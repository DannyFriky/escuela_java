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
        QuitaEs1 quitar1 = new QuitaEs1();
        QuitaEs2 quitar2 = new QuitaEs2();
        QuitaEs3 quitar3 = new QuitaEs3();
        
        HiloCrearFichero hFichero1 = new HiloCrearFichero("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java_practica", quitar1); 
        HiloCrearFichero hFichero2 = new HiloCrearFichero("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java_practica", quitar2);  
        HiloCrearFichero hFichero3 = new HiloCrearFichero("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java_practica", quitar3); 
        
    }
}
