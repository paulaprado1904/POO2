import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner ler = new Scanner(System.in);

        ServicoBancoImpl servicoBancoImpl = new ServicoBancoImpl();
        Cliente cliente = servicoBancoImpl.cadastrarCliente("Isabella", "12345678901", new Endereco(), new ArrayList<>(), 2000.0,
                "Isabela", "Isabela123");
        Cliente cliente2 = servicoBancoImpl.cadastrarCliente("Paula", "98765432109", new Endereco(), new ArrayList<>(),  3000.0,
                "Paula", "Paula123");


        int opcao;
            do {
                Menu menu = new Menu();
                menu.menuPrincipal();
                opcao = ler.nextInt();
                String cpf;

                switch (opcao) {
                    case 1:

                        System.out.print("CPF: ");
                        cpf = ler.next();
                        for(Cliente clientes : servicoBancoImpl.getClientes()){
                            if(cpf.equals(clientes.getCpf()))
                                System.out.println("Seu saldo de "+ clientes.getNome()
                                        +" é de R$" + servicoBancoImpl.consultarSaldo(clientes));
                        }
                        break;

                    case 2:
                        System.out.print("CPF: ");
                        cpf = ler.next();
                        for(Cliente clientes : servicoBancoImpl.getClientes()){
                            if(cpf.equals(clientes.getCpf()))
                                System.out.println(servicoBancoImpl.consultarDadosCliente(clientes.getCpf()).printaDadosCliente());
                        }
                        break;
                    case 3:
                        System.out.print("CPF: ");
                        cpf = ler.next();
                        for(Cliente clientes : servicoBancoImpl.getClientes()){
                            if(cpf.equals(clientes.getCpf()))
                                System.out.println("O limite especial de " + clientes.getNome()
                                        +" é de R$" + servicoBancoImpl.consultarLimiteEspecial(clientes));
                        }
                        break;
                    case 4:
                        double novoLimiteEspecial;
                        System.out.print("CPF: ");
                        cpf = ler.next();
                        for(Cliente clientes : servicoBancoImpl.getClientes()){
                            if(cpf.equals(clientes.getCpf())) {
                                System.out.print("Limite especial: ");
                                novoLimiteEspecial = ler.nextDouble();

                                servicoBancoImpl.alterarLimiteEspecial(clientes, novoLimiteEspecial);

                                if(clientes.getContaBancaria().getLimiteEspecial() >= 5000.00
                                        && clientes.getContaBancaria().getLimiteEspecial() <= 10000.00){
                                    clientes.getContaBancaria().setClienteEspecial(true);
                                }

                                if(clientes.getContaBancaria().getLimiteEspecial() >= 20000
                                        && clientes.getContaBancaria().getLimiteEspecial() <= 100000.00){
                                    clientes.getContaBancaria().setClienteVIP(true);
                                }

                                System.out.println("O limite especial de " + clientes.getNome()
                                                    +" foi ajustado para " + clientes.getContaBancaria().getLimiteEspecial() + "!");

                                if(clientes.getContaBancaria().isClienteVIP())
                                    System.out.println(clientes.getNome() + " é cliente VIP!");

                                if(clientes.getContaBancaria().isClienteEspecial())
                                    System.out.println(clientes.getNome() + " é cliente Especial!");
                            }

                        }

                        break;
                    case 5:
                        String rua, bairro, complemento, cep;
                        int numeroCasa;
                        System.out.print("CPF: ");
                        cpf = ler.next();
                        for(Cliente clientes : servicoBancoImpl.getClientes()){
                            if(cpf.equals(clientes.getCpf())){
                                System.out.println("Cliente: " + clientes.getNome());
                                Endereco enderecoClienteNovo = new Endereco();


                                ler.nextLine(); //??????
                                System.out.print("Rua: ");
                                rua = ler.nextLine();
                                enderecoClienteNovo.setRua(rua);

                                System.out.print("Número: ");
                                numeroCasa = ler.nextInt();
                                enderecoClienteNovo.setNumero(numeroCasa);
                                ler.nextLine(); //???????

                                System.out.print("Bairro: ");
                                bairro = ler.nextLine();
                                enderecoClienteNovo.setBairro(bairro);

                                System.out.print("CEP: ");
                                cep = ler.nextLine();
                                enderecoClienteNovo.setCep(cep);

                                System.out.print("Complemento: ");
                                complemento = ler.nextLine();
                                enderecoClienteNovo.setComplemento(complemento);

                                servicoBancoImpl.alterarEndereco(clientes, enderecoClienteNovo);

                                System.out.println("O endereço de " + clientes.getNome() +" alterado com sucesso!");

                            }
                        }
                        break;
                    case 6:
                        //xxxx-x
                        String novaAgencia, antigaAgencia;
                        System.out.print("CPF: ");
                        cpf = ler.next();
                        for(Cliente clientes : servicoBancoImpl.getClientes()){
                            if(cpf.equals(clientes.getCpf())){
                                antigaAgencia = clientes.getContaBancaria().getAgencia();
                                System.out.print("Agência: ");
                                novaAgencia = ler.next();
                                servicoBancoImpl.alterarAgencia(clientes, novaAgencia);
                                System.out.println("Agencia de " + clientes.getNome()
                                                    +" foi alterada de "+ antigaAgencia
                                                    +" para " + clientes.getContaBancaria().getAgencia()
                                                    +" com sucesso!");

                            }
                        }

                        break;
                    case 0:
                        System.out.println("Saindo...");
                }

            } while (opcao != 0);

    }
}
