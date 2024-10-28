package fixdrive.system.controller;

import fixdrive.system.dto.AutomovelDto;
import fixdrive.system.entities.Automovel;
import fixdrive.system.exceptions.AutomovelInvalid;
import fixdrive.system.exceptions.AutomovelNotFound;
import fixdrive.system.exceptions.AutomovelNotUpdate;
import fixdrive.system.service.AutomovelService;
import fixdrive.system.service.AutomovelServiceImpl;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;


@Path("/automovel")
public class AutomovelController {

    private AutomovelService automovelService = new AutomovelServiceImpl();

    @GET
    @Path("/automoveis")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAutomoveis(){
        return Response.status(Response.Status.OK).entity(this.automovelService.listarTodos()).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAutomovel(AutomovelDto automovelDto){
        try{
            Automovel automovel = new Automovel(automovelDto.getPlacaAutomovel(), automovelDto.getMarcaAutomovel(), automovelDto.getModeloAutomovel(), automovelDto.getAnoAutomovel(), automovelDto.getNumeroChassi(), automovelDto.getCodigoRenavam(), automovelDto.getPorteAutomovel());
            automovel = this.automovelService.create(automovel);
            return Response.status(Response.Status.CREATED).entity(automovel).build();
        } catch(AutomovelInvalid e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAutomovel(@PathParam("id") Integer id, AutomovelDto automovelDto){
        try {
            Automovel automovel = this.automovelService.update(new Automovel(automovelDto.getId(), automovelDto.getPlacaAutomovel(), automovelDto.getMarcaAutomovel(), automovelDto.getModeloAutomovel(), automovelDto.getNumeroChassi(), automovelDto.getCodigoRenavam(), automovelDto.getAnoAutomovel() ,automovelDto.getPorteAutomovel()));
            return Response.status(Response.Status.OK).entity(automovel).build();
        } catch (AutomovelNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("mensagem", "ID não existente")).build();
        } catch (AutomovelNotUpdate e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("mensagem", "Não foi possível atualizar")).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAutomovel(@PathParam("id") Integer id){
        try{
            this.automovelService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (AutomovelNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
