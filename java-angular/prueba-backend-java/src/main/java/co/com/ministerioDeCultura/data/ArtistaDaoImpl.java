/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.data;

import co.com.ministerioDeCultura.domain.Artista;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author oscar
 */
@Stateless
/*se implementa los metodos abstractos de la interfaz artistaDao*/
public class ArtistaDaoImpl implements ArtistaDao{

       /*inyectamos la unidad de persistenacia*/
    @PersistenceContext (unitName = "pruebaPU")
    EntityManager em;
    
    @Override
    public List<Artista> listaArtista() {
      return em.createNamedQuery("Artista.findAll").getResultList();
    }

    @Override
    public Artista encontrarArtista(Artista artista) {
        return em.find(Artista.class, artista.getCodigo());
    }

    @Override
    public void agregarArtista(Artista artista) {
      em.persist(artista);
    }

    @Override
    public void actualizarArtista(Artista artista) {
      em.merge(artista);
    }

    @Override
    public void eliminarArtista(Artista artista) {
       em.remove(em.merge(artista));
    }

    @Override
    public List<Artista> listaTodosArtistas(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
