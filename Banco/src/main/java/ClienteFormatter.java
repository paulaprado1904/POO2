public class ClienteFormatter {
    private EnderecoFormatter enderecoFormatter = new EnderecoFormatter();
    private ContaBancariaFormatter contaBancariaFormatter = new ContaBancariaFormatter();
    private FamiliarFormatter familiarFormatter = new FamiliarFormatter();

    public String format(Cliente cliente) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nome: ").append(cliente.getNome()).append("\n")
                .append("CPF: ").append(cliente.getCpf()).append("\n")
                .append("Endereço: ").append(enderecoFormatter.format(cliente.getEndereco())).append("\n")
                .append("Data de Cadastro: ").append(cliente.getDataCadastro()).append("\n")
                .append("Salário Mensal: ").append(cliente.getSalarioMensal()).append("\n")
                .append("Conta Bancária: ").append(contaBancariaFormatter.format(cliente.getContaBancaria())).append("\n")
                .append("Familiares: ").append(formatFamiliares(cliente.getGestaoFamiliares()));
        return stringBuilder.toString();
    }

    private String formatFamiliares(GestaoFamiliares gestaoFamiliares) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Familiar familiar : gestaoFamiliares.getFamilia()) {
            stringBuilder.append("\n").append(familiarFormatter.format(familiar));
        }
        return stringBuilder.toString();
    }
}
