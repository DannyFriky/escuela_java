import { Component, OnInit } from '@angular/core';
import {HEROES} from '../model/array-hero';
import {Hero} from '../model/hero';

@Component({
  selector: 'app-hero-list',
  templateUrl: './hero-list.component.html',
  styleUrls: ['./hero-list.component.css']
})
export class HeroListComponent implements OnInit {

  heroes: Hero[];

  constructor() { }

  ngOnInit() {
    this.heroes  = HEROES;
  }

}
