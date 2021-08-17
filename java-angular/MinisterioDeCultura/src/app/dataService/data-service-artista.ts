import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Artista } from "../Model/artista.model";

@Injectable()
export class DataServiceArtista {

    constructor(private httpClient: HttpClient){}

    urlBase='http://localhost:8080/prueba-backend-java/webservice/artistas'; 

    
   cargarArtistas(){
    return this.httpClient.get(this.urlBase);
}

agregarArtista(artista: Artista){
    return this.httpClient.post(this.urlBase , artista);
}

modificarArtista(codigo:String, artista:Artista){
     let url:string;
     url = this.urlBase + '/' + codigo;
     this.httpClient.put(url, artista)
     .subscribe(
         (response)=>{
             console.log('resultado de modificar artista' + response)
         },
         (error) => console.log('Error en modificar Artista:' + error)
     );
 }

 eliminarArtista(codigo: String){
   let url:string;
   url = this.urlBase + '/' + codigo;
   this.httpClient.delete(url)
   .subscribe(
     (response)=>{
         console.log('resultado de eliminar artista' + response)
     },
     (error) => console.log('Error en eliminar Artista:' + error)
 );
 }
}
