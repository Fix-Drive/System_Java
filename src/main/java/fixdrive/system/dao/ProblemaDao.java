package fixdrive.system.dao;

import fixdrive.system.entities.Problema;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProblemaDao {

    Problema createProblema(Problema problema);

    Problema updateProblema(Problema problema, Connection connection) throws SQLException;

    List<Problema> listarProblemas();

    void deleteProblemaById(int id) throws SQLException;

    Problema problemaById(int id) throws SQLException;
}
