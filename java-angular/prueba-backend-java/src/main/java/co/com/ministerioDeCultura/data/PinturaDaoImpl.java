/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.data;

import co.com.ministerioDeCultura.domain.Pintura;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author oscar
 */
public class PinturaDaoImpl implements PinturaDao{
    
        
       /*inyectamos la unidad de persistenacia*/
    @PersistenceContext (unitName = "pruebaPU")
    EntityManager em;

    @Override
    public List<Pintura> listaPintura() {
      return em.createNamedQuery("Pintura.findAll").getResultList();
    }

    @Override
    public Pintura encontrarPintura(Pintura pintura) {
        return em.find(Pintura.class, pintura.getCodigo());
    }

    @Override
    public void agregarPintura(Pintura pintura) {
      em.persist(pintura);
    }

    @Override
    public void actualizarPintura(Pintura pintura) {
      em.merge(pintura);
    }

    @Override
    public void eliminarPintura(Pintura pintura) {
       em.remove(em.merge(pintura));
    }
    
    
}
