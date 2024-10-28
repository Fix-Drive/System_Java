package fixdrive.system.dao;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.entities.Automovel;
import fixdrive.system.exceptions.AutomovelNotFound;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AutomovelDaoImpl implements AutomovelDao{


    private final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public Automovel createAutomovel(Automovel automovel) {
        final String sql = "INSERT INTO T_VB_AUTOMOVEL(placa_automovel, ds_marca_automovel, ds_modelo_automovel, ano_automovel, cd_chassi, cd_renavam) VALUES (?,?,?,?,?,?)";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, automovel.getPlacaAutomovel());
            stmt.setString(2, automovel.getMarcaAutomovel());
            stmt.setString(3, automovel.getModeloAutomovel());
            stmt.setInt(4, automovel.getAnoAutomovel());
            stmt.setLong(5, automovel.getNumeroChassi());
            stmt.setLong(6, automovel.getCodigoRenavam());
            stmt.executeUpdate();

        } catch (SQLException e) {
            this.log.warning("Não foi possível incluir o Automóvel.");
        }
        return automovel;
    }


    @Override
    public Automovel updateAutomovel(Automovel automovel, Connection connection) throws SQLException, AutomovelNotFound {
        final String sql = "UPDATE INTO T_VB_AUTOMOVEL SET placa_automovel=?, ds_marca_automovel=?, ds_modelo_automovel=?, ano_automovel=?, cd_chassi=?, cd_renavam=? WHERE id_automovel=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, automovel.getPlacaAutomovel());
        stmt.setString(2, automovel.getMarcaAutomovel());
        stmt.setString(3, automovel.getModeloAutomovel());
        stmt.setInt(4, automovel.getAnoAutomovel());
        stmt.setLong(5, automovel.getNumeroChassi());
        stmt.setLong(6, automovel.getCodigoRenavam());
        int atualizacoes = stmt.executeUpdate();
        if (atualizacoes != 1) {
            throw new AutomovelNotFound(automovel.getId());
        }
        return automovel;
    }


    @Override
    public List<Automovel> listAutomoveis() {
        final List<Automovel> automoveis = new ArrayList<>();
        final String sql = "SELECT * FROM T_VB_AUTOMOVEL";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Automovel automovel = new Automovel();
                automovel.setId(rs.getInt("id_automovel"));
                automovel.setPlacaAutomovel(rs.getString("placa_automovel"));
                automovel.setMarcaAutomovel(rs.getString("marca_automovel"));
                automovel.setModeloAutomovel(rs.getString("modelo_automovel"));
                automovel.setAnoAutomovel(rs.getInt("ano_automovel"));
                automovel.setNumeroChassi(rs.getLong("cd_chassi"));
                automovel.setCodigoRenavam(rs.getLong("cd_renavam"));
                automoveis.add(automovel);
            }
        } catch (SQLException e) {
            this.log.warning("Não foi possível recuperar o Automóvel no banco de dados.");
        }
        return automoveis;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        final String sql = "DELETE FROM T_VB_AUTOMOVEL WHERE id_automovel=?";
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int exclusoes = stmt.executeUpdate();
            if (exclusoes != 1) {
                throw new AutomovelNotFound(id);
            }
        }

    }

    @Override
    public Automovel findById(int id) throws SQLException {
        final String sql = "SELECT * FROM T_VB_AUTOMOVEL WHERE id_automovel=?";
        Automovel automovelEncontrado = null;
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                automovelEncontrado = new Automovel();
                automovelEncontrado.setId(rs.getInt("id_automovel"));
                automovelEncontrado.setPlacaAutomovel(rs.getString("placa_automovel"));
                automovelEncontrado.setMarcaAutomovel(rs.getString("marca_automovel"));
                automovelEncontrado.setModeloAutomovel(rs.getString("modelo_automovel"));
                automovelEncontrado.setAnoAutomovel(rs.getInt("ano_automovel"));
                automovelEncontrado.setNumeroChassi(rs.getLong("cd_chassi"));
                automovelEncontrado.setCodigoRenavam(rs.getLong("cd_renavam"));

            } else {
                throw new AutomovelNotFound(id);
            }
        }
        return automovelEncontrado;
    }
}
