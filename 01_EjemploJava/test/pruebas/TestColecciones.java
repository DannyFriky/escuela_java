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
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import poo.Pelota;

/**
 *
 * @author alumno
 */
public class TestColecciones {
	
	
	
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
	 @Test
	 public void sets(){
		 
		HashSet<Pelota> pelotas = new HashSet<>();
		Pelota p1 = new Pelota();
		pelotas.add(p1);
		Pelota p2 = new Pelota();
		pelotas.add(p2);
		Pelota p3 = new Pelota();
		pelotas.add(p3);
		
		pelotas.add(p3);
		 System.out.println("Set de pelotas :" +pelotas);
		 assertEquals(pelotas.size(),3);
		 
		 HashMap<String,Boolean> coloresCalidos = new HashMap<>();
		 coloresCalidos.put("BLANCO", false);
		 coloresCalidos.put("NEGRO", false);
		 coloresCalidos.put("ROJO", true);
		 coloresCalidos.put("AZUL", false);
		 coloresCalidos.put("VERDE", false);
		 
		 if(coloresCalidos.get("ROJO"))
			 System.out.println("rojooo es calido");
		 if(coloresCalidos.get("AZUL"))
			 System.out.println("azul es calido");
		 
		 System.out.println("Verde es: " + coloresCalidos.get("VERDE"));
		 
		 HashMap<String, Coche> cochecitos = new HashMap<>();
		 TreeMap<String, Coche> cochecitosT = new TreeMap<>();
		 
		Coche coche1 = new Coche("matricula1",(byte)4,"Skoda",60,TipoCarburante.DIESEL, TipoColor.AZUL) ;
		Coche coche2 = new Coche("matricula2",(byte)4,"Fiat",60,TipoCarburante.ELECTRICO, TipoColor.ROJO) ;
		Coche coche3 = new Coche("matricula3",(byte)4,"Kia",60,TipoCarburante.GASOLINA, TipoColor.NEGRO) ;
		
		cochecitosT.put(coche1.getMatricula(), coche1);
		cochecitosT.put(coche2.getMatricula(), coche2);
		cochecitosT.put(coche3.getMatricula(), coche3);
		 
		cochecitosT.forEach((clave,valor)->{
			System.out.println("Clave : "+clave);
			System.out.println("Valor :" + valor);
		
		});

	 }
}
