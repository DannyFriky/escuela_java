import { Injectable } from '@angular/core';
import {Cliente} from '../app/Model/Cliente';
import {MensajesService} from '../app/mensajes.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class ClienterestService {

	clientes: Cliente[];

	APIurl: string = "http://localhost:8084/CRUD_Vista_JSTL/api/";

	httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json'}) };

	constructor(private mensajes: MensajesService, private http: HttpClient) { }

	getClientes(): Observable<Cliente[]> {
		return this.http.get<Cliente[]>(this.APIurl + "users");
	}

	editCliente(cliente: Cliente): Observable<string> {
		return this.http.put<string>(this.APIurl + "users", cliente, this.httpOptions);
	}

	deleteCliente(cliente: Cliente): Observable<any> {
		const options = {
			headers: new HttpHeaders({
			  'Content-Type': 'application/json'
			}),
			body: cliente
		  }
	  
		return this.http.delete(this.APIurl + "users", options);
	}

	registerCliente(cliente: Cliente):  Observable<Cliente> {
		return this.http.post<Cliente>(this.APIurl + "users", cliente);
	}
}
