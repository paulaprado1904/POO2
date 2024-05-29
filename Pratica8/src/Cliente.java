import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Cliente {
    private String nome;
    private List<Contrato> contratos;

    public Cliente(String nome) {
        this.nome = nome;
        this.contratos = new ArrayList<>();
    }

    public void adicionarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    // Método para obter os contratos do cliente
    public List<Contrato> getContratos() {
        return new ArrayList<>(contratos); // Retorna uma cópia da lista de contratos para garantir imutabilidade
    }
}
