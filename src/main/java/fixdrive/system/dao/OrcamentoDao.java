package fixdrive.system.dao;

import fixdrive.system.entities.Orcamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrcamentoDao {

    Orcamento createOrcamento(Orcamento orcamento);

    Orcamento updateOrcamento(Orcamento orcamento, Connection connection) throws SQLException;

    List<Orcamento> listarOrcamentos();

    void deleteOrcamento(int id) throws SQLException;

    Orcamento orcamentoById(int id) throws SQLException;
}
