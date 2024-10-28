package fixdrive.system.dao;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.entities.Problema;
import fixdrive.system.exceptions.ProblemaNotFound;
import fixdrive.system.exceptions.ProblemaNotIncluded;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProblemaDaoImpl implements ProblemaDao {


    private final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public Problema createProblema(Problema problema) {
        final String sql = "INSERT INTO T_VB_PROBLEMA(ds_tipo_problema, ds_descricao, ds_gravidade_problema) VALUES (?,?,?)";
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, problema.getTipoProblema());
            stmt.setString(2, problema.getDescricaoProblema());
            stmt.setInt(3, problema.getGravidadeProblema());
            int linhasIncluidas = stmt.executeUpdate();
            if (linhasIncluidas == 0) {
                throw new ProblemaNotIncluded();
            }

        } catch (SQLException e) {
            this.log.warning("Não foi possível incluir o Problema");
        }
        return problema;
    }

    @Override
    public Problema updateProblema(Problema problema, Connection connection) throws SQLException {
        final String sql = "UPDATE INTO T_VB_PROBLEMA SET ds_tipo_problema=?, ds_descricao=?, ds_gravidade_problema=? WHERE id_problema=? ";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, problema.getTipoProblema());
        stmt.setString(2, problema.getDescricaoProblema());
        stmt.setInt(3, problema.getGravidadeProblema());
        int atualizacoes = stmt.executeUpdate();
        if (atualizacoes != 1) {
            throw new ProblemaNotFound(problema.getId());
        }

        return problema;
    }

    @Override
    public List<Problema> listarProblemas() {
        final List<Problema> problemas = new ArrayList<>();
        final String sql = "SELECT * FROM T_VB_PROBLEMA";
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Problema problema = new Problema();
                problema.setId(rs.getInt("id_problema"));
                problema.setTipoProblema(rs.getString("ds_tipo_problema"));
                problema.setDescricaoProblema(rs.getString("ds_descricao"));
                problema.setGravidadeProblema(rs.getInt("ds_gravidade_problema"));
                problemas.add(problema);
            }

        } catch (SQLException e) {
            this.log.warning("Não foi possível recuperar o Problema no banco de dados");
        }
        return problemas;
    }

    @Override
    public void deleteProblemaById(int id) throws SQLException {
        final String sql = "DELETE FROM T_VB_PROBLEMA WHERE id_problema=?";
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int exclusoes = stmt.executeUpdate();
            if (exclusoes != 1) {
                throw new ProblemaNotFound(id);
            }
        }
    }

    @Override
    public Problema problemaById(int id) throws SQLException {
        final String sql = "SELECT * FROM T_VB_PROBLEMA WHERE id_problema=?";
        Problema problemaEncontrado = null;
        try (Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                problemaEncontrado = new Problema();
                problemaEncontrado.setId(rs.getInt("id_problema"));
                problemaEncontrado.setTipoProblema(rs.getString("ds_tipo_problema"));
                problemaEncontrado.setDescricaoProblema(rs.getString("ds_descricao"));
                problemaEncontrado.setGravidadeProblema(rs.getInt("ds_gravidade_problema"));

            } else {
                throw new ProblemaNotFound(id);
            }
            return problemaEncontrado;
        }
    }
}
