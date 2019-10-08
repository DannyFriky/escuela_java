import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  constructor(private usuarioSrv : UsuariosService) { }

  ngOnInit() {
   this.usuarioSrv.addMessage("Comenzando el Registro de usuario");
  }

}
