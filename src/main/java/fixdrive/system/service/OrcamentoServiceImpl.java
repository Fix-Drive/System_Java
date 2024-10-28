package fixdrive.system.service;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.dao.OrcamentoDao;
import fixdrive.system.dao.OrcamentoDaoFactory;
import fixdrive.system.entities.Orcamento;
import fixdrive.system.exceptions.OrcamentoInvalid;
import fixdrive.system.exceptions.OrcamentoNotUpdate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrcamentoServiceImpl implements OrcamentoService {

    private OrcamentoDao orcamentoDao = OrcamentoDaoFactory.createOrcamentoDaoImpl();

    @Override
    public List<Orcamento> listarTodos() {
        return this.orcamentoDao.listarOrcamentos();
    }

    @Override
    public Orcamento create(Orcamento orcamento) {
        if (orcamento.getId() == null) {
            throw new OrcamentoInvalid();
        }
        return this.orcamentoDao.createOrcamento(orcamento);
    }

    @Override
    public Orcamento update(Orcamento orcamento) {
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            orcamento = this.orcamentoDao.updateOrcamento(orcamento, connection);
            connection.commit();
        } catch (SQLException e) {
            throw new OrcamentoNotUpdate();
        }
        return orcamento;
    }

    @Override
    public void delete(int id) {

    }
}
