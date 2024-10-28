package fixdrive.system.dao;

public class OrcamentoDaoFactory {

    private OrcamentoDaoFactory(){

    }

    public static OrcamentoDao createOrcamentoDaoImpl(){
        return new OrcamentoDaoImpl();
    }
}
