package poo;

/**
 * @author Danny
 */
public class Moto extends Vehiculo {
	
	private boolean pataLevantada;
	protected final int capacidadDeposito; //valor constante
    protected final TipoCarburante carburante; //valor constante
    protected double nivelDeposito;

	public Moto(String matricula, byte ruedas, String marca, int capacidad, TipoCarburante carburante, TipoColor color) {
		super(matricula, ruedas, marca, color);
		this.pataLevantada = true;
		this.capacidadDeposito = capacidad;
		this.carburante = carburante;		
		this.nivelDeposito=capacidad/2;
	}

	@Override
	public void abrirPuerta() {
		System.out.println("Las motos no tienen puertas");
	}

	@Override
	public void echarCarburante(double cantidad) {
		if(cantidad>0)
			this.nivelDeposito += cantidad;
		if(this.nivelDeposito>this.capacidadDeposito)
			this.nivelDeposito = this.capacidadDeposito;
	}

	@Override
	public void acelerar() {
		if (arrancado) {
			nivelDeposito -= 0.2;
		}

	}

	@Override
	protected void vaciarDeposito(double cantidad) {
			this.nivelDeposito -= cantidad;
	}

	@Override
	public void pintarVehiculo(TipoColor nuevoColor) {
		this.color = nuevoColor;
	}
	
	public void subirPata(){
		if(!pataLevantada)
			pataLevantada=true;
	}

	@Override
	public void aparcar() {
		this.arrancado = false;
		this.pataLevantada = true;
	}

}
