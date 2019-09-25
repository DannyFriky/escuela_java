package practicaparejas;

/**
 * @author Danny
 */
public class QuitaEs3 implements interfazEspacios{
    @Override
    public String quitaEspacio(String texto) {
        texto = texto.trim();
        while (texto.contains("  ")) {
                texto = texto.replace("  ", " ");
        }
        return texto;
    }
}
