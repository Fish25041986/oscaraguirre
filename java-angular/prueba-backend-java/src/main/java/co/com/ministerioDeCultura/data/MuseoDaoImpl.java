/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.data;

import co.com.ministerioDeCultura.domain.Museo;
import java.util.List;
import javax.ejb.Stateless;
/**Llamo todo todas las clases del paquete persistence ya que voy a 
 utilizar varias*/
import javax.persistence.*;

/**
 *
 * @author oscar
 */

@Stateless
/*se implementa los metodos abstractos de la interfaz museoDao*/
public class MuseoDaoImpl implements MuseoDao{
    
    /*inyectamos la unidad de persistenacia*/
    @PersistenceContext (unitName = "pruebaPU")
    EntityManager em;
    
    @Override
    public List<Museo> listaMuseos() {
        return em.createNamedQuery("Museo.findAll").getResultList();
    }

    @Override
    public Museo encontrarMuseo(Museo museo) {
        return em.find(Museo.class, museo.getCodigo());
    }

    @Override
    public void agregarMuseo(Museo museo) {
        em.persist(museo);
    }

    @Override
    public void actualizarMuseo(Museo museo) {
        em.merge(museo);
    }

    @Override
    public void eliminarMuseo(Museo museo) {
        em.remove(em.merge(museo));
    }
    
}
