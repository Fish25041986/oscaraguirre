/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.data;

import co.com.ministerioDeCultura.domain.Pintura;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface PinturaDao {
    
      /*lista todos los pinturaS existentes*/
    public List<Pintura>listaPintura();
    
    /*metodo para encontrar un pintura*/
    public Pintura encontrarPintura(Pintura pintura);
    
     /*metodo para insertar un nuevo pintura*/
    public void agregarPintura(Pintura pintura);
    
    /*metodo para actualizar la informacion un nuevo pintura*/
    public void actualizarPintura(Pintura pintura);
    
    /*metodo para eliminar un pintura*/
    public void eliminarPintura (Pintura pintura);
}
