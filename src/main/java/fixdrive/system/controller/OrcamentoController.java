package fixdrive.system.controller;

import fixdrive.system.dto.OrcamentoDto;
import fixdrive.system.model.Orcamento;
import fixdrive.system.service.OrcamentoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/orcamento")
public class OrcamentoController {
    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrcamentoById(@PathParam("id") Long id) {
        try {
            Orcamento orcamento = orcamentoService.getOrcamentoById(id);
            if (orcamento != null) {
                return Response.ok(mapToDto(orcamento)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrcamentos() {
        try {
            List<Orcamento> orcamentos = orcamentoService.getAllOrcamentos();
            List<OrcamentoDto> dtos = orcamentos.stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
            return Response.ok(dtos).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrcamento(OrcamentoDto orcamentoDto) {
        try {
            Orcamento orcamento = new Orcamento();
            orcamento.setIdOrcamento(orcamentoDto.getId());
            orcamento.setVlPeca(orcamentoDto.getVlPeca());
            orcamento.setVlServico(orcamentoDto.getVlServico());
            orcamento.setIdManutencao(orcamentoDto.getIdManutencao());

            orcamentoService.createOrcamento(orcamento);
            return Response.status(Response.Status.CREATED).entity(orcamento).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrcamento(@PathParam("id") Long id, OrcamentoDto orcamentoDto) {
        try {
            Orcamento orcamento = orcamentoService.getOrcamentoById(id);
            if (orcamento != null) {
                orcamento.setVlPeca(orcamentoDto.getVlPeca());
                orcamento.setVlServico(orcamentoDto.getVlServico());
                orcamento.setIdManutencao(orcamentoDto.getIdManutencao());

                orcamentoService.updateOrcamento(orcamento);
                return Response.ok(orcamento).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrcamento(@PathParam("id") Long id) {
        try {
            orcamentoService.deleteOrcamento(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private OrcamentoDto mapToDto(Orcamento orcamento) {
        OrcamentoDto dto = new OrcamentoDto();
        dto.setId(orcamento.getIdOrcamento());
        dto.setVlPeca(orcamento.getVlPeca());
        dto.setVlServico(orcamento.getVlServico());
        dto.setIdManutencao(orcamento.getIdManutencao());
        return dto;
    }
}
