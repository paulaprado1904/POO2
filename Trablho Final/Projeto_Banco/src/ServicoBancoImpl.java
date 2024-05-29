
import java.util.ArrayList;
import java.util.List;

class ServicoBancoImpl implements ServicoBanco {
    private final List<Cliente> clientes;

    public ServicoBancoImpl() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public Cliente cadastrarCliente(String nome, String cpf, Endereco endereco, List<Familiar> familiares, double salarioMensal,
                                    String usuario, String senha) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setFamiliares(familiares);
        cliente.setDataCadastro();
        cliente.setSalarioMensal(salarioMensal);
        cliente.setContaBancaria(new ContaBancaria()); // Inicializa da conta bancária
        cliente.setLogin(new Login());
        cliente.getLogin().setUsuario(usuario);
        cliente.getLogin().setSenha(senha);
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public boolean autenticaCliente(String usuario, String senha){
        for(Cliente cliente : clientes)
            if(cliente.getLogin().autentica(usuario, senha)) return true;
        return false;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public double consultarSaldo(Cliente cliente) {
        return cliente.getContaBancaria().getSaldo();
    }

    @Override
    public Cliente consultarDadosCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public double consultarLimiteEspecial(Cliente cliente) {
        return cliente.getContaBancaria().getLimiteEspecial();
    }

    @Override
    public void alterarLimiteEspecial(Cliente cliente, double novoLimite) {
        cliente.getContaBancaria().setLimiteEspecial(novoLimite);
    }

    @Override
    public void alterarEndereco(Cliente cliente, Endereco novoEndereco) {
        cliente.setEndereco(novoEndereco);
    }

    @Override
    public void alterarAgencia(Cliente cliente, String novaAgencia) {
        cliente.getContaBancaria().setAgencia(novaAgencia);
    }
}
