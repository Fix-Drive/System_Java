package fixdrive.system.dao;

import fixdrive.system.model.Manutencao;

import java.sql.SQLException;
import java.util.List;

public interface ManutencaoDao {
    Manutencao findById(Long id) throws SQLException;
    List<Manutencao> findAll() throws SQLException;
    Manutencao createManutencao(Manutencao manutencao) throws SQLException;
    void update(Manutencao manutencao) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
