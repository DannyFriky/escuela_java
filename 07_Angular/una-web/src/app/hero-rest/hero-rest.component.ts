import { Component, OnInit } from '@angular/core';
import { Hero } from '../model/hero';
import { HeroRestService } from '../hero-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-hero-rest',
  template:`<h2>Listado heroes REST: </h2>
  <ul><li *ngFor="let hero of heroesRecibidos"> 
  {{hero.id}} - {{hero.name}}</li></ul>
  <div><input [(ngModel)]="id" placehorlder="id"/>
  <input [(ngModel)]="name" placehorlder="name"/>
  <input type="button" (click)="enviar()" value="ENVIAR">
  </div>
  `

})
export class HeroRestComponent implements OnInit {

  heroesRecibidos : Hero[];
  id : string;
  name : string;
  constructor(private heroRestSrv: HeroRestService) { }
  enviar(){
    let nuevoHeroe = new Hero();
    nuevoHeroe.id = parseInt(this.id);
    nuevoHeroe.name = this.name;
    
    this.heroRestSrv.add(nuevoHeroe).subscribe((obj)=>{
      this.ngOnInit();
    });

  }
  ngOnInit() {
    let observArrayHeroes: Observable<Hero[]>;
    observArrayHeroes = this.heroRestSrv.getHeroes();
//La ejecucion continua hasta que el array es recibido.
//Para recibirlo asincronamente nos subscribimos al Observable
/*let funcionAvisameCuandoLoTengas = (heroesRec) =>{
  this.heroesRecibidos = heroesRec;
  console.log("Hemos recibido los heroes");
};
observArrayHeroes.subscribe(funcionAvisameCuandoLoTengas);
console.log("nos hemos subscrito");*/
//lo de arriba hace lo mismo que esto
observArrayHeroes.subscribe(heroesRec => this.heroesRecibidos = heroesRec)

  }

}
