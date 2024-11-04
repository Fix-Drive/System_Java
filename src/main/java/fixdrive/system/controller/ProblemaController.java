package fixdrive.system.controller;

import fixdrive.system.dto.ProblemaDto;
import fixdrive.system.model.Problema;
import fixdrive.system.service.ProblemaServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/problema")
public class ProblemaController {

    private final ProblemaServiceImpl problemaService = new ProblemaServiceImpl();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProblemaById(@PathParam("id") Long id) {
        try {
            Problema problema = problemaService.getProblemaById(id);
            if (problema != null) {
                return Response.ok(mapToDto(problema)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProblemas() {
        try {
            List<Problema> problemas = problemaService.getAllProblemas();
            List<ProblemaDto> dtos = problemas.stream()
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
    public Response createProblema(ProblemaDto problemaDto) {
        try {
            Problema problema = new Problema();
            problema.setIdProblema(problemaDto.getId());
            problema.setTipoProblema(problemaDto.getTipoProblema());
            problema.setDescricao(problemaDto.getDescricao());
            problema.setPontuacaoGravidade(problemaDto.getPontuacaoGravidade());
            problema.setIdAutomovel(problemaDto.getIdAutomovel());

            problemaService.createProblema(problema);
            return Response.status(Response.Status.CREATED).entity(problema).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProblema(@PathParam("id") Long id, ProblemaDto problemaDto) {
        try {
            Problema problema = problemaService.getProblemaById(id);
            if (problema != null) {
                problema.setTipoProblema(problemaDto.getTipoProblema());
                problema.setDescricao(problemaDto.getDescricao());
                problema.setPontuacaoGravidade(problemaDto.getPontuacaoGravidade());
                problema.setIdAutomovel(problemaDto.getIdAutomovel());

                problemaService.updateProblema(problema);
                return Response.ok(problema).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProblema(@PathParam("id") Long id) {
        try {
            problemaService.deleteProblema(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private ProblemaDto mapToDto(Problema problema) {
        ProblemaDto dto = new ProblemaDto();
        dto.setId(problema.getIdProblema());
        dto.setTipoProblema(problema.getTipoProblema());
        dto.setDescricao(problema.getDescricao());
        dto.setPontuacaoGravidade(problema.getPontuacaoGravidade());
        dto.setIdAutomovel(problema.getIdAutomovel());
        return dto;
    }
}
