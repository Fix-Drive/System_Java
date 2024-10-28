package fixdrive.system.entities;

public class Diagnostico {

    private Integer id;
    private String resultadoDiagnostico;

    public Diagnostico() {

    }

    public Diagnostico(Integer id, String resultadoDiagnostico) {
        this.id = id;
        this.resultadoDiagnostico = resultadoDiagnostico;
    }

    public Diagnostico(String resultadoDiagnostico) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResultadoDiagnostico() {
        return resultadoDiagnostico;
    }

    public void setResultadoDiagnostico(String resultadoDiagnostico) {
        this.resultadoDiagnostico = resultadoDiagnostico;
    }
}
