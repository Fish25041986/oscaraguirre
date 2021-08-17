import { Injectable } from "@angular/core";
import { DataService } from "../dataService/data-serviceMuseo";
import { Museo } from "../Model/museo.model";

@Injectable()
export class MuseoService {

    museos: Museo[] = [];

    constructor( private dataService: DataService) {}
  
    // Se usa para modificar el valor del arreglo debido a la llamada asincrona
    setMuseos(museos: Museo[]){
      this.museos = museos;
    }
  
    obtenerMuseos() {
      return this.dataService.cargarMuseos();
    }
  
  
    agregarMuseo(museo: Museo){
      console.log('museo a agregar:' + museo.nombre);
      this.dataService.agregarMuseo(museo)
        .subscribe(
          (museo: any) => {
            // Recuperamos objeto museo con el codigo recien agregado
            console.log('se agrega al arreglo museo recien insertada suscriber:' + museo.codigo);
            this.museos.push(museo);
          }
        );
    }
  
    encontrarMuseo(codigo: String){

      const museodato = this.museos.find( museo => museo.codigo == codigo);
      console.log('museo encontrado:' + museodato!.codigo + ' ' + museodato!.nombre);
      return museodato;
    }
  
    modificarMuseo(codigo: String, museo: Museo) {
      console.log('museo a modificar:' + museo.codigo);
      // se actualiza el objeto museo del arreglo
      var museoModificadaLocal=null;
      museoModificadaLocal = this.museos.find(museo => museo.codigo == codigo);
      museoModificadaLocal!.codigo= museo.codigo;
      museoModificadaLocal!.nombre = museo.nombre;
      // guardar la persona en la base de datos
      this.dataService.modificarMuseo(codigo, museo)
    }
  
    eliminarPersona(codigo: String) {
      console.log('eliminar museo con id:' + codigo);
      const index = this.museos.findIndex( museo => museo.codigo == codigo); //encontramos el indice en el arreglo
      this.museos.splice(index,1);
      this.dataService.eliminarMuseo(codigo);
    }

}
