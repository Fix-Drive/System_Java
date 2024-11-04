package fixdrive.system.dao;

import fixdrive.system.model.Diagnostico;

import java.sql.SQLException;
import java.util.List;

public interface DiagnosticoDao {
    Diagnostico findById(Long id) throws SQLException;
    List<Diagnostico> findAll() throws SQLException;
    Diagnostico createDiagnostico(Diagnostico diagnostico) throws SQLException;
    void update(Diagnostico diagnostico) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
