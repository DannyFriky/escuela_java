import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListadoComponent } from './listado/listado.component';
import { RegistroComponent } from './registro/registro.component';


const routes: Routes = [
  {path: "registro", component: RegistroComponent},
  {path: "lista", component: ListadoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
