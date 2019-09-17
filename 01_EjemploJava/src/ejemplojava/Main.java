package ejemplojava;

/**
 * @author Danny
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Coche miCoche;
        
        miCoche = new Coche("Skoda",60,false);//La instanciacion se hace con "new"

        miCoche.echarCarburante(30.0); //empezamos con medio deposito
        
        System.out.println("Coche salido de la fabrica : " + miCoche.getMarca());
        System.out.println("Nivel de deposito : " + miCoche.getNivelDep() + " litros");
        System.out.println("----------------");
        Coche otroCoche = new Coche("Fiat",60,true);
        
        otroCoche.echarCarburante(30.0); //empezamos con medio deposito

        
        System.out.println("Coche salido de la fabrica : " + otroCoche.getMarca());
        otroCoche.vaciarDeposito();
        System.out.println("Nivel de deposito : " + otroCoche.getNivelDep() + " litros");
        System.out.println("----------------");

		
		miCoche.setArrancado(true);
		miCoche.mostrarEstado();
		for (int i=0; i < 3; i++)
			miCoche.acelerar();
		miCoche.setArrancado(false);
		miCoche.mostrarEstado();
    }
    
}
