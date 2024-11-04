package fixdrive.system.service;

import fixdrive.system.model.Problema;

import java.sql.SQLException;
import java.util.List;

public interface ProblemaService {
    Problema getProblemaById(Long id) throws SQLException;
    List<Problema> getAllProblemas() throws SQLException;
    Problema createProblema(Problema problema) throws SQLException;
    void updateProblema(Problema problema) throws SQLException;
    void deleteProblema(Long id) throws SQLException;
}
