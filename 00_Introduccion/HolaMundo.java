class HolaMundo {
	
	public static void main (String[] args){
		System.out.println("Hola Mundo!");
		
		String nombre = "Danny";
		System.out.println("Hola " + nombre +"!");
		
		byte unByte =-128; // -128 a 127
		System.out.println("Byte: " + unByte );

		int numero = 1234567890; // diez digitos
		System.out.println("Entero: " +  numero);
		
		float decimalFloat = 1.23456789f;// siete u ocho cifras
		System.out.println("Float: " +  decimalFloat);
		
		double decimalDoble = 1.234567890;// quince o dieciseis cifras
		System.out.println("Double: " +  decimalDoble);
		
		long entLargo = 1234567890123456789L;//diecinueve cifras
		System.out.println("Largo: " +  entLargo);
		
		char caracter = 65;
		System.out.println("Caracter: " +  caracter);
		
		char[] texto ={'a','b','c'};
		
		for(int i=0; i<3;i++){
			
		System.out.println("Caracter [n]: " +  texto[i]);
		}
	
	}
} 