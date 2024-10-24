package fixdrive.system.entities;

public class Pagamento {
    private String modoPagamento;


    public Pagamento() {

    }




    public Pagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }




    public String getModoPagamento() {
        return modoPagamento;
    }




    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }




    public void identificarPagamento() {
        System.out.println("Modo de pagamento: " + getModoPagamento());

    }
}




