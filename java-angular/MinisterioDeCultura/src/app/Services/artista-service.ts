import { Injectable } from "@angular/core";
import { DataServiceArtista } from "../dataService/data-service-artista";
import { Artista } from "../Model/artista.model";

@Injectable()
export class ArtistaService {

    
    artistas: Artista[] = [];

    constructor( private dataService: DataServiceArtista) {}
  
    // Se usa para modificar el valor del arreglo debido a la llamada asincrona
    setArtistas(artistas: Artista[]){
      this.artistas = artistas;
    }
  
    obtenerArtistas() {
      return this.dataService.cargarArtistas();
    }
  
  
    agregarArtista(artista: Artista){
      console.log('artista a agregar:' + artista.nombre);
      this.dataService.agregarArtista(artista)
        .subscribe(
          (artista: any) => {
            // Recuperamos objeto artista con el codigo recien agregado
            console.log('se agrega al arreglo artista recien insertada suscriber:' + artista.codigo);
            this.artistas.push(artista);
          }
        );
    }
  
    encontrarArtista(codigo: String){

      const artistadato = this.artistas.find( artista => artista.codigo == codigo);
      console.log('artista encontrado:' + artistadato!.codigo + ' ' + artistadato!.nombre);
      return artistadato;
    }
  
    modificarArtista(codigo: String, artista: Artista) {
      console.log('artista a modificar:' + artista.codigo);
      // se actualiza el objeto artista del arreglo
      var artistaModificadaLocal=null;
      artistaModificadaLocal = this.artistas.find(artista => artista.codigo == codigo);
      artistaModificadaLocal!.codigo= artista.codigo;
      artistaModificadaLocal!.nombre = artista.nombre;
      // guardar la persona en la base de datos
      this.dataService.modificarArtista(codigo, artista)
    }
  
    eliminarArtista(codigo: String) {
      console.log('eliminar artista con id:' + codigo);
      const index = this.artistas.findIndex( artista => artista.codigo == codigo); //encontramos el indice en el arreglo
      this.artistas.splice(index,1);
      this.dataService.eliminarArtista(codigo);
    }
}
