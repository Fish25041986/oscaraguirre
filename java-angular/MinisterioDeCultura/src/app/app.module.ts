import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataService } from './dataService/data-serviceMuseo';
import { MuseoService } from './Services/museo-service';
import { MuseosComponent } from './museos/museos.component';
import { ArtistasComponent } from './artistas/artistas.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PinturasComponent } from './pinturas/pinturas.component';
import { ArtistaService } from './Services/artista-service';
import { DataServiceArtista } from './dataService/data-service-artista';

@NgModule({
  declarations: [
    AppComponent,
    MuseosComponent,
    ArtistasComponent,
    PinturasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    { provide: MuseoService, useClass: DataService },
    { provide: ArtistaService, useClass: DataServiceArtista }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
