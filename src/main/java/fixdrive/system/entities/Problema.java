package fixdrive.system.entities;

public class Problema {

    private Integer id;
    private String tipoProblema;
    private String descricaoProblema;
    private int gravidadeProblema;



    public Problema() {

    }

    public Problema(Integer id, String tipoProblema, String descricaoProblema, int gravidadeProblema) {
        this.id = id;
        this.tipoProblema = tipoProblema;
        this.descricaoProblema = descricaoProblema;
        this.gravidadeProblema = gravidadeProblema;
    }

    public Problema(String tipoProblema, String descricaoProblema, int gravidadeProblema) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public int getGravidadeProblema() {
        return gravidadeProblema;
    }

    public void setGravidadeProblema(int gravidadeProblema) {
        this.gravidadeProblema = gravidadeProblema;
    }
}
