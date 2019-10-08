import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HeroListComponent } from '../app/hero-list/hero-list.component'
import { NewHeroComponent } from '../app/new-hero/new-hero.component'
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
        //Listado de vinculaciones entre URL y Component
const routes: Routes =[
  {path: "heroes", component: HeroListComponent},
  {path: "addHeroes", component: NewHeroComponent},
  {path: "dashboard", component: DashboardComponent},
  {path: "", redirectTo:'/dashboard', pathMatch:'full'},
  { path: 'detail/:id', component: HeroDetailComponent}

];

@NgModule({
  declarations: [],
  imports: [
    //CommonModule
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
