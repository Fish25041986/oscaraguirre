import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArtistaService } from '../Services/artista-service';

@Component({
  selector: 'app-artistas',
  templateUrl: './artistas.component.html',
  styles: [
  ]
})
export class ArtistasComponent implements OnInit {
  
  artistas: any;

  constructor(private artistaService:ArtistaService,
    private router:Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.artistaService.obtenerArtistas()
    .subscribe(
      artistasObtenidas => {
        //cargamos los datos de los artistas obtenidos en el arreglo local
        this.artistas = artistasObtenidas;
        this.artistaService.setArtistas(this.artistas);
        console.log('artista obtenidas del subscriber:' + this.artistas);
      }
    );
  }

}
