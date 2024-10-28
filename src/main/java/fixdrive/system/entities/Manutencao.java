package fixdrive.system.entities;

public class Manutencao {

    private Integer id;
    private String tipoManutencao;
    private String descricaoManutencao;
    private String tipoPeca;
    private String recomendacaoCentroAutomotivo;


    public Manutencao() {
    }

    public Manutencao(Integer id, String tipoManutencao, String descricaoManutencao, String tipoPeca, String recomendacaoCentroAutomotivo) {
        this.id = id;
        this.tipoManutencao = tipoManutencao;
        this.descricaoManutencao = descricaoManutencao;
        this.tipoPeca = tipoPeca;
        this.recomendacaoCentroAutomotivo = recomendacaoCentroAutomotivo;
    }

    public Manutencao(String tipoManutencao, String descricaoManutencao, String tipoPeca, String recomendacaoCentroAutomotivo) {
    }

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






