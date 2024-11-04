package fixdrive.system.service;

import fixdrive.system.dao.ProblemaDao;
import fixdrive.system.dao.ProblemaDaoImpl;
import fixdrive.system.model.Problema;

import java.sql.SQLException;
import java.util.List;

public class ProblemaServiceImpl implements ProblemaService {
    private final ProblemaDao problemaDao = new ProblemaDaoImpl();

    @Override
    public Problema getProblemaById(Long id) throws SQLException {
        return problemaDao.findById(id);
    }

    @Override
    public List<Problema> getAllProblemas() throws SQLException {
        return problemaDao.findAll();
    }

    @Override
    public Problema createProblema(Problema problema) throws SQLException {
        return problemaDao.createProblema(problema);
    }

    @Override
    public void updateProblema(Problema problema) throws SQLException {
        problemaDao.update(problema);
    }

    @Override
    public void deleteProblema(Long id) throws SQLException {
        problemaDao.deleteById(id);
    }
}
