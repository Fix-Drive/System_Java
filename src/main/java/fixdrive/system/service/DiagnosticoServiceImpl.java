package fixdrive.system.service;

import fixdrive.system.dao.DiagnosticoDao;
import fixdrive.system.dao.DiagnosticoDaoImpl;
import fixdrive.system.model.Diagnostico;

import java.sql.SQLException;
import java.util.List;

public class DiagnosticoServiceImpl implements DiagnosticoService {
    private final DiagnosticoDao diagnosticoDao = new DiagnosticoDaoImpl();

    @Override
    public Diagnostico getDiagnosticoById(Long id) throws SQLException {
        return diagnosticoDao.findById(id);
    }

    @Override
    public List<Diagnostico> getAllDiagnosticos() throws SQLException {
        return diagnosticoDao.findAll();
    }

    @Override
    public Diagnostico createDiagnostico(Diagnostico diagnostico) throws SQLException {
        return diagnosticoDao.createDiagnostico(diagnostico);
    }

    @Override
    public void updateDiagnostico(Diagnostico diagnostico) throws SQLException {
        diagnosticoDao.update(diagnostico);
    }

    @Override
    public void deleteDiagnostico(Long id) throws SQLException {
        diagnosticoDao.deleteById(id);
    }
}
