package fixdrive.system.dto;

public class ClienteDto {

    private Integer id;

    private String nome;

    private String idade;

    private String email;

    private String senha;

    private Long numeroCpf;

    private Long numeroRg;

    private String endereco;

    private Long numeroCnh;

    private int numeroTelefone;

    public ClienteDto(Integer id, String nome, String idade, String email, String senha, Long numeroCpf, Long numeroRg, String endereco, Long numeroCnh, int numeroTelefone) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.numeroCpf = numeroCpf;
        this.numeroRg = numeroRg;
        this.endereco = endereco;
        this.numeroCnh = numeroCnh;
        this.numeroTelefone = numeroTelefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
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

    public Long getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(Long numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public Long getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(Long numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getNumeroCnh() {
        return numeroCnh;
    }

    public void setNumeroCnh(Long numeroCnh) {
        this.numeroCnh = numeroCnh;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
