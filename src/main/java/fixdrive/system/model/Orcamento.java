package fixdrive.system.model;

public class Orcamento {
    private Long idOrcamento;
    private Double vlPeca;
    private Double vlServico;
    private Long idManutencao;

    // Getters e Setters
    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Double getVlPeca() {
        return vlPeca;
    }

    public void setVlPeca(Double vlPeca) {
        this.vlPeca = vlPeca;
    }

    public Double getVlServico() {
        return vlServico;
    }

    public void setVlServico(Double vlServico) {
        this.vlServico = vlServico;
    }

    public Long getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }
}
