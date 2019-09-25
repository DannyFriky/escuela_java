package practicaparejas;

import java.util.Date;

/**
 * @author Danny
 */
public class Observador implements Notificacion{

	@Override
	public void acabar(double tiempo, String nombre) {
		tiempo = new Date().getTime() - tiempo;
		System.out.println("El hilo " + nombre + " ha tardado " + tiempo +" ms en acabar");	}

}
