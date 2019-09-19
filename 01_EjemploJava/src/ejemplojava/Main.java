package ejemplojava;

import poo.TipoCarburante;
import poo.CocheRally;
import poo.TipoColor;
import poo.Coche;
import clasesjava.ProbandoString;

/**
 * @author Danny
 */
public class Main {

    /**
     * @param args the command line arguments
     */
	
	public static void main(String[] args) {
		ProbandoString.tratarCadenas();
	}
    public static void mainCoches(String[] args) {
        
        Coche miCoche;
		byte ruedas = 4;
        
        miCoche = new Coche("matricula",ruedas,"Skoda",60,TipoCarburante.DIESEL, TipoColor.AZUL);//La instanciacion se hace con "new"

        miCoche.echarCarburante(20.0); //empezamos con medio deposito
        
        System.out.println("Coche salido de la fabrica : " + miCoche.getMarca());
        System.out.println("Nivel de deposito : " + miCoche.getNivelDep() + " litros");
        System.out.println("----------------");
        Coche otroCoche = new Coche("matricula",ruedas,"Fiat",60,TipoCarburante.GASOLINA, TipoColor.NEGRO);
        
        otroCoche.echarCarburante(10.0); //empezamos con medio deposito

        
        System.out.println("Coche salido de la fabrica : " + otroCoche.getMarca());
        //otroCoche.vaciarDeposito(3.0);
        System.out.println("Nivel de deposito : " + otroCoche.getNivelDep() + " litros");
        System.out.println("----------------");

		miCoche.setArrancado(true);
		miCoche.mostrarEstado();
		for (int i=0; i < 3; i++)
			miCoche.acelerar();
		miCoche.setArrancado(false);
		miCoche.mostrarEstado();
		
		
		CocheRally cocheChulo = new CocheRally ("matricula",ruedas,"MarcaBuena",90,TipoCarburante.ELECTRICO,TipoColor.AZUL);
		cocheChulo.echarCarburante(45);
		cocheChulo.setArrancado(true);
		cocheChulo.acelerar();
		cocheChulo.derrapar();
		
		miCoche = cocheChulo;
		
		CocheRally cc = (CocheRally)miCoche;
		System.out.println("y el rozamiento : "+ cc.getRozamiento());
		//cocheChulo.rozamiento = 10.0f;
		System.out.println("y el rozamiento : "+ cc.getRozamiento());

		
    }
    
}
