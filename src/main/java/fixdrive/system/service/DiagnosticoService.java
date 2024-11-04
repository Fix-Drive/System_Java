package fixdrive.system.service;

import fixdrive.system.model.Diagnostico;

import java.sql.SQLException;
import java.util.List;

public interface DiagnosticoService {
    Diagnostico getDiagnosticoById(Long id) throws SQLException;
    List<Diagnostico> getAllDiagnosticos() throws SQLException;
    Diagnostico createDiagnostico(Diagnostico diagnostico) throws SQLException;
    void updateDiagnostico(Diagnostico diagnostico) throws SQLException;
    void deleteDiagnostico(Long id) throws SQLException;
}
