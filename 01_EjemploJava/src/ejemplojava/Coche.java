package ejemplojava;

/**
 * @author Danny
 */
public class Coche {
    
    private final byte numRuedas; //valor constante
    private final String marca; //valor constante
    private final int capacidadDeposito;
    private final boolean esGasolina;
    private double nivelDeposito;
	private boolean arrancado;

	public Coche(String marca, int capacidad, boolean gasolina){
		this.numRuedas =4;
		this.marca = marca;
		this.capacidadDeposito = capacidad;
		this.esGasolina =gasolina;
	
	}
	
	public byte getNumRuedas() {
		return numRuedas;
	}


	public int getCapacidadDeposito() {
		return capacidadDeposito;
	}

	public boolean isEsGasolina() {
		return esGasolina;
	}

	public boolean isArrancado() {
		return arrancado;
	}
	
	public double getNivelDep(){
		return nivelDeposito;
	}
	
	
	public void setArrancado(boolean arrancado) {
		this.arrancado = arrancado;
	}
	public void echarCarburante (double cantidad){
		
		if(cantidad>0)
			this.nivelDeposito += cantidad;
		if(this.nivelDeposito>this.capacidadDeposito)
			this.nivelDeposito = this.capacidadDeposito;
			
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

	public String getMarca() {
		return marca;
	}
}
