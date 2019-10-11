import { Component, OnInit } from '@angular/core';
import { Cliente } from '../Model/Cliente';
import { ClienterestService } from '../clienterest.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-registro',
	templateUrl: './registro.component.html',
	styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

	cliente: Cliente = {id:0, email: '', password: '', name: '', age: 0};

	constructor(private clienteServicio: ClienterestService, private router: Router) { }

	ngOnInit() {
	}

	registrar(cliente: Cliente): void {
		this.clienteServicio.registerCliente(cliente).subscribe(x => this.validacion(x));
	}

	validacion(cliente: Cliente): void {
		console.log("Registro exitoso");
		this.router.navigate(['/list']);
	}

}
