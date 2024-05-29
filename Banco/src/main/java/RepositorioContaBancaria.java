interface RepositorioContaBancaria {
    void adicionarContaBancaria(ContaBancaria contaBancaria);
    ContaBancaria buscarContaBancaria(String cpf);
    void atualizarSaldo(String cpf, double novoSaldo);
    void atualizarPoupanca(String cpf, boolean temPoupanca);
    public void atualizarContaBancaria(ContaBancaria contaBancaria);
}
