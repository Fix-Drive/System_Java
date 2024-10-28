package fixdrive.system.service;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.dao.ManutencaoDao;
import fixdrive.system.dao.ManutencaoDaoFactory;
import fixdrive.system.entities.Manutencao;
import fixdrive.system.exceptions.ManutencaoInvalid;
import fixdrive.system.exceptions.ManutencaoNotFound;
import fixdrive.system.exceptions.ManutencaoNotUpdate;

import java.sql.Connection;
import java.util.List;

public class ManutencaoServiceImpl implements ManutencaoService {


    private ManutencaoDao manutencaoDao = ManutencaoDaoFactory.createManutencaoDaoImpl();


    @Override
    public List<Manutencao> listarTodos() {
        return this.manutencaoDao.listarManutencoes();
    }

    @Override
    public Manutencao create(Manutencao manutencao) {
        if (manutencao.getId() == null){
            throw new ManutencaoInvalid();
        }
        return this.manutencaoDao.createManutencao(manutencao);
    }

    @Override
    public Manutencao update(Manutencao manutencao) {
        try (Connection connection = ConnectionDb.getInstance().getConnection()){
            manutencao = this.manutencaoDao.updateManutencao(manutencao, connection);
            connection.commit();

        } catch (Exception e){
            throw new ManutencaoNotUpdate();
        }
        return manutencao;
    }

    @Override
    public void delete(int id) {
        try{
            this.manutencaoDao.deleteManutencaoById(id);
        } catch (Exception e){
            throw new ManutencaoNotFound(id);
        }

    }
}
