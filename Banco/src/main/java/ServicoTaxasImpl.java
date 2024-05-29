class ServicoTaxasImpl implements ServicoTaxas {
    @Override
    public double calcularJuros(double saldo, double limiteEspecial, double taxa) {
        if (saldo < 0) {
            return saldo * taxa; // Juros aplicados ao saldo negativo
        } else {
            return (saldo + limiteEspecial) * taxa; // Juros aplicados ao saldo total (saldo + limite especial)
        }
    }

    @Override
    public double calcularLucro(double saldo, boolean temPoupanca, double taxa) {
        if (temPoupanca) {
            return saldo * taxa; // Lucro aplicado ao saldo se tiver poupança
        } else {
            return 0; // Sem lucro se não tiver poupança
        }
    }
}
