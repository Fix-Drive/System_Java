package fixdrive.system.entities;

public class Orcamento {


    private Integer id;
    private double valorPeca;
    private double valorServico;


    public Orcamento() {

    }


    public Orcamento(Integer id, double valorPeca, double valorServico) {
        this.id = id;
        this.valorPeca = valorPeca;
        this.valorServico = valorServico;
    }

    public Orcamento(Double valorPeca, Double valorServico) {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }
}
