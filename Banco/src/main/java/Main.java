import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        RepositorioContaBancaria repositorioContaBancaria = new RepositorioContaBancariaImpl();
        ServicoTaxas servicoTaxas = new ServicoTaxasImpl();
        ServicoBancoImpl servicoBanco = new ServicoBancoImpl(repositorioCliente, repositorioContaBancaria);

        // Cadastrar alguns clientes para teste
        // Cliente 1
        Endereco enderecoCliente1 = new Endereco("Rua A", 123, "Bairro X", "12345-678", "Complemento");
        Familiar familiarCliente1 = new Familiar("Ana", "11111111111");
        GestaoFamiliares gestaoFamiliaresCliente1 = new GestaoFamiliares();
        gestaoFamiliaresCliente1.adicionarFamiliar(familiarCliente1);

        Cliente cliente1 = new Cliente("João", "12345678901", enderecoCliente1, gestaoFamiliaresCliente1.getFamilia(), "01/01/2022", 2000.00, null, gestaoFamiliaresCliente1);

        // Cliente 2
        Endereco enderecoCliente2 = new Endereco("Rua B", 456, "Bairro Y", "98765-432", "Complemento");
        Familiar familiarCliente2 = new Familiar("Pedro", "22222222222");
        GestaoFamiliares gestaoFamiliaresCliente2 = new GestaoFamiliares();
        gestaoFamiliaresCliente2.adicionarFamiliar(familiarCliente2);

        Cliente cliente2 = new Cliente("Maria", "98765432109", enderecoCliente2, gestaoFamiliaresCliente2.getFamilia(), "15/02/2022", 3000.00, null, gestaoFamiliaresCliente2);

        // Criar contas bancárias para os clientes
        // Conta 1
        ContaBancaria conta1 = new ContaBancaria(5000.00, 2000.00, 3, false, false, "001", "123456", false, cliente1.getCpf());

        // Conta 2
        ContaBancaria conta2 = new ContaBancaria(8000.00, 3000.00, 2, false, false, "002", "654321", false, cliente2.getCpf());

        // Associar as contas bancárias aos clientes
        cliente1.setContaBancaria(conta1);
        cliente2.setContaBancaria(conta2);
        // Associar as contas bancárias aos clientes
        cliente1.setContaBancaria(conta1);
        cliente2.setContaBancaria(conta2);

        // Adicionar os clientes e suas contas bancárias aos repositórios
        repositorioCliente.adicionarCliente(cliente1);
        repositorioCliente.adicionarCliente(cliente2);
        repositorioContaBancaria.adicionarContaBancaria(conta1);
        repositorioContaBancaria.adicionarContaBancaria(conta2);

        int opcao;
        do {
            menu.menuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o CPF: ");
                    String cpfSaldo = scanner.nextLine();
                    double saldo = servicoBanco.consultarSaldo(cpfSaldo);
                    System.out.println("Saldo: " + saldo);
                    break;
                case 2:
                    System.out.print("Digite o CPF: ");
                    String cpfDados = scanner.nextLine();
                    Cliente cliente = servicoBanco.consultarDadosCliente(cpfDados);
                    if (cliente != null) {
                        ClienteFormatter clienteFormatter = new ClienteFormatter();
                        String clienteFormatado = clienteFormatter.format(cliente);
                        System.out.println("Dados do cliente: \n" + clienteFormatado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }

                    break;
                case 3:
                    System.out.print("Digite o CPF: ");
                    String cpfLimite = scanner.nextLine();
                    double limite = servicoBanco.consultarLimiteEspecial(cpfLimite);
                    System.out.println("Limite especial: " + limite);
                    break;
                case 4:
                    System.out.print("Digite o CPF: ");
                    String cpfAlterarLimite = scanner.nextLine();
                    System.out.print("Digite o novo limite especial: ");
                    double novoLimite = scanner.nextDouble();
                    servicoBanco.alterarLimiteEspecial(cpfAlterarLimite, novoLimite);
                    break;
                case 5:
                    System.out.print("Digite o CPF: ");
                    String cpfAlterarEndereco = scanner.nextLine();

                    // Obter novos detalhes do endereço do usuário
                    System.out.print("Digite a nova rua: ");
                    String novaRua = scanner.nextLine();
                    System.out.print("Digite o novo número: ");
                    int novoNumero = scanner.nextInt();
                    System.out.print("Digite o novo bairro: ");
                    String novoBairro = scanner.nextLine();
                    System.out.print("Digite o novo CEP: ");
                    String novoCep = scanner.nextLine();
                    System.out.print("Digite o novo complemento: ");
                    String novoComplemento = scanner.nextLine();

                    // Criar um novo objeto de endereço com as informações fornecidas
                    Endereco novoEndereco = new Endereco(novaRua, novoNumero, novoBairro, novoCep, novoComplemento);

                    // Chamar o método para alterar o endereço
                    servicoBanco.alterarEndereco(cpfAlterarEndereco, novoEndereco);
                    break;

                case 6:
                    System.out.print("Digite o CPF: ");
                    String cpfAlterarAgencia = scanner.nextLine();
                    System.out.print("Digite a nova agência: ");
                    String novaAgencia = scanner.nextLine();

                    // Chamar o método para alterar a agência
                    servicoBanco.alterarAgencia(cpfAlterarAgencia, novaAgencia);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
