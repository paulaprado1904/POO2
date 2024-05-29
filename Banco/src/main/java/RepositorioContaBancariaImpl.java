import java.util.HashMap;
import java.util.Map;
class RepositorioContaBancariaImpl implements RepositorioContaBancaria {
    private Map<String, ContaBancaria> contas;

    public RepositorioContaBancariaImpl() {
        this.contas = new HashMap<>();
    }

    @Override
    public void adicionarContaBancaria(ContaBancaria contaBancaria) {
        contas.put(contaBancaria.getCpf(), contaBancaria);
    }

    @Override
    public ContaBancaria buscarContaBancaria(String cpf) {
        return contas.get(cpf);
    }

    @Override
    public void atualizarContaBancaria(ContaBancaria contaBancaria) {
        String cpf = contaBancaria.getCpfDoCliente();
        if (contas.containsKey(cpf)) {
            contas.put(cpf, contaBancaria);
            System.out.println("Conta bancária atualizada com sucesso.");
        } else {
            System.out.println("Conta bancária não encontrada para o CPF fornecido.");
        }
    }

    @Override
    public void atualizarSaldo(String cpf, double novoSaldo) {
        ContaBancaria contaBancaria = contas.get(cpf);
        if (contaBancaria != null) {
            contaBancaria.setSaldo(novoSaldo);
        } else {
            // Lidar com o caso em que a conta bancária não foi encontrada
            System.out.println("Conta bancária não encontrada para o CPF fornecido.");
        }
    }

    @Override
    public void atualizarPoupanca(String cpf, boolean temPoupanca) {
        ContaBancaria contaBancaria = contas.get(cpf);
        if (contaBancaria != null) {
            contaBancaria.setPoupanca(temPoupanca);
        } else {
            // Lidar com o caso em que a conta bancária não foi encontrada
            System.out.println("Conta bancária não encontrada para o CPF fornecido.");
        }
    }

}
