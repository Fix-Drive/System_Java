package fixdrive.system.dao;

public class ProblemaDaoFactory {

    private ProblemaDaoFactory(){

    }

    public static ProblemaDao createProblemaDaoImpl(){
        return new ProblemaDaoImpl();
    }
}
