import java.util.List;
interface RepositorioCliente {
    void adicionarCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);
    void atualizarEndereco(String cpf, Endereco novoEndereco);
    void atualizarLimiteEspecial(String cpf, double novoLimite);
    void atualizarAgencia(String cpf, String novaAgencia);
    void adicionarFamiliares(String cpf, List<Familiar> familiares);
}
