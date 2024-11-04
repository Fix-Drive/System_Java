package fixdrive.system.controller;

import fixdrive.system.dto.DiagnosticoDto;
import fixdrive.system.model.Diagnostico;
import fixdrive.system.service.DiagnosticoServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/diagnostico")
public class DiagnosticoController {

    private final DiagnosticoServiceImpl diagnosticoService = new DiagnosticoServiceImpl();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiagnosticoById(@PathParam("id") Long id) {
        try {
            Diagnostico diagnostico = diagnosticoService.getDiagnosticoById(id);
            if (diagnostico != null) {
                return Response.ok(mapToDto(diagnostico)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDiagnosticos() {
        try {
            List<Diagnostico> diagnosticos = diagnosticoService.getAllDiagnosticos();
            List<DiagnosticoDto> dtos = diagnosticos.stream()
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
    public Response createDiagnostico(DiagnosticoDto diagnosticoDto) {
        try {
            Diagnostico diagnostico = new Diagnostico();
            diagnostico.setIdDiagnostico(diagnosticoDto.getId());
            diagnostico.setResultadoDiagnostico(diagnosticoDto.getResultadoDiagnostico());
            diagnostico.setIdProblema(diagnosticoDto.getIdProblema());
            diagnostico.setIdAutomovel(diagnosticoDto.getIdAutomovel());

            diagnosticoService.createDiagnostico(diagnostico);
            return Response.status(Response.Status.CREATED).entity(diagnostico).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDiagnostico(@PathParam("id") Long id, DiagnosticoDto diagnosticoDto) {
        try {
            Diagnostico diagnostico = diagnosticoService.getDiagnosticoById(id);
            if (diagnostico != null) {
                diagnostico.setResultadoDiagnostico(diagnosticoDto.getResultadoDiagnostico());
                diagnostico.setIdProblema(diagnosticoDto.getIdProblema());
                diagnostico.setIdAutomovel(diagnosticoDto.getIdAutomovel());

                diagnosticoService.updateDiagnostico(diagnostico);
                return Response.ok(diagnostico).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDiagnostico(@PathParam("id") Long id) {
        try {
            diagnosticoService.deleteDiagnostico(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private DiagnosticoDto mapToDto(Diagnostico diagnostico) {
        DiagnosticoDto dto = new DiagnosticoDto();
        dto.setId(diagnostico.getIdDiagnostico());
        dto.setResultadoDiagnostico(diagnostico.getResultadoDiagnostico());
        dto.setIdProblema(diagnostico.getIdProblema());
        dto.setIdAutomovel(diagnostico.getIdAutomovel());
        return dto;
    }
}
