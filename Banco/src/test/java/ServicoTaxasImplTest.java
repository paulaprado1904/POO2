import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ServicoTaxasImplTest {

    @Test
    public void calcularJuros_saldoNegativo() {
        // Arrange
        double saldo = -1000.00;
        double limiteEspecial = 2000.00;
        double taxa = 0.05; // 5%

        ServicoTaxasImpl servicoTaxas = new ServicoTaxasImpl();

        // Act
        double juros = servicoTaxas.calcularJuros(saldo, limiteEspecial, taxa);

        // Assert
        assertEquals(saldo * taxa, juros, 0.001);
    }

    @Test
    public void calcularJuros_saldoPositivo() {
        // Arrange
        double saldo = 2000.00;
        double limiteEspecial = 2000.00;
        double taxa = 0.05; // 5%

        ServicoTaxasImpl servicoTaxas = new ServicoTaxasImpl();

        // Act
        double juros = servicoTaxas.calcularJuros(saldo, limiteEspecial, taxa);

        // Assert
        assertEquals((saldo + limiteEspecial) * taxa, juros, 0.001);
    }

    @Test
    public void calcularLucro_comPoupanca() {
        // Arrange
        double saldo = 3000.00;
        boolean temPoupanca = true;
        double taxa = 0.03; // 3%

        ServicoTaxasImpl servicoTaxas = new ServicoTaxasImpl();

        // Act
        double lucro = servicoTaxas.calcularLucro(saldo, temPoupanca, taxa);

        // Assert
        assertEquals(saldo * taxa, lucro, 0.001);
    }

    @Test
    public void calcularLucro_semPoupanca() {
        // Arrange
        double saldo = 3000.00;
        boolean temPoupanca = false;
        double taxa = 0.03; // 3%

        ServicoTaxasImpl servicoTaxas = new ServicoTaxasImpl();

        // Act
        double lucro = servicoTaxas.calcularLucro(saldo, temPoupanca, taxa);

        // Assert
        assertEquals(0, lucro, 0.001);
    }
}
