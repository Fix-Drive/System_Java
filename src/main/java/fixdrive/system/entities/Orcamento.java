package fixdrive.system.entities;

public class Orcamento {


    private String tipoPeca;
    private String valorPeca;
    private double valorDiagnostico;


    public Orcamento() {

    }



    public Orcamento(String tipoPeca, String valorPeca, double valorDiagnostico) {
        this.tipoPeca = tipoPeca;
        this.valorPeca = valorPeca;
        this.valorDiagnostico = valorDiagnostico;
    }

    public String getTipoPeca(int tipoPeca) {
        return this.tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(String valorPeca) {
        this.valorPeca = valorPeca;
    }

    public double getValorDiagnostico() {
        return valorDiagnostico;
    }

    public void setValorDiagnostico(double valorDiagnostico) {
        this.valorDiagnostico = valorDiagnostico;
    }

    public void mostrarOrcamentoDiagnosticoFinal() {
        System.out.println("A taxa para consulta diagnóstica é de R$ 10,00");

    }

    public void verificarPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;


    }

}
