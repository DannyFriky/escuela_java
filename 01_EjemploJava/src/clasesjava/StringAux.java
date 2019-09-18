package clasesjava;

/**
 * @author Danny
 */

public final class StringAux {
	
		String str;

		public StringAux(String str){
			this.str =str;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}
		
		public String quitarEspacios(){
			
			String textoCorregido ="";
			String[] aux2 = this.str.split("\\s+");
			for (String aux1 : aux2) {
				textoCorregido = textoCorregido.concat(aux1 + " ");			
			}
			
			this.str = textoCorregido.trim();
			return getStr();
			
		}
		
		public int contarPalabras(){

			
			String[] aux2 = this.str.split("\\s+");

			return aux2.length;
		}
		
		public static String quitarEspaciosV1(String texto){
			
			String result ="";
			for(int i =0; i<texto.length();i++){
				if(texto.charAt(i) != ' '){
					result += texto.charAt(i);
					if(texto.charAt(i+1) == ' '){
						result += ' ';
					}
				}
			}
			return result.trim();
		}
		
		public static String quitarEspaciosV2(String texto){
			
			String result ="";
			for(int i =0; i<texto.length();i++){
				if(texto.charAt(i) != ' '){
					result += texto.charAt(i);
					if(texto.charAt(i+1) == ' '){
						result += ' ';
					}
				}
			}
			return result.trim();
		}
		
		public static int contarPalabras(String texto){
			String[] aux2 = texto.split("\\s+");

			return aux2.length;
		}

}


			//String[] auxT = this.str.split(" ");
			//int contador = 0;
			//for (String aux1 : aux2) {
				//if (!aux1.isEmpty()) {
					//contador++;
				//}
			//}