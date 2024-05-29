package Banco;

public class ContaBancariaFactory {
    private static final ContaBancariaFactory instance = new ContaBancariaFactory();

    private ContaBancariaFactory() {}

    public static ContaBancariaFactory getInstance() {
        return instance;
    }

    public ContaBancaria criarConta(String tipo) {
        switch (tipo.toUpperCase()) {
            case "CORRENTE":
                return new ContaCorrente();
            case "POUPANCA":
                return new ContaPoupanca();
            default:
                throw new IllegalArgumentException("Tipo de conta inválido.");
        }
    }
}
