import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Museo } from '../Model/museo.model';
import { MuseoService } from '../Services/museo-service';

@Component({
  selector: 'app-museos',
  templateUrl: './museos.component.html',
  styles: [
  ]
})
export class MuseosComponent implements OnInit {

museos: any;

  constructor(private museoService:MuseoService,
    private router:Router,
    private route:ActivatedRoute
    ) { }

    ngOnInit(): void{
      this.museoService.obtenerMuseos()
        .subscribe(
          museoObtenidas => {
            //cargamos los datos de persona obtenidos en el arreglo local
            this.museos = museoObtenidas;
            this.museoService.setMuseos(this.museos);
            console.log('personas obtenidas del subscriber:' + this.museos);
          }
        );
    }
 
}
