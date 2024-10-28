package fixdrive.system.dao;

public class AutomovelDaoFactory {

    private AutomovelDaoFactory(){

    }
    public static AutomovelDao createAutomovelDaoImpl(){
        return new AutomovelDaoImpl();
    }
}
