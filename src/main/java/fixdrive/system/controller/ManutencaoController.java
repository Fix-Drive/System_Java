package fixdrive.system.controller;

import fixdrive.system.dto.ManutencaoDto;
import fixdrive.system.model.Manutencao;
import fixdrive.system.service.ManutencaoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/manutencao")
public class ManutencaoController {
    private final ManutencaoService manutencaoService;

    public ManutencaoController(ManutencaoService manutencaoService) {
        this.manutencaoService = manutencaoService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManutencaoById(@PathParam("id") Long id) {
        try {
            Manutencao manutencao = manutencaoService.getManutencaoById(id);
            if (manutencao != null) {
                return Response.ok(mapToDto(manutencao)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllManutencoes() {
        try {
            List<Manutencao> manutencoes = manutencaoService.getAllManutencoes();
            List<ManutencaoDto> dtos = manutencoes.stream()
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
    public Response createManutencao(ManutencaoDto manutencaoDto) {
        try {
            Manutencao manutencao = new Manutencao();
            manutencao.setIdManutencao(manutencaoDto.getId());
            manutencao.setTipoManutencao(manutencaoDto.getTipoManutencao());
            manutencao.setDescricao(manutencaoDto.getDescricao());
            manutencao.setPecaManutencao(manutencaoDto.getPecaManutencao());
            manutencao.setRecomendacaoOficina(manutencaoDto.getRecomendacaoOficina());
            manutencao.setIdDiagnostico(manutencaoDto.getIdDiagnostico());
            manutencao.setIdProblema(manutencaoDto.getIdProblema());
            manutencao.setIdAutomovel(manutencaoDto.getIdAutomovel());

            manutencaoService.createManutencao(manutencao);
            return Response.status(Response.Status.CREATED).entity(manutencao).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateManutencao(@PathParam("id") Long id, ManutencaoDto manutencaoDto) {
        try {
            Manutencao manutencao = manutencaoService.getManutencaoById(id);
            if (manutencao != null) {
                manutencao.setTipoManutencao(manutencaoDto.getTipoManutencao());
                manutencao.setDescricao(manutencaoDto.getDescricao());
                manutencao.setPecaManutencao(manutencaoDto.getPecaManutencao());
                manutencao.setRecomendacaoOficina(manutencaoDto.getRecomendacaoOficina());
                manutencao.setIdDiagnostico(manutencaoDto.getIdDiagnostico());
                manutencao.setIdProblema(manutencaoDto.getIdProblema());
                manutencao.setIdAutomovel(manutencaoDto.getIdAutomovel());

                manutencaoService.updateManutencao(manutencao);
                return Response.ok(manutencao).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteManutencao(@PathParam("id") Long id) {
        try {
            manutencaoService.deleteManutencao(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private ManutencaoDto mapToDto(Manutencao manutencao) {
        ManutencaoDto dto = new ManutencaoDto();
        dto.setId(manutencao.getIdManutencao());
        dto.setTipoManutencao(manutencao.getTipoManutencao());
        dto.setDescricao(manutencao.getDescricao());
        dto.setPecaManutencao(manutencao.getPecaManutencao());
        dto.setRecomendacaoOficina(manutencao.getRecomendacaoOficina());
        dto.setIdDiagnostico(manutencao.getIdDiagnostico());
        dto.setIdProblema(manutencao.getIdProblema());
        dto.setIdAutomovel(manutencao.getIdAutomovel());
        return dto;
    }
}
