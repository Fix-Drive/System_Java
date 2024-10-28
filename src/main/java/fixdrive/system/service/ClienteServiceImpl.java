package fixdrive.system.service;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.dao.ClienteDao;
import fixdrive.system.entities.Cliente;
import fixdrive.system.exceptions.ClienteInvalid;
import fixdrive.system.exceptions.ClienteNotFound;
import fixdrive.system.exceptions.ClienteNotUpdate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private ClienteDao clienteDao;


    @Override
    public List<Cliente> listarClientes() throws SQLException {
        return this.clienteDao.findAll();
    }

    @Override
    public Cliente create(Cliente cliente) throws ClienteInvalid, SQLException {
        if (cliente.getId() != null){
            throw new ClienteInvalid();
        }
        validarClientes(cliente);
        return this.clienteDao.create(cliente);
    }

    @Override
    public Cliente edit(Cliente cliente) throws ClienteNotUpdate, ClienteNotFound {
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            cliente = this.clienteDao.update(cliente, connection);
            connection.commit();

        } catch (SQLException e) {
            throw new ClienteNotUpdate();
        }
        return cliente;
    }

    @Override
    public void delete(int id) throws ClienteNotFound {
        try {
            this.clienteDao.deleteById(id);
        } catch (SQLException e) {
            throw new ClienteNotFound(id);
        }

    }

    public void validarClientes(Cliente cliente) throws ClienteInvalid {
        if (cliente.getIdade() < 18){
            throw new ClienteInvalid();
        }
        String numeroCpfString = String.valueOf(cliente.getNumeroCpf());
        if (numeroCpfString.length() != 11){
            throw new ClienteInvalid();
        }
        String numeroRgString = String.valueOf(cliente.getNumeroRg());
        if (numeroRgString.length() != 9){
            throw new ClienteInvalid();
        }
        String numeroCnhString = String.valueOf(cliente.getNumeroCnh());
        if (numeroCnhString.length() != 11){
            throw new ClienteInvalid();
        }
    }
}
