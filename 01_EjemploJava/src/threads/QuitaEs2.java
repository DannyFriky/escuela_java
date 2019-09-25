package threads;

/**
 * @author Danny
 */
public class QuitaEs2 implements interfazEspacios {

	@Override
	public String quitaEspacio(String linea) {
		String result = "";
		for (int i = 0; i <linea.length(); i++) {
			if (linea.charAt(i) != ' ') {
				result += linea.charAt(i);
				if (linea.charAt(i + 1) == ' ') {
					result += ' ';
				}
			}
		}
		return result.trim();
	}

}
