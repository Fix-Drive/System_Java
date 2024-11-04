package fixdrive.system.dao;

import fixdrive.system.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {
   Cliente findById(Long id) throws SQLException;
   List<Cliente> findAll() throws SQLException;
   Cliente createCliente(Cliente cliente) throws SQLException;
   void update(Cliente cliente) throws SQLException;
   void deleteById(Long id) throws SQLException;
}
