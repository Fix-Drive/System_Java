package fixdrive.system.service;

import fixdrive.system.exceptions.ExceptionIdadeInvalida;
import fixdrive.system.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteService {
    Cliente getClienteById(Long id) throws SQLException;
    List<Cliente> getAllClientes() throws SQLException;
    Cliente createCliente(Cliente cliente) throws SQLException, ExceptionIdadeInvalida;
    void updateCliente(Cliente cliente) throws SQLException;
    void deleteCliente(Long id) throws SQLException;
}
