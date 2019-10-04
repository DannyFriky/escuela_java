//Type Script:

let variableNum: number;
console.log(variableNum);

variableNum = 100;
//variableNum = "texto"; Mal en tipos
console.log(variableNum);

let miUnion: number|string|boolean;
//miUnion = new Object(); no se le puede asignar un objeto
miUnion ="...";

interface Tiempo{
    dia: number;
    mes: number;
    anio:number;
};

let miCumple: Tiempo = {dia:30,mes:6,anio:1995};
console.log("Cumple el "+ miCumple.dia +" del "+miCumple.mes);

function concatenar(texto1: string,texto2: any){
    console.log("concatenado: "+texto1+texto2);
}

concatenar("hola",3);
concatenar("adios",miCumple);