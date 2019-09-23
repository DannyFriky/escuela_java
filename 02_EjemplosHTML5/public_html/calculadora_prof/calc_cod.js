/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class Calculadora {
    constructor() {
        this.result = document.getElementById("resultado");
        this.anterior = document.getElementById("anterior");
        this.mem = 0;
        this.operador = "";
        this.nuevoNum = false;

    }
    numeroPulsado(eventObj) {
        if(this.nuevoNum){
            this.result.value="0";
            this.nuevoNum=false;
            
        }
        let valor = eventObj.currentTarget.innerHTML;
        //alert(valor);
        if (valor === "+/-") {
            this.result.value = -(parseFloat(this.result.value));
        } else if (valor === ".") {
            if (!calculadora.result.value.includes(".")) {
                this.result.value += valor;
            }
        } else {
            this.result.value += valor;

        }
    }
    operadorPulsado(eventObj) {

        let valor = eventObj.currentTarget.innerHTML;

        if (this.operador !== "") {
            let valActual = parseFloat(this.result.value);
            let resultado = eval(this.mem.toString() + this.operador + valActual);
            this.result.value = resultado;
        }
        this.mem = parseFloat(this.result.value);
        this.anterior.value = `${this.mem} ${valor}`;
        this.operador = valor;

        this.nuevoNum = true;

    }
}

let calculadora;
window.onload = function () {
    calculadora = new Calculadora();
    let botones = document.getElementsByClassName("num");
    for (let boton of botones) {
        boton.addEventListener("click", (evtObj) =>
        {
            calculadora.numeroPulsado(evtObj);
        });
    }
    let botonesOp = document.getElementsByClassName("oper");
    for (let btnOp of botonesOp) {
        btnOp.onclick = (evtObj) =>
        {
            calculadora.operadorPulsado(evtObj);
        };
    }
};


