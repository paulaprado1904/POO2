import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ServicoBancoImplTest {

    private ServicoBanco servicoBanco;

    @Before
    public void setUp() {
        servicoBanco = new ServicoBancoImpl();
    }

    @Test
    public void testConsultarSaldo() {
        Cliente cliente = criarClienteComConta("Isabella", "12345678901", 2000.0, 1500.0, false, false, "Isabela", "Isabela123");
        assertEquals(1500.0, servicoBanco.consultarSaldo(cliente), 0);
    }

    @Test
    public void testConsultarDadosCliente() {
        Cliente cliente = criarClienteComConta("Paula", "98765432109", 3000.0, 0.0, false, false, "Paula", "Paula123");
        assertEquals("Paula", servicoBanco.consultarDadosCliente("98765432109").getNome());
    }

    @Test
    public void testConsultarLimiteEspecial() {
        Cliente cliente = criarClienteComConta("Matheus", "45678912301", 4000.0, 0.0, false, false, "Matheus", "Matheus123");
        cliente.getContaBancaria().setLimiteEspecial(2000.0);
        assertEquals(2000.0, servicoBanco.consultarLimiteEspecial(cliente), 0);
    }

    @Test
    public void testAlterarLimiteEspecial() {
        Cliente cliente = criarClienteComConta("Vanessa", "78912345601", 5000.0, 0.0, false, false, "Vanessa", "Vanessa123");
        servicoBanco.alterarLimiteEspecial(cliente, 500.0);
        assertEquals(500.0, cliente.getContaBancaria().getLimiteEspecial(), 0);
    }

    @Test
    public void testAlterarEndereco() {
        Cliente cliente = criarClienteComConta("Thiago", "32165498701", 6000.0, 0.0, false, false, "Thiago", "Thiago123");
        Endereco novoEndereco = new Endereco();
        novoEndereco.setRua("Nova Rua");
        servicoBanco.alterarEndereco(cliente, novoEndereco);
        assertEquals("Nova Rua", cliente.getEndereco().getRua());
    }

    @Test
    public void testAlterarAgencia() {
        Cliente cliente = criarClienteComConta("John", "65498732101", 7000.0, 0.0, false, false, "John", "John123");
        servicoBanco.alterarAgencia(cliente, "1234-5");
        assertEquals("1234-5", cliente.getContaBancaria().getAgencia());
    }

    @Test
    public void testAutenticaCliente(){
        Cliente cliente = criarClienteComConta("John", "65498732101", 7000.0, 0.0, false, false, "John", "John123");

        assertTrue(servicoBanco.autenticaCliente("John", "John123"));
        assertEquals("John", cliente.getLogin().getUsuario());
        assertEquals("John123", cliente.getLogin().getSenha());
    }

    private Cliente criarClienteComConta(String nome, String cpf, double salarioMensal, double saldo, boolean clienteEspecial, boolean clienteVIP, String usuario, String senha) {
        Cliente cliente = servicoBanco.cadastrarCliente(nome, cpf, new Endereco(), new ArrayList<>(), salarioMensal, usuario, senha);
        ContaBancaria contaBancaria = cliente.getContaBancaria();
        contaBancaria.setSaldo(saldo);
        contaBancaria.setClienteEspecial(clienteEspecial);
        contaBancaria.setClienteVIP(clienteVIP);
        return cliente;
    }
}
