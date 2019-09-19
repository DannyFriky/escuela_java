/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import poo.Coche;
import poo.Moto;
import poo.Pelota;
import poo.Rodable;
import poo.TipoCarburante;
import poo.TipoColor;
import poo.Vehiculo;

/**
 *
 * @author alumno
 */
public class TestAbstractInterface {
	
	
	 @Test
	 public void abstractos() {
		 
		String matricula = "DFRG256";
		byte ruedas = 4; //valor constante
		String marca ="Fiat"; //valor constante
		int capacidad = 60; //valor constante
		TipoCarburante carburante = TipoCarburante.DIESEL; //valor constante
		TipoColor color = TipoColor.AZUL;
		 
		Vehiculo miVehiculo = new Vehiculo(matricula,  ruedas,  marca,  color) {
			@Override
			public void abrirPuerta() {
			
				System.out.println("Has habierto la puerta de un vehiculo generico");
			}

			@Override
			public void echarCarburante(double cantidad) {
				System.out.println("Has echado carburante a un vehiculo generico");	
			}

			@Override
			public void acelerar() {
				System.out.println("Has acelerado un vehiculo generico");	
			}

			@Override
			protected void vaciarDeposito(double cantidad) {
				System.out.println("Has gastado carburante de carburante un vehiculo generico");	
			}

			@Override
			public void pintarVehiculo(TipoColor nuevoColor) {
				System.out.println("Has cambiado el color a un vehiculo generico");	
			}

			@Override
			public void aparcar() {
				System.out.println("Has aparcado un vehiculo generico");	
			}
		
		 };
		byte ruedas2=2;

		Moto miMoto = new Moto(matricula,ruedas2 ,  marca,  capacidad,  carburante,  color);
//		miVehiculo.abrirPuerta();
//		miMoto.abrirPuerta();
//		miMoto.setArrancado(true);
//		miMoto.acelerar();
//		miMoto.setMatricula("aaaaa");
//		miMoto.acelerar();
		Coche miCoche = new Coche(matricula, ruedas, marca, capacidad, carburante, color);
//		miCoche.setArrancado(true);
//		miCoche.acelerar();
//		miCoche.acelerar();
//		miCoche.acelerar();
//		miCoche.acelerar();
//		System.out.println(miCoche);
//		miCoche.acelerar();
//		miCoche.acelerar();
//		miCoche.acelerar();
//		miCoche.acelerar();
//		miCoche.aparcar();
//		System.out.println(miCoche);
		
		miMoto.moverse();
		miCoche.moverse();
		Pelota balon = new Pelota();
		ArrayList<Rodable> cosasQueRuedan = new ArrayList<>();
		cosasQueRuedan.add(balon);
		cosasQueRuedan.add(miMoto);
		cosasQueRuedan.add(miCoche);
		
		for(Rodable rod : cosasQueRuedan){
			rod.moverse();
			
		}

	 }
	 
	
}
