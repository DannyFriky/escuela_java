import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Component({
  selector: 'app-listado',
  template:`<h2>Listado Usuarios REST: </h2>
  <ul><li *ngFor="let user of usuariosRecibidos"> 
  {{user.id}} - {{user.email}} - {{user.password}} - {{user.name}} - {{user.age}}
  
  <input type="button" (click)="modUser(user)" value="Modificar">
  <input type="button" (click)="borUser(user)" value="Borrar">
  </li></ul>
  
  
  <li *ngIf="this.userModificado != null">
  <h2>{{ this.userModificado.name | uppercase }} MODIFICAR</h2>
  <app-formulario [userMod]="this.userModificado"></app-formulario>
  <input type="button" (click)="modificar(this.userModificado)" value="Modificar">
  </li>

  <li *ngIf="this.userBorr != null">
  <h2>{{ this.userBorr.name | uppercase }} BORRAR</h2>
  <app-formulario [userMod]="this.userBorr"></app-formulario>
  <input type="button" (click)="borrar(this.userBorr)" value="Borrar">
  </li>
  `
})

//<app-formulario [user]="userModificado"></app-formulario>
export class ListadoComponent implements OnInit {
  usuariosRecibidos : User[];
  userModificado : User;
  userBorr : User;
  constructor(private usuarioSrv : UsuariosService) { }

  ngOnInit() {
    this.usuarioSrv.addMessage("Comenzando el Listado de Usuarios");
    
    let observArrayUsers : Observable<User[]>;
    observArrayUsers = this.usuarioSrv.getUsers();

    observArrayUsers.subscribe(usersRec => this.usuariosRecibidos = usersRec)
  
  
  }

  modUser(user: User){
    this.userBorr = null;
    this.userModificado = user;
  }
  borUser(user: User){
    this.userModificado = null;
    this.userBorr = user;
  }
  modificar(user:User){
    this.usuarioSrv.modify(user).subscribe((obj)=>{
      this.ngOnInit();
    });;
  }

  borrar(user:User){
    alert("hola");
    this.usuarioSrv.delete(user).subscribe((obj)=>{
      this.ngOnInit();
    });;
  }
}
