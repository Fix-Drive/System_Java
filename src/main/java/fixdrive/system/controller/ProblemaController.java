package fixdrive.system.controller;


import fixdrive.system.dto.ProblemaDto;
import fixdrive.system.entities.Problema;
import fixdrive.system.exceptions.ProblemaInvalid;
import fixdrive.system.exceptions.ProblemaNotFound;
import fixdrive.system.exceptions.ProblemaNotUpdate;
import fixdrive.system.service.ProblemaService;
import fixdrive.system.service.ProblemaServiceImpl;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/problema")
public class ProblemaController {

    private ProblemaService problemaService = new ProblemaServiceImpl();

    @GET
    @Path("/problemas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProblemas(){
        return Response.status(Response.Status.OK).entity(this.problemaService.listarTodos()).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProblema(ProblemaDto problemaDto){
        try{
            Problema problema = new Problema(problemaDto.getTipoProblema(), problemaDto.getDescricaoProblema(), problemaDto.getGravidadeProblema());
            problema = this.problemaService.create(problema);
            return Response.status(Response.Status.CREATED).entity(problema).build();
        } catch (ProblemaInvalid e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProblema(@PathParam("id") Integer id, ProblemaDto problemaDto){
        try{
            Problema problema = this.problemaService.update(new Problema(problemaDto.getId(), problemaDto.getTipoProblema(), problemaDto.getDescricaoProblema(), problemaDto.getGravidadeProblema()));
            return Response.status(Response.Status.OK).entity(problema).build();
        } catch (ProblemaNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (ProblemaNotUpdate e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProblema(@PathParam("id") Integer id){
        try {
            this.problemaService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (ProblemaNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
