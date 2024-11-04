package fixdrive.system.controller;

import fixdrive.system.dto.AutomovelDto;
import fixdrive.system.model.Automovel;
import fixdrive.system.service.AutomovelServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/automovel")
public class AutomovelController {

    private final AutomovelServiceImpl automovelService = new AutomovelServiceImpl();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomovelById(@PathParam("id") Long id) {
        try {
            Automovel automovel = automovelService.getAutomovelById(id);
            if (automovel != null) {
                return Response.ok(mapToDto(automovel)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAutomoveis() {
        try {
            List<Automovel> automoveis = automovelService.getAllAutomoveis();
            List<AutomovelDto> dtos = automoveis.stream()
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
    public Response createAutomovel(AutomovelDto automovelDto) {
        try {
            Automovel automovel = new Automovel();
            automovel.setIdAutomovel(automovelDto.getId());
            automovel.setPlacaAutomovel(automovelDto.getPlacaAutomovel());
            automovel.setTipoAutomovel(automovelDto.getTipoAutomovel());
            automovel.setMarcaAutomovel(automovelDto.getMarcaAutomovel());
            automovel.setModeloAutomovel(automovelDto.getModeloAutomovel());
            automovel.setPorteAutomovel(automovelDto.getPorteAutomovel());
            automovel.setAnoAutomovel(automovelDto.getAnoAutomovel());
            automovel.setNumeroChassi(automovelDto.getNumeroChassi());
            automovel.setCodigoRenavam(automovelDto.getCodigoRenavam());
            automovel.setIdCliente(automovelDto.getIdCliente());

            automovelService.createAutomovel(automovel);
            return Response.status(Response.Status.CREATED).entity(automovel).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAutomovel(@PathParam("id") Long id, AutomovelDto automovelDto) {
        try {
            Automovel automovel = automovelService.getAutomovelById(id);
            if (automovel != null) {
                automovel.setPlacaAutomovel(automovelDto.getPlacaAutomovel());
                automovel.setTipoAutomovel(automovelDto.getTipoAutomovel());
                automovel.setMarcaAutomovel(automovelDto.getMarcaAutomovel());
                automovel.setModeloAutomovel(automovelDto.getModeloAutomovel());
                automovel.setPorteAutomovel(automovelDto.getPorteAutomovel());
                automovel.setAnoAutomovel(automovelDto.getAnoAutomovel());
                automovel.setNumeroChassi(automovelDto.getNumeroChassi());
                automovel.setCodigoRenavam(automovelDto.getCodigoRenavam());
                automovel.setIdCliente(automovelDto.getIdCliente());

                automovelService.updateAutomovel(automovel);
                return Response.ok(automovel).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAutomovel(@PathParam("id") Long id) {
        try {
            automovelService.deleteAutomovel(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private AutomovelDto mapToDto(Automovel automovel) {
        AutomovelDto dto = new AutomovelDto();
        dto.setId(automovel.getIdAutomovel());
        dto.setPlacaAutomovel(automovel.getPlacaAutomovel());
        dto.setTipoAutomovel(automovel.getTipoAutomovel());
        dto.setMarcaAutomovel(automovel.getMarcaAutomovel());
        dto.setModeloAutomovel(automovel.getModeloAutomovel());
        dto.setPorteAutomovel(automovel.getPorteAutomovel());
        dto.setAnoAutomovel(automovel.getAnoAutomovel());
        dto.setNumeroChassi(automovel.getNumeroChassi());
        dto.setCodigoRenavam(automovel.getCodigoRenavam());
        dto.setIdCliente(automovel.getIdCliente());
        return dto;
    }
}
