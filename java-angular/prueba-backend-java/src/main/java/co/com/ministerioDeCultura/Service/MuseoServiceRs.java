package co.com.ministerioDeCultura.Service;

import co.com.ministerioDeCultura.data.MuseoDao;
import co.com.ministerioDeCultura.domain.Museo;


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
@Path("/museos")
public class MuseoServiceRs {
    
    @Inject
    private MuseoDao museoDao;
    
    
  @GET
  @Produces(value=MediaType.APPLICATION_JSON) 
  public List<Museo> listaMuseos(){
    List<Museo>museos= museoDao.listaMuseos();
      System.out.println(museos);
      return museos;
  }
  
  @GET
  @Produces(value = MediaType.APPLICATION_JSON)
  @Path("{codigo}")
  public Museo encuentraMuseo(@PathParam("codigo") String codigo){
  Museo museo = museoDao.encontrarMuseo(new Museo(codigo));
      System.out.println(museo);
      return museo;
  }
  
  
  @POST
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  public Museo agregarMuseo(Museo museo){
      museoDao.agregarMuseo(museo);
      System.out.println(museo);
      return  museo;
  }
  
  
  @PUT
  @Consumes(value = MediaType.APPLICATION_JSON)
  @Produces(value = MediaType.APPLICATION_JSON)
  @Path("{codigo}")
  public Response modificaMuseo(@PathParam("codigo") String codigo,Museo museomdf){
    Museo museo = museoDao.encontrarMuseo(new Museo(codigo));
      if (museo !=null) {
          museoDao.actualizarMuseo(museomdf);
          System.out.println(museomdf);
          return Response.ok().entity(museomdf).build();
      }else{
      return Response.status(Status.NOT_FOUND).build();
      }
  }
  
  @DELETE
  @Produces(value = MediaType.APPLICATION_JSON)
  @Path("{codigo}")
  public Response eliminarPersona(@PathParam("codigo") String codigo){
   museoDao.eliminarMuseo(new Museo(codigo));
      System.out.println(codigo);
      return Response.ok().build();
  }
}
