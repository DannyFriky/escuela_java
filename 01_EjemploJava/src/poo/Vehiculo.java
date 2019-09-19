package poo;

/**
 * @author Danny
 */
public abstract class Vehiculo {
	
	protected String matricula;
	protected final byte numRuedas; //valor constante
    protected final String marca; //valor constante
	protected boolean arrancado;
	protected TipoColor color;
	
	public Vehiculo(String matricula, byte ruedas, String marca, TipoColor color){
		
		this.matricula = matricula;
		this.numRuedas =ruedas;
		this.marca = marca;
		this.arrancado = false;
		this.color = color;
		
	}
	
	public abstract void abrirPuerta();

	public abstract void echarCarburante(double cantidad);
	
	public abstract void acelerar();
	
	protected abstract void vaciarDeposito(double cantidad);
	
	public abstract void pintarVehiculo(TipoColor nuevoColor);
	
	public abstract void aparcar();

	public String getMatricula() {
		return matricula;
	}

		public void setArrancado(boolean arrancado) {
		this.arrancado = arrancado;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
}
