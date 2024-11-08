package fixdrive.system.dto;

public class ManutencaoDto {
    private Long id;
    private String tipoManutencao;
    private String descricao;
    private String pecaManutencao;
    private String recomendacaoOficina;
    private Long idDiagnostico;
    private Long idProblema;
    private Long idAutomovel;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
