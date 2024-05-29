class ContaBancaria {
    private double saldo;
    private double limiteEspecial;
    private int tempoFiliado;
    private boolean clienteEspecial;
    private boolean clienteVIP;
    private String agencia;
    private String conta;
    private boolean poupanca;
    private String cpfDoCliente; // CPF do cliente associado a esta conta bancária

    public ContaBancaria(double saldo, double limiteEspecial, int tempoFiliado, boolean clienteEspecial, boolean clienteVIP, String agencia, String conta, boolean poupanca, String cpfDoCliente) {
        this.saldo = saldo;
        this.limiteEspecial = limiteEspecial;
        this.tempoFiliado = tempoFiliado;
        this.clienteEspecial = clienteEspecial;
        this.clienteVIP = clienteVIP;
        this.agencia = agencia;
        this.conta = conta;
        this.poupanca = poupanca;
        this.cpfDoCliente = cpfDoCliente;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getCpf() {
        return cpfDoCliente;
    }

    public void setCpf(String cpfDoCliente) {
        this.cpfDoCliente = cpfDoCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isPoupanca() {
        return poupanca;
    }

    public void setPoupanca(boolean poupanca) {
        this.poupanca = poupanca;
    }

    public int getTempoFiliado() {
        return tempoFiliado;
    }

    public void setTempoFiliado(int tempoFiliado) {
        this.tempoFiliado = tempoFiliado;
    }

    public void setClienteVIP(boolean clienteVIP) {
        this.clienteVIP = clienteVIP;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCpfDoCliente() {
        return cpfDoCliente;
    }

    public void setCpfDoCliente(String cpfDoCliente) {
        this.cpfDoCliente = cpfDoCliente;
    }

    public boolean isClienteEspecial() {
        return clienteEspecial;
    }

    public void setClienteEspecial(boolean clienteEspecial) {
        this.clienteEspecial = clienteEspecial;
    }

    public boolean isClienteVIP() {
        return clienteVIP;
    }
}
