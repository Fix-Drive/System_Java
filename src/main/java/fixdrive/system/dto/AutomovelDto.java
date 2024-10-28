package fixdrive.system.dto;

public class AutomovelDto {

    private Integer id;

    private String placaAutomovel;

    private String marcaAutomovel;

    private String modeloAutomovel;

    private Long numeroChassi;

    private Long codigoRenavam;

    private int anoAutomovel;

    private String porteAutomovel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlacaAutomovel() {
        return placaAutomovel;
    }

    public void setPlacaAutomovel(String placaAutomovel) {
        this.placaAutomovel = placaAutomovel;
    }

    public String getMarcaAutomovel() {
        return marcaAutomovel;
    }

    public void setMarcaAutomovel(String marcaAutomovel) {
        this.marcaAutomovel = marcaAutomovel;
    }

    public String getModeloAutomovel() {
        return modeloAutomovel;
    }

    public void setModeloAutomovel(String modeloAutomovel) {
        this.modeloAutomovel = modeloAutomovel;
    }

    public Long getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(Long numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public Long getCodigoRenavam() {
        return codigoRenavam;
    }

    public void setCodigoRenavam(Long codigoRenavam) {
        this.codigoRenavam = codigoRenavam;
    }

    public int getAnoAutomovel() {
        return anoAutomovel;
    }

    public void setAnoAutomovel(int anoAutomovel) {
        this.anoAutomovel = anoAutomovel;
    }

    public String getPorteAutomovel() {
        return porteAutomovel;
    }

    public void setPorteAutomovel(String porteAutomovel) {
        this.porteAutomovel = porteAutomovel;
    }
}
