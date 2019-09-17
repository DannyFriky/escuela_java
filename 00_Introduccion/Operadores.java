class Operadores{
	
	public static void main(String[] arg){
	
		if( arg[0].equals("aa")){
		
			System.out.println("Quieres dos AA");
		}else{
			System.out.println("Quieres otra cosa");
		}
		
		System.out.println(arg[0].equals("aa") ? 
		"Quieres dos AA" :"Quieres otra cosa");
		
		byte result = 1 & 2;
		System.out.println ("AND binario :" + result);
		
		
	}
}