import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;


public class ContaBancariaTest {

    @Test
    public void calcularJuros() {
        ContaBancaria conta = new ContaBancaria();
        conta.setSaldo(1000.0);
        conta.setClienteEspecial(true);
        conta.calcularJuros();
        assertEquals(1012.0, conta.getSaldo(), 0.001); // Espera-se que o saldo aumente em 1.2%
    }

    @Test
    public void pagarTaxaMensal() {
        ContaBancaria conta = new ContaBancaria();
        conta.setSaldo(1000.0);
        conta.setClienteEspecial(true);
        conta.pagarTaxaMensal();
        assertEquals(900.0, conta.getSaldo()); // Espera-se que o saldo diminua em 100.0
    }

    @Test
    public void calcularLucroPoupanca() {
        ContaBancaria conta = new ContaBancaria();
        conta.setSaldo(1000.0);
        conta.setClienteVIP(true);
        conta.calcularLucroPoupanca();
        assertEquals(1000.8, conta.getSaldo(), 0.001); // Espera-se que o saldo aumente em 0.08%
    }

    @Test
    public void realizarPagamentoMensal() {
        ContaBancaria conta = new ContaBancaria();
        conta.setSaldo(1000.0);
        conta.setClienteVIP(true);
        conta.realizarPagamentoMensal();
        assertEquals(730.0, conta.getSaldo()); // Espera-se que o saldo diminua em 270.0
    }
}
