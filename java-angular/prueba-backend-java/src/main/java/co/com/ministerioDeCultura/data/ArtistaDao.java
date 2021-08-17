/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.data;

import co.com.ministerioDeCultura.domain.Artista;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface ArtistaDao {
    
    /*lista todos los artistas existentes*/
    public List<Artista>listaArtista();
    
     /*lista todos los artistas existentes*/
    public List<Artista>listaTodosArtistas(String codigo);
    
    /*metodo para encontrar un artista*/
    public Artista encontrarArtista(Artista artista);
    
    /*metodo para insertar un nuevo artista*/
    public void agregarArtista(Artista artista);
    
    /*metodo para actualizar la informacion un nuevo artista*/
    public void actualizarArtista(Artista artista);
    
    /*metodo para eliminar un artista*/
    public void eliminarArtista (Artista artista);
}
