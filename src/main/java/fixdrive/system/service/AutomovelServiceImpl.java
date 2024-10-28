package fixdrive.system.service;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.dao.AutomovelDao;
import fixdrive.system.dao.AutomovelDaoFactory;
import fixdrive.system.entities.Automovel;
import fixdrive.system.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AutomovelServiceImpl implements AutomovelService{

    private AutomovelDao automovelDao = AutomovelDaoFactory.createAutomovelDaoImpl();




    @Override
    public List<Automovel> listarTodos() {
        return this.automovelDao.listAutomoveis();
    }

    @Override
    public Automovel create(Automovel automovel) {
        if (automovel.getId() != null){
            throw new AutomovelInvalid();
        }
        validarAutomovel(automovel);
        return this.automovelDao.createAutomovel(automovel);
    }

    @Override
    public Automovel update(Automovel automovel) throws AutomovelNotUpdate, AutomovelNotFound {
        try(Connection connection = ConnectionDb.getInstance().getConnection()) {
            automovel = this.automovelDao.updateAutomovel(automovel, connection);
            connection.commit();
        } catch (SQLException | ClienteNotFound e) {
            throw new AutomovelNotUpdate();
        }
        return automovel;
    }

    @Override
    public void delete(int id) {
        try {
            this.automovelDao.deleteById(id);

        } catch (SQLException e) {
            throw new AutomovelNotFound(id);
        }

    }

    public void validarAutomovel(Automovel automovel){
        if (automovel.getPlacaAutomovel().length() != 7){
            throw new IllegalArgumentException("A placa do automóvel deve possuir 7 caracteres");
        }

    }
}
