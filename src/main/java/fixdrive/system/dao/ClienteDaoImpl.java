package fixdrive.system.dao;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.entities.Cliente;
import fixdrive.system.exceptions.ClienteNotFound;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClienteDaoImpl implements ClienteDao {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public Cliente create(Cliente cliente)  {
        final String sql = "INSERT INTO T_VB_CLIENTE(nm_cliente, ds_email, ds_senha, nr_cpf, nr_rg, idade, ds_endereco, nr_cnh, dt_validade_cnh, nr_telefone) values (?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getSenha());
            stmt.setLong(5, cliente.getNumeroCpf());
            stmt.setLong(6, cliente.getNumeroRg());
            stmt.setString(7, cliente.getEndereco());
            stmt.setLong(8, cliente.getNumeroCnh());
            stmt.setDate(9, java.sql.Date.valueOf(cliente.getDataValidadeCnh()));
            stmt.setLong(10, cliente.getNumeroTelefone());
            stmt.executeUpdate();

        } catch (SQLException e) {
            this.logger.warning("Não foi possível inserir o cliente");

        }
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente, Connection connection) throws ClienteNotFound, SQLException {
        final String sql = "UPDATE INTO T_VB_CLIENTE SET NM_CLIENTE=?, IDADE=?, DS_EMAIL=? ,DS_SENHA=?, NR_CPF=?, NR_RG=?, DS_ENDERECO=?, NR_CNH=?, DT_VALIDADE_CNH=?, NR_TELEFONE=? WHERE ID=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getIdade());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getSenha());
        stmt.setLong(5, cliente.getNumeroCpf());
        stmt.setLong(6, cliente.getNumeroRg());
        stmt.setString(7, cliente.getEndereco());
        stmt.setLong(8, cliente.getNumeroCnh());
        stmt.setDate(9, Date.valueOf(cliente.getDataValidadeCnh()));
        stmt.setLong(10, cliente.getNumeroTelefone());
        stmt.setInt(11, cliente.getId());
        int alteracoes = stmt.executeUpdate();
        if (alteracoes != 1) {
            throw new ClienteNotFound(cliente.getId());
        }
        return cliente;

    }

    @Override
    public List<Cliente> findAll() {
        final List<Cliente> clientes = new ArrayList<>();
        final String sql = "SELECT * FROM T_VB_CLIENTE";
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nm_cliente"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEmail(rs.getString("ds_email"));
                cliente.setSenha(rs.getString("ds_senha"));
                cliente.setNumeroCpf(rs.getInt("nr_cpf"));
                cliente.setNumeroRg(rs.getInt("nr_rg"));
                cliente.setEndereco(rs.getString("ds_endereco"));
                cliente.setNumeroCnh(rs.getInt("nr_cnh"));
                cliente.setDataValidadeCnh(rs.getDate("dt_validade_cnh").toLocalDate());
                cliente.setNumeroTelefone(rs.getInt("nr_telefone"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            this.logger.warning("Não foi possível recuperar o cliente do banco de dados");

        }
        return clientes;
    }

    @Override
    public void deleteById(int id) throws SQLException, ClienteNotFound {
        final String sql = "DELETE FROM T_VB_CLIENTE WHERE  id_cliente=?";
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int exclusoes = stmt.executeUpdate();
            if (exclusoes != 1) {
                throw new ClienteNotFound(id);
            }
        }


    }

    @Override
    public Cliente findById(int id) throws ClienteNotFound, SQLException {
        final String sql = "SELECT * FROM T_VB_CLIENTE WHERE ID=?";
        Cliente clienteEncontrado = null;
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                clienteEncontrado = new Cliente();
                clienteEncontrado.setNome(rs.getString("nm_cliente"));
                clienteEncontrado.setIdade(rs.getInt("idade"));
                clienteEncontrado.setEmail(rs.getString("ds_email"));
                clienteEncontrado.setSenha(rs.getString("ds_senha"));
                clienteEncontrado.setNumeroCpf(rs.getInt("nr_cpf"));
                clienteEncontrado.setNumeroRg(rs.getInt("nr_rg"));
                clienteEncontrado.setEndereco(rs.getString("ds_endereco"));
                clienteEncontrado.setNumeroCnh(rs.getInt("nr_cnh"));
                clienteEncontrado.setDataValidadeCnh(rs.getDate("dt_validade_cnh").toLocalDate());
                clienteEncontrado.setNumeroTelefone(rs.getInt("nr_telefone"));

            } else {
                throw new ClienteNotFound(id);
            }

            return clienteEncontrado;
        }
    }
}
