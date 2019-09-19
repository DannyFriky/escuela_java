/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
public class TestGenericos {
	
	@Test
	public void metodosGenericos() {
		ArrayList<Integer> listaInt = new ArrayList<>();
		insertarDobleGenerico(listaInt, 10);
		insertarDobleGenerico(listaInt, 15);
		System.out.println("Enteros : " + listaInt.toString());
		
		ArrayList<String> listaStr = new ArrayList<>();
		insertarDobleGenerico(listaStr, "hola1");
		insertarDobleGenerico(listaStr, "hola2");
		System.out.println("String : " +listaStr.toString());
		
		Integer[] listaI = {3,4,5};
		mostrarLista(listaI);
		
		ArrayList<Integer> nueva = convertirAArrayList(listaI);
		
		System.out.println("Nueva lista : "+ nueva.toString());
		
		String[] listaStr2 ={"hola","patata","alpargata"};
		ArrayList<String> nueva2 = convertirAArrayList(listaStr2);
		
		System.out.println("Nueva lista : "+ nueva2.toString());
		
	
	}
	
	
	public static <Tipo>void insertarDobleGenerico (ArrayList<Tipo> lista, Tipo valor){
		
		lista.add(valor);
		lista.add(valor);
	}
	
	public static <Tipo>void mostrarLista(Tipo[] lista){
		
	
		for(int i=0;i<lista.length;i++)
			System.out.println("-> " + lista[i]);
	}
	
	public static <Tipo> ArrayList<Tipo> convertirAArrayList(Tipo[] lista){
		
		ArrayList <Tipo> array = new ArrayList<>();
		
		array.addAll(Arrays.asList(lista));
		
		return array;
	}
	
}
