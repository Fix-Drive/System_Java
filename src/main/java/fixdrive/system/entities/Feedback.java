package fixdrive.system.entities;

public class Feedback {
    private String comentarioAvaliativo;
    private int pontuacao;



    public Feedback() {

    }

    public Feedback(String comentarioAvaliativo, int pontuacao) {
        this.comentarioAvaliativo = comentarioAvaliativo;
        this.pontuacao = pontuacao;
    }

    public String getComentarioAvaliativo() {
        return comentarioAvaliativo;
    }

    public void setComentarioAvaliativo(String comentarioAvaliativo) {
        this.comentarioAvaliativo = comentarioAvaliativo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void informarComentario(String comentarioAvaliativo) {
        this.comentarioAvaliativo = comentarioAvaliativo;
        System.out.println("Comentário registrado! Agradecemos a colaboração.");
    }

    public void informarPontuacao(int pontuacao) {
        try {
            if (pontuacao >= 0 && pontuacao <= 5) {
                this.pontuacao = pontuacao;

            } else {
                throw new Exception("Erro. Pontuação deve ser classificada de 0 a 5");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
