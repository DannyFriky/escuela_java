import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-registro',
  template: `<h2>REGISTRAR</h2>
  <app-formulario [userMod]="this.userAdd"></app-formulario>
  <input type="button" (click)="add(this.userAdd)" value="Añadir">`
})
export class RegistroComponent implements OnInit {
  userAdd: User;
  constructor(private usuarioSrv : UsuariosService) { }

  ngOnInit() {
   this.userAdd = new User;
   this.usuarioSrv.addMessage("Comenzando el Registro de usuario");
  }

  add(user: User) {
    this.usuarioSrv.addUser(user).subscribe((obj) => {
      this.usuarioSrv.addMessage("Usuario añadido");

      this.ngOnInit();
    });;
  }

}
