package fixdrive.system.entities;

public class Automovel {

    private Integer id;
    private String placaAutomovel;
    private String marcaAutomovel;
    private String modeloAutomovel;
    private long numeroChassi;
    private long codigoRenavam;
    private int anoAutomovel;
    private String porteAutomovel;


    public Automovel() {

    }


    public Automovel(Integer id, String placaAutomovel, String marcaAutomovel, String modeloAutomovel, long numeroChassi, long codigoRenavam, int anoAutomovel, String porteAutomovel) {
        this.id = id;
        this.placaAutomovel = placaAutomovel;
        this.marcaAutomovel = marcaAutomovel;
        this.modeloAutomovel = modeloAutomovel;
        this.numeroChassi = numeroChassi;
        this.codigoRenavam = codigoRenavam;
        this.anoAutomovel = anoAutomovel;
        this.porteAutomovel = porteAutomovel;
    }

    public Automovel(String placaAutomovel, String marcaAutomovel, String modeloAutomovel, int anoAutomovel, Long numeroChassi, Long codigoRenavam, String porteAutomovel) {
    }

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




    public long getNumeroChassi() {

        return numeroChassi;
    }




    public void setNumeroChassi(long numeroChassi) {

        this.numeroChassi = numeroChassi;
    }




    public long getCodigoRenavam() {

        return codigoRenavam;
    }




    public void setCodigoRenavam(long codigoRenavam) {

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
