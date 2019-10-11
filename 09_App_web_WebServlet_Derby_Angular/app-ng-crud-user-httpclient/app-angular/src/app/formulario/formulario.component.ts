import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from '../Model/Cliente';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  @Input() cliente: Cliente;
  @Input() editable: boolean = true;

  constructor() { }

  ngOnInit() {
  }

}
