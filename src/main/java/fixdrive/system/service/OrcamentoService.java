package fixdrive.system.service;

import fixdrive.system.model.Orcamento;

import java.sql.SQLException;
import java.util.List;

public interface OrcamentoService {
    Orcamento getOrcamentoById(Long id) throws SQLException;
    List<Orcamento> getAllOrcamentos() throws SQLException;
    Orcamento createOrcamento(Orcamento orcamento) throws SQLException;
    void updateOrcamento(Orcamento orcamento) throws SQLException;
    void deleteOrcamento(Long id) throws SQLException;
}
