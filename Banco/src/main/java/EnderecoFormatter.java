public class EnderecoFormatter {
    public String format(Endereco endereco) {
        return endereco.getRuaAv() + ", " + endereco.getNumero() + ", " +
                endereco.getBairro() + ", " + endereco.getCep() + ", " +
                endereco.getComplemento();
    }
}
