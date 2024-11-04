package fixdrive.system.dao;

import fixdrive.system.model.Problema;

import java.sql.SQLException;
import java.util.List;

public interface ProblemaDao {
    Problema findById(Long id) throws SQLException;
    List<Problema> findAll() throws SQLException;
    Problema createProblema(Problema problema) throws SQLException;
    void update(Problema problema) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
