// Classe abstrata para definir comportamentos comuns aos veículos
public abstract class VeiculoAlugavel implements Veiculo {
    protected double valorBase; // Valor base do veículo
    protected double taxaImposto; // Taxa de imposto do veículo

    // Construtor
    public VeiculoAlugavel(double valorBase, double taxaImposto) {
        this.valorBase = valorBase;
        this.taxaImposto = taxaImposto;
    }

    // Implementação do método de cálculo do imposto
    @Override
    public double calcularImposto() {
        return valorBase * taxaImposto;
    }
    @Override
    public double calcularValorAluguel() {
        return valorBase + calcularImposto();
    }
}