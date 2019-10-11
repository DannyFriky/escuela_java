import { Component, OnInit } from '@angular/core';
import { Cliente } from '../Model/Cliente';
import { ClienterestService } from '../clienterest.service';
import { MensajesService } from '../mensajes.service';
import { Router } from '@angular/router';
//import { CLIENTES } from '../Model/arrayClientes';

@Component({
	selector: 'app-listado-clientes',
	templateUrl: './listado-clientes.component.html',
	styleUrls: ['./listado-clientes.component.css']
})
export class ListadoClientesComponent implements OnInit {
	clientes: Cliente[];
	clienteSeleccionado: Cliente;
	editable: boolean = false;

	constructor(private clienteRest: ClienterestService, private mensajesService: MensajesService, private router: Router) { }

	ngOnInit() {
		this.clienteRest.getClientes().subscribe(clientes => {this.clientes = clientes;});
	}

	seleccionar(cliente: Cliente): void {
		this.clienteSeleccionado = cliente;
		this.mensajesService.add("Se ha seleccionado el cliente: " + cliente.name);
	}

	edicion(): void {
		this.editable = !this.editable;
		this.mensajesService.add("Se ha cambiado el modo de edición.");
	}

	editarCliente(cliente: Cliente): void {
		console.log("1234");
		console.log(cliente);
		this.edicion();
		this.clienteRest.editCliente(cliente).subscribe(test => test);

		this.mensajesService.add("¡Editando!.");
	}

	eliminarCliente(cliente: Cliente): void {
		this.clienteRest.deleteCliente(cliente).subscribe(x => x);

		setTimeout(function() {
			window.location.reload();
		}, 100);
	}
}
