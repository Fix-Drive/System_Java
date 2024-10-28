package fixdrive.system.dao;

import fixdrive.system.entities.Automovel;
import fixdrive.system.exceptions.ClienteNotFound;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AutomovelDao {

    Automovel createAutomovel(Automovel automovel);

    Automovel updateAutomovel(Automovel automovel, Connection connection) throws SQLException, ClienteNotFound;

    List<Automovel> listAutomoveis();

    void deleteById(int id) throws SQLException;

    Automovel findById(int id) throws SQLException;
}
