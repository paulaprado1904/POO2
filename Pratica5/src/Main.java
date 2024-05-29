import java.util.Scanner;
import java.util.concurrent.*;

// Interface para as operações suportadas pela calculadora
interface Operacoes<T> {
    T soma(T a, T b);
    T subtracao(T a, T b);
    T multiplicacao(T a, T b);
    T divisao(T a, T b);
    T potencia(T base, int expoente);
    T raizQuadrada(T a);
    T raizCubica(T a);
    T fatorial(T a);
    T fibonacci(int n);
    T progressaoAritmetica(T a1, T n, T r);
    T progressaoGeometrica(T a1, T n, T r);
}

// Implementação da classe Calculadora que suporta operações genéricas
class Calculadora<T extends Number> implements Operacoes<T>, Runnable {
    private T ultimoResultado;

    public T getUltimoResultado() {
        return ultimoResultado;
    }

    @Override
    public void run() {
        System.out.println("Calculadora iniciada...");
    }

    @Override
    public T soma(T a, T b) {
        return ultimoResultado = calcular(a.doubleValue() + b.doubleValue());
    }

    @Override
    public T subtracao(T a, T b) {
        return ultimoResultado = calcular(a.doubleValue() - b.doubleValue());
    }

    @Override
    public T multiplicacao(T a, T b) {
        return ultimoResultado = calcular(a.doubleValue() * b.doubleValue());
    }

    @Override
    public T divisao(T a, T b) {
        if (b.doubleValue() == 0) {
            System.out.println("Não é possível dividir por zero!");
            return null;
        }
        return ultimoResultado = calcular(a.doubleValue() / b.doubleValue());
    }

    @Override
    public T potencia(T base, int expoente) {
        return ultimoResultado = calcular(Math.pow(base.doubleValue(), expoente));
    }

    @Override
    public T raizQuadrada(T a) {
        return ultimoResultado = calcular(Math.sqrt(a.doubleValue()));
    }

    @Override
    public T raizCubica(T a) {
        return ultimoResultado = calcular(Math.cbrt(a.doubleValue()));
    }

    @Override
    public T fatorial(T a) {
        int n = a.intValue();
        if (n < 0) {
            System.out.println("Fatorial de número negativo não é definido.");
            return null;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return ultimoResultado = calcular(result);
    }

    @Override
    public T fibonacci(int n) {
        int a = 0, b = 1, c;
        if (n == 0) return ultimoResultado = calcular(0);
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return ultimoResultado = calcular(b);
    }

    @Override
    public T progressaoAritmetica(T a1, T n, T r) {
        double result = (n.doubleValue() / 2) * (2 * a1.doubleValue() + (n.doubleValue() - 1) * r.doubleValue());
        return ultimoResultado = calcular(result);
    }

    @Override
    public T progressaoGeometrica(T a1, T n, T r) {
        double result = a1.doubleValue() * Math.pow(r.doubleValue(), n.doubleValue() - 1);
        return ultimoResultado = calcular(result);
    }

    private T calcular(double value) {
        if (value % 1 == 0) {
            return (T) Integer.valueOf((int) value);
        } else {
            return (T) Double.valueOf(value);
        }
    }
}

// Classe principal que permite ao usuário interagir com as calculadoras
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar nova calculadora");
            System.out.println("2. Sair");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Digite um nome para a calculadora:");
                String nomeCalculadora = scanner.next();
                Calculadora<Double> calculadora = new Calculadora<>();
                Thread thread = new Thread(calculadora);
                thread.start();

                while (true) {
                    System.out.println("\nEscolha uma operação:");
                    System.out.println("1. Soma");
                    System.out.println("2. Subtração");
                    System.out.println("3. Multiplicação");
                    System.out.println("4. Divisão");
                    System.out.println("5. Potência");
                    System.out.println("6. Raiz Quadrada");
                    System.out.println("7. Raiz Cúbica");
                    System.out.println("8. Fatorial");
                    System.out.println("9. Fibonacci");
                    System.out.println("10. Progressão Aritmética");
                    System.out.println("11. Progressão Geométrica");
                    System.out.println("12. Mostrar último resultado");
                    System.out.println("13. Voltar");

                    int operacao = scanner.nextInt();
                    double a, b, r;
                    int expoente, n;

                    switch (operacao) {
                        case 1:
                            System.out.println("Digite o primeiro número:");
                            a = scanner.nextDouble();
                            System.out.println("Digite o segundo número:");
                            b = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.soma(a, b));
                            break;
                        case 2:
                            System.out.println("Digite o primeiro número:");
                            a = scanner.nextDouble();
                            System.out.println("Digite o segundo número:");
                            b = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.subtracao(a, b));
                            break;
                        case 3:
                            System.out.println("Digite o primeiro número:");
                            a = scanner.nextDouble();
                            System.out.println("Digite o segundo número:");
                            b = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.multiplicacao(a, b));
                            break;
                        case 4:
                            System.out.println("Digite o primeiro número:");
                            a = scanner.nextDouble();
                            System.out.println("Digite o segundo número:");
                            b = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.divisao(a, b));
                            break;
                        case 5:
                            System.out.println("Digite a base:");
                            a = scanner.nextDouble();
                            System.out.println("Digite o expoente:");
                            expoente = scanner.nextInt();
                            System.out.println("Resultado: " + calculadora.potencia(a, expoente));
                            break;
                        case 6:
                            System.out.println("Digite o número:");
                            a = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.raizQuadrada(a));
                            break;
                        case 7:
                            System.out.println("Digite o número:");
                            a = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.raizCubica(a));
                            break;
                        case 8:
                            System.out.println("Digite o número:");
                            a = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.fatorial(a));
                            break;
                        case 9:
                            System.out.println("Digite o número de termos:");
                            n = scanner.nextInt();
                            System.out.println("Resultado: " + calculadora.fibonacci(n));
                            break;
                        case 10:
                            System.out.println("Digite o primeiro termo:");
                            a = scanner.nextDouble();
                            System.out.println("Digite o número de termos:");
                            n = scanner.nextInt();
                            System.out.println("Digite a razão:");
                            r = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.progressaoAritmetica(a, (double) n, r));
                            break;
                        case 11:
                            System.out.println("Digite o primeiro termo:");
                            a = scanner.nextDouble();
                            System.out.println("Digite o número de termos:");
                            n = scanner.nextInt();
                            System.out.println("Digite a razão:");
                            r = scanner.nextDouble();
                            System.out.println("Resultado: " + calculadora.progressaoGeometrica(a, (double) n, r));
                            break;
                        case 12:
                            System.out.println("Último resultado: " + calculadora.getUltimoResultado());
                            break;
                        case 13:
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }

                    if (operacao == 13) {
                        break;
                    }
                }
            } else if (opcao == 2) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        executorService.shutdown();
        scanner.close();
    }
}
