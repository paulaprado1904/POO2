interface ServicoTaxas {
    double calcularJuros(double saldo, double limiteEspecial, double taxa);
    double calcularLucro(double saldo, boolean temPoupanca, double taxa);
}
