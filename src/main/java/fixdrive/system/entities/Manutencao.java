package fixdrive.system.entities;

public class Manutencao {
    private String dataAgendamentoManutencao;
    private int horarioAgendamentoManutencao;
    private String enderecoCentroAutomotivo;





    public Manutencao() {

    }






    public Manutencao(String dataAgendamentoManutencao, int horarioAgendamentoManutencao,
                      String enderecoCentroAutomotivo) {
        this.dataAgendamentoManutencao = dataAgendamentoManutencao;
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
    }

    public String getDataAgendamentoManutencao() {
        return dataAgendamentoManutencao;
    }

    public void setDataAgendamentoManutencao(String dataAgendamentoManutencao) {
        this.dataAgendamentoManutencao = dataAgendamentoManutencao;
    }

    public int getHorarioAgendamentoManutencao() {
        return horarioAgendamentoManutencao;
    }

    public void setHorarioAgendamentoManutencao(int horarioAgendamentoManutencao) {
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
    }

    public String getEnderecoCentroAutomotivo() {
        return enderecoCentroAutomotivo;
    }

    public void setEnderecoCentroAutomotivo(String enderecoCentroAutomotivo) {
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
    }

    public void agendarManutencao() {
        System.out.println("Dia da semana escolhido para a realização da manutenção: " + dataAgendamentoManutencao);
    }

    public void agendarHorario() {
        System.out.println("Horário escolhido: " + horarioAgendamentoManutencao);
    }

    public void verificarCentroAutomotivo() {
        System.out.println("Centro Automotivo selecionado: " + enderecoCentroAutomotivo);
    }


}
