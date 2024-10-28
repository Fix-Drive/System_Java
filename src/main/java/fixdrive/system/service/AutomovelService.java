package fixdrive.system.service;

import fixdrive.system.entities.Automovel;

import java.sql.SQLException;
import java.util.List;

public interface AutomovelService {

    List<Automovel> listarTodos();

    Automovel create(Automovel automovel);

    Automovel update(Automovel automovel);

    void delete(int id);
}
