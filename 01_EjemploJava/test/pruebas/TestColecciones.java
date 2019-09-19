/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import poo.Coche;
import poo.TipoCarburante;
import poo.TipoColor;
import java.util.ArrayList;
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
public class TestColecciones {
	
	
	 @Test
	 public void arrays() {
		 byte ruedas = 4;
		Coche[] coches = new Coche[3];
		coches[0] = new Coche("matricula",ruedas,"Skoda",60,TipoCarburante.DIESEL, TipoColor.AZUL) ;
		coches[1] = new Coche("matricula",ruedas,"Fiat",60,TipoCarburante.ELECTRICO, TipoColor.ROJO) ;
		coches[2] = new Coche("matricula",ruedas,"Kia",60,TipoCarburante.GASOLINA, TipoColor.NEGRO) ;
		
		Coche[] cocheBis = {coches[2], new Coche("matricula",ruedas,"Fiat",60,TipoCarburante.DIESEL, TipoColor.ROJO), coches[0]};
		
		Coche elMio = coches[2];
		elMio.setArrancado(true);
		elMio.acelerar();
		///////////////////
		coches[2].mostrarEstado();
		
		ArrayList arrayListObj = new ArrayList(); //ArrayList no generico
		arrayListObj.add(42);
		arrayListObj.add("aaaaa");
		arrayListObj.add(elMio);
		arrayListObj.add(false);
		for (Object obj : arrayListObj){
			System.out.println("OBJ : " + obj);
		}
		
		ArrayList<Integer> ventasAnuales = new ArrayList<Integer>();
		Integer objEntero = new Integer(200);
		objEntero.longValue();
		ventasAnuales.add(objEntero);
		ventasAnuales.add(3000);
		
		ArrayList<Coche> cochesParaVender = new ArrayList<>() ;
		cochesParaVender.add(elMio);
		//cochesParaVender.add(new Coche("Fiat2"));
		//cochesParaVender.forEach(TestColecciones::mostrarCoches);
		cochesParaVender.forEach((obj)->{
		 System.out.println("-> "+ obj);
		});
		

	 }
}
