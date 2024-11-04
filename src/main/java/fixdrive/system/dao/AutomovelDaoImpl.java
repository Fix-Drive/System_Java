package fixdrive.system.dao;

import fixdrive.system.model.Automovel;
import fixdrive.system.connection.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDaoImpl implements AutomovelDao {

    @Override
    public Automovel findById(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VB_AUTOMOVEL WHERE ID_AUTOMOVEL = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToAutomovel(rs);
            }
        }
        return null;
    }

    @Override
    public List<Automovel> findAll() throws SQLException {
        List<Automovel> automoveis = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_AUTOMOVEL";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                automoveis.add(mapResultSetToAutomovel(rs));
            }
        }
        return automoveis;
    }

    @Override
    public Automovel createAutomovel(Automovel automovel) throws SQLException {
        String sql = "INSERT INTO T_VB_AUTOMOVEL (ID_AUTOMOVEL, PLACA_AUTOMOVEL, DS_TIPO_AUTOMOVEL, DS_MARCA_AUTOMOVEL, " +
                "DS_MODELO_AUTOMOVEL, DS_PORTE_AUTOMOVEL, ANO_AUTOMOVEL, CD_CHASSI, CD_RENAVAM, ID_CLIENTE) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, automovel.getIdAutomovel()); // ID gerado manualmente
            stmt.setString(2, automovel.getPlacaAutomovel());
            stmt.setString(3, automovel.getTipoAutomovel());
            stmt.setString(4, automovel.getMarcaAutomovel());
            stmt.setString(5, automovel.getModeloAutomovel());
            stmt.setString(6, automovel.getPorteAutomovel());
            stmt.setInt(7, automovel.getAnoAutomovel());
            stmt.setString(8, automovel.getNumeroChassi());
            stmt.setLong(9, automovel.getCodigoRenavam());
            stmt.setLong(10, automovel.getIdCliente());

            stmt.executeUpdate();
        }
        return automovel;
    }

    @Override
    public void update(Automovel automovel) throws SQLException {
        String sql = "UPDATE T_VB_AUTOMOVEL SET PLACA_AUTOMOVEL = ?, DS_TIPO_AUTOMOVEL = ?, DS_MARCA_AUTOMOVEL = ?, " +
                "DS_MODELO_AUTOMOVEL = ?, DS_PORTE_AUTOMOVEL = ?, ANO_AUTOMOVEL = ?, CD_CHASSI = ?, CD_RENAVAM = ?, " +
                "ID_CLIENTE = ? WHERE ID_AUTOMOVEL = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, automovel.getPlacaAutomovel());
            stmt.setString(2, automovel.getTipoAutomovel());
            stmt.setString(3, automovel.getMarcaAutomovel());
            stmt.setString(4, automovel.getModeloAutomovel());
            stmt.setString(5, automovel.getPorteAutomovel());
            stmt.setInt(6, automovel.getAnoAutomovel());
            stmt.setString(7, automovel.getNumeroChassi());
            stmt.setLong(8, automovel.getCodigoRenavam());
            stmt.setLong(9, automovel.getIdCliente());
            stmt.setLong(10, automovel.getIdAutomovel());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM T_VB_AUTOMOVEL WHERE ID_AUTOMOVEL = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Automovel mapResultSetToAutomovel(ResultSet rs) throws SQLException {
        Automovel automovel = new Automovel();
        automovel.setIdAutomovel(rs.getLong("ID_AUTOMOVEL"));
        automovel.setPlacaAutomovel(rs.getString("PLACA_AUTOMOVEL"));
        automovel.setTipoAutomovel(rs.getString("DS_TIPO_AUTOMOVEL"));
        automovel.setMarcaAutomovel(rs.getString("DS_MARCA_AUTOMOVEL"));
        automovel.setModeloAutomovel(rs.getString("DS_MODELO_AUTOMOVEL"));
        automovel.setPorteAutomovel(rs.getString("DS_PORTE_AUTOMOVEL"));
        automovel.setAnoAutomovel(rs.getInt("ANO_AUTOMOVEL"));
        automovel.setNumeroChassi(rs.getString("CD_CHASSI"));
        automovel.setCodigoRenavam(rs.getLong("CD_RENAVAM"));
        automovel.setIdCliente(rs.getLong("ID_CLIENTE"));
        return automovel;
    }
}
