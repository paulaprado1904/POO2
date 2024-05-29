interface ServicoBanco {
    double consultarSaldo(String cpf);
    Cliente consultarDadosCliente(String cpf);
    double consultarLimiteEspecial(String cpf);
    void alterarLimiteEspecial(String cpf, double novoLimite);
    void alterarEndereco(String cpf, Endereco novoEndereco);
    void alterarAgencia(String cpf, String novaAgencia);

    void cobrarMensalidade(String cpf);
}
