public class ContaBancariaFormatter {
    public String format(ContaBancaria contaBancaria) {
        return "Saldo: " + contaBancaria.getSaldo() + "\n" +
                "Limite Especial: " + contaBancaria.getLimiteEspecial() + "\n" +
                "Tempo Filiado: " + contaBancaria.getTempoFiliado() + "\n" +
                "Cliente Especial: " + contaBancaria.isClienteEspecial() + "\n" +
                "Cliente VIP: " + contaBancaria.isClienteVIP() + "\n" +
                "Agência: " + contaBancaria.getAgencia() + "\n" +
                "Conta: " + contaBancaria.getConta() + "\n" +
                "Poupança: " + contaBancaria.isPoupanca();
    }
}
