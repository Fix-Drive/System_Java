package fixdrive.system.dao;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.entities.Orcamento;
import fixdrive.system.exceptions.OrcamentoNotFound;
import fixdrive.system.exceptions.OrcamentoNotIncluded;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrcamentoDaoImpl implements OrcamentoDao{


    private final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public Orcamento createOrcamento(Orcamento orcamento) {
        final String sql = "INSERT INTO T_VB_ORCAMENTO(vl_peca, vl_servico) VALUES(?,?)";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, orcamento.getValorPeca());
            stmt.setDouble(2, orcamento.getValorServico());
            int linhasIncluidas = stmt.executeUpdate();
            if (linhasIncluidas != 1){
                throw new OrcamentoNotIncluded();
            }

        } catch (SQLException e) {
            this.log.warning("Não foi possível inserir o Orçamento");
        }
        return orcamento;
    }

    @Override
    public Orcamento updateOrcamento(Orcamento orcamento, Connection connection) throws SQLException {
        final String sql = "UPDATE INTO T_VB_ORCAMENTO SET vl_peca = ?, vl_servico = ? WHERE id_orcamento = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setDouble(1, orcamento.getValorPeca());
        stmt.setDouble(2, orcamento.getValorServico());
        int atualizacoes = stmt.executeUpdate();
        if (atualizacoes != 1){
            throw new OrcamentoNotFound(orcamento.getId());
        }
        return null;
    }

    @Override
    public List<Orcamento> listarOrcamentos() {
        final List<Orcamento> orcamentos = new ArrayList<>();
        final String sql = "SELECT * FROM T_VB_ORCAMENTO";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Orcamento orcamento = new Orcamento();
                orcamento.setId(rs.getInt("id_orcamento"));
                orcamento.setValorPeca(rs.getDouble("vl_peca"));
                orcamento.setValorServico(rs.getDouble("vl_servico"));
                orcamentos.add(orcamento);
            }
        } catch (Exception e) {
            this.log.warning("Não foi possível recuperar o Orçamento no banco de dados");
        }
        return orcamentos;
    }

    @Override
    public void deleteOrcamento(int id) throws SQLException {
        final String sql = "DELETE FROM T_VB_ORCAMENTO WHERE id_orcamento = ?";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int exclusoes = stmt.executeUpdate();
            if (exclusoes != 1){
                throw new OrcamentoNotFound(id);
            }
        }

    }

    @Override
    public Orcamento orcamentoById(int id) throws SQLException {
        final String sql = "SELECT * FROM T_VB_ORCAMENTO WHERE id_orcamento = ?";
        Orcamento orcamentoEncontrado = null;
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                orcamentoEncontrado = new Orcamento();
                orcamentoEncontrado.setId(rs.getInt("id_orcamento"));
                orcamentoEncontrado.setValorPeca(rs.getDouble("vl_peca"));
                orcamentoEncontrado.setValorServico(rs.getDouble("vl_servico"));
            } else{
                throw new OrcamentoNotFound(id);
            }
        }
        return orcamentoEncontrado;
    }
}
