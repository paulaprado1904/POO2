import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RepositorioClienteImpl implements RepositorioCliente {
    private Map<String, Cliente> clientes;

    public RepositorioClienteImpl() {
        this.clientes = new HashMap<>();
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }

    @Override
    public void atualizarEndereco(String cpf, Endereco novoEndereco) {
        clientes.get(cpf).setEndereco(novoEndereco);
    }
    @Override
    public void atualizarLimiteEspecial(String cpf, double novoLimite) {
        Cliente cliente = clientes.get(cpf);
        ContaBancaria conta = cliente.getContaBancaria();
        conta.setLimiteEspecial(novoLimite);
        clientes.put(cpf, cliente);
    }

    @Override
    public void atualizarAgencia(String cpf, String novaAgencia) {
        Cliente cliente = clientes.get(cpf);
        ContaBancaria conta = cliente.getContaBancaria();
        conta.setAgencia(novaAgencia);
        clientes.put(cpf, cliente);
    }

    @Override
    public void adicionarFamiliares(String cpf, List<Familiar> familiares) {
        Cliente cliente = clientes.get(cpf);
        GestaoFamiliares gestaoFamiliares = cliente.getGestaoFamiliares();
        gestaoFamiliares.adicionarFamiliares(familiares);
        clientes.put(cpf, cliente);
    }


}
