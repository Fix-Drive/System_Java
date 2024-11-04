package fixdrive.system.dto;

public class FeedbackDto {
    private Long id;
    private String dsComentarioAvaliativo;
    private Integer nrPontuacaoAvaliativa;
    private Long idDiagnostico;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDsComentarioAvaliativo() {
        return dsComentarioAvaliativo;
    }

    public void setDsComentarioAvaliativo(String dsComentarioAvaliativo) {
        this.dsComentarioAvaliativo = dsComentarioAvaliativo;
    }

    public Integer getNrPontuacaoAvaliativa() {
        return nrPontuacaoAvaliativa;
    }

    public void setNrPontuacaoAvaliativa(Integer nrPontuacaoAvaliativa) {
        this.nrPontuacaoAvaliativa = nrPontuacaoAvaliativa;
    }

    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
}
