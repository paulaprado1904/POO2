import java.util.List;

class Cliente {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private List<Familiar> familia;
    private String dataCadastro;
    private double salarioMensal;
    private ContaBancaria contaBancaria;
    private GestaoFamiliares gestaoFamiliares;

    public Cliente(String nome, String cpf, Endereco endereco, List<Familiar> familia, String dataCadastro, double salarioMensal, ContaBancaria contaBancaria, GestaoFamiliares gestaoFamiliares) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.familia = familia;
        this.dataCadastro = dataCadastro;
        this.salarioMensal = salarioMensal;
        this.contaBancaria = contaBancaria;
        this.gestaoFamiliares = gestaoFamiliares;
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

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public List<Familiar> getFamilia() {
        return familia;
    }

    public void setFamilia(List<Familiar> familia) {
        this.familia = familia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public GestaoFamiliares getGestaoFamiliares() {
        return gestaoFamiliares;
    }

    public void setGestaoFamiliares(GestaoFamiliares gestaoFamiliares) {
        this.gestaoFamiliares = gestaoFamiliares;
    }


}