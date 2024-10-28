package fixdrive.system.service;

import fixdrive.system.entities.Problema;

import java.util.List;

public interface ProblemaService {

    List<Problema> listarTodos();

    Problema create(Problema problema);

    Problema update(Problema problema);

    void delete(int id);
}
