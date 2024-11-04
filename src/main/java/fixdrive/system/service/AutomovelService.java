package fixdrive.system.service;

import fixdrive.system.model.Automovel;

import java.sql.SQLException;
import java.util.List;

public interface AutomovelService {
    Automovel getAutomovelById(Long id) throws SQLException;
    List<Automovel> getAllAutomoveis() throws SQLException;
    Automovel createAutomovel(Automovel automovel) throws SQLException;
    void updateAutomovel(Automovel automovel) throws SQLException;
    void deleteAutomovel(Long id) throws SQLException;
}
