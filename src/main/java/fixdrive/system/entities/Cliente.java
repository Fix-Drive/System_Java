package fixdrive.system.entities;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {

    private Integer id;
    private String nome;
    private int idade;
    private String email;
    private String senha;
    private long numeroCpf;
    private long numeroRg;
    private String endereco;
    private long numeroCnh;
    private LocalDate dataValidadeCnh;
    private long numeroTelefone;

    public Cliente() {

    }


    public Cliente(String nome, String idade, String email, String senha, Long numeroCpf, Long numeroRg, String endereco, Long numeroCnh, int numeroTelefone) {
    }

    public Cliente(Integer id, String nome, String idade, String email, String senha, Long numeroCpf, Long numeroRg, String endereco, Long numeroCnh, int numeroTelefone) {
    }


    public LocalDate getDataValidadeCnh() {
        return dataValidadeCnh;
    }

    public void setDataValidadeCnh(LocalDate dataValidadeCnh) {
        this.dataValidadeCnh = dataValidadeCnh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(long numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
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
        this.numeroCnh = numeroCnh;
    }

}









