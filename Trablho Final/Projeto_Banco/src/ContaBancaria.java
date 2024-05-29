import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class ContaBancaria {
    private double saldo;
    private double limiteEspecial;
    private int tempoFiliado;
    private boolean clienteEspecial;
    private boolean clienteVIP;
    private String agencia;
    private String conta;
    private boolean possuiPoupanca;

    public ContaBancaria() {
        // Valores padrão para inicializar as variáveis
        this.saldo = 0.0;
        this.limiteEspecial = 0.0;
        this.tempoFiliado = 0;
        this.clienteEspecial = false;
        this.clienteVIP = false;
        this.agencia = "";
        this.conta = "";
        this.possuiPoupanca = false;
    }

    public ContaBancaria(double saldo, double limiteEspecial, String dataCadastro, boolean clienteEspecial, boolean clienteVIP, String agencia, String conta, boolean possuiPoupanca) {
        this.saldo = saldo;
        if (limiteEspecial >= 100 && limiteEspecial <= 2000) {
            this.limiteEspecial = limiteEspecial;
        } else if (clienteEspecial && limiteEspecial >= 5000 && limiteEspecial <= 10000) {
            this.limiteEspecial = limiteEspecial;
        } else if (clienteVIP && limiteEspecial >= 20000 && limiteEspecial <= 100000) {
            this.limiteEspecial = limiteEspecial;
        } else {
            throw new IllegalArgumentException("Limite especial inválido para o tipo de cliente.");
        }
        // Calculando o tempo de filiado com base na data de cadastro do cliente
        calcularTempoFiliado(dataCadastro);
        this.clienteEspecial = clienteEspecial;
        this.clienteVIP = clienteVIP;
        this.agencia = agencia;
        this.conta = conta;
        this.possuiPoupanca = possuiPoupanca;
    }

    private void calcularTempoFiliado(String dataCadastro) {
        // Convertendo a string de data para LocalDate
        LocalDate dataCadastroFormatada = LocalDate.parse(dataCadastro, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // Calculando o tempo de filiado com base na data de cadastro
        this.tempoFiliado = (int) ChronoUnit.MONTHS.between(dataCadastroFormatada, LocalDate.now());
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        if (limiteEspecial >= 100 && limiteEspecial <= 2000) {
            this.limiteEspecial = limiteEspecial;
        } else if (clienteEspecial && limiteEspecial >= 5000 && limiteEspecial <= 10000) {
            this.limiteEspecial = limiteEspecial;
        } else if (clienteVIP && limiteEspecial >= 20000 && limiteEspecial <= 100000) {
            this.limiteEspecial = limiteEspecial;
        } else {
            throw new IllegalArgumentException("Limite especial inválido para o tipo de cliente.");
        }
    }


    public int getTempoFiliado() {
        return tempoFiliado;
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

    public void setClienteVIP(boolean clienteVIP) {
        this.clienteVIP = clienteVIP;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public boolean isPossuiPoupanca() {
        return possuiPoupanca;
    }

    public void setPossuiPoupanca(boolean possuiPoupanca) {
        this.possuiPoupanca = possuiPoupanca;
    }

public void calcularJuros() {
        double taxaJuros = 0.0;
        if (clienteEspecial) {
            taxaJuros = 0.012; // 1.2% ao mês para cliente especial
        } else if (clienteVIP) {
            taxaJuros = 0.01; // 1% ao mês para cliente VIP
        } else {
            taxaJuros = 0.02; // 2% ao mês para clientes normais
        }
        double juros = saldo * taxaJuros;
        saldo += juros;
    }

    public void pagarTaxaMensal() {
        double taxaMensal = 0.0;
        if (clienteEspecial) {
            taxaMensal = 100.0; // Taxa mensal para cliente especial
        } else if (clienteVIP) {
            taxaMensal = 270.0; // Taxa mensal para cliente VIP
        } else {
            taxaMensal = 30.0; // Taxa mensal para clientes normais
        }
        saldo -= taxaMensal;
    }

    public void calcularLucroPoupanca() {
        double taxaLucro = 0.0;
        if (clienteEspecial) {
            taxaLucro = 0.0008; // 0.08% ao mês para cliente especial
        } else if (clienteVIP) {
            taxaLucro = 0.0008; // 0.08% ao mês para cliente VIP
        } else {
            taxaLucro = 0.0005; // 0.05% ao mês para clientes normais
        }
        double lucro = saldo * taxaLucro;
        saldo += lucro;
    }

    public void realizarPagamentoMensal() {
        double valorPagamento = 0.0;
        if (clienteEspecial) {
            valorPagamento = 100.0; // Cliente especial paga 100,00 R$
        } else if (clienteVIP) {
            valorPagamento = 270.0; // Cliente VIP paga 270,00 R$
        } else {
            valorPagamento = 30.0; // Clientes normais pagam 30,00 R$
        }
        saldo -= valorPagamento;
    }


    public String printaDadosContaBancaria(){
        return "\nSaldo: " + getSaldo()
                +"\nLimite especial: " + getLimiteEspecial()
                +"\nTempo de afiliado: " + getTempoFiliado() + " meses"
                +"\nCliente especial: " + isClienteEspecial()
                +"\nCliente VIP: " + isClienteVIP()
                +"\nAgencia: " + getAgencia()
                +"\nConta: " + getConta()
                +"\nPoupança: " + isPossuiPoupanca();
    }

}