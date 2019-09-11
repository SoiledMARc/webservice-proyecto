package fabrica.prendas.servicio.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import fabrica.prendas.domain.Tela;
import fabrica.prendas.servicio.TelaService;
import javax.ws.rs.core.Response.Status;

@Path("/tela")
@Stateless
public class TelaServiceRS {
    
    @Inject
    private TelaService telaService;
    
    @GET
    @Path("/all")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tela> listarTelas(){
        return telaService.listarTelas();
    }
    
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/findI/{id}")
    public Tela encontrarTelaPorId(@PathParam("id") int id){
        return telaService.encontrarTelaPorId(new Tela(id));
    }
    
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/findN/{nombre}")
    public Tela encontrarTelaPorNombre(@PathParam("nombre") String nombre){
        return telaService.encontrarPorNombre(new Tela(nombre));
    }
    
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/findT/{tipo}")
    public List<Tela> listarPorTipo(@PathParam("tipo") String tipo){
        Tela aux = new Tela();
        aux.setTipoTela(tipo);
        return telaService.encontrarPorTipo(aux);
    }
    
    @POST
    @Path("/save")
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarTela(Tela tela){
        try{
            telaService.agregarTela(tela);
            return Response.ok().entity(tela).build();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/update/{id}")
    public Response modificarTelaPorId(@PathParam("id")int id, Tela telaModificada){
        try{
            Tela tela = telaService.encontrarTelaPorId(new Tela(id));
            if (tela != null) {
                telaService.modificar(telaModificada);
                return Response.ok().entity(telaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        }catch(Exception e){
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response eliminarTelaPorId(@PathParam("id") int id){
        try{
            telaService.eliminar(new Tela(id));
            return Response.ok().build();
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
            return Response.status(404).build();
        }
    }
}
