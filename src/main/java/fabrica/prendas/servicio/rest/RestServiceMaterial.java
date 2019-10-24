package fabrica.prendas.servicio.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import fabrica.prendas.domain.Material;
import fabrica.prendas.servicio.MaterialService;

@Path("/material")
@Stateless
public class RestServiceMaterial {

    @Inject
    private MaterialService service;

    @GET
    @Path("/all")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.TEXT_HTML})
    public Response findAll() {
        try {
            List<Material> found = service.findAll();
            System.out.println("HHHHOOOOOAALLALA: " + found.get(0));
            if (found == null || found.isEmpty()) {
                throw new RuntimeException("No se han encontrado coincidencias");
            }
            return Response.status(Status.ACCEPTED).entity(new GenericEntity<List<Material>>(found) {
            }).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @GET
    @Path("/all2")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.TEXT_HTML})
    public List<Material> findAll2() {
        return service.findAll();
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM})
    @Path("/find/{id}")
    public Material findById(@PathParam("id") int id) {
        return service.findMaterialById(new Material(id));
    }

    @POST
    @Path("/save")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response agregarMaterial(Material m) {
        try {
            service.insertMaterial(m);
            return Response.ok().entity(m).build();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/update/{id}")
    public Response modificarMaterial(@PathParam("id") int id, Material materialMod) {
        try {
            Material tipo = service.findMaterialById(new Material(id));
            if (tipo != null) {
                service.updateMaterial(materialMod);
                return Response.ok().entity(materialMod).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response eliminarPorId(@PathParam("id") int id) {
        try {
            service.deleteMaterial(new Material(id));
            return Response.ok().build();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/findI/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response findByDni(@PathParam("id") int id) throws Throwable {

        List<Material> found = service.findById(new Material(id));
        System.out.println("HHHHOOOOOAALLALA: " + found.get(0));
        if (found == null || found.isEmpty()) {
            throw new RuntimeException("No se han encontrado coincidencias");
        }
        return Response.status(Status.ACCEPTED).entity(new GenericEntity<List<Material>>(found) {
        }).build();
    }
}
