package fixdrive.system.service;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.dao.ProblemaDao;
import fixdrive.system.dao.ProblemaDaoFactory;
import fixdrive.system.entities.Problema;
import fixdrive.system.exceptions.ProblemaInvalid;
import fixdrive.system.exceptions.ProblemaNotFound;
import fixdrive.system.exceptions.ProblemaNotUpdate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProblemaServiceImpl implements ProblemaService{


    private ProblemaDao problemaDao = ProblemaDaoFactory.createProblemaDaoImpl();




    @Override
    public List<Problema> listarTodos() {
        return this.problemaDao.listarProblemas();
    }

    @Override
    public Problema create(Problema problema) {
        if (problema.getId() != null){
            throw new ProblemaInvalid();
        }
        validarProblema(problema);
        return this.problemaDao.createProblema(problema);
    }

    @Override
    public Problema update(Problema problema) {
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            problema = this.problemaDao.updateProblema(problema, connection);
            connection.commit();
        } catch (SQLException e) {
            throw new ProblemaNotUpdate();
        }
        return problema;
    }

    @Override
    public void delete(int id) {
        try{
            this.problemaDao.deleteProblemaById(id);
        } catch (SQLException e) {
            throw new ProblemaNotFound(id);
        }

    }


    public void validarProblema(Problema problema) {
        if (problema.getGravidadeProblema() < 0 && problema.getGravidadeProblema() > 5) {
            throw new IllegalArgumentException("A gravidade deve ser classificada entre 0 e 5");
        }
    }
}
