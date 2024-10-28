package fixdrive.system.dto;

public class ManutencaoDto {

    private Integer id;

    private String tipoManutencao;

    private String descricaoManutencao;

    private String tipoPeca;

    private String recomendacaoCentroAutomotivo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }

    public String getDescricaoManutencao() {
        return descricaoManutencao;
    }

    public void setDescricaoManutencao(String descricaoManutencao) {
        this.descricaoManutencao = descricaoManutencao;
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getRecomendacaoCentroAutomotivo() {
        return recomendacaoCentroAutomotivo;
    }

    public void setRecomendacaoCentroAutomotivo(String recomendacaoCentroAutomotivo) {
        this.recomendacaoCentroAutomotivo = recomendacaoCentroAutomotivo;
    }
}
