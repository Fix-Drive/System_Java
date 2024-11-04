package fixdrive.system.model;

public class Manutencao {
    private Long idManutencao;
    private String tipoManutencao;
    private String descricao;
    private String pecaManutencao;
    private String recomendacaoOficina;
    private Long idDiagnostico;
    private Long idProblema;
    private Long idAutomovel;

    // Getters e Setters
    public Long getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }

    public String getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPecaManutencao() {
        return pecaManutencao;
    }

    public void setPecaManutencao(String pecaManutencao) {
        this.pecaManutencao = pecaManutencao;
    }

    public String getRecomendacaoOficina() {
        return recomendacaoOficina;
    }

    public void setRecomendacaoOficina(String recomendacaoOficina) {
        this.recomendacaoOficina = recomendacaoOficina;
    }

    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
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
