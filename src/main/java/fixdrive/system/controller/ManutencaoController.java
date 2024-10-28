package fixdrive.system.controller;

import fixdrive.system.dto.ManutencaoDto;
import fixdrive.system.entities.Manutencao;
import fixdrive.system.exceptions.ManutencaoInvalid;
import fixdrive.system.exceptions.ManutencaoNotFound;
import fixdrive.system.exceptions.ManutencaoNotUpdate;
import fixdrive.system.exceptions.ProblemaNotFound;
import fixdrive.system.service.ManutencaoService;
import fixdrive.system.service.ManutencaoServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/manutencao")
public class ManutencaoController {

    private ManutencaoService manutencaoService = new ManutencaoServiceImpl();

    @GET
    @Path("/manutencoes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllManutencoes(){
        return Response.status(Response.Status.OK).entity(this.manutencaoService.listarTodos()).build();
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addManutencoe(ManutencaoDto manutencaoDto){
        try{
            Manutencao manutencao = new Manutencao(manutencaoDto.getTipoManutencao(), manutencaoDto.getDescricaoManutencao(), manutencaoDto.getTipoPeca(), manutencaoDto.getRecomendacaoCentroAutomotivo());
            return Response.status(Response.Status.CREATED).entity(manutencao).build();
        } catch (ManutencaoInvalid e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateManutencao(@PathParam("id") Integer id, ManutencaoDto manutencaoDto){
        try{
            Manutencao manutencao = this.manutencaoService.update(new Manutencao(manutencaoDto.getId(), manutencaoDto.getTipoManutencao(), manutencaoDto.getDescricaoManutencao(), manutencaoDto.getTipoPeca(), manutencaoDto.getRecomendacaoCentroAutomotivo()));
            return Response.status(Response.Status.OK).entity(manutencao).build();
        } catch (ProblemaNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (ManutencaoNotUpdate e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteManutencao(@PathParam("id") Integer id){
        try{
            this.manutencaoService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (ManutencaoNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
