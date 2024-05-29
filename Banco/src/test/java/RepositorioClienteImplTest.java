import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClienteImplTest {

    @Test
    public void adicionarCliente() {
        RepositorioClienteImpl repositorio = new RepositorioClienteImpl();
        Cliente cliente = new Cliente("João", "12345678901", new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, null, null);
        repositorio.adicionarCliente(cliente);

        assertNotNull(repositorio.buscarCliente("12345678901"));
    }

    @Test
    public void buscarCliente() {
        RepositorioClienteImpl repositorio = new RepositorioClienteImpl();
        Cliente cliente = new Cliente("João", "12345678901", new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, null, null);
        repositorio.adicionarCliente(cliente);

        Cliente clienteEncontrado = repositorio.buscarCliente("12345678901");
        assertNotNull(clienteEncontrado);
        assertEquals("João", clienteEncontrado.getNome());
    }

    @Test
    public void atualizarEndereco() {
        RepositorioClienteImpl repositorio = new RepositorioClienteImpl();
        Cliente cliente = new Cliente("João", "12345678901", new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, null, null);
        repositorio.adicionarCliente(cliente);

        Endereco novoEndereco = new Endereco("Rua B", 456, "Bairro Y", "98765-432", "Complemento");
        repositorio.atualizarEndereco("12345678901", novoEndereco);

        assertEquals(novoEndereco, repositorio.buscarCliente("12345678901").getEndereco());
    }

    @Test
    public void atualizarLimiteEspecial() {
        RepositorioClienteImpl repositorio = new RepositorioClienteImpl();
        Cliente cliente = new Cliente("João", "12345678901", new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, new ContaBancaria(0, 0, 0, false, false, "", "", false, ""), null);
        repositorio.adicionarCliente(cliente);

        double novoLimite = 3000.00;
        repositorio.atualizarLimiteEspecial("12345678901", novoLimite);

        assertEquals(novoLimite, cliente.getContaBancaria().getLimiteEspecial(), 0);
    }

    @Test
    public void atualizarAgencia() {
        RepositorioClienteImpl repositorio = new RepositorioClienteImpl();
        Cliente cliente = new Cliente("João", "12345678901", new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, new ContaBancaria(0, 0, 0, false, false, "", "", false, ""), null);
        repositorio.adicionarCliente(cliente);

        String novaAgencia = "002";
        repositorio.atualizarAgencia("12345678901", novaAgencia);

        assertEquals(novaAgencia, cliente.getContaBancaria().getAgencia());
    }

    @Test
    public void adicionarFamiliares() {
        RepositorioClienteImpl repositorio = new RepositorioClienteImpl();
        Cliente cliente = new Cliente("João", "12345678901", new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, null, new GestaoFamiliares());
        repositorio.adicionarCliente(cliente);

        List<Familiar> familiares = new ArrayList<>();
        familiares.add(new Familiar("Ana", "11111111111"));
        familiares.add(new Familiar("Pedro", "22222222222"));

        repositorio.adicionarFamiliares("12345678901", familiares);

        assertEquals(2, cliente.getGestaoFamiliares().getFamilia().size());
    }
}
