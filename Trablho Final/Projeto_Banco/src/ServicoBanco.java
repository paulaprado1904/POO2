import java.util.List;

public interface ServicoBanco {

    Cliente cadastrarCliente(String nome, String cpf, Endereco endereco, List<Familiar> familiares, double salarioMensal,
                             String usuario, String senha);

    boolean autenticaCliente(String usuario, String senha);
    double consultarSaldo(Cliente cliente);
    Cliente consultarDadosCliente(String cpf);
    double consultarLimiteEspecial(Cliente cliente);
    void alterarLimiteEspecial(Cliente cliente, double novoLimite);
    void alterarEndereco(Cliente cliente, Endereco novoEndereco);
    void alterarAgencia(Cliente cliente, String novaAgencia);
}

