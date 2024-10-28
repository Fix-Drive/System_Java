package fixdrive.system.dao;

import fixdrive.system.connection.ConnectionDb;
import fixdrive.system.entities.Diagnostico;
import fixdrive.system.exceptions.DiagnosticoNotFound;
import fixdrive.system.exceptions.DiagnosticoNotIncluded;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DiagnosticoDaoImpl implements DiagnosticoDao {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public Diagnostico createDiagnostico(Diagnostico diagnostico) {
        final String sql = "INSERT INTO T_VB_DIAGNOSTICO(ds_resultado_diagnostico) VALUES (?)";
        try(Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, diagnostico.getResultadoDiagnostico());
            int linhasIncluidas = stmt.executeUpdate();
            if(linhasIncluidas != 1) {
                throw new DiagnosticoNotIncluded();

            }

        } catch (SQLException e) {
            this.log.warning("Não foi possível inserir o diagnostico ");
        }
        return diagnostico;
    }

    @Override
    public Diagnostico updateDiagnostico(Diagnostico diagnostico, Connection connection) throws SQLException {
        final String sql = "UPDATE INTO T_VB_DIAGNOSTICO SET ds_resultado_diagnostico = ? WHERE id_diagnostico = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, diagnostico.getResultadoDiagnostico());
        int atualizacoes = stmt.executeUpdate();
        if(atualizacoes != 1) {
            throw new DiagnosticoNotFound(diagnostico.getId());
        }
        return diagnostico;
    }

    @Override
    public List<Diagnostico> listarDiagnosticos() {
        final List<Diagnostico> diagnosticos = new ArrayList<>();
        final String sql = "SELECT * FROM T_VB_DIAGNOSTICO";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Diagnostico diagnostico = new Diagnostico();
                diagnostico.setId(rs.getInt("id_diagnostico"));
                diagnostico.setResultadoDiagnostico(rs.getString("ds_resultado_diagnostico"));
                diagnosticos.add(diagnostico);
            }

        } catch (Exception e) {
            this.log.warning("Não foi possível recuperar o Diagnóstico no banco de dados");
        }
        return diagnosticos;
    }

    @Override
    public void deleteDiagnostico(int id) throws SQLException {
        final String sql = "DELETE FROM T_VB_DIAGNOSTICO WHERE id_diagnostico = ?";
        try(Connection connection = ConnectionDb.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int exclusoes = stmt.executeUpdate();
            if(exclusoes != 1) {
                throw new DiagnosticoNotFound(id);
            }

        }

    }

    @Override
    public Diagnostico DiagnosticoById(int id) throws SQLException {
        final String sql = "SELECT * FROM T_VB_DIAGNOSTICO WHERE id_diagnostico = ?";
        Diagnostico diagnosticoEncontrado = null;
        try(Connection connection = ConnectionDb.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                diagnosticoEncontrado = new Diagnostico();
                diagnosticoEncontrado.setId(rs.getInt("id_diagnostico"));
                diagnosticoEncontrado.setResultadoDiagnostico(rs.getString("ds_resultado_diagnostico"));

            }else{
                throw new DiagnosticoNotFound(id);
            }

        }
        return diagnosticoEncontrado;
    }
}
