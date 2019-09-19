package poo;

/**
 * @author Danny
 */
public class Pelota implements Rodable{

	@Override
	public byte getNumRuedas() {
		return 1;
	}

	@Override
	public void moverse() {
		System.out.println("Y bota bota la pelota");
	}

}
