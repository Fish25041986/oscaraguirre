/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.data;

import co.com.ministerioDeCultura.domain.Museo;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface MuseoDao {
    
     /*lista todos los museos existentes*/
    public List<Museo>listaMuseos();
    
    /*metodo para encontrar un museo*/
    public Museo encontrarMuseo(Museo museo);
    
     /*metodo para insertar un nuevo museo*/
    public void agregarMuseo(Museo museo);
    
    /*metodo para actualizar la informacion un nuevo museo*/
    public void actualizarMuseo(Museo museo);
    
    /*metodo para eliminar un museo*/
    public void eliminarMuseo (Museo museo);
    
    
}
