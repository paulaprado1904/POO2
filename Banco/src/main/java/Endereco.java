class Endereco {
    private String ruaAv;
    private int numero;
    private String bairro;
    private String cep;
    private String complemento;

    public Endereco(String ruaAv, int numero, String bairro, String cep, String complemento) {
        this.ruaAv = ruaAv;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getRuaAv() {
        return ruaAv;
    }

    public void setRuaAv(String ruaAv) {
        this.ruaAv = ruaAv;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}