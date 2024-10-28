package fixdrive.system.dao;

import fixdrive.system.entities.Cliente;
import fixdrive.system.exceptions.ClienteNotFound;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {

   Cliente create(Cliente cliente) throws SQLException;

   Cliente update(Cliente cliente, Connection connection) throws SQLException, ClienteNotFound;

   List<Cliente> findAll() throws SQLException;

   void deleteById(int id) throws SQLException, ClienteNotFound;

   Cliente findById(int id) throws ClienteNotFound, SQLException;


}
