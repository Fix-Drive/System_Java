package fixdrive.system.service;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.dao.DiagnosticoDao;
import fixdrive.system.dao.DiagnosticoDaoFactory;
import fixdrive.system.entities.Diagnostico;
import fixdrive.system.exceptions.DiagnosticoInvalid;
import fixdrive.system.exceptions.DiagnosticoNotFound;
import fixdrive.system.exceptions.DiagnosticoNotUpdate;

import java.sql.Connection;
import java.util.List;

public class DiagnosticoServiceImpl implements DiagnosticoService {

    private DiagnosticoDao diagnosticoDao = DiagnosticoDaoFactory.createDiagnosticoDaoImpl();


    @Override
    public List<Diagnostico> listarTodos() {
        return this.diagnosticoDao.listarDiagnosticos();
    }

    @Override
    public Diagnostico create(Diagnostico diagnostico) {
        if (diagnostico.getId() == null) {
            throw new DiagnosticoInvalid();
        }
        return this.diagnosticoDao.createDiagnostico(diagnostico);
    }

    @Override
    public Diagnostico update(Diagnostico diagnostico) {
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            diagnostico = this.diagnosticoDao.updateDiagnostico(diagnostico, connection);
            connection.commit();
        } catch (Exception e) {
            throw new DiagnosticoNotUpdate();
        }
        return diagnostico;
    }

    @Override
    public void delete(int id) {
        try{
            this.diagnosticoDao.deleteDiagnostico(id);
        } catch (Exception e) {
            throw new DiagnosticoNotFound(id);
        }

    }
}
