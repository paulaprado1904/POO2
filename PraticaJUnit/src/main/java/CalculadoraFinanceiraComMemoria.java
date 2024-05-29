import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraFinanceiraComMemoria {
    static Map<String, Double> memoriaResultados = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPercentagem(obterOuResgatarValor("parte"), obterOuResgatarValor("todo"));
                    break;
                case 2:
                    calcularVariacaoPercentual(obterOuResgatarValor("anterior"), obterOuResgatarValor("posterior"));
                    break;
                case 3:
                    calcularValorPresenteSimples(obterOuResgatarValor("VF"), obterOuResgatarValor("i"), obterOuResgatarValor("n"));
                    break;
                case 4:
                    calcularValorFuturoSimples(obterOuResgatarValor("VP"), obterOuResgatarValor("i"), obterOuResgatarValor("n"));
                    break;
                case 5:
                    calcularValorPresenteComposto(obterOuResgatarValor("VF"), obterOuResgatarValor("i"), obterOuResgatarValor("n"));
                    break;
                case 6:
                    calcularValorFuturoComposto(obterOuResgatarValor("VP"), obterOuResgatarValor("i"), obterOuResgatarValor("n"));
                    break;
                case 7:
                    calcularValorParcela(obterOuResgatarValor("VP"), obterOuResgatarValor("i"), obterOuResgatarValor("n"));
                    break;
                case 0:
                    System.out.println("Encerrando a calculadora.");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Calcular percentagem");
        System.out.println("2. Calcular variação em percentagem");
        System.out.println("3. Calcular valor presente simples (VPS)");
        System.out.println("4. Calcular valor futuro simples (VFS)");
        System.out.println("5. Calcular valor presente composto (VPC)");
        System.out.println("6. Calcular valor futuro composto (VFC)");
        System.out.println("7. Calcular valor da parcela (PMT)");
        System.out.println("0. Sair");
    }

    public static void calcularPercentagem(double parte, double todo) {
        double percentagem = (parte / todo) * 100;
        System.out.println("A percentagem é: " + percentagem + "%");
        memoriaResultados.put("percentagem", percentagem);
    }

    public static void calcularVariacaoPercentual(double anterior, double posterior) {
        double variacaoPercentual = ((posterior / anterior) - 1) * 100;
        System.out.println("A variação percentual é: " + variacaoPercentual + "%");
        memoriaResultados.put("variacaoPercentual", variacaoPercentual);
    }

    public static void calcularValorPresenteSimples(double vf, double i, double n) {
        double vps = vf / (1 + i * n);
        System.out.println("O valor presente simples (VPS) é: " + vps);
        memoriaResultados.put("VPS", vps);
    }

    public static void calcularValorFuturoSimples(double vp, double i, double n) {
        double vfs = vp * (1 + i * n);
        System.out.println("O valor futuro simples (VFS) é: " + vfs);
        memoriaResultados.put("VFS", vfs);
    }

    public static void calcularValorPresenteComposto(double vf, double i, double n) {
        double vpc = vf / Math.pow((1 + i), n);
        System.out.println("O valor presente composto (VPC) é: " + vpc);
        memoriaResultados.put("VPC", vpc);
    }

    public static void calcularValorFuturoComposto(double vp, double i, double n) {
        double vfc = vp * Math.pow((1 + i), n);
        System.out.println("O valor futuro composto (VFC) é: " + vfc);
        memoriaResultados.put("VFC", vfc);
    }

    public static void calcularValorParcela(double vp, double i, double n) {
        double pmt = vp * ((i * Math.pow((1 + i), n)) / (1 + i));
        System.out.println("O valor da parcela (PMT) é: " + pmt);
        memoriaResultados.put("PMT", pmt);
    }

    public static double obterOuResgatarValor(String nomeVariavel) {
        System.out.println("Deseja resgatar um valor da memória para " + nomeVariavel + "? (S/N)");
        String resposta = scanner.next().toUpperCase();

        if (resposta.equals("S")) {
            System.out.println("Digite o nome da variável:");
            nomeVariavel = scanner.next();
            if (memoriaResultados.containsKey(nomeVariavel)) {
                return memoriaResultados.get(nomeVariavel);
            } else {
                System.out.println("Nenhuma informação encontrada na memória para essa variável.");
                System.out.println("Digite o valor manualmente:");
                return scanner.nextDouble();
            }
        } else {
            System.out.println("Digite o valor manualmente:");
            return scanner.nextDouble();
        }
    }
}
