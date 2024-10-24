package fixdrive.system.entities;

public class Cliente {

    private String nome;
    private int idade;
    private String email;
    private String senha;
    private long numeroCpf;
    private long numeroRg;
    private String endereco;
    private long numeroCnh;

    public Cliente() {

    }

    public Cliente(String nome, int idade, String email, String senha, long numeroCpf, long numeroRg, String endereco,
                   long numeroCnh) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.numeroCpf = numeroCpf;
        this.numeroRg = numeroRg;
        this.endereco = endereco;
        this.numeroCnh = numeroCnh;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        if (idade < 18) {
            throw new IllegalArgumentException("O cliente deve ser maior de 18 anos.");
        }
        this.idade = idade;

    }


    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    public long getNumeroCpf() {

        return numeroCpf;
    }

    public void setNumeroCpf(long numeroCpf) {
        String numeroCpfString = String.valueOf(numeroCpf);
        if (numeroCpfString.length() != 11) {
            throw new IllegalArgumentException("O CPF deve ter 11 dígitos.");
        }
        this.numeroCpf = numeroCpf;
    }

    public long getNumeroRg() {

        return numeroRg;
    }

    public void setNumeroRg(long numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public long getNumeroCnh() {

        return numeroCnh;
    }

    public void setNumeroCnh(long numeroCnh) {
        String numeroCnhString = String.valueOf(numeroCnh);
        if (numeroCnhString.length() != 11) {
            throw new IllegalArgumentException("O número da CNH deve ter 11 dígitos.");
        }

        this.numeroCnh = numeroCnh;
    }


    public void mostrarRegistroDados() {
        System.out.println("Dados pessoais cadastrados!");
        System.out.println("");
        System.out.println("Nome: " + getNome());
        System.out.println("Número CPF: " + getNumeroCpf());
        System.out.println("Número RG: " + getNumeroRg());
        System.out.println("Número CNH: " + getNumeroCnh());
        System.out.println("Email: " + getEmail());
        System.out.println("Endereço completo: " + getEndereco());

    }
}









