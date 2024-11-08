package fixdrive.system.dto;

public class ProblemaDto {
    private Long id;
    private String tipoProblema;
    private String descricao;
    private int pontuacaoGravidade;
    private Long idAutomovel;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
