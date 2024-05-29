class ServicoBancoImpl implements ServicoBanco {
    private final RepositorioCliente repositorioCliente;
    private final RepositorioContaBancaria repositorioContaBancaria;

    public ServicoBancoImpl(RepositorioCliente repositorioCliente, RepositorioContaBancaria repositorioContaBancaria) {
        this.repositorioCliente = repositorioCliente;
        this.repositorioContaBancaria = repositorioContaBancaria;
    }

    @Override
    public double consultarSaldo(String cpf) {
        ContaBancaria conta = repositorioContaBancaria.buscarContaBancaria(cpf);
        return conta != null ? conta.getSaldo() : 0;
    }

    @Override
    public Cliente consultarDadosCliente(String cpf) {
        return repositorioCliente.buscarCliente(cpf);
    }

    @Override
    public double consultarLimiteEspecial(String cpf) {
        Cliente cliente = repositorioCliente.buscarCliente(cpf);
        return cliente != null ? cliente.getContaBancaria().getLimiteEspecial() : 0;
    }

    @Override
    public void alterarLimiteEspecial(String cpf, double novoLimite) {
        ContaBancaria conta = repositorioContaBancaria.buscarContaBancaria(cpf);
        if (conta != null) {
            conta.setLimiteEspecial(novoLimite);
            repositorioContaBancaria.atualizarContaBancaria(conta);
        }
    }

    @Override
    public void alterarEndereco(String cpf, Endereco novoEndereco) {
        repositorioCliente.atualizarEndereco(cpf, novoEndereco);
    }

    @Override
    public void alterarAgencia(String cpf, String novaAgencia) {
        Cliente cliente = repositorioCliente.buscarCliente(cpf);
        if (cliente != null) {
            ContaBancaria conta = cliente.getContaBancaria();
            if (conta != null) {
                conta.setAgencia(novaAgencia);
                repositorioContaBancaria.atualizarContaBancaria(conta);
            }
        }
    }

    @Override
    public void cobrarMensalidade(String cpf) {
        Cliente cliente = repositorioCliente.buscarCliente(cpf);
        if (cliente != null) {
            ContaBancaria contaBancaria = cliente.getContaBancaria();
            if (contaBancaria != null) {
                double mensalidade;
                if (contaBancaria.isClienteVIP()) {
                    mensalidade = 270.00;
                } else if (contaBancaria.isClienteEspecial()) {
                    mensalidade = 100.00;
                } else {
                    mensalidade = 30.00;
                }

                if (contaBancaria.getSaldo() >= mensalidade) {
                    contaBancaria.setSaldo(contaBancaria.getSaldo() - mensalidade);
                    repositorioContaBancaria.atualizarContaBancaria(contaBancaria);
                }
            }
        }
    }

}
