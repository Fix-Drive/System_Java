package fixdrive.system.entities;

public class Servico {

    private String tipoServico;
    private String descricaoServico;




    public Servico() {
    }



    public Servico(String tipoServico, String descricaoServico) {
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;

    }


    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public void mostrarTipoServicoNecessario() {
        System.out.println("A manutenção em questão envolve " + tipoServico);

    }

}
