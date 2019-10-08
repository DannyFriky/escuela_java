import { Component, OnInit, Input} from '@angular/core'; // añaida la notacion input
import { Hero } from '../model/hero';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { HeroService } from '../hero.service';


@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {
  //Vamos a obtener un Hero de un componente padre
  @Input() hero: Hero; //esta propiedad viene de algun componente externo
  constructor(private route : ActivatedRoute,
              private heroSrv : HeroService,
              private location : Location) { }

  ngOnInit() {
    this.getHero();
  }

  getHero():void{
    //Cogemos el id del parametro de la ruta /detail/:id
    const id = this.route.snapshot.paramMap.get('id');
    this.hero = this.heroSrv.getHero(parseInt(id));
  
  }

}
