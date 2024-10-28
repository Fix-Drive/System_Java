package fixdrive.system.dao;

import fixdrive.system.entities.Diagnostico;
import fixdrive.system.entities.Manutencao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DiagnosticoDao {


    Diagnostico createDiagnostico(Diagnostico diagnostico);

    Diagnostico updateDiagnostico(Diagnostico diagnostico, Connection connection) throws SQLException;

    List<Diagnostico> listarDiagnosticos();

    void deleteDiagnostico(int id) throws SQLException;

    Diagnostico DiagnosticoById(int id) throws SQLException;


}
