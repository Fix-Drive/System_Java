package fixdrive.system.model;

public class Cliente {
    private Long idCliente;
    private String nmCliente;
    private Integer idadeCliente;
    private String dsEmail;
    private String dsSenha;
    private Long nrCpf;
    private Long nrRg;
    private String dsEndereco;
    private Long nrCnh;
    private Long nrTelefone;

    // Getters e Setters
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public Integer getIdadeCliente() {
        return idadeCliente;
    }

    public void setIdadeCliente(Integer idadeCliente) {
        this.idadeCliente = idadeCliente;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public Long getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(Long nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Long getNrRg() {
        return nrRg;
    }

    public void setNrRg(Long nrRg) {
        this.nrRg = nrRg;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public Long getNrCnh() {
        return nrCnh;
    }

    public void setNrCnh(Long nrCnh) {
        this.nrCnh = nrCnh;
    }

    public Long getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(Long nrTelefone) {
        this.nrTelefone = nrTelefone;
    }
}
