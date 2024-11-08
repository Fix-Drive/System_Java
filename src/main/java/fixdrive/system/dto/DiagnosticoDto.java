package fixdrive.system.dto;

public class DiagnosticoDto {
    private Long id;
    private String resultadoDiagnostico;
    private Long idProblema;
    private Long idAutomovel;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResultadoDiagnostico() {
        return resultadoDiagnostico;
    }

    public void setResultadoDiagnostico(String resultadoDiagnostico) {
        this.resultadoDiagnostico = resultadoDiagnostico;
    }

    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public Long getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Long idAutomovel) {
        this.idAutomovel = idAutomovel;
    }
}
