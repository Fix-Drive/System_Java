package fixdrive.system.model;

public class Feedback {
    private Long idFeedback;
    private String dsComentarioAvaliativo;
    private Integer nrPontuacaoAvaliativa;
    private Long idDiagnostico;

    // Getters e Setters
    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
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
