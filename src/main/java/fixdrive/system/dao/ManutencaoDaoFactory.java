package fixdrive.system.dao;

public class ManutencaoDaoFactory {

    private ManutencaoDaoFactory(){

    }

    public static ManutencaoDao createManutencaoDaoImpl(){
        return new ManutencaoDaoImpl();
    }
}
