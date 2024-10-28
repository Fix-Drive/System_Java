package fixdrive.system.dto;

public class ProblemaDto {

    private Integer id;

    private String tipoProblema;

    private String descricaoProblema;

    private int gravidadeProblema;


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

    public void setGravidadeProblema() {
        this.gravidadeProblema = gravidadeProblema;
    }
}
