package fixdrive.system.controller;

import fixdrive.system.dto.ClienteDto;
import fixdrive.system.exceptions.ExceptionIdadeInvalida;
import fixdrive.system.model.Cliente;
import fixdrive.system.service.ClienteService;
import fixdrive.system.service.ClienteServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/clientes")
public class ClienteController {
    private ClienteService clienteService = new ClienteServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClientes() {
        try {
            List<Cliente> clientes = clienteService.getAllClientes();
            List<ClienteDto> dtos = clientes.stream()
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
    public Response createCliente(ClienteDto clienteDto) {
        try {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(clienteDto.getId());
            cliente.setNmCliente(clienteDto.getNmCliente());
            cliente.setIdadeCliente(clienteDto.getIdadeCliente());
            cliente.setDsEmail(clienteDto.getDsEmail());
            cliente.setDsSenha(clienteDto.getDsSenha());
            cliente.setNrCpf(clienteDto.getNrCpf());
            cliente.setNrRg(clienteDto.getNrRg());
            cliente.setDsEndereco(clienteDto.getDsEndereco());
            cliente.setNrCnh(clienteDto.getNrCnh());
            cliente.setNrTelefone(clienteDto.getNrTelefone());

            clienteService.createCliente(cliente);
            return Response.status(Response.Status.CREATED).entity(cliente).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        } catch (ExceptionIdadeInvalida e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(@PathParam("id") Long id, ClienteDto clienteDto) {
        try {
            Cliente cliente = clienteService.getClienteById(id);
            if (cliente != null) {
                cliente.setNmCliente(clienteDto.getNmCliente());
                cliente.setIdadeCliente(clienteDto.getIdadeCliente());
                cliente.setDsEmail(clienteDto.getDsEmail());
                cliente.setDsSenha(clienteDto.getDsSenha());
                cliente.setNrCpf(clienteDto.getNrCpf());
                cliente.setNrRg(clienteDto.getNrRg());
                cliente.setDsEndereco(clienteDto.getDsEndereco());
                cliente.setNrCnh(clienteDto.getNrCnh());
                cliente.setNrTelefone(clienteDto.getNrTelefone());

                clienteService.updateCliente(cliente);
                return Response.ok(cliente).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCliente(@PathParam("id") Long id) {
        try {
            clienteService.deleteCliente(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private ClienteDto mapToDto(Cliente cliente) {
        ClienteDto dto = new ClienteDto();
        dto.setId(cliente.getIdCliente());
        dto.setNmCliente(cliente.getNmCliente());
        dto.setIdadeCliente(cliente.getIdadeCliente());
        dto.setDsEmail(cliente.getDsEmail());
        dto.setDsSenha(cliente.getDsSenha());
        dto.setNrCpf(cliente.getNrCpf());
        dto.setNrRg(cliente.getNrRg());
        dto.setDsEndereco(cliente.getDsEndereco());
        dto.setNrCnh(cliente.getNrCnh());
        dto.setNrTelefone(cliente.getNrTelefone());
        return dto;
    }
}
