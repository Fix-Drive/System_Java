package fixdrive.system.controller;


import fixdrive.system.dto.DiagnosticoDto;
import fixdrive.system.entities.Diagnostico;
import fixdrive.system.exceptions.DiagnosticoNotFound;
import fixdrive.system.exceptions.DiagnosticoNotUpdate;
import fixdrive.system.service.DiagnosticoService;
import fixdrive.system.service.DiagnosticoServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/diagnostico")
public class DiagnosticoController {

    private DiagnosticoService diagnosticoService = new DiagnosticoServiceImpl();

    @GET
    @Path("/diagnosticos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDiagnosticos(){
        return Response.status(Response.Status.OK).entity(this.diagnosticoService.listarTodos()).build();
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDiagnostico(DiagnosticoDto diagnosticoDto){
        try{
            Diagnostico diagnostico = new Diagnostico(diagnosticoDto.getResultadoDiagnostico());
            diagnostico = this.diagnosticoService.create(diagnostico);
            return Response.status(Response.Status.CREATED).entity(diagnostico).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("mensagem", "Dados invalidados")).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDiagnostico(@PathParam("id") Integer id, DiagnosticoDto diagnosticoDto){
        try{
            Diagnostico diagnostico = this.diagnosticoService.update(new Diagnostico(diagnosticoDto.getId(), diagnosticoDto.getResultadoDiagnostico()));
            return Response.status(Response.Status.OK).entity(diagnostico).build();
        } catch (DiagnosticoNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("mensagem", "ID não existente")).build();
        } catch (DiagnosticoNotUpdate e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("mensagem", "Não foi possível realizar a atualização")).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDiagnostico(@PathParam("id") Integer id){
        try{
            this.diagnosticoService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (DiagnosticoNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
