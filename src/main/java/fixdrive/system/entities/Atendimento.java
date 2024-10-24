package fixdrive.system.entities;

public class Atendimento {

    private String nomeMecanico;
    private long telefoneMecanico;
    private int avaliacaoMecanico;

    public Atendimento() {

    }



    public String getNomeMecanico() {
        return nomeMecanico;
    }



    public void setNomeMecanico(String nomeMecanico) {
        this.nomeMecanico = nomeMecanico;
    }



    public long getTelefoneMecanico() {
        return telefoneMecanico;
    }



    public void setTelefoneMecanico(long telefoneMecanico) {
        this.telefoneMecanico = telefoneMecanico;
    }



    public int getAvaliacaoMecanico() {
        return avaliacaoMecanico;
    }



    public void setAvaliacaoMecanico(int avaliacaoMecanico) {
        this.avaliacaoMecanico = avaliacaoMecanico;
    }



    public Atendimento(String nomeMecanico, long telefoneMecanico, int avaliacaoMecanico) {
        this.nomeMecanico = nomeMecanico;
        this.telefoneMecanico = telefoneMecanico;
        this.avaliacaoMecanico = avaliacaoMecanico;
    }




    public void registrarInformacoesMecanico() {
        System.out.println("Nome do mecânico: " + getNomeMecanico());
        System.out.println("Telefone: " + getTelefoneMecanico());
        System.out.println("Avaliação: " + getAvaliacaoMecanico());

    }

}
