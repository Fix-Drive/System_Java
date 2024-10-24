package fixdrive.system.entities;

public class Problema {
    private int tipoProblema;
    private String descricaoProblema;
    private int gravidadeProblema;


    public Problema(int tipoProblema, String descricaoProblema, int gravidadeProblema) {
        this.tipoProblema = tipoProblema;
        this.descricaoProblema = descricaoProblema;
        this.gravidadeProblema = gravidadeProblema;
    }

    public Problema() {

    }

    public int getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(int tipoProblema) {
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

    public void registrarProblema(int tipoProblema, String descricaoProblema) {
        this.tipoProblema = tipoProblema;
        this.descricaoProblema = descricaoProblema;
    }

    public void classificarGravidade(int gravidadeProblema) {
        try {
            if (getGravidadeProblema() >= 0 && getGravidadeProblema() <= 5) {
                this.gravidadeProblema = gravidadeProblema;

            } else {
                throw new Exception("Erro. Gravidade é classificada de 0 a 5");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
