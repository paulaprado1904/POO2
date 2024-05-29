import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando alguns veículos
        Veiculo caminhao = new Caminhao(200, 0.1);
        Veiculo carro = new Carro(100, 0.05);
        Veiculo moto = new Moto(50, 0.02);

        // Criando alguns clientes
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        // Criando alguns contratos
        Contrato contrato1 = new Contrato(caminhao, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 10));
        Contrato contrato2 = new Contrato(carro, LocalDate.of(2024, 3, 5), LocalDate.of(2024, 3, 15));
        Contrato contrato3 = new Contrato(moto, LocalDate.of(2024, 3, 8), LocalDate.of(2024, 3, 20));

        // Adicionando contratos aos clientes
        cliente1.adicionarContrato(contrato1);
        cliente2.adicionarContrato(contrato2);
        cliente2.adicionarContrato(contrato3);

        // Imprimindo informações sobre os contratos dos clientes
        System.out.println("Contratos do Cliente 1:");
        listarContratos(cliente1);

        System.out.println("\nContratos do Cliente 2:");
        listarContratos(cliente2);
    }

    // Método para listar os contratos de um cliente
    public static void listarContratos(Cliente cliente) {
        List<Contrato> contratos = cliente.getContratos();
        for (Contrato contrato : contratos) {
            System.out.println(contrato);
        }
    }
}
