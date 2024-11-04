package fixdrive.system.dao;

import fixdrive.system.model.Orcamento;

import java.sql.SQLException;
import java.util.List;

public interface OrcamentoDao {
    Orcamento findById(Long id) throws SQLException;
    List<Orcamento> findAll() throws SQLException;
    Orcamento createOrcamento(Orcamento orcamento) throws SQLException;
    void update(Orcamento orcamento) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
