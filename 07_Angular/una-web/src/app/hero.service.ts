import { Injectable } from '@angular/core';
import { Hero } from './model/hero';
import { HEROES } from './model/array-hero';
import { MessageService } from './message.service';


@Injectable({
  providedIn: 'root'
})
export class HeroService {

  arrayHeroes: Hero[];

  constructor(private messageSrv : MessageService) { 
    this.arrayHeroes = HEROES;
  }
  getHeroes() : Hero[]{
    this.messageSrv.add("HeroService: capturando heroes");
    return HEROES;
  }
  
  add(newHero : Hero){
    HEROES.push(newHero);
    this.messageSrv.add("HeroService: Heroe "+newHero.name+" añadido");
  }

  getHero(id : number): Hero {
    let hero = this.arrayHeroes.find( hero => hero.id === id );
    return hero;
  }
}
