class Animal{
    especie: string;
    edad: number;
    volador: boolean;

    constructor(especie: string, edad: number, volador: boolean){
        this.especie = especie;
        this.edad = edad;
        this.volador = volador;
    }

    srtingfy(): string{
        return "Animal "+ this.especie + " con " + this.edad + " y vuela :" +this.volador;
    }

    mostrar(): void{
        console.log(this.srtingfy());
    }
}

let gato = new Animal("Gato",7,false); //El primer valor que le des es el que toma como propio

gato.mostrar();

class Mamifero extends Animal{
    private mamas: number;

    public constructor(especie: string,edad:number,volador:boolean,mamas:number){
        super(especie,edad,volador);
        this.mamas =mamas;
    }
}

let otroGato = new Mamifero("otroGato",3,false,6);
