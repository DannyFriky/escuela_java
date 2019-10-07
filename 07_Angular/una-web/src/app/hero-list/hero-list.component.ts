import { Component, OnInit } from '@angular/core';
//import {HEROES} from '../model/array-hero';
import {Hero} from '../model/hero';
import { HeroService } from '../hero.service';
@Component({
  selector: 'app-hero-list',
  templateUrl: './hero-list.component.html',
  styleUrls: ['./hero-list.component.css']
})
export class HeroListComponent implements OnInit {

  heroes: Hero[];
  selectedHero: Hero;
  constructor(private heroSrv: HeroService) { }

  ngOnInit() {
    //this.heroes  = HEROES;
    this.getHeroesFromService();
  }

  onSelect(hero: Hero):void{
    this.selectedHero = hero;
  }

  getHeroesFromService(): void{
    this.heroes = this.heroSrv.getHeroes();
  }
}
