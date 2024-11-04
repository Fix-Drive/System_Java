package fixdrive.system.dao;

import fixdrive.system.model.Automovel;

import java.sql.SQLException;
import java.util.List;

public interface AutomovelDao {
    Automovel findById(Long id) throws SQLException;
    List<Automovel> findAll() throws SQLException;
    Automovel createAutomovel(Automovel automovel) throws SQLException;
    void update(Automovel automovel) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
