import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculadoraFinanceiraComMemoriaTest {

    @Test
    public void testCalcularPercentagem() {
        double parte = 10.5;
        double todo = 20.3;
        double expected = 51.724; // O valor esperado com flutuações
        double delta = 0.001; // Margem de erro aceitável

        CalculadoraFinanceiraComMemoria.calcularPercentagem(parte, todo);
        assertEquals(expected, CalculadoraFinanceiraComMemoria.memoriaResultados.get("percentagem"), delta);
    }


    @Test
    public void testCalcularVariacaoPercentual() {
        double anterior = 10.5;
        double posterior = 20.3;
        double expected = 93.333; // O valor esperado com flutuações
        double delta = 0.001; // Margem de erro aceitável

        CalculadoraFinanceiraComMemoria.calcularVariacaoPercentual(anterior, posterior);
        assertEquals(expected, CalculadoraFinanceiraComMemoria.memoriaResultados.get("variacaoPercentual"), delta);
    }

    @Test
    public void testCalcularValorPresenteSimples() {
        double vf = 1000;
        double i = 0.05;
        double n = 2;
        double expected = 909.090; // O valor esperado com flutuações
        double delta = 0.001; // Margem de erro aceitável

        CalculadoraFinanceiraComMemoria.calcularValorPresenteSimples(vf, i, n);
        assertEquals(expected, CalculadoraFinanceiraComMemoria.memoriaResultados.get("VPS"), delta);
    }

    @Test
    public void testCalcularValorFuturoSimples() {
        double vp = 1000;
        double i = 0.05;
        double n = 2;
        double expected = 1100.0; // O valor esperado com flutuações
        double delta = 0.001; // Margem de erro aceitável

        CalculadoraFinanceiraComMemoria.calcularValorFuturoSimples(vp, i, n);
        assertEquals(expected, CalculadoraFinanceiraComMemoria.memoriaResultados.get("VFS"), delta);
    }

    @Test
    public void testCalcularValorPresenteComposto() {
        double vf = 1000;
        double i = 0.05;
        double n = 2;
        double expected = 907.029; // O valor esperado com flutuações
        double delta = 0.001; // Margem de erro aceitável

        CalculadoraFinanceiraComMemoria.calcularValorPresenteComposto(vf, i, n);
        assertEquals(expected, CalculadoraFinanceiraComMemoria.memoriaResultados.get("VPC"), delta);
    }

    @Test
    public void testCalcularValorFuturoComposto() {
        double vp = 1000;
        double i = 0.05;
        double n = 2;
        double expected = 1102.5; // O valor esperado com flutuações
        double delta = 0.001; // Margem de erro aceitável

        CalculadoraFinanceiraComMemoria.calcularValorFuturoComposto(vp, i, n);
        assertEquals(expected, CalculadoraFinanceiraComMemoria.memoriaResultados.get("VFC"), delta);
    }

    @Test
    public void testCalcularValorParcela() {
        double vp = 1000;
        double i = 0.05;
        double n = 2;
        double expected = 52.500; // O valor esperado com flutuações
        double delta = 0.001; // Margem de erro aceitável

        CalculadoraFinanceiraComMemoria.calcularValorParcela(vp, i, n);
        assertEquals(expected, CalculadoraFinanceiraComMemoria.memoriaResultados.get("PMT"), delta);
    }
    @Test
    public void testMemoriaResultados() {
        System.out.println("Conteúdo da memória:");
        for (String chave : CalculadoraFinanceiraComMemoria.memoriaResultados.keySet()) {
            double valor = CalculadoraFinanceiraComMemoria.memoriaResultados.get(chave);
            System.out.println(chave + ": " + valor);
        }
    }
}
