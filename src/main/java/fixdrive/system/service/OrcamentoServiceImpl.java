package fixdrive.system.service;

import fixdrive.system.dao.OrcamentoDao;
import fixdrive.system.model.Orcamento;

import java.sql.SQLException;
import java.util.List;

public class OrcamentoServiceImpl implements OrcamentoService {
    private final OrcamentoDao orcamentoDao;

    public OrcamentoServiceImpl(OrcamentoDao orcamentoDao) {
        this.orcamentoDao = orcamentoDao;
    }

    @Override
    public Orcamento getOrcamentoById(Long id) throws SQLException {
        return orcamentoDao.findById(id);
    }

    @Override
    public List<Orcamento> getAllOrcamentos() throws SQLException {
        return orcamentoDao.findAll();
    }

    @Override
    public Orcamento createOrcamento(Orcamento orcamento) throws SQLException {
        return orcamentoDao.createOrcamento(orcamento);
    }

    @Override
    public void updateOrcamento(Orcamento orcamento) throws SQLException {
        orcamentoDao.update(orcamento);
    }

    @Override
    public void deleteOrcamento(Long id) throws SQLException {
        orcamentoDao.deleteById(id);
    }
}
