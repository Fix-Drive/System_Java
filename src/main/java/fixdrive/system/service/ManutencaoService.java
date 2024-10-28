package fixdrive.system.service;

import fixdrive.system.entities.Manutencao;

import java.util.List;

public interface ManutencaoService {

    List<Manutencao> listarTodos();

    Manutencao create(Manutencao manutencao);

    Manutencao update(Manutencao manutencao);

    void delete(int id);
}
