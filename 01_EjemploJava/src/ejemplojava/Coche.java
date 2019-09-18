package ejemplojava;

/**
 * @author Danny
 */
public class Coche {
   
	public static final int CAPACIDAD_DEPOSITO = 60; //Como declarar una constante
	
    private final byte numRuedas; //valor constante
    private final String marca; //valor constante
    private final int capacidadDeposito; //valor constante
    private final TipoCarburante carburante; //valor constante
    private double nivelDeposito;
	private boolean arrancado;
	private TipoColor color;

	public Coche(String marca, int capacidad, TipoCarburante carburante, TipoColor color){
		this.numRuedas =4;
		this.marca = marca;
		this.capacidadDeposito = capacidad;
		this.carburante = carburante;		
		this.nivelDeposito=capacidad/2;
		this.arrancado = false;
		this.color = color;
	}
	
		public Coche(String marca, int capacidad, TipoCarburante carburante, String color){
		this.numRuedas =4;
		this.marca = marca;
		this.capacidadDeposito = capacidad;
		this.carburante = carburante;		
		this.nivelDeposito=capacidad/2;
		this.arrancado = false;
		
		//this.color =Enum.valueOf(TipoColor.class, color);  Esta no me mola, pero ya que esta -\o/-
		//this.color = TipoColor.valueOf(color.toUpperCase());

		for (TipoColor iteraC : TipoColor.values()){
			if (color.compareToIgnoreCase(iteraC.name())==0)
				this.color = iteraC;
		}
		
		System.out.println("Color : "+this.color);
		
	}
	
	public void echarCarburante (double cantidad){
		
		if(cantidad>0)
			this.nivelDeposito += cantidad;
		if(this.nivelDeposito>this.capacidadDeposito)
			this.nivelDeposito = this.capacidadDeposito;	
	}
	
	public void pintarCoche(TipoColor nuevoColor){
		this.color = nuevoColor;
	}
	
	public void acelerar(){
		if (arrancado) nivelDeposito -= 0.1;
	}
    
    public void vaciarDeposito(){
		
		this.nivelDeposito = 3;
        System.out.println("Deposito vaciado de : "  + this.toString());
    }
    
    public String toString(){
		
		return "Coche " + marca +" nivel " + nivelDeposito; //Math.round(nivelDeposito*100.0)/100.0;
	}
	
	public void mostrarEstado(){
		System.out.println("Estado de " + this.toString());
	}
	//GET
	public String getMarca() {
		return marca;
	}
	
	public byte getNumRuedas() {
		return numRuedas;
	}

	public int getCapacidadDeposito() {
		return capacidadDeposito;
	}

	public TipoCarburante isEsGasolina() {
		return carburante;
	}

	public boolean isArrancado() {
		return arrancado;
	}
	
	public double getNivelDep(){
		return nivelDeposito;
	}

	public TipoColor getColor() {
		return color;
	}
	
	
	
	//SET
	public void setArrancado(boolean arrancado) {
		this.arrancado = arrancado;
	}
}
