package fixdrive.system.dao;

import fixdrive.system.entities.Manutencao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ManutencaoDao {

    Manutencao createManutencao(Manutencao manutencao);

    Manutencao updateManutencao(Manutencao manutencao, Connection connection) throws SQLException;

    List<Manutencao> listarManutencoes();

    void deleteManutencaoById(int id) throws SQLException;

    Manutencao ManutencaoById(int id) throws SQLException;

}
