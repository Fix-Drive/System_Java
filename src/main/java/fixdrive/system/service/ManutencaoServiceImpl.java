package fixdrive.system.service;

import fixdrive.system.dao.ManutencaoDao;
import fixdrive.system.model.Manutencao;

import java.sql.SQLException;
import java.util.List;

public class ManutencaoServiceImpl implements ManutencaoService {
    private final ManutencaoDao manutencaoDao;

    public ManutencaoServiceImpl(ManutencaoDao manutencaoDao) {
        this.manutencaoDao = manutencaoDao;
    }

    @Override
    public Manutencao getManutencaoById(Long id) throws SQLException {
        return manutencaoDao.findById(id);
    }

    @Override
    public List<Manutencao> getAllManutencoes() throws SQLException {
        return manutencaoDao.findAll();
    }

    @Override
    public Manutencao createManutencao(Manutencao manutencao) throws SQLException {
        return manutencaoDao.createManutencao(manutencao);
    }

    @Override
    public void updateManutencao(Manutencao manutencao) throws SQLException {
        manutencaoDao.update(manutencao);
    }

    @Override
    public void deleteManutencao(Long id) throws SQLException {
        manutencaoDao.deleteById(id);
    }
}
