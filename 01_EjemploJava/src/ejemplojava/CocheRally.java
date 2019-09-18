package ejemplojava;

/**
 * @author Danny
 */
public class CocheRally extends Coche{
	
	float rozamiento;

	public CocheRally(String marca, int capacidad, TipoCarburante carburante, TipoColor color, float rozamiento){
		super(marca, capacidad, carburante, color);//para llamar a un constructor modificado
		this.rozamiento = rozamiento;
		
	}
	
	public CocheRally(String marca, int capacidad, TipoCarburante carburante, String color, float rozamiento){
		super(marca, capacidad, carburante, color);//para llamar a un constructor modificado
		this.rozamiento = rozamiento;
		
	}
	
	public void derrapar(){
		System.out.println("niuuuum");
		super.explosionCilindro();
	}
	@Override
	public void acelerar(){
		if (this.isArrancado()) {
			vaciarDeposito(0.5);
			explosionCilindro();
		}
	}
	public void derrapar(float cuanto){
		System.out.println("niuuuum :" +cuanto+" veces");
		super.explosionCilindro();
	}

	public float getRozamiento() {
		return rozamiento;
	}

	public void setRozamiento(float rozamiento) {
		this.rozamiento = rozamiento;
	}
	
}
