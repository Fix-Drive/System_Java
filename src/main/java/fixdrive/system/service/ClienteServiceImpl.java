package fixdrive.system.service;

import fixdrive.system.dao.ClienteDao;
import fixdrive.system.dao.ClienteDaoImpl;
import fixdrive.system.exceptions.ExceptionIdadeInvalida;
import fixdrive.system.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private ClienteDao clienteDao = new ClienteDaoImpl();

    @Override
    public Cliente getClienteById(Long id) throws SQLException {
        return clienteDao.findById(id);
    }

    @Override
    public List<Cliente> getAllClientes() throws SQLException {
        return clienteDao.findAll();
    }

    @Override
    public Cliente createCliente(Cliente cliente) throws SQLException, ExceptionIdadeInvalida {
        validateIdade(cliente);
        return clienteDao.createCliente(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) throws SQLException {
        clienteDao.update(cliente);
    }

    @Override
    public void deleteCliente(Long id) throws SQLException {
        clienteDao.deleteById(id);
    }

    private void validateIdade(Cliente cliente) throws ExceptionIdadeInvalida {
        if (cliente.getIdadeCliente() < 18) {
            throw new ExceptionIdadeInvalida("O cliente deve ser maior de idade para se cadastrar.");
        }
    }
}
