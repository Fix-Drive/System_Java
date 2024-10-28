package fixdrive.system.service;

import fixdrive.system.entities.Cliente;
import fixdrive.system.exceptions.ClienteInvalid;
import fixdrive.system.exceptions.ClienteNotFound;

import java.sql.SQLException;
import java.util.List;

public interface ClienteService {

    List<Cliente> listarClientes() throws SQLException;

    Cliente create(Cliente cliente) throws ClienteInvalid, SQLException;

    Cliente edit(Cliente cliente) throws SQLException, ClienteNotFound;

    void delete(int id) throws ClienteNotFound;
}
