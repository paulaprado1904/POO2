
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

class Cliente {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private List<Familiar> familiares;
    private String dataCadastro;
    private double salarioMensal;
    private ContaBancaria contaBancaria;
    private Login login;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro() {
        // Define a data de cadastro como a data atual
        this.dataCadastro = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public Login getLogin() { return login; }

    public void setLogin(Login login) { this.login = login; }

    public String printaDadosCliente(){
        return "\nNome: "+getNome()
               +"\nCPF: "+getCpf()
               +"\n\nEndereço: "
               +getEndereco().printaEnderecoCLiente()
               +"\n\nDados da conta:"
               +getContaBancaria().printaDadosContaBancaria();
    }
}