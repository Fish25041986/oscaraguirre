import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtistasComponent } from './artistas/artistas.component';
import { MuseosComponent } from './museos/museos.component';

const routes: Routes = [
  { path: '', component: ArtistasComponent},
  { path: 'museos', component:  MuseosComponent},
  { path: 'artistas/:codigo', component: ArtistasComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
