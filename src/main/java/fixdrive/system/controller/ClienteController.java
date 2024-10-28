package fixdrive.system.controller;


import fixdrive.system.dto.ClienteDto;
import fixdrive.system.entities.Cliente;
import fixdrive.system.exceptions.ClienteInvalid;
import fixdrive.system.exceptions.ClienteNotFound;
import fixdrive.system.exceptions.ClienteNotUpdate;
import fixdrive.system.service.ClienteService;
import fixdrive.system.service.ClienteServiceFactory;
import fixdrive.system.service.ClienteServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/cliente")
    public class ClienteController {

    private ClienteService clienteService = ClienteServiceFactory.create();

    @GET
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClientes() throws SQLException {
        return Response.status(Response.Status.OK).entity(this.clienteService.listarClientes()).build();
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCliente(ClienteDto clientedto){
        try {
            Cliente cliente = new Cliente(clientedto.getNome(), clientedto.getIdade(), clientedto.getEmail(), clientedto.getSenha(), clientedto.getNumeroCpf(), clientedto.getNumeroRg(), clientedto.getEndereco(), clientedto.getNumeroCnh(), clientedto.getNumeroTelefone());
            cliente = this.clienteService.create(cliente);
            return Response.status(Response.Status.CREATED).entity(cliente).build();
        } catch (ClienteInvalid | SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Dados inválidos.").build();

    }
}

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
        public Response updateCliente(@PathParam("id") int id, ClienteDto clientedto){
        try {
            Cliente cliente = this.clienteService.edit(new Cliente(clientedto.getId(), clientedto.getNome(), clientedto.getIdade(), clientedto.getEmail(), clientedto.getSenha(), clientedto.getNumeroCpf(), clientedto.getNumeroRg(), clientedto.getEndereco(), clientedto.getNumeroCnh(), clientedto.getNumeroTelefone()));
            return Response.status(Response.Status.OK).entity(cliente).build();
        } catch (ClienteNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("mensagem", "ID não existente")).build();
        } catch (ClienteNotUpdate | SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("mensagem","Não foi possível atualizar")).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
        public Response deleteCliente(@PathParam("id") int id) {
        try{
            this.clienteService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (ClienteNotFound e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
