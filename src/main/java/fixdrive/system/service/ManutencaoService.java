package fixdrive.system.service;

import fixdrive.system.model.Manutencao;

import java.sql.SQLException;
import java.util.List;

public interface ManutencaoService {
    Manutencao getManutencaoById(Long id) throws SQLException;
    List<Manutencao> getAllManutencoes() throws SQLException;
    Manutencao createManutencao(Manutencao manutencao) throws SQLException;
    void updateManutencao(Manutencao manutencao) throws SQLException;
    void deleteManutencao(Long id) throws SQLException;
}
