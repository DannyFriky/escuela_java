import { Component, OnInit } from '@angular/core';
import { HeroService } from '../hero.service';
import { Hero } from '../model/hero';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  heroes :Hero[];
  constructor(private heroSrv : HeroService) { }

  ngOnInit() {

    this.heroes = this.heroSrv.getHeroes().slice(1,4);
  }

}
