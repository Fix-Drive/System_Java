package fixdrive.system.dto;

public class OrcamentoDto {
    private Long id;
    private Double vlPeca;
    private Double vlServico;
    private Long idManutencao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
