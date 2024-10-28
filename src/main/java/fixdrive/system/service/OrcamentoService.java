package fixdrive.system.service;

import fixdrive.system.entities.Orcamento;

import java.util.List;

public interface OrcamentoService {

    List<Orcamento> listarTodos();

    Orcamento create(Orcamento orcamento);

    Orcamento update(Orcamento orcamento);

    void delete(int id);
}
