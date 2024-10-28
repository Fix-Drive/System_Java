package fixdrive.system.service;

import fixdrive.system.entities.Diagnostico;

import java.util.List;

public interface DiagnosticoService {

    List<Diagnostico> listarTodos();

    Diagnostico create(Diagnostico diagnostico);

    Diagnostico update(Diagnostico diagnostico);

    void delete(int id);
}
