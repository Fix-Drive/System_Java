package fixdrive.system.dao;

import fixdrive.system.model.Cliente;
import fixdrive.system.connection.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public Cliente findById(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VB_CLIENTE WHERE ID_CLIENTE = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToCliente(rs);
            }
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM T_VB_CLIENTE";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clientes.add(mapResultSetToCliente(rs));
            }
        }
        return clientes;
    }

    @Override
    public Cliente createCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO T_VB_CLIENTE (ID_CLIENTE, NM_CLIENTE, IDADE_CLIENTE, DS_EMAIL, DS_SENHA, NR_CPF, NR_RG, DS_ENDERECO, NR_CNH, NR_TELEFONE) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, cliente.getIdCliente()); // ID gerado manualmente
            stmt.setString(2, cliente.getNmCliente());
            stmt.setInt(3, cliente.getIdadeCliente());
            stmt.setString(4, cliente.getDsEmail());
            stmt.setString(5, cliente.getDsSenha());
            stmt.setLong(6, cliente.getNrCpf());
            stmt.setLong(7, cliente.getNrRg());
            stmt.setString(8, cliente.getDsEndereco());
            stmt.setLong(9, cliente.getNrCnh());
            stmt.setLong(10, cliente.getNrTelefone());

            stmt.executeUpdate();
        }
        return cliente;
    }

    @Override
    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE T_VB_CLIENTE SET NM_CLIENTE = ?, IDADE_CLIENTE = ?, DS_EMAIL = ?, DS_SENHA = ?, NR_CPF = ?, NR_RG = ?, DS_ENDERECO = ?, NR_CNH = ?, NR_TELEFONE = ? " +
                "WHERE ID_CLIENTE = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNmCliente());
            stmt.setInt(2, cliente.getIdadeCliente());
            stmt.setString(3, cliente.getDsEmail());
            stmt.setString(4, cliente.getDsSenha());
            stmt.setLong(5, cliente.getNrCpf());
            stmt.setLong(6, cliente.getNrRg());
            stmt.setString(7, cliente.getDsEndereco());
            stmt.setLong(8, cliente.getNrCnh());
            stmt.setLong(9, cliente.getNrTelefone());
            stmt.setLong(10, cliente.getIdCliente());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM T_VB_CLIENTE WHERE ID_CLIENTE = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Cliente mapResultSetToCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getLong("ID_CLIENTE"));
        cliente.setNmCliente(rs.getString("NM_CLIENTE"));
        cliente.setIdadeCliente(rs.getInt("IDADE_CLIENTE"));
        cliente.setDsEmail(rs.getString("DS_EMAIL"));
        cliente.setDsSenha(rs.getString("DS_SENHA"));
        cliente.setNrCpf(rs.getLong("NR_CPF"));
        cliente.setNrRg(rs.getLong("NR_RG"));
        cliente.setDsEndereco(rs.getString("DS_ENDERECO"));
        cliente.setNrCnh(rs.getLong("NR_CNH"));
        cliente.setNrTelefone(rs.getLong("NR_TELEFONE"));
        return cliente;
    }
}
