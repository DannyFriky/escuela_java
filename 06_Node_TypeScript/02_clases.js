var Animal = /** @class */ (function () {
    function Animal(especie, edad, volador) {
        this.especie = especie;
        this.edad = edad;
        this.volador = volador;
    }
    Animal.prototype.srtingfy = function () {
        return "Animal " + this.especie + " con " + this.edad + " y vuela :" + this.volador;
    };
    Animal.prototype.mostrar = function () {
        console.log(this.srtingfy());
    };
    return Animal;
}());
var gato = new Animal("Gato", 7, false); //El primer valor que le des es el que toma como propio
gato.mostrar();
