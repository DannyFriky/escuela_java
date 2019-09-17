class EstructurasControl{
	
	public static void main(String[] arg){
	
	/*
		for(int i=0;i<arg.length; i++){
			System.out.println("Arg " + i);
			System.out.println("Arg " + arg[i]);
		}
		
		while(i<arg.length){
		
			System.out.println("Arg " + i);
			System.out.println("Arg " + arg[i]);
		
			i+=1;
		
		}
		
		int i=0;
		
		
		do{
			System.out.println("Arg " + i);
			System.out.println("Arg " + arg[i]);
			i++;
			
		}while(i<arg.length);
		
		boolean siEjecutar =(5<3)&&(20==20);
		if(siEjecutar){
			System.out.println("Condicion cierta");
		}else if(!siEjecutar){
			System.out.println("Condicion falsa-cierta");
		}else{
			System.out.println("Condicion falsa-falsa");
		}
		*/

		int valor = 0;
		switch(arg[0]){
			case "0":
				System.out.println("Cero");
				break;
			case "1":
				System.out.println("Uno");
				break;
			default :
				System.out.println("Ninguno");
		
		}
	}
}