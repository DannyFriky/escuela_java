package clasesjava;
/**
 * @author Danny
 */
public class ProbandoString {
	
	public static void tratarCadenas(){
	
		/*String texto = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, vivia ...";
		System.out.println(texto);
		System.out.println("Cuarta letra : "+texto.charAt(3));
		//Comparaciones
		String texto2 ="En un lugar de Madrid...";
		System.out.println("Comparacion : "+texto.compareTo(texto2));
		System.out.println("Comparacion Ignore: "+texto.compareToIgnoreCase(texto2));
		
		texto2 = texto2.substring(0,10);
		
		if (texto.contains(texto2)){
			System.out.println("pues lo contiene : " + texto2);
		} else{
			System.out.println("pues no lo contiene");
		}
		
		System.out.println("\"Mancha\" esta a partir del lugar : " + texto.indexOf("Mancha"));
		
		texto = texto.replace("lugar","bar");
		System.out.println(texto);*/
		StringAux texto3= new StringAux("          en      un       LUGAR     ");

		System.out.println("El texto: "+ texto3.quitarEspacios() + " \ntiene :" + texto3.contarPalabras() +" palabras");

	
	}
	
}
