package fixdrive.system.dao;

public class DiagnosticoDaoFactory {

    private DiagnosticoDaoFactory(){

    }

    public static DiagnosticoDao createDiagnosticoDaoImpl(){
        return new DiagnosticoDaoImpl();
    }
}
