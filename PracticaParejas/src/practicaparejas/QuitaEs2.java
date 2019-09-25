package practicaparejas;

/**
 * @author Danny
 */
public class QuitaEs2 implements interfazEspacios {

	@Override
	public String quitaEspacio(String texto) {
            texto = texto.trim();
            String[] palabras = texto.split(" ");
            String result = "";
            for (String palabra : palabras) {
                if ( ! palabra.isEmpty())
                    result += palabra + " ";
            }
            return result.trim();
	}

}
