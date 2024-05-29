import java.time.LocalDate;

// Classe para representar um Contrato de locação
public class Contrato {
    private Veiculo veiculo; // Veículo alugado
    private LocalDate dataInicio; // Data de início do contrato
    private LocalDate dataFim; // Data de término do contrato

    // Construtor
    public Contrato(Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim) {
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Método toString para fornecer uma representação em string dos detalhes do contrato
    @Override
    public String toString() {
        return "Contrato [veiculo=" + veiculo.getClass().getSimpleName() + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
    }

}