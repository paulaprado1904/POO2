import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServicoBancoImplTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void consultarSaldo() {
        // Arrange
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        double saldoEsperado = 1000.0; // Saldo esperado

        ContaBancaria contaBancaria = new ContaBancaria(saldoEsperado, 2000.00, 3, false, true, "001", "123456", false, cpf);
        repositorioContaBancaria.adicionarContaBancaria(contaBancaria);

        // Act
        double saldoAtual = servicoBanco.consultarSaldo(cpf);

        // Assert
        assertEquals(saldoEsperado, saldoAtual, 0.001);
    }


    @Test
    public void consultarDadosCliente() {
        // Arrange
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        Cliente clienteEsperado = new Cliente("João", cpf, new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, null, new GestaoFamiliares());
        repositorioCliente.adicionarCliente(clienteEsperado);

        // Act
        Cliente clienteAtual = servicoBanco.consultarDadosCliente(cpf);

        // Assert
        assertEquals(clienteEsperado, clienteAtual);
    }


    @Test
    public void consultarLimiteEspecial() {
        // Arrange
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        double limiteEspecialEsperado = 2000.00;
        Cliente cliente = new Cliente("João", cpf, new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, null, new GestaoFamiliares());
        ContaBancaria contaBancaria = new ContaBancaria(5000.00, limiteEspecialEsperado, 3, false, false, "001", "123456", false, cpf);

        // Associar a conta bancária ao cliente
        cliente.setContaBancaria(contaBancaria);

        // Adicionar o cliente e a conta bancária aos respectivos repositórios
        repositorioCliente.adicionarCliente(cliente);
        repositorioContaBancaria.adicionarContaBancaria(contaBancaria);

        // Act
        double limiteEspecialAtual = servicoBanco.consultarLimiteEspecial(cpf);

        // Assert
        assertEquals(limiteEspecialEsperado, limiteEspecialAtual, 0.001);
    }


    @Test
    public void alterarLimiteEspecial() {
        // Arrange
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        double novoLimite = 3000.00;
        Cliente cliente = new Cliente("João", cpf, new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento"), null, "01/01/2022", 2000.00, null, new GestaoFamiliares());
        ContaBancaria contaBancaria = new ContaBancaria(5000.00, 2000.00, 3, false, false, "001", "123456", false, cpf);
        repositorioCliente.adicionarCliente(cliente);
        repositorioContaBancaria.adicionarContaBancaria(contaBancaria);

        // Act
        servicoBanco.alterarLimiteEspecial(cpf, novoLimite);

        // Assert
        assertEquals(novoLimite, contaBancaria.getLimiteEspecial(), 0.001);
    }


    @Test
    public void alterarEndereco() {
        // Arrange
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        Endereco enderecoAntigo = new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento");
        Cliente cliente = new Cliente("João", cpf, enderecoAntigo, null, "01/01/2022", 2000.00, null, new GestaoFamiliares());
        repositorioCliente.adicionarCliente(cliente);

        Endereco novoEndereco = new Endereco("Rua B", 456, "Bairro Y", "98765-432", "Novo complemento");

        // Act
        servicoBanco.alterarEndereco(cpf, novoEndereco);

        // Assert
        assertEquals(novoEndereco, repositorioCliente.buscarCliente(cpf).getEndereco());
    }


    @Test
    public void alterarAgencia() {
        // Arrange
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        ContaBancaria contaBancaria = new ContaBancaria(0, 0, 0, false, false, "001", "123456", false, cpf);
        Cliente cliente = new Cliente("João", cpf, null, null, "01/01/2022", 2000.00, contaBancaria, null);
        repositorioCliente.adicionarCliente(cliente);

        String novaAgencia = "002";

        // Act
        servicoBanco.alterarAgencia(cpf, novaAgencia);

        // Assert
        assertEquals(novaAgencia, repositorioCliente.buscarCliente(cpf).getContaBancaria().getAgencia());
    }

    @Test
    public void cobrarMensalidade_saldoSuficiente() {
        // Arrange
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        double saldoInicial = 300.00;
        ContaBancaria contaBancaria = new ContaBancaria(saldoInicial, 0, 0, false, false, "001", "123456", false, cpf);
        Cliente cliente = new Cliente("João", cpf, null, null, "01/01/2022", 2000.00, contaBancaria, null);

        // Adicionar a conta bancária ao repositório antes de cobrar a mensalidade
        repositorioContaBancaria.adicionarContaBancaria(contaBancaria);
        repositorioCliente.adicionarCliente(cliente);

        // Act
        servicoBanco.cobrarMensalidade(cpf);

        // Assert
        double saldoEsperado = saldoInicial - 30.00;
        assertEquals(saldoEsperado, repositorioContaBancaria.buscarContaBancaria(cpf).getSaldo(), 0.001);
    }

    @Test
    public void cobrarMensalidade_saldoInsuficiente() {
        // Arrange
        RepositorioClienteImpl repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancariaImpl repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxasImpl servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        String cpf = "12345678901";
        double saldoInicial = 20.00; // Define um saldo inicial menor do que a mensalidade
        ContaBancaria contaBancaria = new ContaBancaria(saldoInicial, 0, 0, false, false, "001", "123456", false, cpf);
        Cliente cliente = new Cliente("João", cpf, null, null, "01/01/2022", 2000.00, contaBancaria, null);
        repositorioCliente.adicionarCliente(cliente); // Adiciona o cliente ao repositório
        repositorioContaBancaria.adicionarContaBancaria(contaBancaria); // Adiciona a conta bancária ao repositório

        // Act
        servicoBanco.cobrarMensalidade(cpf);

        // Assert
        // Verifica se o saldo permanece o mesmo após a tentativa de cobrança
        assertEquals(saldoInicial, repositorioContaBancaria.buscarContaBancaria(cpf).getSaldo(), 0.001);
    }

}