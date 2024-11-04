package fixdrive.system.service;

import fixdrive.system.dao.AutomovelDao;
import fixdrive.system.dao.AutomovelDaoImpl;
import fixdrive.system.model.Automovel;

import java.sql.SQLException;
import java.util.List;

public class AutomovelServiceImpl implements AutomovelService {
    private final AutomovelDao automovelDao = new AutomovelDaoImpl();

    @Override
    public Automovel getAutomovelById(Long id) throws SQLException {
        return automovelDao.findById(id);
    }

    @Override
    public List<Automovel> getAllAutomoveis() throws SQLException {
        return automovelDao.findAll();
    }

    @Override
    public Automovel createAutomovel(Automovel automovel) throws SQLException {
        return automovelDao.createAutomovel(automovel);
    }

    @Override
    public void updateAutomovel(Automovel automovel) throws SQLException {
        automovelDao.update(automovel);
    }

    @Override
    public void deleteAutomovel(Long id) throws SQLException {
        automovelDao.deleteById(id);
    }
}
