import { Component, OnInit } from '@angular/core';
import { Hero } from '../model/hero';
@Component({
  selector: 'app-mi-control',
  templateUrl: './mi-control.component.html',
  styleUrls: ['./mi-control.component.css']
})
export class MiControlComponent implements OnInit {


  propiedadHola = 'Vamos a comer';

  static contIds =0;

  hero: Hero = {
    id: 1,
    name: 'Midoriya',
    url:'../assets/image/Midoriya.jpg',
  };
  constructor() { 

    MiControlComponent.contIds++;
    this.hero.id = MiControlComponent.contIds;

  }

  ngOnInit() {
  }

}
