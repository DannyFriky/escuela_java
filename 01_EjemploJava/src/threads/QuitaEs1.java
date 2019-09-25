package threads;

/**
 * @author Danny
 */
public class QuitaEs1 implements interfazEspacios {

	@Override
	public String quitaEspacio(String linea) {
		String textoCorregido = "";
		String[] aux2 = linea.split("\\s+");
		for (String aux1 : aux2) {
			textoCorregido = textoCorregido.concat(aux1 + " ");
		}

		linea = textoCorregido.trim();
		return linea;

	}

}
