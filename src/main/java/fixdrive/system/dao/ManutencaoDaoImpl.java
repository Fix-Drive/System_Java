package fixdrive.system.dao;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.entities.Manutencao;
import fixdrive.system.entities.Problema;
import fixdrive.system.exceptions.ManutencaoNotFound;
import fixdrive.system.exceptions.ManutencaoNotIncluded;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ManutencaoDaoImpl implements ManutencaoDao{

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public Manutencao createManutencao(Manutencao manutencao) {
        final String sql = "INSERT INTO T_VB_MANUTENCAO(ds_tipo_manutencao, ds_descricao, ds_peca_manutencao, ds_recomendacao_oficina) VALUES (?,?,?,?)";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, manutencao.getTipoManutencao());
            stmt.setString(2, manutencao.getDescricaoManutencao());
            stmt.setString(3, manutencao.getTipoPeca());
            stmt.setString(4, manutencao.getRecomendacaoCentroAutomotivo());
            int linhasIncluidas = stmt.executeUpdate();
            if(linhasIncluidas != 1){
                throw new ManutencaoNotIncluded();
            }


        } catch (SQLException e) {
            this.log.warning("Não foi possível incluir a Manutenção");
        }
        return manutencao;
    }

    @Override
    public Manutencao updateManutencao(Manutencao manutencao, Connection connection) throws SQLException {
        final String sql = "UPDATE T_VB_MANUTENCAO SET ds_tipo_problema=?, ds_descricao=?, ds_peca_manutencao, ds_recomendacao_oficina=? WHERE id_manutencao=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, manutencao.getTipoManutencao());
        stmt.setString(2, manutencao.getDescricaoManutencao());
        stmt.setString(3, manutencao.getTipoPeca());
        stmt.setString(4, manutencao.getRecomendacaoCentroAutomotivo());
        int atualizacoes = stmt.executeUpdate();
        if(atualizacoes != 1){
            throw new ManutencaoNotFound(manutencao.getId());
        }
        return manutencao;
    }

    @Override
    public List<Manutencao> listarManutencoes() {
        final List<Manutencao> manutencoes = new ArrayList<>();
        final String sql = "SELECT * FROM T_VB_MANUTENCAO";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Manutencao manutencao = new Manutencao();
                manutencao.setId(rs.getInt("id_manutencao"));
                manutencao.setTipoManutencao(rs.getString("ds_tipo_manutencao"));
                manutencao.setDescricaoManutencao(rs.getString("ds_descricao"));
                manutencao.setTipoPeca(rs.getString("ds_peca_manutencao"));
                manutencao.setRecomendacaoCentroAutomotivo("ds_recomendacao_oficina");
                manutencoes.add(manutencao);

            }
        } catch (SQLException e) {
            this.log.warning("Não foi possível recuperar a Manutenção no banco de dados");
        }

        return manutencoes;
    }

    @Override
    public void deleteManutencaoById(int id) throws SQLException {
        final String sql = "DELETE FROM T_VB_MANUTENCAO WHERE id_manutencao=?";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int exclusoes = stmt.executeUpdate();
            if(exclusoes != 1){
                throw new ManutencaoNotFound(id);
            }

        }
    }

    @Override
    public Manutencao ManutencaoById(int id) throws SQLException {
        final String sql = "SELECT * FROM T_VB_MANUTENCAO WHERE id_manutencao=?";
        Manutencao manutencaoEncontrada = null;
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                manutencaoEncontrada = new Manutencao();
                manutencaoEncontrada.setId(rs.getInt("id_manutencao"));
                manutencaoEncontrada.setDescricaoManutencao("ds_descricao");
                manutencaoEncontrada.setTipoPeca(rs.getString("ds_peca_manutencao"));
                manutencaoEncontrada.setRecomendacaoCentroAutomotivo("ds_recomendacao_oficina");

            }else{
                throw new ManutencaoNotFound(id);
            }

        }
        return manutencaoEncontrada;
    }
}
