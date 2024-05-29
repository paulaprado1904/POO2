import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnderecoTest {

    @Test
    public void testPrintaEnderecoCliente() {
        // Criação de um objeto Endereco para teste
        Endereco endereco = new Endereco();
        endereco.setRua("Rua ABC");
        endereco.setNumero(123);
        endereco.setBairro("Centro");
        endereco.setCep("12345-678");
        endereco.setComplemento("Apartamento 101");

        // String esperada com o endereço formatado
        String enderecoEsperado = "\nRua: Rua ABC\nNúmero: 123\nBairro: Centro\nCEP: 12345-678\nComplemento: Apartamento 101";

        // Chama o método a ser testado
        String enderecoFormatado = endereco.printaEnderecoCLiente();

        // Verifica se o resultado do método é igual ao esperado
        assertEquals(enderecoEsperado, enderecoFormatado);
    }
}
