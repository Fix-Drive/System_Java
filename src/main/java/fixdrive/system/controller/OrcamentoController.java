package fixdrive.system.controller;


import fixdrive.system.dto.OrcamentoDto;
import fixdrive.system.entities.Orcamento;
import fixdrive.system.exceptions.OrcamentoNotFound;
import fixdrive.system.exceptions.OrcamentoNotUpdate;
import fixdrive.system.service.OrcamentoService;
import fixdrive.system.service.OrcamentoServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/orcamento")
public class OrcamentoController {

    private OrcamentoService orcamentoService = new OrcamentoServiceImpl();

    @GET
    @Path("/orcamentos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrcamentos() {
        return Response.status(Response.Status.OK). entity(this.orcamentoService.listarTodos()).build();
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrcamento(OrcamentoDto orcamentoDto) {
        try{
            Orcamento orcamento = new Orcamento(orcamentoDto.getValorPeca(), orcamentoDto.getValorServico());
            orcamento = this.orcamentoService.create(orcamento);
            return Response.status(Response.Status.CREATED). entity(orcamento).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST). entity(Map.of("mensagem", "Dados invalidados")).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrcamento(@PathParam("id") Integer id, OrcamentoDto orcamentoDto) {
        try{
            Orcamento orcamento = this.orcamentoService.update(new Orcamento(orcamentoDto.getId(), orcamentoDto.getValorPeca(), orcamentoDto.getValorServico()));
            return Response.status(Response.Status.OK). entity(orcamento).build();

        } catch (OrcamentoNotFound e) {
            return Response.status(Response.Status.NOT_FOUND). entity(Map.of("mensagem", "ID não existente")).build();
        } catch (OrcamentoNotUpdate e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("mensagem", "Não foi possível realizar a atualização")).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOrcamento(@PathParam("id") Integer id) {
        try{
            this.orcamentoService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (OrcamentoNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
