import org.junit.Test;
import static org.junit.Assert.*;

public class RepositorioContaBancariaImplTest {

    @Test
    public void adicionarContaBancaria() {
        RepositorioContaBancariaImpl repositorio = new RepositorioContaBancariaImpl();
        ContaBancaria contaBancaria = new ContaBancaria(5000.00, 2000.00, 3, false, false, "001", "123456", false, "12345678901");

        repositorio.adicionarContaBancaria(contaBancaria);

        assertEquals(contaBancaria, repositorio.buscarContaBancaria("12345678901"));
    }

    @Test
    public void buscarContaBancaria() {
        RepositorioContaBancariaImpl repositorio = new RepositorioContaBancariaImpl();
        ContaBancaria contaBancaria = new ContaBancaria(5000.00, 2000.00, 3, false, false, "001", "123456", false, "12345678901");
        repositorio.adicionarContaBancaria(contaBancaria);

        assertEquals(contaBancaria, repositorio.buscarContaBancaria("12345678901"));
    }

    @Test
    public void atualizarSaldo() {
        RepositorioContaBancariaImpl repositorio = new RepositorioContaBancariaImpl();
        ContaBancaria contaBancaria = new ContaBancaria(5000.00, 2000.00, 3, false, false, "001", "123456", false, "12345678901");
        repositorio.adicionarContaBancaria(contaBancaria);

        repositorio.atualizarSaldo("12345678901", 6000.00);

        assertEquals(6000.00, repositorio.buscarContaBancaria("12345678901").getSaldo(), 0.01);
    }

    @Test
    public void atualizarPoupanca() {
        RepositorioContaBancariaImpl repositorio = new RepositorioContaBancariaImpl();
        ContaBancaria contaBancaria = new ContaBancaria(5000.00, 2000.00, 3, false, false, "001", "123456", false, "12345678901");
        repositorio.adicionarContaBancaria(contaBancaria);

        repositorio.atualizarPoupanca("12345678901", true);

        assertTrue(repositorio.buscarContaBancaria("12345678901").isPoupanca());
    }
}
