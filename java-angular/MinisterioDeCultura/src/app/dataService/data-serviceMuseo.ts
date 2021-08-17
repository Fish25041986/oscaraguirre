import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Museo } from "../Model/museo.model";

@Injectable()
export class DataService {
    constructor(private httpClient: HttpClient){}

   urlBase='http://localhost:8080/prueba-backend-java/webservice/museos'; 

   cargarMuseos(){
       return this.httpClient.get(this.urlBase);
   }

   agregarMuseo(museo: Museo){
       return this.httpClient.post(this.urlBase , museo);
   }

   modificarMuseo(codigo:String, museo:Museo){
        let url:string;
        url = this.urlBase + '/' + codigo;
        this.httpClient.put(url, museo)
        .subscribe(
            (response)=>{
                console.log('resultado de modificar museo' + response)
            },
            (error) => console.log('Error en modificar Museo:' + error)
        );
    }

    eliminarMuseo(codigo: String){
      let url:string;
      url = this.urlBase + '/' + codigo;
      this.httpClient.delete(url)
      .subscribe(
        (response)=>{
            console.log('resultado de eliminar museo' + response)
        },
        (error) => console.log('Error en eliminar Museo:' + error)
    );
    }
   
}
