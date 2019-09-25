/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import practicaparejas.StringAux;
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
public class TestStringAux {
	
	@Test
	public void probandoQuitarEspacios(){
		String texto = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, vivia ...";
		String texto2 ="En un lugar de Madrid...";
		String texto3= "          en      un       LUGAR     ";
		
		String resultadoOK ="en un LUGAR";
		String resultadoAux ="";//futura llamada
		
		//StringAux texto3Aux = new StringAux(texto3);
		//resultadoAux = texto3Aux.quitarEspacios();
		resultadoAux = StringAux.quitarEspaciosV2(texto3);

		//resultadoAux = StringAux.quitarEspaciosV1(texto3);
		assertEquals(resultadoOK,resultadoAux);
		
	}
	@Test
	public void probandoContarPalabras(){
		assertEquals(5,StringAux.contarPalabras("En un lugar de Madrid..."));
		assertEquals(3,StringAux.contarPalabras("En un lugar "));
		assertEquals(0,StringAux.contarPalabras("                 "));
		assertEquals(1,StringAux.contarPalabras("AAAAAAAAAAAAAAAAAA"));

	}

}
