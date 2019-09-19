package poo;

/**
 * @author Danny
 */
public class Coche extends Vehiculo {
   

	public Coche(String matricula, byte ruedas, String marca, int capacidad, TipoCarburante carburante, TipoColor color){
		super( matricula,  ruedas,  marca,  capacidad,  carburante,  color);
	}
	
//	public Coche(String marca){
//		this.numRuedas =4;
//		this.marca = marca;
//		this.capacidadDeposito = 60;
//		this.carburante = TipoCarburante.DIESEL;		
//		this.nivelDeposito=capacidadDeposito/2;
//		this.arrancado = false;
//		this.color = TipoColor.AZUL;
//	}
//	
//	public Coche(String marca, int capacidad, TipoCarburante carburante, String color){
//		this.numRuedas =4;
//		this.marca = marca;
//		this.capacidadDeposito = capacidad;
//		this.carburante = carburante;		
//		this.nivelDeposito=capacidad/2;
//		this.arrancado = false;
//		
//		//this.color =Enum.valueOf(TipoColor.class, color);  Esta no me mola, pero ya que esta -\o/-
//		//this.color = TipoColor.valueOf(color.toUpperCase());
//
//		for (TipoColor iteraC : TipoColor.values()){
//			if (color.compareToIgnoreCase(iteraC.name())==0)
//				this.color = iteraC;
//		}
//		
//		System.out.println("Color : "+this.color);
//		
//	}
//	
		@Override
	public void abrirPuerta() {
		System.out.println("Has abierto las 4 puertas");
		
	}
	
		@Override
	public void echarCarburante (double cantidad){
		
		if(cantidad>0)
			this.nivelDeposito += cantidad;
		if(this.nivelDeposito>this.capacidadDeposito)
			this.nivelDeposito = this.capacidadDeposito;	
	}
		@Override
	public void pintarVehiculo(TipoColor nuevoColor){
		this.color = nuevoColor;
	}
	
		@Override
	public void acelerar(){
		
		if (arrancado) {
			nivelDeposito -= 0.1;
				explosionCilindro();
		}
	}
		@Override
    protected void vaciarDeposito(double cantidad){
		
		this.nivelDeposito -= cantidad;
    }
    
    public String toString(){

		return "Coche " + marca +" nivel " + nivelDeposito +" arrancado : " + arrancado; //Math.round(nivelDeposito*100.0)/100.0;
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

	protected void explosionCilindro(){
		System.out.println("PUM");
	}

	@Override
	public void aparcar() {
		this.arrancado=false;
	}


}
