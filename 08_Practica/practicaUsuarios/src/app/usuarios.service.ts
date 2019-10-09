import { Injectable } from '@angular/core';
import { MessageService } from './message.service';
import { User } from './model/user';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  urlApiRest ="http://localhost:8084/CRUD_Vista_JSTL/api/users";
  httpOptions = {headers : new HttpHeaders({'Content-Type':"aplication/json"})};


  constructor(private messageSrv : MessageService, private httpCli: HttpClient) { 
   
  }

  getUsers():Observable<User[]>{
    let observResp : Observable<User[]>;
    observResp= this.httpCli.get<User[]>(this.urlApiRest);

    return observResp;
  }

  addMessage(mensaje : string){
    this.messageSrv.add(mensaje);
  }

  modify(userMod : User): Observable<User>{

    return  this.httpCli.put<User>(this.urlApiRest, userMod, this.httpOptions);
  }

  delete(userDel : User): Observable<User>{
    const url = `${this.urlApiRest}/?${userDel.id}`;
    return  this.httpCli.delete<User>(url, this.httpOptions);
  }

  addUser(userAdd : User): Observable<User>{
    return  this.httpCli.post<User>(this.urlApiRest, userAdd, this.httpOptions);

  }
}
