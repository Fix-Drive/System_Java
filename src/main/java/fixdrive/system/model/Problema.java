package fixdrive.system.model;

public class Problema {
    private Long idProblema;
    private String tipoProblema;
    private String descricao;
    private int pontuacaoGravidade;
    private Long idAutomovel;

    // Getters e Setters
    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontuacaoGravidade() {
        return pontuacaoGravidade;
    }

    public void setPontuacaoGravidade(int pontuacaoGravidade) {
        this.pontuacaoGravidade = pontuacaoGravidade;
    }

    public Long getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Long idAutomovel) {
        this.idAutomovel = idAutomovel;
    }
}
