package Banco;

public class Banco {
    public static void main(String[] args) {
        ContaBancariaFactory factory = ContaBancariaFactory.getInstance();

        // Criando uma conta corrente
        ContaBancaria contaCorrente = factory.criarConta("CORRENTE");
        contaCorrente.depositar(1000);
        contaCorrente.sacar(500);
        System.out.println("Saldo da conta corrente: " + contaCorrente.getSaldo());

        // Criando uma conta poupança
        ContaBancaria contaPoupanca = factory.criarConta("POUPANCA");
        contaPoupanca.depositar(2000);
        contaPoupanca.sacar(100);
        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
    }
}
