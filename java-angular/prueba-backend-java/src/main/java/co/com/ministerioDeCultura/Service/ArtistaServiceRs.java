/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ministerioDeCultura.Service;
import co.com.ministerioDeCultura.data.ArtistaDao;
import co.com.ministerioDeCultura.domain.Artista;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author oscar
 */
@Stateless
@Path("/artistas")
public class ArtistaServiceRs {
    
    
    @Inject
    private ArtistaDao artistaDao;
    
       
  @GET
  @Produces(value=MediaType.APPLICATION_JSON) 
  public List<Artista> listaArtista(){
    List<Artista>artistas= artistaDao.listaArtista();
      System.out.println(artistas);
      return artistas;
  }
  
  
  @GET
  @Produces(value = MediaType.APPLICATION_JSON)
  @Path("{codigo}")
  public Artista encuentraArtista(@PathParam("codigo") String codigo){
  Artista artista = artistaDao.encontrarArtista(new Artista(codigo));
      System.out.println(artista);
      return artista;
  }
  
  
  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  public Artista agregarArtista(Artista artista){
      artistaDao.agregarArtista(artista);
      System.out.println(artista);
      return  artista;
  }
  
  
  @PUT
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  @Path("{codigo}")
  public Response modificaArtista(@PathParam("codigo") String codigo,Artista artistamdf){
    Artista artista = artistaDao.encontrarArtista(new Artista(codigo));
      if (artista !=null) {
          artistaDao.actualizarArtista(artistamdf);
          System.out.println(artistamdf);
          return Response.ok().entity(artistamdf).build();
      }else{
      return Response.status(Status.NOT_FOUND).build();
      }
  }
  
  @DELETE
  @Produces(value = MediaType.APPLICATION_JSON)
  @Path("{codigo}")
  public Response eliminarArtista(@PathParam("codigo") String codigo){
   artistaDao.eliminarArtista(new Artista(codigo));
      System.out.println(codigo);
      return Response.ok().build();
  }
}
