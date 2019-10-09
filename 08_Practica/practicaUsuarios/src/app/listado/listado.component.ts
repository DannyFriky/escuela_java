import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})

//<app-formulario [user]="userModificado"></app-formulario>
export class ListadoComponent implements OnInit {
  usuariosRecibidos: User[];
  userModificado: User;
  userMost: boolean;
  constructor(private usuarioSrv: UsuariosService) { }

  ngOnInit() {
    this.usuarioSrv.addMessage("Comenzando el Listado de Usuarios");

    let observArrayUsers: Observable<User[]>;
    observArrayUsers = this.usuarioSrv.getUsers();

    observArrayUsers.subscribe(usersRec => this.usuariosRecibidos = usersRec)
  }

  modUser(user: User) {
    this.userModificado = user;
    this.userMost =false;
  }

  mostrar(user :User){
    this.userModificado = user;
    this.userMost =true;
  }

  modificar(user: User) {
    this.usuarioSrv.modify(user).subscribe((obj) => {
      this.usuarioSrv.addMessage("Usuario modificado");

      this.ngOnInit();
    });;
  }

  borrar(user: User) {
    this.userModificado = null;
    this.usuarioSrv.delete(user).subscribe((obj) => {
      this.usuarioSrv.addMessage("Usuario borrado");

      this.ngOnInit();
    });;
  }

}
