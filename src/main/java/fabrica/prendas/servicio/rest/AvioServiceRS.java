package fabrica.prendas.servicio.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import fabrica.prendas.domain.Avios;
import fabrica.prendas.servicio.AvioService;
import javax.ws.rs.core.Response.Status;

@Path("/avios")
@Stateless
public class AvioServiceRS {

    @Inject
    private AvioService avioService;

    @GET
    @Path("/all")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Avios> listarAvios() {
        return avioService.listarTodos();
    }

    @GET
    @Path("/findT/{tipo}")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Avios> listarAviosPorTipo(@PathParam("tipo") String tipo) {
        Avios aux = new Avios(tipo);
        return avioService.encontraPorTipo(aux);
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/findI/{id}")
    public Avios encontrarAviosPorId(@PathParam("id") int id) {
        return avioService.encontrarPorId(new Avios(id));
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/findN/{nombre}")
    public Avios encontrarAviosPorNombre(@PathParam("nombre") String nombre) {
        Avios aux = new Avios();
        aux.setNombreAvio(nombre);
        return avioService.encontrarPorNombre(aux);
    }

    @POST
    @Path("/save")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarAvio(Avios avio) {
        try {
            avioService.insertarAvio(avio);
            return Response.ok().entity(avio).build();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/update/{id}")
    public Response modificarAvioPorId(@PathParam("id") int id,Avios avioModificado){
        try{
            Avios avio = avioService.encontrarPorId(new Avios(id));
            if (avio != null) {
                avioService.modificarAvio(avio);
                return Response.ok().entity(avioModificado).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response eliminarAvioPorId(@PathParam("id") int id){
        try{
            avioService.eliminarAvio(new Avios(id));
            return Response.ok().build();
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
            return Response.status(404).build();
        }
    }
}
